package com.vibame.telugupanchangamcalendar.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.OldArticlesAdaptor;
import com.vibame.telugupanchangamcalendar.model.OldData;

import java.util.ArrayList;

public class OldArticlesActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;
    OldArticlesAdaptor oldArticlesAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_articles);

        recyclerView = findViewById(R.id.Old_recyclerView);
        imgBack = findViewById(R.id.imgBack);
        activity = OldArticlesActivity.this;

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        oldarticles();
    }

    private void oldarticles() {

        ArrayList<OldData> oldData = new ArrayList<>();
        OldData oldData1 = new OldData("god_pik.jpg","Good Morning");
        OldData oldData2 = new OldData("god_pik.jpg","Good Afternoon");
        OldData oldData3 = new OldData("god_pik.jpg","Good Evening");

        oldData.add(oldData1);
        oldData.add(oldData2);
        oldData.add(oldData3);

        oldArticlesAdaptor = new OldArticlesAdaptor(this,oldData);
        recyclerView.setAdapter(oldArticlesAdaptor);
    }
}