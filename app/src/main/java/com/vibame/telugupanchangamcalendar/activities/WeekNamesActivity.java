package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.FruitsNamesAdapter;
import com.vibame.telugupanchangamcalendar.adapter.WeekNamesAdapter;
import com.vibame.telugupanchangamcalendar.model.FruitsNames;
import com.vibame.telugupanchangamcalendar.model.WeekNames;

public class WeekNamesActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_names);

        WeekNames[] weekNames = new WeekNames[]{
                new WeekNames("1. Pharbava Nama Year","1901 1910 2010 2100"),
                new WeekNames("2. Pharbava Nama Year","1901 1910 2010 2100"),
                new WeekNames("1. Pharbava Nama Year","1901 1910 2010 2100"),


        };


        recyclerView = findViewById(R.id.Telugu_rcView);
        WeekNamesAdapter adapter = new WeekNamesAdapter(weekNames, activity);

        imgBack = findViewById(R.id.imgBack);
        activity = this;


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