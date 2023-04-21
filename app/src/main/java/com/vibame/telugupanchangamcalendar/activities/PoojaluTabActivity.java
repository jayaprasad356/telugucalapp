package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
    TextView tvHead;
    String Head;
    RecyclerView recyclerView;
    Activity activity;
    DatabaseHelper databaseHelper;
    ImageView imgBack;
    String subcategory_id,poojalu_id;
    PoojaluTabAdapter poojaluTabAdapter;
    TextView tvTitle,tvDescription;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poojalu_tab);

        tvHead = findViewById(R.id.tvHead);
        imgBack = findViewById(R.id.imgBack);
        recyclerView = findViewById(R.id.recyclerView);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        Head = getIntent().getStringExtra(Constant.TITLE);
        subcategory_id = getIntent().getStringExtra(Constant.SUBCATEGORY_ID);
        activity = PoojaluTabActivity.this;
        session = new Session(activity);
        poojalu_id = session.getData(Constant.POOJALU_ID);
        databaseHelper = new DatabaseHelper(activity);
        recyclerView.setLayoutManager(new GridLayoutManager(activity, 1));
        poojaluTabList();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvHead.setText(Head);
    }

    private void poojaluTabList()
    {
        if (databaseHelper.getPoojaluTabList(poojalu_id,subcategory_id).size() !=0){
            tvTitle.setText(databaseHelper.getPoojaluTabList(poojalu_id,subcategory_id).get(0).getTitle());
            tvDescription.setText(databaseHelper.getPoojaluTabList(poojalu_id,subcategory_id).get(0).getDescription());

            poojaluTabAdapter = new PoojaluTabAdapter(activity, databaseHelper.getPoojaluTabList(poojalu_id,subcategory_id));
            recyclerView.setAdapter(poojaluTabAdapter);
        }
        else {
            recyclerView.setVisibility(View.GONE);

        }
    }
}