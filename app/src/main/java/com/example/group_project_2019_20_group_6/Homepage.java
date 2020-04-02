package com.example.group_project_2019_20_group_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.group_project_2019_20_group_6.Adapter.HomepageRecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {

    private static final String TAG= "HomePage";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPostUrls = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Log.d(TAG, "onCreat started");
        initImageBitmaps();

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

    private void initImageBitmaps(){
        Log.d(TAG,"initImageBitmaps: preparing bitmaps.");

        mPostUrls.add("https://i.imgur.com/mMBNROZ.jpg");
        mImageUrls.add("http://i.imgur.com/Vwj2r0R.jpg");
        mNames.add("Powerleague");

        mPostUrls.add("https://i.imgur.com/mMBNROZ.jpg");
        mImageUrls.add("http://i.imgur.com/Vwj2r0R.jpg");
        mNames.add("Powerleague");

        mPostUrls.add("https://i.imgur.com/mMBNROZ.jpg");
        mImageUrls.add("http://i.imgur.com/Vwj2r0R.jpg");
        mNames.add("Powerleague");
        
        mPostUrls.add("https://i.imgur.com/mMBNROZ.jpg");
        mImageUrls.add("http://i.imgur.com/Vwj2r0R.jpg");
        mNames.add("Powerleague");



        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: initrecyclerview" );
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        HomepageRecyclerViewAdapter adapter = new HomepageRecyclerViewAdapter(mNames,mPostUrls,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
