package com.example.group_project_2019_20_group_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class Extra1Activity extends AppCompatActivity {

    String eTitle[]= {"Balls","Bibs","Cones","Rackets"};
    int images[]={R.drawable.footballball,R.drawable.cones,R.drawable.badmintonball,R.drawable.basketbball,R.drawable.racquets,R.drawable.badmintonracket,R.drawable.tennisballs,R.drawable.sportbibs};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra1);

        //Expandable
        final ExpandableListView elv = (ExpandableListView) findViewById(R.id.expandableView);
        final ArrayList<Sports> sport = getData();

        // Create and Bind to Adapter
        ExtraAdapter adapter = new ExtraAdapter(this, sport);
        elv.setAdapter(adapter);

        //set on child click listener
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if(groupPosition==0){
                    if(childPosition==0){
                        Intent intent= new Intent(getApplicationContext(),Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle= new Bundle();
                        bundle.putInt("Image",images[0]);
                        intent.putExtras(bundle);
                        //put the index title to other activity
                        intent.putExtra("title",eTitle[0]);
                        startActivity(intent);
                    }
                    if(childPosition==1){
                        Intent intent= new Intent(getApplicationContext(),Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle= new Bundle();
                        bundle.putInt("Image",images[7]);
                        intent.putExtras(bundle);
                        intent.putExtra("title",eTitle[1]);
                        startActivity(intent);
                    }
                    if(childPosition==2){
                        Intent intent= new Intent(getApplicationContext(),Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle= new Bundle();
                        bundle.putInt("Image",images[1]);
                        intent.putExtras(bundle);
                        intent.putExtra("title",eTitle[2]);
                        startActivity(intent);
                    }
                }
                else if (groupPosition==1) {
                    if (childPosition == 0) {
                        Intent intent = new Intent(getApplicationContext(), Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[3]);
                        intent.putExtras(bundle);
                        intent.putExtra("title",eTitle[0]);
                        startActivity(intent);
                    }
                    if (childPosition == 1) {
                        Intent intent = new Intent(getApplicationContext(), Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[7]);
                        intent.putExtras(bundle);
                        intent.putExtra("title",eTitle[1]);
                        startActivity(intent);
                    }
                    if (childPosition == 2) {
                        Intent intent = new Intent(getApplicationContext(), Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[1]);
                        intent.putExtras(bundle);
                        intent.putExtra("title",eTitle[2]);
                        startActivity(intent);
                    }
                }
                else if(groupPosition==2){
                    if (childPosition==0){
                        Intent intent= new Intent(getApplicationContext(),Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle= new Bundle();
                        bundle.putInt("Image",images[6]);
                        intent.putExtras(bundle);
                        intent.putExtra("title",eTitle[0]);
                        startActivity(intent);
                    }
                    if(childPosition==1){
                        Intent intent= new Intent(getApplicationContext(),Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle= new Bundle();
                        bundle.putInt("Image",images[1]);
                        intent.putExtras(bundle);
                        intent.putExtra("title",eTitle[2]);
                        startActivity(intent);
                    }
                    if (childPosition==2) {
                        Intent intent = new Intent(getApplicationContext(), Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle = new Bundle();
                        bundle.putInt("Image", images[4]);
                        intent.putExtras(bundle);
                        intent.putExtra("title",eTitle[3]);
                        startActivity(intent);
                    }
                }
                else if (groupPosition==3){
                    if(childPosition==0){
                        Intent intent= new Intent(getApplicationContext(),Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle= new Bundle();
                        bundle.putInt("Image",images[2]);
                        intent.putExtras(bundle);
                        intent.putExtra("title",eTitle[0]);
                        startActivity(intent);
                    }
                    if(childPosition==1){
                        Intent intent= new Intent(getApplicationContext(),Extra2Activity.class);
                        //put the index image to the other activity
                        Bundle bundle= new Bundle();
                        bundle.putInt("Image",images[5]);
                        intent.putExtras(bundle);
                        intent.putExtra("title",eTitle[3]);
                        startActivity(intent);
                    }
                }

                return false;
            }
        });

    }

    // Add and get data
    private ArrayList<Sports> getData()
    {
        Sports sp1= new Sports("Football");
        sp1.extras.add("Balls");
        sp1.extras.add("Bibs");
        sp1.extras.add("Cones");

        Sports sp2= new Sports("Basketball");
        sp2.extras.add("Balls");
        sp2.extras.add("Bibs");
        sp2.extras.add("Cones");

        Sports sp3= new Sports("Tennis");
        sp3.extras.add("Balls");
        sp3.extras.add("Cones");
        sp3.extras.add("Rackets");

        Sports sp4= new Sports("Badminton");
        sp4.extras.add("Balls");
        sp4.extras.add("Rackets");

        ArrayList<Sports> allSports= new ArrayList<Sports>();
        allSports.add(sp1);
        allSports.add(sp2);
        allSports.add(sp3);
        allSports.add(sp4);

        return allSports;

    }
}
