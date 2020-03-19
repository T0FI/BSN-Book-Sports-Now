package com.example.group_project_2019_20_group_6.Fragments.Booking;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group_project_2019_20_group_6.Adapter.MyBranchAdapter;
import com.example.group_project_2019_20_group_6.Adapter.sqlBranchAdapter;
import com.example.group_project_2019_20_group_6.R;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.mysql.cj.xdevapi.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.*;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.group_project_2019_20_group_6.Adapter.sqlBranchAdapter.json;


public class BookingStep1Fragment extends Fragment {

    public static class Branch {
        int no;
        int location;
        String name;
        String locationName;

        public int getBranchNo() {
                return no;
        }

        Branch(int n, int location, String name, String locationName) {
            no = n;
            this.location = location;
            this.name = name;
            this.locationName = locationName;
        }

        @Override
        public String toString() {
            return name + "  -  " + locationName;
        }

    }

    @BindView(R.id.spinner)
    MaterialSpinner spinner;

    //@BindView(R.id.recycler_branch)
    //RecyclerView recycler_branch;

    Unbinder unbinder;

    static BookingStep1Fragment instance;

    public static BookingStep1Fragment getInstance() {
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
    }

    public void updateSpinner() {


        ArrayList<Branch> list = new ArrayList<Branch>();
             //Get tuple (row)
        for (int i = 0; i < json.length(); i++) {
            JSONObject elm = null;
            try {
                elm = json.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            //Create a branch form the tuple
            try {
                Branch br = new Branch(elm.getInt("branchNo"), elm.getInt("locationNo"), elm.getString("branchName"), elm.getString("branchLocationName"));
                list.add(br);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        spinner.setItems(list);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View itemView = inflater.inflate(R.layout.fragment_booking_step_one, container, false);
        unbinder = ButterKnife.bind(this, itemView);

        //Json fetching
        sqlBranchAdapter.connect(this);

        return itemView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
