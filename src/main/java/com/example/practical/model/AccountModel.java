package com.example.practical.model;

import com.example.practical.entity.Account;
import com.example.practical.entity.User;
import com.example.practical.util.ConnectionHelper;
import com.example.practical.util.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AccountModel {

    public boolean save(User user) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            SQLConfig.DATABASE_ACCOUNT_INSERT);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            // PrepareStatement
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User findAccountByUsername(String username) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            SQLConfig.SELECT_ACCOUNT_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String usernameDatabase = resultSet.getString("username");
                String passwordDatabase = resultSet.getString("password");
                User user = new User();
                user.setUsername(usernameDatabase);
                user.setPassword(passwordDatabase);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
