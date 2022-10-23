package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.adapter.SakunaluAdapter;
import com.vibame.telugupanchangamcalendar.model.SakunaluData;

public class SakunaluActivity extends AppCompatActivity {
    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sakunalu);


        SakunaluData[] sakunaluDatas = new SakunaluData[]{
                new SakunaluData("First Sakunam", "this is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),
                new SakunaluData("Second Sakunam", "this is Second sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),
                new SakunaluData("Third Sakunam", "this is Third sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description"),

        };
        recyclerView = findViewById(R.id.sakuna_rcView);
        SakunaluAdapter adapter = new SakunaluAdapter(sakunaluDatas, activity);

        imgBack = findViewById(R.id.imgBack);
        activity = SakunaluActivity.this;


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