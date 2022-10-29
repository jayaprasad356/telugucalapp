package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.NavaGrahaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.TeluguYearsAdapter;
import com.vibame.telugupanchangamcalendar.model.NavaGrahalu;
import com.vibame.telugupanchangamcalendar.model.TeluguYear;

public class NavaGrahaluActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nava_grahalu);


        NavaGrahalu[] navaGrahalus = new NavaGrahalu[]{
                new NavaGrahalu("Title","wwwwwwww"),
                new NavaGrahalu("Title","wwwwwwww"),
                new NavaGrahalu("Title","wwwwwwww"),
                new NavaGrahalu("Title","wwwwwwww"),


        };


        recyclerView = findViewById(R.id.Telugu_rcView);
        NavaGrahaluAdapter adapter = new NavaGrahaluAdapter(navaGrahalus, activity);

        imgBack = findViewById(R.id.imgBack);
        activity = NavaGrahaluActivity.this;


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