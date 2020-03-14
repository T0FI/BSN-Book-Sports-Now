package com.example.group_project_2019_20_group_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent = new Intent(Splash_Screen.this
                        ,Homepage.class); //change to user log in when screen is uploaded,
                                          
                startActivity(homeintent);
                finish();
            }

        }, SPLASH_TIME_OUT);
    }
}
