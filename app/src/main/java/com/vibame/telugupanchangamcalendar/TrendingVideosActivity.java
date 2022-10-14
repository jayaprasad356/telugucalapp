package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.adapter.ImageViewAdapter;
import com.vibame.telugupanchangamcalendar.adapter.VideoViewAdapter;
import com.vibame.telugupanchangamcalendar.model.ImagesView;
import com.vibame.telugupanchangamcalendar.model.VideosView;

import java.util.ArrayList;

public class TrendingVideosActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Activity activity;
    ImageView imgBack;
    VideoViewAdapter videoViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_videos);

        activity = TrendingVideosActivity.this;


        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);



        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(gridLayoutManager);


       videos();
    }

    private void videos() {

        ArrayList<VideosView> videosViews = new ArrayList<>();

        VideosView imageTab1 = new VideosView("","");
        VideosView imageTab2 = new VideosView("","");
        VideosView imageTab3 = new VideosView("","");
        VideosView imageTab4 = new VideosView("","");

        videosViews.add(imageTab1);
        videosViews.add(imageTab2);
        videosViews.add(imageTab3);
        videosViews.add(imageTab4);

        videoViewAdapter = new VideoViewAdapter(activity,videosViews);
        recyclerView.setAdapter(videoViewAdapter);
    }
}