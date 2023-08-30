package com.example.myproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etNewUsername, etNewPassword;
    private Button btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_page);

        mAuth = FirebaseAuth.getInstance();

        etNewUsername = findViewById(R.id.etNewUsername);
        etNewPassword = findViewById(R.id.etNewPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUsername = etNewUsername.getText().toString();
                String newPassword = etNewPassword.getText().toString();

                if (TextUtils.isEmpty(newUsername) || TextUtils.isEmpty(newPassword)) {
                    Toast.makeText(RegistrationActivity.this, "Username and password are required.",
                            Toast.LENGTH_SHORT).show();
                } else if (newPassword.length() < 6) {
                    Toast.makeText(RegistrationActivity.this, "Password must be at least 6 characters.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    // Create a new user with email and password
                    mAuth.createUserWithEmailAndPassword(newUsername, newPassword)
                            .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Registration successful, display success message
                                        Toast.makeText(RegistrationActivity.this, "Registration successful.",
                                                Toast.LENGTH_SHORT).show();
                                        finish(); // Close the registration activity
                                    } else {
                                        // Registration failed, display error message
                                        Toast.makeText(RegistrationActivity.this, "Registration failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
