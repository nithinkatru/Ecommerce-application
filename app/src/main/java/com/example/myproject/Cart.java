package com.example.myproject;
import java.util.List;



import com.google.android.gms.analytics.ecommerce.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public int getSize() {
        return items.size();
    }

    public boolean contains(Product product) {
        return items.contains(product);
    }

    // You can add more methods as needed, such as calculating the total price of the items in the cart.
}
