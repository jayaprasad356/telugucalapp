package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.SakunaluActivity;
import com.vibame.telugupanchangamcalendar.adapter.MonthAdapter;
import com.vibame.telugupanchangamcalendar.adapter.SakunaluAdapter;
import com.vibame.telugupanchangamcalendar.model.MonthData;
import com.vibame.telugupanchangamcalendar.model.SakunaluData;

public class MonthActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);



        MonthData[] monthData = new MonthData[]{
                new MonthData("Month", "this is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),
                new MonthData("Month", "this is Second sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),
                new MonthData("Month", "this is Third sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),
                new MonthData("Month", "this is Third sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),

        };
        recyclerView = findViewById(R.id.month_rcView);
        MonthAdapter adapter = new MonthAdapter(monthData, activity);

        imgBack = findViewById(R.id.imgBack);
        activity = MonthActivity.this;


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