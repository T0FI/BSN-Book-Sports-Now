package com.example.group_project_2019_20_group_6.Fragments.Booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.group_project_2019_20_group_6.R;


public class BookingStep5Fragment extends Fragment {

    static BookingStep5Fragment instance;

    public static BookingStep5Fragment getInstance() {
        if (instance == null)
            instance = new BookingStep5Fragment();
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

        return inflater.inflate(R.layout.fragment_booking_step_five,container, false);
    }
}
