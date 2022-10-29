package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.TeluguYearsAdapter;
import com.vibame.telugupanchangamcalendar.adapter.ThidhiAdhiAdapter;
import com.vibame.telugupanchangamcalendar.model.TeluguYear;
import com.vibame.telugupanchangamcalendar.model.ThidhiAdhi;

public class ThidhiAdhiActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thidhi_adhi);



        ThidhiAdhi[] thidhiAdhis = new ThidhiAdhi[]{
                new ThidhiAdhi("1. Pharbava","1901 1910 2010 2100"),
                new ThidhiAdhi("2. Pharbava","1901 1910 2010 2100"),
                new ThidhiAdhi("1. Pharbava","1901 1910 2010 2100"),


        };


        recyclerView = findViewById(R.id.Telugu_rcView);
        ThidhiAdhiAdapter adapter = new ThidhiAdhiAdapter(thidhiAdhis, activity);

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