package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage); // Replace "homepage" with the actual name of your XML file

        // Find the button by ID
        btnSubmit = findViewById(R.id.btnSubmit);

        // Set a click listener on the button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create animation set for combined effects
                AnimationSet animationSet = new AnimationSet(true);

                // Rotation animation: Rotate button from 0 to 360 degrees
                RotateAnimation rotate = new RotateAnimation(0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(1000);
                animationSet.addAnimation(rotate);

                // Scale animation: Scale button from 1.0 to 1.5 and back
                ScaleAnimation scale = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                scale.setDuration(1000);
                animationSet.addAnimation(scale);

                // Translation animation: Move button down by 200 pixels
                TranslateAnimation translate = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 2);
                translate.setDuration(1000);
                animationSet.addAnimation(translate);

                // Start the animation on the button
                btnSubmit.startAnimation(animationSet);

                // Redirect to the login page after the animation completes
                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {}

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });
            }
        });
    }
}
