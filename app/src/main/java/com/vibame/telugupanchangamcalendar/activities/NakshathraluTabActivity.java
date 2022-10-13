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
import com.vibame.telugupanchangamcalendar.adapter.NakshatharaluTabAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;

public class NakshathraluTabActivity extends AppCompatActivity {
    TextView tvHead;
    String Head;
    RecyclerView recyclerView;
    Activity activity;
    DatabaseHelper databaseHelper;
    ImageView imgBack;
    String nakshatralu_id;
    NakshatharaluTabAdapter nakshatharaluTabAdapter;
    TextView tvTitle,tvDescription;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nakshathralu_tab);
        tvHead = findViewById(R.id.tvHead);
        imgBack = findViewById(R.id.imgBack);
        recyclerView = findViewById(R.id.recyclerView);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        Head = getIntent().getStringExtra(Constant.TITLE);
        nakshatralu_id = getIntent().getStringExtra(Constant.NAKSHATRALU_ID);
        activity = NakshathraluTabActivity.this;
        session = new Session(activity);
        databaseHelper = new DatabaseHelper(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        nakshatraluTabList();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvHead.setText(Head);
    }

    private void nakshatraluTabList() {
        if (databaseHelper.getNakshatharaluTabList(nakshatralu_id).size() !=0){
            tvTitle.setText(databaseHelper.getNakshatharaluTabList(nakshatralu_id).get(0).getTitle());
            tvDescription.setText(databaseHelper.getNakshatharaluTabList(nakshatralu_id).get(0).getDescription());

            nakshatharaluTabAdapter = new NakshatharaluTabAdapter(activity, databaseHelper.getNakshatharaluTabList(nakshatralu_id));
            recyclerView.setAdapter(nakshatharaluTabAdapter);
        }
        else {
            recyclerView.setVisibility(View.GONE);

        }
    }
}