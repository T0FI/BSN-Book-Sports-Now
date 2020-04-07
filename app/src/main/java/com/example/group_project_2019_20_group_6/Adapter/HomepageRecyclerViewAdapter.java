package com.example.group_project_2019_20_group_6.Adapter;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.group_project_2019_20_group_6.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomepageRecyclerViewAdapter extends RecyclerView.Adapter<HomepageRecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "HomepageRecyclerViewAda";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImagesPost = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();
    private Context mContext;


    public HomepageRecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<String> mImagesPost, ArrayList<String> mImage, Context mContext) {
        this.mImageNames = mImageNames;
        this.mImagesPost = mImagesPost;
        this.mImage = mImage;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false); 
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder: called.");

        // we will be adding the image post to this section
        Glide.with(mContext)
                .asBitmap()
                .load(mImagesPost.get(position))
                .into(holder.image);
        // adding the image userphoto
        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
                .into(holder.userimage);

        // we will get the image names
        holder.imagename.setText(mImageNames.get(position));
        //when the post has been clicked we will show something
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        CircleImageView userimage;
        TextView imagename;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.post);
            userimage = itemView.findViewById(R.id.profilePic);
            imagename = itemView.findViewById(R.id.UsrName);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }

}
