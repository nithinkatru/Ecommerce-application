package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private Product selectedProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Get the selected product data from the intent
        selectedProduct = getIntent().getParcelableExtra("selectedProduct");

        // Set up the views to display the product details
        ImageView imageProduct = findViewById(R.id.imageProductDetail);
        TextView textProductName = findViewById(R.id.textProductNameDetail);
        TextView textProductPrice = findViewById(R.id.textProductPriceDetail);
        TextView textProductDescription = findViewById(R.id.textProductDescriptionDetail);

        imageProduct.setImageResource(selectedProduct.getImageResourceId());
        textProductName.setText(selectedProduct.getName());
        textProductPrice.setText(String.format("$%.2f", selectedProduct.getPrice()));
        textProductDescription.setText(selectedProduct.getDescription());

        // Handle the image click event
        imageProduct.setOnClickListener(view -> {
            Intent intent = new Intent(ProductDetailActivity.this, DetailedProductActivity.class);
            intent.putExtra("selectedProduct", selectedProduct);
            startActivity(intent);
        });
    }
}
