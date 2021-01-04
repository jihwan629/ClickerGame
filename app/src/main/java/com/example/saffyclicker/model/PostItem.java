package com.example.saffyclicker.model;

public class PostItem {
    private int itemImg;

    private String itemName;
    private String itemExplanation;

    private boolean purchased;

    private int plus;
    private int multiply;

    private int price;

    public PostItem(int itemImg, String itemName, String itemExplanation, boolean purchased, int plus, int multiply, int price) {
        this.itemImg = itemImg;
        this.itemName = itemName;
        this.itemExplanation = itemExplanation;
        this.purchased = purchased;
        this.plus = plus;
        this.multiply = multiply;
        this.price = price;
    }

    public int getItemImg() {
        return itemImg;
    }

    public void setItemImg(int itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemExplanation() {
        return itemExplanation;
    }

    public void setItemExplanation(String itemExplanation) {
        this.itemExplanation = itemExplanation;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public int getPlus() {
        return plus;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }

    public int getMultiply() {
        return multiply;
    }

    public void setMultiply(int multiply) {
        this.multiply = multiply;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
