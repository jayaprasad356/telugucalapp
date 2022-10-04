package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.MuhurthamTabAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

public class MuhurthamtabActivity extends AppCompatActivity {


    MuhurthamTabAdapter muhurthamTabAdapter;
    Activity activity;
    RecyclerView recyclerview;
    String MuhurthamId,Muhurtham;
    DatabaseHelper databaseHelper;
    TextView tvHead;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muhurthamtab);
        activity = MuhurthamtabActivity.this;
        MuhurthamId = getIntent().getStringExtra(Constant.MUHURTHAM_ID);
        Muhurtham = getIntent().getStringExtra(Constant.MUHURTHAM);
        databaseHelper = new DatabaseHelper(activity);
        recyclerview = findViewById(R.id.recyclerView);
        tvHead = findViewById(R.id.tvHead);
        imgBack = findViewById(R.id.imgBack);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerview.setLayoutManager(linearLayoutManager);
        muhurthamtab();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tvHead.setText(Muhurtham);

    }

    private void muhurthamtab() {
        if (databaseHelper.getMuhurthamTabList(MuhurthamId).size() !=0){
            muhurthamTabAdapter = new MuhurthamTabAdapter(activity,databaseHelper.getMuhurthamTabList(MuhurthamId));
            recyclerview.setAdapter(muhurthamTabAdapter);

        }


    }
}