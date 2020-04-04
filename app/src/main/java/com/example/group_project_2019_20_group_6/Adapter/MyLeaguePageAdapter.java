package com.example.group_project_2019_20_group_6.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.group_project_2019_20_group_6.LeagueTest;

public class MyLeaguePageAdapter extends FragmentPagerAdapter {

    public MyLeaguePageAdapter(FragmentManager fm) {

        super(fm);

    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return LeagueTest.getInstance();
            case 1:



        }

        return null;
    }

    @Override
    public int getCount() {

        return 1;
    }
}