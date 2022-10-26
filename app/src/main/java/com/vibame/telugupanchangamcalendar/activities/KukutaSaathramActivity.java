package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.KukutaAdapter;
import com.vibame.telugupanchangamcalendar.adapter.KukutaMenu2Adapter;
import com.vibame.telugupanchangamcalendar.adapter.PilliAdapter;
import com.vibame.telugupanchangamcalendar.model.KukutaSasthramData;
import com.vibame.telugupanchangamcalendar.model.KukutaSasthramMenu2Data;
import com.vibame.telugupanchangamcalendar.model.PilliSasthramData;

public class KukutaSaathramActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView,hen_start_rcView;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kukuta_saathram);

        recyclerView = findViewById(R.id.pilli_rcView);
        hen_start_rcView = findViewById(R.id.hen_start_rcView);
        imgBack = findViewById(R.id.back_opt);
        title = findViewById(R.id.tvHead);
        title.setText(R.string.kukuta_sasthram);


        KukutaSasthramData[] kukutaSasthramData = new KukutaSasthramData[]{
                new KukutaSasthramData("Kukuta Sasthram Detail in info", "this card is a kukuta sasthram details info descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description and is end of pilli sasthram"),


        };


        KukutaSasthramMenu2Data[] kukutaSasthramMenu2Data = new KukutaSasthramMenu2Data[]{
                new KukutaSasthramMenu2Data("this card is a kukuta sasthram details info descriptionhis is first sakuna sastharam descriptionhis is first sakuna sastharam description and is end of pilli sasthram","1\n2\n3","1\n2\n3","1\n2\n3","Hen Star","Star","Winning","Lossing")
        };


        KukutaAdapter adapter = new KukutaAdapter(kukutaSasthramData, activity);
        KukutaMenu2Adapter adapter1 = new KukutaMenu2Adapter(kukutaSasthramMenu2Data, activity);
        activity = KukutaSaathramActivity.this;
        imgBack.setOnClickListener(view -> onBackPressed());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        hen_start_rcView.setLayoutManager(linearLayoutManager1);
        hen_start_rcView.setAdapter(adapter1);

    }
}