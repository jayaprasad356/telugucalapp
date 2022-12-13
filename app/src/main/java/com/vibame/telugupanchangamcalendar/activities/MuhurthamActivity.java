package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.MuhurthamAdapter;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

public class MuhurthamActivity extends AppCompatActivity {
    Activity activity;
    RecyclerView recyclerview;
    MuhurthamAdapter muhurthamAdapter;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muhurtham);
        activity = MuhurthamActivity.this;

        databaseHelper = new DatabaseHelper(activity);

        recyclerview = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerview.setLayoutManager(linearLayoutManager);


        muhurthamlist();


    }

    private void muhurthamlist() {
        if (databaseHelper.getMuhurthamList().size() !=0){
            muhurthamAdapter = new MuhurthamAdapter(activity,databaseHelper.getMuhurthamList());
            recyclerview.setAdapter(muhurthamAdapter);

        }
    }
}