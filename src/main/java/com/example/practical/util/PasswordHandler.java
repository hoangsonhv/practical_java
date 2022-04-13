package com.example.practical.util;

public class PasswordHandler {
    public static boolean checkPassword(String password, String passwordDatabase) {
        return password.equals(passwordDatabase);
    }
}
