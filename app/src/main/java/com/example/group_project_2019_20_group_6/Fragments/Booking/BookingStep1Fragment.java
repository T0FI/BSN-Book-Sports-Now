package com.example.group_project_2019_20_group_6.Fragments.Booking;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group_project_2019_20_group_6.R;
import com.jaredrummler.materialspinner.MaterialSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import java.sql.*;

import static android.content.Context.MODE_PRIVATE;


public class BookingStep1Fragment extends Fragment {


    @BindView(R.id.spinner)
    MaterialSpinner spinner;

    //@BindView(R.id.recycler_branch)
    //RecyclerView recycler_branch;

    Unbinder unbinder;

    static BookingStep1Fragment instance;

    public static BookingStep1Fragment getInstance() {
        if (instance == null)
            instance = new BookingStep1Fragment();
        return instance;
    }

    private volatile Connection con;
    private volatile Statement stmt;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setup SQL connection
//        try {
//            DriverManager.registerDriver((Driver) Class.forName("org.sqldroid.SQLDroidDriver").newInstance());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (java.lang.InstantiationException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        Thread ConnectionThread = new Thread(() -> {
            try {
                con = DriverManager.getConnection("jdbc:mysql://192.168.0.16/dbbsn", "user", "pass");
                stmt = con.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        ConnectionThread.setName("Con");
        ConnectionThread.start();

        while (true) {
            try {
                if (stmt != null && !stmt.isClosed()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            stmt = con.createStatement();
            System.out.println(
                stmt.execute("SELECT UserName FROM Booking;")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View itemView = inflater.inflate(R.layout.fragment_booking_step_one,container, false);
        unbinder = ButterKnife.bind(this, itemView);

        

        return itemView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
