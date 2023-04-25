package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.AudioLiveAdapter;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

public class NewBakthiMusicActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Activity activity;
    AudioLiveAdapter audioLiveAdapter;
    DatabaseHelper databaseHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bakthi_music);

        activity = this;

        databaseHelper = new DatabaseHelper(activity);

        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        audiolive();


    }

    private void audiolive() {
        Log.d("AUDIO_COUNT", String.valueOf(databaseHelper.getAudiosCount()));
        if (databaseHelper.getAudioList().size() != 0) {
            audioLiveAdapter = new AudioLiveAdapter(activity, databaseHelper.getAudioList());
            recyclerView.setAdapter(audioLiveAdapter);
        } else {
            recyclerView.setVisibility(View.GONE);
        }
    }


}