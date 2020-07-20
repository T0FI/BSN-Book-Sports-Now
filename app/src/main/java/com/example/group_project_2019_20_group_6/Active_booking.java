package com.example.group_project_2019_20_group_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group_project_2019_20_group_6.Adapter.HomepageRecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Active_booking extends AppCompatActivity {

    TextView RefNo, Date, Time, Location, Facility, Extra;
    Button callbackdash;
    Button callbackdash2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_booking);

        //Underline Text Style
        TextView Bookinginfo = findViewById(R.id.bookinginfo);
        String text = "Booking Information";
        SpannableString ss = new SpannableString(text);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        ss.setSpan(underlineSpan, 0, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Bookinginfo.setText(ss);


        RefNo = findViewById(R.id.refNo);
        Date = findViewById(R.id.date);
        Time = findViewById(R.id.time);
        Location = findViewById(R.id.location);
        Facility = findViewById(R.id.facility);
        Extra = findViewById(R.id.extra);


        getJSON("http://81.98.161.132/getAllActive_Bookings_info.php");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            //navigation bar
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(Active_booking.this,
                                com.example.group_project_2019_20_group_6.Homepage.class);
                        overridePendingTransition(0, 0);
                        startActivity(intent);
                        break;
                    case R.id.league:
                        Intent intent2 = new Intent(Active_booking.this,
                                com.example.group_project_2019_20_group_6.LeagueMain.class);
                        overridePendingTransition(0, 0);
                        startActivity(intent2);
                        break;
                    case R.id.userscreen:
                        Intent intent3 = new Intent(Active_booking.this,
                                com.example.group_project_2019_20_group_6.UserProfile.class);
                        overridePendingTransition(0, 0);
                        startActivity(intent3);
                        break;
                }
                return false;
            }

        });
        callbackdash = findViewById(R.id.backdash);

        callbackdash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Active_booking.this, User_Dashboard.class);
                startActivity(intent);

            }
        });
        callbackdash2 = findViewById(R.id.backdash2);

        callbackdash2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Active_booking.this, User_Dashboard.class);
                startActivity(intent);

            }
        });
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
            list.add (obj.getString( "Booking ref no")); //adding the elements of the database
            list.add (obj.getString("Date"));
            list.add (obj.getString("Time"));
            list.add(obj.getString("Location"));
            list.add(obj.getString("Facility"));
            list.add (obj.getString("Extra equipment"));
        }

        RefNo.setText(list.get(0)); //setting the elements of the array into the textview
        Date.setText(list.get(1));
        Time.setText(list.get(2));
        Location.setText(list.get(3));
        Facility.setText(list.get(4));
        Extra.setText(list.get(5));

    }
}
