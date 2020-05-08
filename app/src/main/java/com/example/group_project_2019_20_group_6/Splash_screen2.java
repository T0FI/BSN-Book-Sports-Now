package com.example.group_project_2019_20_group_6;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_screen2 extends AppCompatActivity{

    private static int SPLASH_SCREEN = 4000;

    //Variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView bsn, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen2);


        //Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.appCompatImageView);
        bsn = findViewById(R.id.textView10);
        slogan = findViewById(R.id.textView11);

        image.setAnimation(topAnim);
        bsn.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_screen2.this,Login_2.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(bsn, "logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Splash_screen2.this,pairs);

                startActivity(intent,options.toBundle());

            }
        },SPLASH_SCREEN);

    }
}
