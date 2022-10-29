package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.LagnaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.TeluguYearsAdapter;
import com.vibame.telugupanchangamcalendar.model.Lagnalu;
import com.vibame.telugupanchangamcalendar.model.TeluguYear;

public class LagnaluActivity extends AppCompatActivity {


    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagnalu);


        Lagnalu[] lagnalus = new Lagnalu[]{
                new Lagnalu("1. Pharbava Nama Year","1901 1910 2010 2100"),
                new Lagnalu("2. Pharbava Nama Year","1901 1910 2010 2100"),
                new Lagnalu("1. Pharbava Nama Year","1901 1910 2010 2100"),


        };


        recyclerView = findViewById(R.id.Telugu_rcView);
        LagnaluAdapter adapter = new LagnaluAdapter(lagnalus, activity);

        imgBack = findViewById(R.id.imgBack);
        activity = LagnaluActivity.this;


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