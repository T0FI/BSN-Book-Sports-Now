package com.example.group_project_2019_20_group_6;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.group_project_2019_20_group_6.Adapter.MyViewPageAdapter;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingActivity extends AppCompatActivity {

    @BindView(R.id.step_view)
    StepView stepView;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.btn_Previous)
    Button btn_Previous;

    @BindView(R.id.btn_Next)
    Button btn_Next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booking);

        ButterKnife.bind(this);

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

                if (i==0)
                    btn_Previous.setEnabled(false);
                else
                    btn_Previous.setEnabled(true);

                setColorButton();

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }

        });


    }

    // Changing the color of the buttons
    private void setColorButton() {

        if (btn_Next.isEnabled())
        {
            btn_Next.setBackgroundResource(R.color.colorButton);
        }
        else
        {
            btn_Next.setBackgroundResource(android.R.color.darker_gray);
        }

        if (btn_Previous.isEnabled())
        {
            btn_Previous.setBackgroundResource(R.color.colorButton);
        }
        else
        {
            btn_Previous.setBackgroundResource(android.R.color.darker_gray);
        }

    }
    // Changing the color of the buttons


    // All the steps during the booking page
    private void setupStepView() {

        List<String> stepList = new ArrayList<>();
        stepList.add("Branch");
        stepList.add("Pitch");
        stepList.add("Time");
        stepList.add("Extras");
        stepList.add("Confirm");
        stepView.setSteps(stepList);


    }
    // All the steps during the booking page




}
