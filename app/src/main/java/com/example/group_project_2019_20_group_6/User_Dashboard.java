package com.example.group_project_2019_20_group_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class User_Dashboard extends AppCompatActivity {


    Button callactive;
    Button callprevious;
    Button callreward;
    Button callinvite;
    Button callmanage;
    Button callfeedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__dashboard);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

        //navigation bar
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.home:
                    Intent intent = new Intent(User_Dashboard.this,
                            com.example.group_project_2019_20_group_6.Homepage.class);
                    overridePendingTransition(0, 0);
                    startActivity(intent);
                    break;
                case R.id.league:
                    Intent intent2 = new Intent(User_Dashboard.this,
                            com.example.group_project_2019_20_group_6.LeagueMain.class);
                    overridePendingTransition(0, 0);
                    startActivity(intent2);
                    break;
                case R.id.userscreen:
                    Intent intent3 = new Intent(User_Dashboard.this,
                            com.example.group_project_2019_20_group_6.UserProfile.class);
                    overridePendingTransition(0, 0);
                    startActivity(intent3);
                    break;
            }
            return false;
        }

    });

        callactive = findViewById(R.id.active_button);

        callactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Dashboard.this,Active_booking.class);
                startActivity(intent);

            }
        });

        callprevious = findViewById(R.id.previous_button);

        callprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Dashboard.this,Previous_booking.class);
                startActivity(intent);

            }
        });

        callreward = findViewById(R.id.reward_button);

        callreward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Dashboard.this,Rewards.class);
                startActivity(intent);

            }
        });

        callinvite = findViewById(R.id.invite_button);

        callinvite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Dashboard.this,Invite_friend.class);
                startActivity(intent);

            }
        });

        callmanage = findViewById(R.id.manage_button);

        callmanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Dashboard.this,Manage_Account.class);
                startActivity(intent);

            }
        });

        callfeedback = findViewById(R.id.feedback_button);

        callfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Dashboard.this,Feedback.class);
                startActivity(intent);

            }
        });

    }
}
