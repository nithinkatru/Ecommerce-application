package com.example.myproject;

public class ScreenItem {
    private int imageResId;
    private String title;
    private double price;

    public ScreenItem(int imageResId, String title, double price) {
        this.imageResId = imageResId;
        this.title = title;
        this.price = price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    // Add setters and other methods as needed
}
