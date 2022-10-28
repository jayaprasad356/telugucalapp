package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.RashuluAdaptor;
import com.vibame.telugupanchangamcalendar.model.RashuluModel;

import java.util.ArrayList;

public class RashuluActivity extends AppCompatActivity {

    private RecyclerView RashuluRecycler;
    private RashuluAdaptor rashuluAdaptor;
    private ArrayList<RashuluModel> rashuluModelArrayList;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rashulu);
        activity = this;
        RashuluRecycler = findViewById(R.id.RashuluRecycler);
        RashuluRecycler.setLayoutManager(new LinearLayoutManager(activity));
        RashuluRecycler.setHasFixedSize(true);
        BuildRecycler();
    }

    private void BuildRecycler() {
        rashuluModelArrayList = new ArrayList<>();
        rashuluModelArrayList.add(new RashuluModel("one","from x to y"));
        rashuluModelArrayList.add(new RashuluModel("one","from x to y"));
        rashuluModelArrayList.add(new RashuluModel("one","from x to y"));
        rashuluModelArrayList.add(new RashuluModel("one","from x to y"));
        rashuluModelArrayList.add(new RashuluModel("one","from x to y"));
        rashuluAdaptor = new RashuluAdaptor(rashuluModelArrayList,activity);
        RashuluRecycler.setAdapter(rashuluAdaptor);
    }
}