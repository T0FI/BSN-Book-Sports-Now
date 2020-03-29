package com.example.group_project_2019_20_group_6.Fragments.Booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group_project_2019_20_group_6.Adapter.sqlBranchAdapter;
import com.example.group_project_2019_20_group_6.Adapter.sqlPitchAdapter;
import com.example.group_project_2019_20_group_6.R;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.group_project_2019_20_group_6.Adapter.sqlPitchAdapter.json;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class BookingStep2Fragment extends Fragment {

    @BindView(R.id.recycler_pitch)
    RecyclerView pitchesView;

    private RecyclerView recycler_pitch = pitchesView;

    public static class Pitch {
        int no;
        int pitchPrice;
        String pitchSize;

        public int getPitchNo() {
            return no;
        }

        Pitch(int n, int pitchPrice, String pitchSize) {

            no = n;
            this.pitchPrice = pitchPrice;
            this.pitchSize = pitchSize;
        }

        @Override
        public String toString() {
            return pitchSize + "PITCH";
        }
    }

    static BookingStep2Fragment instance;

    public static BookingStep2Fragment getInstance() {
        if (instance == null)
            instance = new BookingStep2Fragment();
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

        View itemView = inflater.inflate(R.layout.fragment_booking_step_two, container, false);
        Unbinder unbinder = ButterKnife.bind(this, itemView);

        return itemView;

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
                Pitch br = new Pitch(elm.getInt("pitchNo"), elm.getInt("pitchPrize"), elm.getString("pitchSize"));
                list.add(br);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //Update into view
        recycler_pitch = pitchesView;
        recycler_pitch.setHasFixedSize(true);
        recycler_pitch.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //https://developer.android.com/guide/topics/ui/layout/recyclerview
        class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

            class MyViewHolder extends RecyclerView.ViewHolder {
                // each data item is just a string in this case
                public androidx.cardview.widget.CardView v;
                public MyViewHolder(CardView v) {
                    super(v);
                    this.v = v;
                }
            }


            // Create new views (invoked by the layout manager)
            @Override
            public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                // create a new view
                androidx.cardview.widget.CardView v = (CardView) LayoutInflater.from(getContext()).inflate(R.layout.layout_pitch, parent, false);
//                parent.addView(v);

                MyViewHolder vh = new MyViewHolder(v);

                return vh;
            }

            // Replace the contents of a view (invoked by the layout manager)
            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                // - get element from your dataset at this position
                // - replace the contents of the view with that element
                Pitch p = list.get(position);
                LinearLayout o = (LinearLayout) holder.v.getChildAt(0);

                ((TextView) o.getChildAt(1)).setText(String.valueOf(p.no));
                ((TextView) o.getChildAt(2)).setText(String.valueOf(p.pitchSize));
                ((TextView) o.getChildAt(3)).setText("£" + p.pitchPrice);

                holder.itemView.setOnClickListener((event) -> {
                    Pitch clickedPitch  = p;

                    //Call on booking 3

                });

            }

            // Return the size of your dataset (invoked by the layout manager)
            @Override
            public int getItemCount() {
                return list.size();
            }
        }

        MyAdapter a = new MyAdapter();
        recycler_pitch.setAdapter(a);

    }
}
