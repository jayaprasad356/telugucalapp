package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.activities.TeluguYearActivity;
import com.vibame.telugupanchangamcalendar.adapter.AnkeluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.TeluguYearsAdapter;
import com.vibame.telugupanchangamcalendar.model.AnkeluData;
import com.vibame.telugupanchangamcalendar.model.TeluguYear;

public class AnkeluActivity extends AppCompatActivity {


    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ankelu);


        AnkeluData[] ankeluData = new AnkeluData[]{
                new AnkeluData("1","1"),
                new AnkeluData("2","2"),
                new AnkeluData("3","3"),
                new AnkeluData("4","4"),
                new AnkeluData("5","5"),


        };


        recyclerView = findViewById(R.id.Telugu_rcView);
        AnkeluAdapter  adapter = new AnkeluAdapter(ankeluData, activity);

        imgBack = findViewById(R.id.imgBack);
        activity = AnkeluActivity.this;


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}