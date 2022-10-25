package com.vibame.telugupanchangamcalendar.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.KakiAdapter;
import com.vibame.telugupanchangamcalendar.model.KakiData;

public class KakiActivity extends AppCompatActivity {
    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaki);
        recyclerView = findViewById(R.id.kaki_rcView);
        imgBack = findViewById(R.id.back_opt);
        title = findViewById(R.id.tvHead);
        title.setText(R.string.kaki_sasthram);


        KakiData[] kakiData = new KakiData[]{
                new KakiData("First KAKI", "this is first kakiSasthram descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),
                new KakiData("Second Kaki", "this is Second kakiSasthram descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),
                new KakiData("Guest Kaki Sasth","wellcome to kaki sastharam for new members"),
                new KakiData("Third KAKI", "this is Third kakiSasthram descriptionhis is first to last lambda"),
                new KakiData("Guest Kaki Sasth","all the best for alln to Kaki sasth")

        };
        KakiAdapter adapter = new KakiAdapter(kakiData, activity);
        activity = KakiActivity.this;
        imgBack.setOnClickListener(view -> onBackPressed());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}