package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CartDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_details);

        TextView textCartItems = findViewById(R.id.textCartItems);
        TextView textTotalAmount = findViewById(R.id.textTotalAmount);

        // Get the cart items details and total amount from the intent
        String cartItemsDetails = getIntent().getStringExtra("cartItemsDetails");
        String totalAmount = getIntent().getStringExtra("totalAmount");

        textCartItems.setText(cartItemsDetails);
        textTotalAmount.setText("Total Amount: " + totalAmount);

        Button btnProceedCheckout = findViewById(R.id.btnProceedToCheckout);

        // Animate the "Proceed to Checkout" button
        btnProceedCheckout.setAlpha(0f); // Initially set to invisible
        btnProceedCheckout.setTranslationY(100f); // Start below the visible area

        // Animate the button to fade in and slide up
        btnProceedCheckout.animate()
                .alpha(1f)
                .translationY(0)
                .setDuration(1000)
                .setStartDelay(500) // Delay the animation start by 500 milliseconds
                .start();

        btnProceedCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the CheckoutActivity
                Intent checkoutIntent = new Intent(CartDetailsActivity.this, CheckoutActivity.class);
                startActivity(checkoutIntent);
            }
        });
    }
}
