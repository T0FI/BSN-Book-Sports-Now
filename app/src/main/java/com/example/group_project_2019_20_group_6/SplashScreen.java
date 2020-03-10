package com.example.group_project_2019_20_group_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 6000; //splash screen stays up for 6 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent = new Intent(SplashScreen.this
                        ,Homepage.class);  //creating intent to open homepage after the splash screen
                startActivity(homeintent);
                finish();
            }

        }, SPLASH_TIME_OUT);


    }
}
