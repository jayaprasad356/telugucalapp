package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.KakiAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PilliAdapter;
import com.vibame.telugupanchangamcalendar.model.KakiData;
import com.vibame.telugupanchangamcalendar.model.PilliSasthramData;

public class PilliSasthramActivity extends AppCompatActivity {
    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilli_sasthram);
        recyclerView = findViewById(R.id.pilli_rcView);
        imgBack = findViewById(R.id.back_opt);
        title = findViewById(R.id.tvHead);
        title.setText(R.string.pilli_sasthram);


        PilliSasthramData[] pilliSasthramData = new PilliSasthramData[]{
                new PilliSasthramData("Pilli Sasthram Detail in info", "this card is a pilli sasthram details info descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description and is end of pilli sasthram"),


        };
        PilliAdapter adapter = new PilliAdapter(pilliSasthramData, activity);
        activity = PilliSasthramActivity.this;
        imgBack.setOnClickListener(view -> onBackPressed());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}