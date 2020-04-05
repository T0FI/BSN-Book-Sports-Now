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
                        Intent intent = new Intent(Homepage.this,
                                com.example.group_project_2019_20_group_6.Homepage.class);
                        overridePendingTransition(0,0);
                        startActivity(intent);
                        break;
                    case R.id.league:
                        Intent intent2 = new Intent(Homepage.this,
                                com.example.group_project_2019_20_group_6.LeagueMain.class);
                        overridePendingTransition(0,0);
                        startActivity(intent2);
                        break;
                    case R.id.userscreen:
                        Intent intent3 = new Intent(Homepage.this,
                                com.example.group_project_2019_20_group_6.UserProfile.class);
                        overridePendingTransition(0,0);
                        startActivity(intent3);
                        break;
                }
                return false;
            }


        });

    }

    private void initImageBitmaps(){
        Log.d(TAG,"initImageBitmaps: preparing bitmaps.");

        mPostUrls.add("https://i2.wp.com/digital-photography-school.com/wp-content/uploads/2015/12/Fig-2.jpg?fit=750%2C500&ssl=1");
        mImageUrls.add("https://www.pexels.com/photo/people-men-grass-sport-2209/");
        mNames.add("James");

        mPostUrls.add("https://static01.nyt.com/images/2017/06/04/sports/soccer/04CAGES-jp4/00cages16-jumbo.jpg");
        mImageUrls.add("http://i.imgur.com/Vwj2r0R.jpg");
        mNames.add("Powerleague");

        mPostUrls.add("https://celebreak.eu/wp-content/uploads/2016/12/powerleague2.jpg");
        mImageUrls.add("http://i.imgur.com/Vwj2r0R.jpg");
        mNames.add("Russ");
        
        mPostUrls.add("https://www.openplay.co.uk/uploads/5dV0Zi866jaaXDpT-500x_.jpg");
        mImageUrls.add("http://i.imgur.com/Vwj2r0R.jpg");
        mNames.add("Bob");

        mPostUrls.add("https://celebreak.eu/wp-content/uploads/2016/09/london-featured-image.jpg");
        mImageUrls.add("http://i.imgur.com/Vwj2r0R.jpg");
        mNames.add("Stan");

        mPostUrls.add("https://www.soccerbible.com/media/57907/bbk-nike-24-min.jpg");
        mImageUrls.add("http://i.imgur.com/Vwj2r0R.jpg");
        mNames.add("Stan");




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
