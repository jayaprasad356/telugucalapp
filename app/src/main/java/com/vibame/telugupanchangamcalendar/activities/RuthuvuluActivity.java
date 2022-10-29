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
import com.vibame.telugupanchangamcalendar.adapter.RuthuvuluAdapter;
import com.vibame.telugupanchangamcalendar.model.NavaGrahalu;
import com.vibame.telugupanchangamcalendar.model.Ruthuvulu;

public class RuthuvuluActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruthuvulu);


        Ruthuvulu[] ruthuvulus = new Ruthuvulu[]{
                new Ruthuvulu("Title","wwwwwwww"),
                new Ruthuvulu("Title","wwwwwwww"),
                new Ruthuvulu("Title","wwwwwwww"),


        };


        recyclerView = findViewById(R.id.Telugu_rcView);
        RuthuvuluAdapter adapter = new RuthuvuluAdapter(ruthuvulus, activity);

        imgBack = findViewById(R.id.imgBack);
        activity = RuthuvuluActivity.this;

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