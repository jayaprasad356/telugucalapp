package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.GrahaluTabAdapter;
import com.vibame.telugupanchangamcalendar.adapter.NakshatharaluAdapter;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.Nakshatharalu;

import java.util.ArrayList;

public class NakshathraluActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Activity activity;
    NakshatharaluAdapter nakshatharaluAdapter;
    ImageView imgBack;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nakshathralu);
        recyclerView = findViewById(R.id.recyclerView);
        activity = NakshathraluActivity.this;
        imgBack = findViewById(R.id.imgBack);
        databaseHelper = new DatabaseHelper(activity);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        nakshatharalu();
    }

    private void nakshatharalu() {
        if (databaseHelper.getNakshatharaluList().size() !=0){
            nakshatharaluAdapter = new NakshatharaluAdapter(activity, databaseHelper.getNakshatharaluList());
            recyclerView.setAdapter(nakshatharaluAdapter);
        }
        else {
            recyclerView.setVisibility(View.GONE);

        }

    }
}