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
import com.vibame.telugupanchangamcalendar.adapter.RashuluAdaptor;
import com.vibame.telugupanchangamcalendar.model.Guninthalu;
import com.vibame.telugupanchangamcalendar.model.RashuluModel;

import java.util.ArrayList;

public class GunintaluActivity extends AppCompatActivity {

    private RecyclerView GunintaluRecycler;
    private GunintaluAdaptor gunintaluAdaptor;
    private ArrayList<Guninthalu> guninthaluArrayList;
    private Activity activity;
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunintalu);
        activity = this;

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GunintaluRecycler = findViewById(R.id.GunintaluRecycler);
        GunintaluRecycler.setLayoutManager(new LinearLayoutManager(activity));
        GunintaluRecycler.setHasFixedSize(true);
        BuildRecycler();
    }

    private void BuildRecycler() {
        guninthaluArrayList = new ArrayList<>();
        guninthaluArrayList.add(new Guninthalu("1 2 3 4 5 6 7 8 9 0"));
        guninthaluArrayList.add(new Guninthalu("1 2 3 4 5 6 7 8 9 0"));
        guninthaluArrayList.add(new Guninthalu("1 2 3 4 5 6 7 8 9 0"));
        guninthaluArrayList.add(new Guninthalu("1 2 3 4 5 6 7 8 9 0"));
        gunintaluAdaptor = new GunintaluAdaptor(activity, guninthaluArrayList);
        GunintaluRecycler.setAdapter(gunintaluAdaptor);
    }
}