package com.example.demomvc.model;

public class Game {
    private String image;
    private int promotion;
    private int priceOld;
    private int priceNew;
    private String name;

    public Game(String image, int promotion, int priceOld, int priceNew, String name) {
        this.image = image;
        this.promotion = promotion;
        this.priceOld = priceOld;
        this.priceNew = priceNew;
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public int getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(int priceOld) {
        this.priceOld = priceOld;
    }

    public int getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(int priceNew) {
        this.priceNew = priceNew;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
