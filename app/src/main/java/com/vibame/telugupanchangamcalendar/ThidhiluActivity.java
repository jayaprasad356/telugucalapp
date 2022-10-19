package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.adapter.GowriAdapter;
import com.vibame.telugupanchangamcalendar.adapter.ThidhiluAdapter;
import com.vibame.telugupanchangamcalendar.model.Gowri;
import com.vibame.telugupanchangamcalendar.model.Thidhilu;

import java.util.ArrayList;

public class ThidhiluActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    ThidhiluAdapter thidhiluAdapter;
    ImageButton ibNextYear,ibPreviousYear;
    TextView tvYear;
    int Year = 2022;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thidhilu);

        activity = ThidhiluActivity.this;

        recyclerView = findViewById(R.id.recyclerView);
        tvYear = findViewById(R.id.tvYear);
        ibNextYear = findViewById(R.id.ibNextYear);
        ibPreviousYear = findViewById(R.id.ibPreviousYear);



        ibNextYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year ++;
                tvYear.setText("" + Year);

            }
        });
        ibPreviousYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year --;
                tvYear.setText("" + Year);


            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);

        recyclerView.setLayoutManager(gridLayoutManager);

        list();
    }

    private void list() {


        ArrayList<Thidhilu> thidhilus = new ArrayList<>();

        Thidhilu gowri1 = new Thidhilu("","Padyami","09 Monday","21 Friday");
        Thidhilu gowri2 = new Thidhilu("","Vidhiya","09 Monday","21 Friday");

        thidhilus.add(gowri1);
        thidhilus.add(gowri2);

        thidhiluAdapter = new ThidhiluAdapter(activity,thidhilus);
        recyclerView.setAdapter(thidhiluAdapter);

    }
}