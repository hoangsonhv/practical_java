package com.example.practical.model;

import com.example.demo_web.entity.Product;

public class MainThread {

    public static void main(String[] args) {
        MyRepository<Product> myRepository = new MyRepository<>();
        myRepository.save(new Product("Name 01", "abc.jpg",2000.0));
    }
}
