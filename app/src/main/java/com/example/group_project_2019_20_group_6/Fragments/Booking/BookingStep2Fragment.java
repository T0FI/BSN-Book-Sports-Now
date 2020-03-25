package com.example.group_project_2019_20_group_6.Fragments.Booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group_project_2019_20_group_6.Adapter.MyBranchAdapter;
import com.example.group_project_2019_20_group_6.Adapter.sqlPitchAdapter;
import com.example.group_project_2019_20_group_6.R;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.group_project_2019_20_group_6.Adapter.sqlPitchAdapter.json;

import java.util.ArrayList;

import butterknife.BindView;


public class BookingStep2Fragment extends Fragment {
    @BindView(R.id.recycler_pitch)
    RecyclerView pitchesView;

    private RecyclerView recycler_pitch;

    public static class Pitch {
        int no;
        int branchNo;
        int pitchPrice;
        String pitchSize;

        public int getPitchNo() {
            return no;
        }

        Pitch(int n, int branchNo, int pitchPrice, String pitchSize) {

            no = n;
            this.branchNo = branchNo;
            this.pitchPrice = pitchPrice;
            this.pitchSize = pitchSize;
        }

        @Override
        public String toString(){
            return pitchSize + "PITCH";
        }



    }

    static BookingStep2Fragment instance;

    public static BookingStep2Fragment getInstance() {
        if (instance == null)
            instance = new BookingStep2Fragment();
        return instance;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        recycler_pitch = (RecyclerView) recycler_pitch.findViewById(R.id.recycler_pitch);
//        recycler_pitch.setHasFixedSize(true);
//        recycler_pitch.setLayoutManager(new LinearLayoutManager(this));
//
//    }





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);




        return inflater.inflate(R.layout.fragment_booking_step_two,container, false);
    }

    public static void connect() {
        sqlPitchAdapter.connect(getInstance(), BookingStep1Fragment.selectedBranch);
    }

    public void update() {

        ArrayList<Pitch> list = new ArrayList<Pitch>();

        //Get row from database
        for (int i = 0; i < json.length(); i++) {
            JSONObject elm = null;
            try {
                elm = json.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //Create a branch from the row
            try {
                Pitch br = new Pitch(elm.getInt("branchNo"), elm.getInt("locationNo"), elm.getInt("pitchPrize"), elm.getString("pitchSize"));
                list.add(br);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //This is a fragment manager for the pitches view
        FragmentTransaction man = getFragmentManager().beginTransaction();

        //for every pitch in a branch, a pitch layout will load
        for (int i = 0; i < list.size(); i++) {
            pitchFragment frag = new pitchFragment();
            Pitch j = list.get(i);
            frag.pitchSize.setText(j.pitchSize);
            frag.pitchPrice.setText(j.pitchPrice);
            frag.pitchNumber.setText(j.no);

            man.add(pitchesView.getId(), frag, "frag");

        }




        man.commit();





    }
}
