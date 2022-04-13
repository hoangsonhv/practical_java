package com.example.practical.entity;

import com.example.practical.annotation.Column;
import com.example.practical.annotation.Table;

import java.util.HashMap;
import java.util.Objects;

@Table(name = "tbProducts")
public class Products {
    @Column(name = "id", type = "INT PRIMARY KEY AUTO_INCREMENT")
    private int id;
    @Column(name = "name", type = "VARCHAR(255)")
    private String name;
    @Column(name = "price", type = "Double")
    private Double price;
    @Column(name = "amount", type = "INT")
    private int amount;
    @Column(name = "details", type = "VARCHAR(255)")
    private String details;

    public Products() {
    }

    public Products(String name, Double price, int amount, String details) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.details = details;
    }

    public Products(int id, String name, Double price, int amount, String details) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.details = details;
    }

    @Override
    public String toString() {
        return "tbProducts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", details='" + details + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    private HashMap<String, String> error;

    private void checkValid(){
        this.error = new HashMap<>();
        if (this.name == null || this.name.length() == 0){
            this.error.put("name", "Name is required!");
        }
        if (this.details == null || this.details.length() == 0){
            this.error.put("details", "Details is not null!");
        }
        if (this.price == 0){
            this.error.put("price", "Price must be greater than 0!");
        }
    }

    public HashMap<String, String > getErrors(){
        checkValid();
        return error;
    }

    public boolean isValid(){
        checkValid();
        return error == null || error.size() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products product = (Products) o;
        return id == product.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
