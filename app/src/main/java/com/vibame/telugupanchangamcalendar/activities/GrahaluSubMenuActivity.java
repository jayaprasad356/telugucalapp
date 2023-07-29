package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.GrahaluSubMenuAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PoojaluSubMenuAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

public class GrahaluSubMenuActivity extends AppCompatActivity {
    TextView tvTitle;
    String Title;
    RecyclerView recyclerView;
    Activity activity;
    DatabaseHelper databaseHelper;
    GrahaluSubMenuAdapter grahaluSubMenuAdapter;
    String Id;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grahalu_sub_menu);
        tvTitle = findViewById(R.id.tvTitle);
        imgBack = findViewById(R.id.imgBack);
        recyclerView = findViewById(R.id.recyclerView);
        Title = getIntent().getStringExtra(Constant.TITLE);
        Id = getIntent().getStringExtra(Constant.ID);
        activity = GrahaluSubMenuActivity.this;
        databaseHelper = new DatabaseHelper(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        grahuluSubMenuList();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvTitle.setText(Title);
    }

    private void grahuluSubMenuList()

    {


        if (databaseHelper.getGrahaluSubMenuList(Id).size() !=0){
            grahaluSubMenuAdapter = new GrahaluSubMenuAdapter(activity, databaseHelper.getGrahaluSubMenuList(Id));
            recyclerView.setAdapter(grahaluSubMenuAdapter);

        }
        else {
            recyclerView.setVisibility(View.GONE);

        }

    }
}