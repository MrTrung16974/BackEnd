package com.example.admin_mvc.model;

public class Product {
    private String name;
    private String description;
    private int price;
    private int star;

    public Product(String name, String description, int price, int star) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.star = star;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
