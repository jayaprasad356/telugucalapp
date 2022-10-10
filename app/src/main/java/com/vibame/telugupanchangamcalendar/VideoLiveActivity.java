package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.adapter.VideoLiveAdapter;
import com.vibame.telugupanchangamcalendar.model.Video;

import java.util.ArrayList;

public class VideoLiveActivity extends AppCompatActivity {

    Activity activity;
    RecyclerView recyclerView;
    VideoLiveAdapter videoLiveAdapter;
    ImageView imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_live);
        activity = VideoLiveActivity.this;


        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);


        videolive();


    }

    private void videolive() {

        ArrayList<Video> videos = new ArrayList<>();

        Video video1  = new Video("","Venkateshwara Swamy","");
        Video video2  = new Video("","Srisailam Swamy Temple","");

        videos.add(video1);
        videos.add(video2);

        videoLiveAdapter = new VideoLiveAdapter(activity,videos);
        recyclerView.setAdapter(videoLiveAdapter);
    }
}