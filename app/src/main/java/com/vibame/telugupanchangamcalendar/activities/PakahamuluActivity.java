package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.MonthAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PakshamuluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PushapaluAdapter;
import com.vibame.telugupanchangamcalendar.model.MonthData;
import com.vibame.telugupanchangamcalendar.model.Pakshamulu;

public class PakahamuluActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakahamulu);


        Pakshamulu[] pakshamulus = new Pakshamulu[]{
                new Pakshamulu("Month", "this is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),
                new Pakshamulu("Month", "this is Second sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),
                new Pakshamulu("Month", "this is Third sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),

        };
        recyclerView = findViewById(R.id.month_rcView);
        PakshamuluAdapter adapter = new PakshamuluAdapter(pakshamulus, activity);

        imgBack = findViewById(R.id.imgBack);
        activity = PakahamuluActivity.this;


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}