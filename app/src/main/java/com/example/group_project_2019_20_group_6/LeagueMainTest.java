package com.example.group_project_2019_20_group_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.group_project_2019_20_group_6.Adapter.MyLeaguePageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeagueMainTest extends AppCompatActivity {

    @BindView(R.id.view_pagerLeague)
    ViewPager viewPagerLeague;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_main_test);
        ButterKnife.bind(this);

        viewPagerLeague.setAdapter(new MyLeaguePageAdapter(getSupportFragmentManager()));

        viewPagerLeague.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {

            }


            @Override
            public void onPageScrollStateChanged(int i) {

            }

        });

    }

}