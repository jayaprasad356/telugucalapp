package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.PushapaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.TeluguYearsAdapter;
import com.vibame.telugupanchangamcalendar.model.Pushapalu;
import com.vibame.telugupanchangamcalendar.model.TeluguYear;

public class PushapaluActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pushapalu);

        Pushapalu[] pushapalus = new Pushapalu[]{
                new Pushapalu("Title","1"),
                new Pushapalu("Title","Title"),
                new Pushapalu("Title","Title")



        };


        recyclerView = findViewById(R.id.Telugu_rcView);
        PushapaluAdapter adapter = new PushapaluAdapter(pushapalus, activity);

        imgBack = findViewById(R.id.imgBack);
        activity = PushapaluActivity.this;


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