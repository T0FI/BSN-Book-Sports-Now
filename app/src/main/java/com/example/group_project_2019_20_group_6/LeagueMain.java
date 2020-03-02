package com.example.group_project_2019_20_group_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LeagueMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_main);
        Button create_league = findViewById(R.id.create);
        //Initialising and assigning variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //perform itemselectedlistener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Homepage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.feed:
                        startActivity(new Intent(getApplicationContext(),Homepage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.league:
                        startActivity(new Intent(getApplicationContext(),LeagueMain.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.userscreen:
                        startActivity(new Intent(getApplicationContext(),Homepage.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.create:
                startActivity(new Intent(getApplicationContext(),league_setup.class));
                break;
        }

    }
}
