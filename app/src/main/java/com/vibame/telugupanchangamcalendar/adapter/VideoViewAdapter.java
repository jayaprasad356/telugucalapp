package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.artjimlop.altex.AltexImageDownloader;
import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.PlayVideoActivity;
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



        Glide.with(activity).load(videosView.getVideo()).into(holder.imgGod);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PlayVideoActivity.class);
                intent.putExtra("videoUrl",videosView.getVideo());
                activity.startActivity(intent);
            }
        });
        holder.cartPlaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PlayVideoActivity.class);
                intent.putExtra("videoUrl",videosView.getVideo());
                activity.startActivity(intent);
            }
        });
        holder.tvDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AltexImageDownloader.writeToDisk(activity,videosView.getVideo() , "Video");
                Toast.makeText(activity, "Video Donloading...", Toast.LENGTH_SHORT).show();
            }
        });
        holder.imgbtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (like){

                    like = false;
                    holder.imgbtnLike.setBackgroundResource(R.drawable.ic_baseline_favorite_24);

                }

                else {

                    like = true;

                    holder.imgbtnLike.setBackgroundResource(R.drawable.ic_filled_heart_filled);




                }





            }
        });
        holder.tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Create an ACTION_SEND Intent*/
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                /*This will be the actual content you wish you share.*/
                String shareBody = videosView.getVideo();
                /*The type of the content is text, obviously.*/
                intent.setType("text/plain");
                /*Applying information Subject and Body.*/
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                /*Fire!*/
                activity.startActivity(Intent.createChooser(intent, "Share"));
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return videosViews.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {

        final ImageView imgGod;
        final  TextView tvDownload,tvShare;
        final ImageButton imgbtnLike;
        final ImageButton cartPlaybtn;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            imgGod = itemView.findViewById(R.id.imgGod);
            tvDownload = itemView.findViewById(R.id.tvDownload);
            imgbtnLike = itemView.findViewById(R.id.imgbtnLike);
            tvShare = itemView.findViewById(R.id.tvShare);
            cartPlaybtn = itemView.findViewById(R.id.cartPlaybtn);


        }
    }
}
