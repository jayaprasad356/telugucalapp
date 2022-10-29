package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.GunintaluAdaptor;
import com.vibame.telugupanchangamcalendar.adapter.JanaPadhaAdapter;
import com.vibame.telugupanchangamcalendar.adapter.KulaVurthaAdaptor;
import com.vibame.telugupanchangamcalendar.adapter.RashuluAdaptor;
import com.vibame.telugupanchangamcalendar.model.Guninthalu;
import com.vibame.telugupanchangamcalendar.model.JanaPadha;
import com.vibame.telugupanchangamcalendar.model.KulaVurthala;
import com.vibame.telugupanchangamcalendar.model.RashuluModel;

import java.util.ArrayList;

public class JanaPadhaActivity extends AppCompatActivity {

    ImageView imgBack;

    private RecyclerView janapadharecycler;
    private JanaPadhaAdapter janaPadhaAdapter;
    private ArrayList<JanaPadha> janaPadhaArrayList;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jana_padha);
        activity = this;
        janapadharecycler = findViewById(R.id.JanaPadhaRecycler);
        janapadharecycler.setLayoutManager(new LinearLayoutManager(activity));
        janapadharecycler.setHasFixedSize(true);
        BuildRecycler();

        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void BuildRecycler() {
        janaPadhaArrayList = new ArrayList<>();
        janaPadhaArrayList.add(new JanaPadha("somex","somey"));
        janaPadhaArrayList.add(new JanaPadha("somex","somey"));
        janaPadhaArrayList.add(new JanaPadha("somex","somey"));
        janaPadhaArrayList.add(new JanaPadha("somex","somey"));
        janaPadhaAdapter = new JanaPadhaAdapter(activity, janaPadhaArrayList);
        janapadharecycler.setAdapter(janaPadhaAdapter);
    }
}