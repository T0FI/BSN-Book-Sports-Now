package com.example.group_project_2019_20_group_6.Fragments.Booking;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.group_project_2019_20_group_6.Adapter.sqlBranchAdapter;
import com.example.group_project_2019_20_group_6.Adapter.sqlTimesAdapter;
import com.example.group_project_2019_20_group_6.R;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.group_project_2019_20_group_6.Adapter.sqlBranchAdapter.json;


public class BookingStep3Fragment extends Fragment {


//    public static BookingStep3Fragment getInstance() {
//        if (instance == null)
//            instance = new BookingStep3Fragment();
//        return instance;
//    }

    public static class Time {
        int no;
        String timesRange;

        public int get_timesNo() {
            return no;
        }

        Time(int n, String timesRange) {
            no = n;
            this.timesRange = timesRange;

        }

        @Override
        public String toString() { return "" +  timesRange; }

    }

    @BindView(R.id.spinnerTime)
    MaterialSpinner spinnerTime;


    Unbinder unbinder;

    static BookingStep3Fragment instance;

    public static BookingStep3Fragment getInstance() {
        if (instance == null)
            instance = new BookingStep3Fragment();
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static BookingStep3Fragment.Time selectedTime;

    public void updateSpinnerTime() {
        ArrayList<BookingStep3Fragment.Time> list = new ArrayList<BookingStep3Fragment.Time>();
        //Get tuple (row)
        for (int i = 0; i < json.length(); i++) {
            JSONObject elm = null;
            try {
                elm = json.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Create a branch from the tuple
            try {
                BookingStep3Fragment.Time T = new BookingStep3Fragment.Time(elm.getInt("timesNo"), elm.getString("timesRange"));
                list.add(T);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        spinnerTime.setItems(list);

        spinnerTime.setOnItemSelectedListener((a,b,c,d)-> {
            selectedTime = list.get(a.getSelectedIndex());
            System.out.println("Selected");
//            BookingStep2Fragment.connect();
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View itemView = inflater.inflate(R.layout.fragment_booking_step_three,container, false);
        unbinder = ButterKnife.bind(this, itemView);

        //Json fetching
        sqlTimesAdapter.connect(this);

        return itemView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}






