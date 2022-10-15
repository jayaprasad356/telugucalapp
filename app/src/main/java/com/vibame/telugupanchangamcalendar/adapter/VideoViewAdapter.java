package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.app.Notification;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.ImagesView;
import com.vibame.telugupanchangamcalendar.model.VideosView;

import java.util.ArrayList;


public class VideoViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<VideosView> videosViews;
    boolean like = false;

    public VideoViewAdapter(Activity activity, ArrayList<VideosView> videosViews) {
        this.activity = activity;
        this.videosViews = videosViews;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.video_view_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final VideosView videosView = videosViews.get(position);



        Glide.with(activity).load(videosView.getImage()).into(holder.imgGod);
//        holder.tvlikebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View v) {
//                if(like){
//                    like = false;
//
//                    holder.tvlikebtn.setBackground(activity.getResources().getDrawable());
//
//                }
//                else {
//                    like = true;
//                    holder.tvlikebtn.setBackground(activity.getResources().getDrawable(R.drawable.ic_baseline_favorite_24));
//
//                }
//
//
//            }
//        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity, AudioPlayActivity.class);
//                intent.putExtra(Constant.AUDIO_TITLE,audio1.getTitle());
//                intent.putExtra(Constant.AUDIO,audio1.getAudio());
//                intent.putExtra(Constant.LYRICS,audio1.getLyrics());
//                activity.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount()
    {
        return videosViews.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {

        final ImageView imgGod;
        final TextView tvlikebtn;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);

            imgGod = itemView.findViewById(R.id.imgGod);
            tvlikebtn = itemView.findViewById(R.id.tvlikebtn);

        }
    }
}
