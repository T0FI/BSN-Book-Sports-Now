package com.example.group_project_2019_20_group_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class UserProfile extends AppCompatActivity {

    TextView UserNameTv, firstnameTv, lastnameTv2, EmailTv, ContactNoTv, CardNoTv, DobTv;
    Button calluser;
    Button calllogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        UserNameTv = findViewById(R.id.UserNameTv);
        firstnameTv = findViewById(R.id.firstnameTv);
        lastnameTv2 = findViewById(R.id.lastnameTv2);
        EmailTv = findViewById(R.id.EmailTv);
        ContactNoTv = findViewById(R.id.ContactNoTv);
        CardNoTv = findViewById(R.id.CardNoTv);
        DobTv = findViewById(R.id.DobTv);
        getJSON("http://81.98.161.132/getAllUsers.php"); //connecting to unique php link for User table on mysql
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            //navigation bar
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(UserProfile.this,
                                com.example.group_project_2019_20_group_6.Homepage.class);
                        overridePendingTransition(0, 0);
                        startActivity(intent);
                        break;
                    case R.id.league:
                        Intent intent2 = new Intent(UserProfile.this,
                                com.example.group_project_2019_20_group_6.LeagueMain.class);
                        overridePendingTransition(0, 0);
                        startActivity(intent2);
                        break;
                    case R.id.userscreen:
                        Intent intent3 = new Intent(UserProfile.this,
                                com.example.group_project_2019_20_group_6.UserProfile.class);
                        overridePendingTransition(0, 0);
                        startActivity(intent3);
                        break;
                }
                return false;
            }

        });

        calluser = findViewById(R.id.user_dashboard);

        calluser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this, User_Dashboard.class);
                startActivity(intent);

            }
        });

        calllogout = findViewById(R.id.logout);

        calllogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this,Login_2.class);
                startActivity(intent);

            }
        });

    } //on create ending




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
            list.add (obj.getString( "userName")); //adding the elements of the database
            list.add (obj.getString("firstName"));
            list.add (obj.getString("lastName"));
            list.add(obj.getString("email"));
            list.add(obj.getString("contactNo"));
            list.add (obj.getString("cardNo"));
            list.add (obj.getString("dOb"));
        }

        UserNameTv.setText(list.get(0)); //setting the elements of the array into the textview
        firstnameTv.setText(list.get(1));
        lastnameTv2.setText(list.get(2));
        EmailTv.setText(list.get(3));
        ContactNoTv.setText(list.get(4));
        CardNoTv.setText(list.get(5));
        DobTv.setText(list.get(6));


    }






}
