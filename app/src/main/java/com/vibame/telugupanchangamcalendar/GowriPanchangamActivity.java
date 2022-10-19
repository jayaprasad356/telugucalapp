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
import com.vibame.telugupanchangamcalendar.model.Gowri;

import java.util.ArrayList;

public class GowriPanchangamActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    GowriAdapter gowriAdapter;
    ImageButton ibNextYear,ibPreviousYear;
    TextView tvYear;
    int Year = 2022;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gowri_panchangam);

        activity = GowriPanchangamActivity.this;

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

        recyclerView.setLayoutManager(linearLayoutManager);

        list();


    }

    private void list() {


        ArrayList<Gowri> gowris = new ArrayList<>();

        Gowri gowri1 = new Gowri("","06:00 - 07:00","Morning - Good","Night - Job");

        gowris.add(gowri1);

        gowriAdapter = new GowriAdapter(activity,gowris);
        recyclerView.setAdapter(gowriAdapter);

    }
}