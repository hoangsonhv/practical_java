package com.example.practical.util;

public class SQLConfig {
    public static final String DATABASE_PRODUCT_INSERT = "insert into products ( name, price, amount, details ) values ( ?,?,?,?)";
    public static final String DATABASE_PRODUCT_SELECT = "select * from products";
    public static final String DATABASE_PRODUCT_SELECT2 = "select * from products where id = ?";
    public static final String DATABASE_PRODUCT_UPDATE = "update products set name = ?, price = ?, amount = ?, details = ? where id = ?";
    public static final String DATABASE_PRODUCT_DELETE = "delete from products where id = ?";

    public static final String DATABASE_ACCOUNT_INSERT = "insert into user ( username, password ) values (?,?)";
    public static final String SELECT_ACCOUNT_BY_USERNAME = "select * from user where username = ?";
}
