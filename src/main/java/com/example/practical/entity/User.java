package com.example.practical.entity;

import com.example.practical.annotation.Column;
import com.example.practical.annotation.Table;

@Table(name = "tbUser")
public class User {
    @Column(name = "id", type = "INT PRIMARY KEY AUTO_INCREMENT")
    private String username;
    @Column(name = "password", type = "VARCHAR(255)")
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "tbUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
