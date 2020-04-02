package com.example.group_project_2019_20_group_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SelectSportScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sport_screen);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //perform itemselectedlistener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId())
                {
                    case R.id.home:
                        Intent intent = new Intent(SelectSportScreen.this,
                                com.example.group_project_2019_20_group_6.Homepage.class);
                        overridePendingTransition(0,0);
                        startActivity(intent);
                        break;
                    case R.id.league:
                        Intent intent2 = new Intent(SelectSportScreen.this,
                                com.example.group_project_2019_20_group_6.LeagueMain.class);
                        overridePendingTransition(0,0);
                        startActivity(intent2);
                        break;
                    case R.id.userscreen:
                        Intent intent3 = new Intent(SelectSportScreen.this,
                                com.example.group_project_2019_20_group_6.UserProfile.class);
                        overridePendingTransition(0,0);
                        startActivity(intent3);
                        break;
                }
                return false;
            }



        });

    }

    //treat the ImageViews as Buttons,once the clickable property is ticked true you can do the same code on the images
//as you would with a Button onclick method.
}
