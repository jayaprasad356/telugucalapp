package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.ImagesActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.VideosActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.ImageTab;
import com.vibame.telugupanchangamcalendar.model.VideoTab;

import java.util.ArrayList;


public class VideosTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<VideoTab> videoTabs;

    public VideosTabAdapter(Activity activity, ArrayList<VideoTab> videoTabs) {
        this.activity = activity;
        this.videoTabs = videoTabs;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.image_tab_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final VideoTab videoTab = videoTabs.get(position);


        holder.tvTitle.setText(videoTab.getName());
        Glide.with(activity).load(videoTab.getImage()).into(holder.imgGod);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, VideosActivity.class);
                intent.putExtra(Constant.VIDEO_CATEGORY_ID,videoTab.getId());
                intent.putExtra(Constant.NAME,videoTab.getName());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return videoTabs.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final ImageView imgGod;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            imgGod = itemView.findViewById(R.id.imgGod);

        }
    }
}
