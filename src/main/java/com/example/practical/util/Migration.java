package com.example.practical.util;

import com.example.demo_web.annotation.Column;
import com.example.demo_web.annotation.Table;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Set;

public class Migration {

    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.example.demo_web");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Table.class);

        for (Class<?> table : annotated){
            createTableFromEntity(table);
        }
    }


    public static void createTableFromEntity(Class clazz){
        if (!clazz.isAnnotationPresent(Table.class)){
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE");
        stringBuilder.append(" ");

        String tableName = clazz.getSimpleName().toLowerCase() + "s";
        Table table = (Table) clazz.getDeclaredAnnotation(Table.class);

        if (table.name() != null && table.name().length() > 0){
            tableName = table.name();
        }
        stringBuilder.append(tableName);
        stringBuilder.append(" ");
        stringBuilder.append("(");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if(!field.isAnnotationPresent(Column.class)){
                continue;
            }
            Column column = field.getDeclaredAnnotation(Column.class);
            String columnName = field.getName();
            String columnType = "";
            if(column.type().length() > 0){
                columnType = column.type();
            }else{
                if (field.getType().getSimpleName().contains("String")){
                    columnType = "VARCHAR(255)";
                }else {
                    columnType = field.getType().getSimpleName();
                }
            }

            stringBuilder.append(columnName);
            stringBuilder.append(" ");
            stringBuilder.append(columnType);
            stringBuilder.append(",");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());

        try {
            Connection connection = ConnectionHelper.getConnection();
            Statement dropStatement = connection.createStatement();
            dropStatement.execute(String.format("DROP TABLE %s", tableName));
            System.out.println(String.format("Drop table %s success!", tableName));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        System.out.println(stringBuilder.toString());
        try {
            Connection connection = ConnectionHelper.getConnection();
            Statement stt = connection.createStatement();
            stt.execute(stringBuilder.toString());
            System.out.println(String.format("Create table %s success!", tableName));
        }catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
