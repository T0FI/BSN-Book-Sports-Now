package com.example.group_project_2019_20_group_6;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExtraAdapter extends BaseExpandableListAdapter {

    private Context c;
    private ArrayList<Sports> sports;
    private LayoutInflater inflater;

    public ExtraAdapter(android.content.Context c, ArrayList<Sports> sports) {
        this.c = c;
        this.sports = sports;
        inflater = (LayoutInflater) c.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
    }

    //Get the number of sports
    @Override
    public int getGroupCount() {
        return sports.size();
    }
    // get the number of extras
    @Override
    public int getChildrenCount(int groupPosition) {
        return sports.get(groupPosition).extras.size();
    }
    // Get Sport
    @Override
    public Object getGroup(int groupPosition) {
        return sports.get(groupPosition);
    }

    // get a single extra
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return sports.get(groupPosition).extras.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    //get sport row
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // Only inflate xml row layout if it isnot present, otherwise reuse it
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sport, null);
        }
        // Get group/sport Item
        Sports s= (Sports) getGroup(groupPosition);
        // Set Sport name
        TextView tv1= (TextView) convertView.findViewById(R.id.textView);

        String name=s.Name;
        tv1.setText(name);

        //set team row background color
        convertView.setBackgroundColor(Color.WHITE);

        return convertView;
    }

    // get the extra row
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        // Only inflate xml row layout if it isnot present, otherwise reuse it
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.extra, null);
        }

        //get extra/child name

        String child = (String) getChild(groupPosition, childPosition);

        //set child/extra name
        TextView tv = (TextView) convertView.findViewById(R.id.textView2);
        ImageView img = (ImageView) convertView.findViewById(R.id.ivBasketballSplash);

        tv.setText(child);

        //get sport name
        String sportname = getGroup(groupPosition).toString();

        // assign extras according to their sport
        if (sportname == "Football") {
            if (child == "Balls") {
                img.setImageResource(R.drawable.footballball);
            } else if (child == "Bibs") {
                img.setImageResource(R.drawable.sportbibs);
            } else if (child == "Cones") {
                img.setImageResource(R.drawable.cones);
            }
        }
        else if (sportname == "Basketball") {
            if (child == "Balls") {
                img.setImageResource(R.drawable.basketbball);
            } else if (child == "Bibs") {
                img.setImageResource(R.drawable.sportbibs);
            } else if (child == "Cones") {
                img.setImageResource(R.drawable.cones);
            }
        }
        else if (sportname == "Tennis") {
            if (child == "Balls") {
                img.setImageResource(R.drawable.tennisballs);
            } else if (child == "Cones") {
                img.setImageResource(R.drawable.cones);
            } else if (child == "Rackets") {
                img.setImageResource(R.drawable.racquets);
            }
        }
        else if(sportname=="Badminton"){
            if (child == "Balls") {
                img.setImageResource(R.drawable.badmintonball);
            } else if (child == "Rackets") {
                img.setImageResource(R.drawable.badmintonracket);
            }
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable ( int groupPosition, int childPosition){
        return true;
    }
}
