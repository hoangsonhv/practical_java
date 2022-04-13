package com.example.practical.util;

public class SQLConfig {
    public static final String DATABASE_PRODUCT_INSERT = "insert into tbProducts ( name, price, amount, details ) values ( ?,?,?,?)";
    public static final String DATABASE_PRODUCT_SELECT = "select * from tbProducts";
    public static final String DATABASE_PRODUCT_SELECT2 = "select * from tbProducts where id = ?";
    public static final String DATABASE_PRODUCT_UPDATE = "update tbProducts set name = ?, price = ?, amount = ?, details = ? where id = ?";
    public static final String DATABASE_PRODUCT_DELETE = "delete from tbProducts where id = ?";

    public static final String DATABASE_ACCOUNT_INSERT = "insert into tbUser ( username, password ) values (?,?)";
    public static final String SELECT_ACCOUNT_BY_USERNAME = "select * from tbUser where username = ?";
}
