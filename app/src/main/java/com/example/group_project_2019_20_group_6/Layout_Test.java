package com.example.group_project_2019_20_group_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Layout_Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout__test);




        //Copy This Code To Your .Java
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId())
                {
                    case R.id.home:
                        Intent intent = new Intent(Layout_Test.this,
                                com.example.group_project_2019_20_group_6.Homepage.class);
                        overridePendingTransition(0,0);
                        startActivity(intent);
                        break;
                    case R.id.league:
                        Intent intent2 = new Intent(Layout_Test.this,
                                com.example.group_project_2019_20_group_6.LeagueMain.class);
                        overridePendingTransition(0,0);
                        startActivity(intent2);
                        break;
                    case R.id.userscreen:
                        Intent intent3 = new Intent(Layout_Test.this,
                                com.example.group_project_2019_20_group_6.UserProfile.class);
                        overridePendingTransition(0,0);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
 });        //up to here




    }

//    public void onClick(View v) {
//        switch(v.getId())
//        {
//            case R.id.home:
//                startActivity(new Intent(getApplicationContext(),Layout_Test.class));
//                break;
//            case R.id.league:
//                Intent intent1 = new Intent(Layout_Test.this,
//                        com.example.group_project_2019_20_group_6.LeagueMain.class);
//                startActivity(intent1);
//                break;
//            case R.id.userscreen:
//                Intent intent = new Intent(Layout_Test.this,
//                        com.example.group_project_2019_20_group_6.UserProfile.class);
//                startActivity(intent);
//                break;
//        }
//
//    }

    }

