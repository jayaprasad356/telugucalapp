package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.AudioLiveAdapter;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

public class LiveDharsanamActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    AudioLiveAdapter audioLiveAdapter;
    DatabaseHelper databaseHelper ;
    ImageView imgBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_dharsanam);
        activity = this;

        databaseHelper = new DatabaseHelper(activity);

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(gridLayoutManager);
        audiolive();


    }

    private void audiolive() {
        Log.d("AUDIO_COUNT", String.valueOf(databaseHelper.getOtherAudiosCount()));
        if (databaseHelper.getAudioList().size() != 0) {
            audioLiveAdapter = new AudioLiveAdapter(activity, databaseHelper.getOtherMusicList());
            recyclerView.setAdapter(audioLiveAdapter);
        } else {
            recyclerView.setVisibility(View.GONE);
        }
    }


}