package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    private final int SPLASHSCREEN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // rediriger vers page principal après délai de 3 secondes //
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // demarrer page
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        // handler post delayed
        new Handler().postDelayed(runnable, SPLASHSCREEN);
    }
}