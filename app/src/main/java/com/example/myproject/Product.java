package com.example.myproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private int imageResourceId;
    private String description;
    private double price;
    private String name;
    private int cartCount;

    public Product(int imageResourceId, String description, double price, String name) {
        this.imageResourceId = imageResourceId;
        this.description = description;
        this.price = price;
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    // Implement Parcelable methods
    protected Product(Parcel in) {
        imageResourceId = in.readInt();
        description = in.readString();
        price = in.readDouble();
        name = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResourceId);
        dest.writeString(description);
        dest.writeDouble(price);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getProductName() {
        return name;
    }
    public int getQuantity() {
        int quantity = 0;
        return quantity;
    }
}
