package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.vibame.telugupanchangamcalendar.adapter.MuhurthamTabAdapter;
import com.vibame.telugupanchangamcalendar.model.MuhurthamTab;

import java.util.ArrayList;

public class MuhurthamtabActivity extends AppCompatActivity {


    MuhurthamTabAdapter muhurthamTabAdapter;
    Activity activity;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muhurthamtab);


        activity = MuhurthamtabActivity.this;

        recyclerview = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerview.setLayoutManager(linearLayoutManager);

        muhurthamtab();

    }

    private void muhurthamtab() {


        ArrayList<MuhurthamTab> muhurthamTabs = new ArrayList<>();

        MuhurthamTab muhurthamTab1 = new MuhurthamTab("1","1","Title","Description");

        muhurthamTabs.add(muhurthamTab1);

        muhurthamTabAdapter = new MuhurthamTabAdapter(activity,muhurthamTabs);
        recyclerview.setAdapter(muhurthamTabAdapter);


    }
}