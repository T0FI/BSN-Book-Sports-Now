package com.example.group_project_2019_20_group_6.Adapter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.group_project_2019_20_group_6.Fragments.Booking.BookingStep3Fragment;

import org.json.JSONArray;

public class sqlTimesAdapter {

    //URL to get all the current branches in the database
    private static String url = "http://81.98.161.132/getAlltimes.php";

    //Variable for each request on connect
    private static JsonArrayRequest request;

    //The result of the database stored here when connect is called
    public static JSONArray json = null;

    //https://stackoverflow.com/questions/45849670/how-to-get-from-mysql-data-to-android-with-json
    public static void connect(final BookingStep3Fragment obj) {
        request = new JsonArrayRequest(Request.Method.GET, url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("Complete");
                json = response;
                obj.updateSpinnerTime();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                // Error
                json = null;
                System.out.println("Error");
                System.err.println(volleyError);
            }
        });
        //run
        System.out.println("Connecting");
        Volley.newRequestQueue(obj.getContext()).add(request);
//        AppController.getInstance();
    }

}


