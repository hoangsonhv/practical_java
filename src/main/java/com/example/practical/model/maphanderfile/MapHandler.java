package com.example.practical.model.maphanderfile;

import com.example.demo_web.entity.Student;

import java.util.HashMap;
import java.util.Scanner;

public class MapHandler {
    static HashMap<String, Student> data = new HashMap<>();

    public static void main(String[] args) {

    }

    private static void generateMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Student Manager");
            System.out.println("----------------");
            System.out.println("1. Add student");
            System.out.println("2. Find student by rollnumber");
            System.out.println("Student Manager");
            System.out.println("Student Manager");
        }
    }

}
