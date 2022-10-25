package com.vibame.telugupanchangamcalendar.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.BalliAdapter;
import com.vibame.telugupanchangamcalendar.model.BalliData;

public class BalliSasthramActivity extends AppCompatActivity {
    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balli_sasthram);
        recyclerView = findViewById(R.id.balli_rcView);
        imgBack = findViewById(R.id.back_opt);
        title = findViewById(R.id.tvHead);
        title.setText(R.string.balli_sasthram);
        BalliData[] balliData = new BalliData[]{
                new BalliData("Balli Sasthram Female", "his is first kakiSasthram description this is first kakiSasthram description need three lines so typing is must skill for computer users", "Female Body", "Uses", "telugu", "telugu", "telugu", "telugu"),
                new BalliData("Balli Sasthram Male", "this is Second Balli adapter datas to store with common commands kakiSasthram description", "Male Body", "Uses", "telugu", "telugu", "telugu", "telugu"),
                new BalliData("How To Remove Dhosham", "this is Third Balli adapter datas to store with common commands kakiSasthram description", "Male Body", "Uses", "telugu", "telugu", "telugu", "telugu")

        };
        BalliAdapter adapter = new BalliAdapter(balliData, activity);
        activity = BalliSasthramActivity.this;
        imgBack.setOnClickListener(view -> onBackPressed());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }
}