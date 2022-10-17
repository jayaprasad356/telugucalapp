package com.vibame.telugupanchangamcalendar.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.artjimlop.altex.AltexImageDownloader;
import com.bumptech.glide.Glide;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.model.ImageTab;
import com.vibame.telugupanchangamcalendar.model.ImagesView;

import java.util.ArrayList;


public class ImageViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<ImagesView> imagesViews;
    boolean like = false;

    public ImageViewAdapter(Activity activity, ArrayList<ImagesView> imagesViews) {
        this.activity = activity;
        this.imagesViews = imagesViews;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.image_view_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final ImagesView imagesView = imagesViews.get(position);



        Glide.with(activity).load(imagesView.getImage()).into(holder.imgGod);

        holder.tvDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AltexImageDownloader.writeToDisk(activity,imagesView.getImage() , "IMAGES");
                Toast.makeText(activity, "Image Donloading...", Toast.LENGTH_SHORT).show();
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
                String shareBody = imagesView.getImage();
                /*The type of the content is text, obviously.*/
                intent.setType("text/plain");
                /*Applying information Subject and Body.*/
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                /*Fire!*/
                activity.startActivity(Intent.createChooser(intent, "Share"));
            }
        });

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
        return imagesViews.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {

        final ImageView imgGod;
        final  TextView tvDownload,tvShare;
        final ImageButton imgbtnLike;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);

            imgGod = itemView.findViewById(R.id.imgGod);
            tvDownload = itemView.findViewById(R.id.tvDownload);
            imgbtnLike = itemView.findViewById(R.id.imgbtnLike);
            tvShare = itemView.findViewById(R.id.tvShare);

        }
    }
}
