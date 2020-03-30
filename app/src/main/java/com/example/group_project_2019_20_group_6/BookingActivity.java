package com.example.group_project_2019_20_group_6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;

import com.example.group_project_2019_20_group_6.Adapter.MyViewPageAdapter;
import com.google.android.gms.common.internal.service.Common;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookingActivity extends AppCompatActivity {


    LocalBroadcastManager localBroadcastManager;

    @BindView(R.id.step_view)
    StepView stepView;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

//    @BindView(R.id.btn_Previous)
//    Button btn_Previous;

    @BindView(R.id.btn_Next)
    Button btn_Next;


    //Event
    @OnClick(R.id.btn_Next)
    void nextClick(){

        Intent intentLoadAnalyseAct = new Intent(BookingActivity.this, Extra1Activity.class);
        startActivity(intentLoadAnalyseAct);
    }

    private BroadcastReceiver buttonNextReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            btn_Next.setEnabled(false);
            setColorButton();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booking);

        ButterKnife.bind(this);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
//        localBroadcastManager.registerReceiver(buttonNextReceiver.);

        setupStepView();
        setColorButton();

        //View
        viewPager.setAdapter(new MyViewPageAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {


                //Show step
                stepView.go(i,true  );

                //Enables the "next" button on step 3
                if (i==2)
                    btn_Next.setEnabled(true);
                else
                    btn_Next.setEnabled(false);

                setColorButton();


            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }

        });



    }

    // Changing the color of the button
    private void setColorButton() {

        if (btn_Next.isEnabled())
        {
            btn_Next.setBackgroundResource(R.color.colorButton);
        }
        else
        {
            btn_Next.setBackgroundResource(android.R.color.darker_gray);
        }

//        if (btn_Previous.isEnabled())
//        {
//            btn_Previous.setBackgroundResource(R.color.colorButton);
//        }
//        else
//        {
//            btn_Previous.setBackgroundResource(android.R.color.darker_gray);
//        }

    }
    // Changing the color of the button


    // All the steps during the booking page
    private void setupStepView() {

        List<String> stepList = new ArrayList<>();
        stepList.add("Branch");
        stepList.add("Pitch");
        stepList.add("Time");
//        stepList.add("Extras");
//        stepList.add("Confirm");
        stepView.setSteps(stepList);


    }
    // All the steps during the booking page




}
