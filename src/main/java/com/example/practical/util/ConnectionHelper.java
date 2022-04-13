package com.example.practical.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {

    private static Connection connection;

    public static Connection getConnection() throws Exception{
        Class.forName(Config.DATABASE_DRIVER_CLASS);
        if (connection == null){
            connection = DriverManager.getConnection(Config.DATABASE_URL,
                    Config.DATABASE_USERNAME,
                    Config.DATABASE_PASSWORD);
            System.out.println("Connect database success!");
        }else {
            System.out.println("Use existing connection.");
        }
        return connection;
    }
}
