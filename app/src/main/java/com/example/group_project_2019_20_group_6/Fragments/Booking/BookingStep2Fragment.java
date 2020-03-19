package com.example.group_project_2019_20_group_6.Fragments.Booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.group_project_2019_20_group_6.R;

import java.util.ArrayList;


public class BookingStep2Fragment extends Fragment {

    public static class Pitch {
        int no;
        int branchNo;
        int pitchPrize;
        String pitchSize;

        public int getPitchNo() {
            return no;
        }

        Pitch(int n, int branchNo, int pitchPrize, String pitchSize) {

            no = n;
            this.branchNo = branchNo;
            this.pitchPrize = pitchPrize;
            this.pitchSize = pitchSize;
        }

//        @Override
//        public String

    }

    static BookingStep2Fragment instance;

    public static BookingStep2Fragment getInstance() {
        if (instance == null)
            instance = new BookingStep2Fragment();
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_booking_step_two,container, false);
    }

    public void update() {

//        ArrayList<Pitch>

    }
}
