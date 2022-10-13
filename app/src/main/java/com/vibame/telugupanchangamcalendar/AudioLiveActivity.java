package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.adapter.AudioLiveAdapter;
import com.vibame.telugupanchangamcalendar.adapter.VideoLiveAdapter;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.Audio;
import com.vibame.telugupanchangamcalendar.model.Video;

import java.util.ArrayList;

public class AudioLiveActivity extends AppCompatActivity {

    Activity activity;
    RecyclerView recyclerView;
    AudioLiveAdapter audioLiveAdapter;
    ImageView imgBack;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_live);

        activity = AudioLiveActivity.this;



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


        audiolive();

    }

    private void audiolive() {
        Log.d("AUDIO_COUNT",databaseHelper.getAudiosCount() + "");



        if (databaseHelper.getAudioList().size() !=0){
            audioLiveAdapter = new AudioLiveAdapter(activity, databaseHelper.getAudioList());
            recyclerView.setAdapter(audioLiveAdapter);

        }
        else {
            recyclerView.setVisibility(View.GONE);

        }
    }
}