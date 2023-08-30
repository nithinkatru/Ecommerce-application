package com.example.myproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    private List<Product> productList;
    private TextView cartCountTextView;
    private RecyclerView recyclerViewProducts;
    private HashMap<String, Integer> cartItemsMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productspage);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setLogo(R.drawable.logo_icon);

        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.hoodie1, "The worlds best smartphone .", 1149.99, "iphone 14 pro"));
        productList.add(new Product(R.drawable.hoodie2, "electronics at lowest price.", 129.99, "Electronics"));
        productList.add(new Product(R.drawable.product_photo, "the best first 4k tc.", 779.99, "apple ultra tv"));

        recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        ProductsAdapter adapter = new ProductsAdapter(ProductsActivity.this, productList);
        recyclerViewProducts.setAdapter(adapter);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cart, menu);

        MenuItem cartItem = menu.findItem(R.id.action_cart);
        View cartActionView = cartItem.getActionView();
        cartCountTextView = cartActionView.findViewById(R.id.cart_count);

        cartActionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCartItems();
            }
        });

        updateCartItemCount();

        return true;
    }

    public void addToCart(Product product) {
        String productName = product.getName();

        if (cartItemsMap.containsKey(productName)) {
            int itemCount = cartItemsMap.get(productName);
            cartItemsMap.put(productName, itemCount + 1);
        } else {
            cartItemsMap.put(productName, 1);
        }

        updateCartItemCount();
        Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();
    }

    private void updateCartItemCount() {
        int totalCartItemCount = 0;

        for (int itemCount : cartItemsMap.values()) {
            totalCartItemCount += itemCount;
        }

        if (cartCountTextView != null) {
            if (totalCartItemCount > 0) {
                cartCountTextView.setVisibility(View.VISIBLE);
                cartCountTextView.setText(String.valueOf(totalCartItemCount));
            } else {
                cartCountTextView.setVisibility(View.INVISIBLE);
            }
        }
    }

    // ... (inside ProductsActivity)
    private void showCartItems() {
        StringBuilder cartItemsText = new StringBuilder();
        double totalAmount = 0.0;

        for (String productName : cartItemsMap.keySet()) {
            int itemCount = cartItemsMap.get(productName);
            Product product = getProductByName(productName);
            double itemTotal = product.getPrice() * itemCount;
            totalAmount += itemTotal;

            cartItemsText.append(itemCount).append("x ").append(product.getName())
                    .append(" ($").append(String.format("%.2f", itemTotal)).append(")\n");
        }

        String totalAmountFormatted = String.format("%.2f", totalAmount);
        String cartItemsDetails = cartItemsText.toString();

        Intent intent = new Intent(ProductsActivity.this, CartDetailsActivity.class);
        intent.putExtra("cartItemsDetails", cartItemsDetails);
        intent.putExtra("totalAmount", totalAmountFormatted);
        startActivity(intent);
    }
// ... (rest of the ProductsActivity)

    private Product getProductByName(String productName) {
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    // ... (Other methods)
}
