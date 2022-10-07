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
import com.vibame.telugupanchangamcalendar.adapter.GrahaluTabAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PoojaluTabAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;

public class GrahaluTabActivity extends AppCompatActivity {
    TextView tvHead;
    String Head;
    RecyclerView recyclerView;
    Activity activity;
    DatabaseHelper databaseHelper;
    ImageView imgBack;
    String subcategory_id,grahalu_id;
    GrahaluTabAdapter grahaluTabAdapter;
    TextView tvTitle,tvDescription;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grahalu_tab);


        tvHead = findViewById(R.id.tvHead);
        imgBack = findViewById(R.id.imgBack);
        recyclerView = findViewById(R.id.recyclerView);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        Head = getIntent().getStringExtra(Constant.TITLE);
        subcategory_id = getIntent().getStringExtra(Constant.SUBCATEGORY_ID);
        activity = GrahaluTabActivity.this;
        session = new Session(activity);
        grahalu_id = session.getData(Constant.GRAHALU_ID);
        databaseHelper = new DatabaseHelper(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        grahaluTabList();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvHead.setText(Head);
    }

    private void grahaluTabList()
    {
        if (databaseHelper.getGrahaluTabList(grahalu_id,subcategory_id).size() !=0){
            tvTitle.setText(databaseHelper.getGrahaluTabList(grahalu_id,subcategory_id).get(0).getTitle());
            tvDescription.setText(databaseHelper.getGrahaluTabList(grahalu_id,subcategory_id).get(0).getDescription());

            grahaluTabAdapter = new GrahaluTabAdapter(activity, databaseHelper.getGrahaluTabList(grahalu_id,subcategory_id));
            recyclerView.setAdapter(grahaluTabAdapter);
        }
        else {
            recyclerView.setVisibility(View.GONE);

        }

    }
}