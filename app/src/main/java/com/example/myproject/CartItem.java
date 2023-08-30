package com.example.myproject;

public class CartItem {
    private String productName;
    private int count;
    private double price;

    public CartItem(String productName, int count, double price) {
        this.productName = productName;
        this.count = count;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getName() {
        return 0;
    }

    public String getQuantity() {
        return null;
    }
}
