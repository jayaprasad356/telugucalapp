package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.GunintaluAdaptor;
import com.vibame.telugupanchangamcalendar.adapter.KulaVurthaAdaptor;
import com.vibame.telugupanchangamcalendar.adapter.RashuluAdaptor;
import com.vibame.telugupanchangamcalendar.model.Guninthalu;
import com.vibame.telugupanchangamcalendar.model.KulaVurthala;
import com.vibame.telugupanchangamcalendar.model.RashuluModel;

import java.util.ArrayList;

public class KulaVurthaActivity extends AppCompatActivity {

    private RecyclerView KulaVurthaReccycler;
    private KulaVurthaAdaptor kulaVurthaAdaptor;
    private ArrayList<KulaVurthala> kulaVurthalaArrayList;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rashulu);
        activity = this;
        KulaVurthaReccycler = findViewById(R.id.RashuluRecycler);
        KulaVurthaReccycler.setLayoutManager(new LinearLayoutManager(activity));
        KulaVurthaReccycler.setHasFixedSize(true);
        BuildRecycler();
    }

    private void BuildRecycler() {
        kulaVurthalaArrayList = new ArrayList<>();
        kulaVurthalaArrayList.add(new KulaVurthala("somex","somey"));
        kulaVurthalaArrayList.add(new KulaVurthala("somex","somey"));
        kulaVurthalaArrayList.add(new KulaVurthala("somex","somey"));
        kulaVurthalaArrayList.add(new KulaVurthala("somex","somey"));
        kulaVurthalaArrayList.add(new KulaVurthala("somex","somey"));
        kulaVurthaAdaptor = new KulaVurthaAdaptor(activity, kulaVurthalaArrayList);
        KulaVurthaReccycler.setAdapter(kulaVurthaAdaptor);
    }
}