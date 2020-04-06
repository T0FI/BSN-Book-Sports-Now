package com.example.group_project_2019_20_group_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.OnClick;

public class LeagueMain extends AppCompatActivity {


    @BindView(R.id.join)
    Button Join;


    @OnClick(R.id.join)
    void nextClick(){

        Intent intentLoadAnalyseAct = new Intent(LeagueMain.this, LeagueMain.class);
        startActivity(intentLoadAnalyseAct);
    }

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
                        Intent intent = new Intent(LeagueMain.this,
                                com.example.group_project_2019_20_group_6.Homepage.class);
                        overridePendingTransition(0,0);
                        startActivity(intent);
                        break;
                    case R.id.league:
                        Intent intent2 = new Intent(LeagueMain.this,
                                com.example.group_project_2019_20_group_6.LeagueMain.class);
                        overridePendingTransition(0,0);
                        startActivity(intent2);
                        break;
                    case R.id.userscreen:
                        Intent intent3 = new Intent(LeagueMain.this,
                                com.example.group_project_2019_20_group_6.UserProfile.class);
                        overridePendingTransition(0,0);
                        startActivity(intent3);
                        break;
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
            case R.id.current_leagues:
                Intent intentLoadAnalyseAct = new Intent(LeagueMain.this, LeagueMainTest.class);
                break;
        }

    }
}
