package com.example.practical.model;

import com.example.practical.entity.Product;
import com.example.practical.util.ConnectionHelper;
import com.example.practical.util.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {


    public boolean save(Product obj){
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_INSERT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setDouble(2, obj.getPrice());
            preparedStatement.setInt(3, obj.getAmount());
            preparedStatement.setString(3, obj.getDetails());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> findAll(){
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = SQLConfig.DATABASE_PRODUCT_SELECT;
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                String details = resultSet.getString("details");
                Product obj = new Product(id,name,price,amount, details);
                productList.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    public Product findById(int id){
        Product  obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_SELECT2);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                String details = resultSet.getString("details");
                obj = new Product(id,name,price,amount, details);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return obj;
    }

    public boolean update(int id, Product updateProduct){
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_UPDATE);
            statement.setString(1, updateProduct.getName());
            statement.setString(2, updateProduct.getThumbnail());
            statement.setDouble(3, updateProduct.getPrice());
            statement.setInt(4, updateProduct.getStatus());
            statement.setInt(5, id);
            statement.execute();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean delete(int id){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_DELETE, id);
            statement.setInt(1, id);
            statement.execute();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
