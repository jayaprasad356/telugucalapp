package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.adapter.ImageTabAdapter;
import com.vibame.telugupanchangamcalendar.adapter.VideosTabAdapter;
import com.vibame.telugupanchangamcalendar.model.ImageTab;
import com.vibame.telugupanchangamcalendar.model.VideoTab;

import java.util.ArrayList;

public class VideoTabActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    ImageView imgBack;
    VideosTabAdapter videosTabAdapter;
    CardView cardTradingImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_tab);


        activity = VideoTabActivity.this;




        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);
        cardTradingImage = findViewById(R.id.cardTradingImage);


        cardTradingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity,TrendingVideosActivity.class);
                startActivity(intent);

            }
        });

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

        ArrayList<VideoTab> videoTabs = new ArrayList<>();

        VideoTab imageTab1 = new VideoTab("","Good Morning","");
        VideoTab imageTab2 = new VideoTab("","Good Morning","");
        VideoTab imageTab3 = new VideoTab("","Good Morning","");
        VideoTab imageTab4 = new VideoTab("","Good Morning","");

        videoTabs.add(imageTab1);
        videoTabs.add(imageTab2);
        videoTabs.add(imageTab3);
        videoTabs.add(imageTab4);

        videosTabAdapter = new VideosTabAdapter(activity,videoTabs);
        recyclerView.setAdapter(videosTabAdapter);
    }
}