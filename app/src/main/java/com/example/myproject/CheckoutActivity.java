package com.example.myproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    private EditText editFirstName, editPhoneNumber, editHouseNumber, editStreet,
            editProvince, editCountry, editPinCode, editCardName, editCardNumber,
            editExpirationDate, editCVV;
    private Button btnConfirmCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Initialize EditText fields
        editFirstName = findViewById(R.id.editFirstName);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);
        editHouseNumber = findViewById(R.id.editHouseNumber);
        editStreet = findViewById(R.id.editStreet);
        editProvince = findViewById(R.id.editProvince);
        editCountry = findViewById(R.id.editCountry);
        editPinCode = findViewById(R.id.editPinCode);
        editCardName = findViewById(R.id.editCardName);
        editCardNumber = findViewById(R.id.editCardNumber);
        editExpirationDate = findViewById(R.id.editExpirationDate);
        editCVV = findViewById(R.id.editCVV);

        // Initialize Confirm Checkout button
        btnConfirmCheckout = findViewById(R.id.btnConfirmCheckout);
        // Load the animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_animation);

        // Apply the animation to the button
        btnConfirmCheckout.startAnimation(animation);
        btnConfirmCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Checkout");
        builder.setMessage("Are you sure you want to proceed with the checkout?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                performCheckout();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void performCheckout() {
        // Retrieve user input from EditText fields
        String firstName = editFirstName.getText().toString();
        String phoneNumber = editPhoneNumber.getText().toString();
        String houseNumber = editHouseNumber.getText().toString();
        String street = editStreet.getText().toString();
        String province = editProvince.getText().toString();
        String country = editCountry.getText().toString();
        String pinCode = editPinCode.getText().toString();
        String cardName = editCardName.getText().toString();
        String cardNumber = editCardNumber.getText().toString();
        String expirationDate = editExpirationDate.getText().toString();
        String cvv = editCVV.getText().toString();

        // You can perform further validation or processing here

        String confirmationMessage = "Thank you for your purchase, " + firstName + "!";
        Toast.makeText(this, confirmationMessage, Toast.LENGTH_LONG).show();

        // Navigate to OrderSuccessActivity
        Intent intent = new Intent(this, OrderSuccessActivity.class);
        startActivity(intent);
        finish();
        // You can also navigate to a success page or perform other actions
        // For example:
        // Intent intent = new Intent(this, OrderSuccessActivity.class);
        // startActivity(intent);
        // finish(); // Finish this activity to prevent going back
    }
}
