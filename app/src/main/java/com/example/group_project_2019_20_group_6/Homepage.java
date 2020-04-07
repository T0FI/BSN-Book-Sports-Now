package com.example.group_project_2019_20_group_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.group_project_2019_20_group_6.Adapter.HomepageRecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
        getJSON("http://81.98.161.132/getallnewsfeed.php");
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




    }

    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: initrecyclerview" );
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        HomepageRecyclerViewAdapter adapter = new HomepageRecyclerViewAdapter(mNames,mPostUrls,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {
                    GetDataFromDataBase(s); //calling the method below
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void GetDataFromDataBase(String json) throws JSONException {
        JSONArray jsonArrayList = new JSONArray(json);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArrayList.length(); i++) {
            JSONObject obj = jsonArrayList.getJSONObject(i);
            mNames.add (obj.getString( "Username")); //adding the elements of the database
            mPostUrls.add (obj.getString("postImage"));
            mImageUrls.add (obj.getString("UserImage"));

        }

        initRecyclerView();


    }
}