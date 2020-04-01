package com.example.group_project_2019_20_group_6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.group_project_2019_20_group_6.Adapter.sqlLeagueAdapter;
import com.example.group_project_2019_20_group_6.Fragments.Booking.BookingStep1Fragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.group_project_2019_20_group_6.Adapter.sqlLeagueAdapter.json;

public class LeagueTest extends Fragment {

    @Nullable
    @BindView(R.id.recycler_league)
    RecyclerView leagueView;


    public static class League {
        int no;
        String leagueName;
        String leagueCapacity;
        String ageRange;



        League(int n, String leagueCapacity, String ageRange, String leagueName) {

            no = n;
            this.leagueCapacity = leagueCapacity;
            this.ageRange = ageRange;
            this.leagueName = leagueName;
        }

        @Override
        public String toString() {
            return no + "";
        }
    }

    static LeagueTest instance;

    public static LeagueTest getInstance() {
        if (instance == null)
            instance = new LeagueTest();
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    RecyclerView recycler_league;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        View itemView = inflater.inflate(R.layout.activity_league_test, container, false);
        Unbinder unbinder = ButterKnife.bind(this, itemView);

        recycler_league = leagueView;

        connect();

        return itemView;
    }

    public static void connect() {
        sqlLeagueAdapter.connect(getInstance());
    }

    public void update() {

        ArrayList<League> list = new ArrayList<League>();

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
                League L = new League(elm.getInt("leagueNo"), elm.getString("leagueName"), elm.getString("leagueCapacity"), elm.getString("ageRange"));
                list.add(L);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //Update into view
        recycler_league = leagueView;
        recycler_league.setHasFixedSize(true);
        recycler_league.setLayoutManager(new LinearLayoutManager(this.getContext()));

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
                androidx.cardview.widget.CardView v = (CardView) LayoutInflater.from(getContext()).inflate(R.layout.activity_league_layout, parent, false);

                MyViewHolder vh = new MyViewHolder(v);

                return vh;
            }

            // Replace the contents of a view (invoked by the layout manager)
            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                // - get element from your dataset at this position
                // - replace the contents of the view with that element
                League l = list.get(position);
                LinearLayout o = (LinearLayout) holder.v.getChildAt(1);



                ((TextView) o.getChildAt(0)).setText(String.valueOf(l.leagueName));
                ((TextView) o.getChildAt(1)).setText(String.valueOf(l.ageRange));
                ((TextView) o.getChildAt(2)).setText(String.valueOf(l.leagueCapacity));


//                holder.itemView.setOnClickListener((event) -> {
//                    BookingStep2Fragment.Pitch clickedPitch  = p;
//                    Toast.makeText(getContext(), "You Have Selected Pitch Number" + p, Toast.LENGTH_SHORT).show();


//                });


            }

            // Return the size of your dataset (invoked by the layout manager)
            @Override
            public int getItemCount() {
                return list.size();
            }
        }

        MyAdapter a = new MyAdapter();
        recycler_league.setAdapter(a);


    }
}