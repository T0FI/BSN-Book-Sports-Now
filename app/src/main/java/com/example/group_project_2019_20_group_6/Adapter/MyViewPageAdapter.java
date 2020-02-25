package com.example.group_project_2019_20_group_6.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.group_project_2019_20_group_6.Fragments.Booking.*;

public class MyViewPageAdapter extends FragmentPagerAdapter {

    public MyViewPageAdapter(FragmentManager fm) {

        super(fm);

    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return BookingStep1Fragment.getInstance();
            case 1:
                return BookingStep2Fragment.getInstance();
            case 2:
                return BookingStep3Fragment.getInstance();
            case 3:
//                return BookingStep4Fragment.getInstance();
//            case 4:
//                return BookingStep5Fragment.getInstance();


        }

        return null;
    }

    @Override
    public int getCount() {

        return 3;
    }
}
