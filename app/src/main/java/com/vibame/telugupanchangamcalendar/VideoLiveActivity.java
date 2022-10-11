package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.adapter.GrahaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.VideoLiveAdapter;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.Video;

import java.util.ArrayList;

public class VideoLiveActivity extends AppCompatActivity {

    Activity activity;
    RecyclerView recyclerView;
    VideoLiveAdapter videoLiveAdapter;
    ImageView imgBack;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_live);
        activity = VideoLiveActivity.this;

        databaseHelper = new DatabaseHelper(activity);
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

        if (databaseHelper.getVideoList().size() !=0){
            videoLiveAdapter = new VideoLiveAdapter(activity, databaseHelper.getVideoList());
            recyclerView.setAdapter(videoLiveAdapter);

        }
        else {
            recyclerView.setVisibility(View.GONE);

        }
    }
}