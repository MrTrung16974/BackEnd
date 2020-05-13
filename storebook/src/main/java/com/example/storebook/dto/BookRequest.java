package com.example.storebook.dto;

import javax.persistence.Column;

public class BookRequest {
    private String name;

    private String description;

    private String price;

    private String star;

    private String image;

    private String nameAuthor;

    private String birthdayAuthor;

    public BookRequest(String name, String description, String price, String star, String image, String nameAuthor, String birthdayAuthor) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.star = star;
        this.image = image;
        this.nameAuthor = nameAuthor;
        this.birthdayAuthor = birthdayAuthor;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getBirthdayAuthor() {
        return birthdayAuthor;
    }

    public void setBirthdayAuthor(String birthdayAuthor) {
        this.birthdayAuthor = birthdayAuthor;
    }
}
