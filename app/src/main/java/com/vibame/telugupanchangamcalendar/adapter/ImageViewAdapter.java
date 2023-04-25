package com.vibame.telugupanchangamcalendar.adapter;

import static com.vibame.telugupanchangamcalendar.helper.Constant.IMAGE_LIST_URL;
import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
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
import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.ImagesActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.ImageViewActivity;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.ImageTab;
import com.vibame.telugupanchangamcalendar.model.ImagesView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


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
        holder.imgGod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ImageViewActivity.class);
                intent.putExtra(Constant.IMAGE,imagesView.getImage());
                intent.putExtra(Constant.ID,imagesView.getId());
                activity.startActivity(intent);
            }
        });

        holder.tvDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AltexImageDownloader.writeToDisk(activity,imagesView.getImage() , "IMAGES");
                Toast.makeText(activity, "Image Donloading...", Toast.LENGTH_SHORT).show();
                downloadCountApi(imagesView.getId());
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
        holder.tvTitle.setText(imagesView.getName());
        holder.tvShare.setOnClickListener(v -> {
            /*Create an ACTION_SEND Intent*/
            Intent intent = new Intent(Intent.ACTION_SEND);
            /*This will be the actual content you wish you share.*/
            String shareBody = imagesView.getImage();
            /*The type of the content is text, obviously.*/
            intent.setType("text/plain");
            /*Applying information Subject and Body.*/
            intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
            intent.putExtra(Intent.EXTRA_TEXT, shareBody);
            /*Fire!*/
            activity.startActivity(Intent.createChooser(intent, "Share"));
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

    private void downloadCountApi(String id)
    {
        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.IMAGE_ID,id);

        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        Log.d("Image_download","yes");
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.DOWNLOADIMAGECOUNT_URL,params,false);



    }

    @Override
    public int getItemCount()
    {
        return imagesViews.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {

        final ImageView imgGod;
        final  TextView tvDownload,tvShare,tvTitle;
        final ImageButton imgbtnLike;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);

            imgGod = itemView.findViewById(R.id.imgGod);
            tvDownload = itemView.findViewById(R.id.tvDownload);
            imgbtnLike = itemView.findViewById(R.id.imgbtnLike);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvShare = itemView.findViewById(R.id.tvShare);

        }
    }
}
