package com.example.group_project_2019_20_group_6.Fragments.Booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.group_project_2019_20_group_6.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class pitchFragment extends Fragment {

    @BindView(R.id.pitch_number)
    EditText pitchNumber;

    @BindView(R.id.pitch_size)
    EditText pitchSize;

    @BindView(R.id.pitch_price)
    EditText pitchPrice;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View itemView = inflater.inflate(R.layout.layout_pitch, container, false);
        unbinder = ButterKnife.bind(this, itemView);

        return itemView;
    }
}
