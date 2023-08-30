package com.example.myproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // Get the selected product data from the intent
        Product selectedProduct = getIntent().getParcelableExtra("selectedProduct");

        // Set up the views to display the product details
        ImageView imageProduct = findViewById(R.id.detailImageProduct);
        TextView textProductName = findViewById(R.id.detailTextProductName);
        TextView textProductPrice = findViewById(R.id.detailTextProductPrice);
        TextView textProductDescription = findViewById(R.id.detailTextProductDescription);

        imageProduct.setImageResource(selectedProduct.getImageResourceId());
        textProductName.setText(selectedProduct.getName());
        textProductPrice.setText(String.format("$%.2f", selectedProduct.getPrice()));
        textProductDescription.setText(selectedProduct.getDescription());
    }
}
