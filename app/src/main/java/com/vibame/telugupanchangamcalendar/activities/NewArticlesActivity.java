package com.vibame.telugupanchangamcalendar.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.NewArticlesAdaptor;
import com.vibame.telugupanchangamcalendar.model.NewData;

import java.util.ArrayList;

public class NewArticlesActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;
    NewArticlesAdaptor newArticlesAdaptor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_articles);

        recyclerView = findViewById(R.id.New_recyclerView);
        imgBack = findViewById(R.id.imgBack);
        activity = NewArticlesActivity.this;

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        newarticles();
    }

    private void newarticles() {

        ArrayList<NewData> newData = new ArrayList<>();
        NewData newData1 = new NewData("god_pik.jpg","Good Morning");
        NewData newData2 = new NewData("god_pik.jpg","Good Afternoon");
        NewData newData3 = new NewData("god_pik.jpg","Good Evening");

        newData.add(newData1);
        newData.add(newData2);
        newData.add(newData3);

        newArticlesAdaptor = new NewArticlesAdaptor(this,newData);
        recyclerView.setAdapter(newArticlesAdaptor);
    }
}