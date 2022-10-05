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
import com.vibame.telugupanchangamcalendar.adapter.PoojaluSubMenuAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PoojaluTabAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;

public class PoojaluTabActivity extends AppCompatActivity {
    TextView tvTitle;
    String Title;
    RecyclerView recyclerView;
    Activity activity;
    DatabaseHelper databaseHelper;
    ImageView imgBack;
    String subcategory_id,poojalu_id;
    PoojaluTabAdapter poojaluTabAdapter;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poojalu_tab);

        tvTitle = findViewById(R.id.tvTitle);
        imgBack = findViewById(R.id.imgBack);
        recyclerView = findViewById(R.id.recyclerView);
        Title = getIntent().getStringExtra(Constant.TITLE);
        subcategory_id = getIntent().getStringExtra(Constant.SUBCATEGORY_ID);
        activity = PoojaluTabActivity.this;
        session = new Session(activity);
        poojalu_id = session.getData(Constant.POOJALU_ID);
        databaseHelper = new DatabaseHelper(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        poojaluTabList();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvTitle.setText(Title);
    }

    private void poojaluTabList()
    {
        if (databaseHelper.getPoojaluTabList(poojalu_id,subcategory_id).size() !=0){
            poojaluTabAdapter = new PoojaluTabAdapter(activity, databaseHelper.getPoojaluTabList(poojalu_id,subcategory_id));
            recyclerView.setAdapter(poojaluTabAdapter);
        }
        else {
            recyclerView.setVisibility(View.GONE);

        }
    }
}