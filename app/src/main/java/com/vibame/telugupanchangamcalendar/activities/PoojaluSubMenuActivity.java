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
import com.vibame.telugupanchangamcalendar.adapter.PoojaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PoojaluSubMenuAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

public class PoojaluSubMenuActivity extends AppCompatActivity {
    TextView tvTitle;
    String Title;
    RecyclerView recyclerView;
    Activity activity;
    DatabaseHelper databaseHelper;
    PoojaluSubMenuAdapter poojaluSubMenuAdapter;
    String Id;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poojalu_sub_menu);
        tvTitle = findViewById(R.id.tvTitle);
        imgBack = findViewById(R.id.imgBack);
        recyclerView = findViewById(R.id.recyclerView);
        Title = getIntent().getStringExtra(Constant.TITLE);
        Id = getIntent().getStringExtra(Constant.ID);
        activity = PoojaluSubMenuActivity.this;
        databaseHelper = new DatabaseHelper(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        poojaluSubMenuList();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvTitle.setText(Title);

    }

    private void poojaluSubMenuList()
    {
        if (databaseHelper.getPoojaluSubMenuList(Id).size() !=0){
            poojaluSubMenuAdapter = new PoojaluSubMenuAdapter(activity, databaseHelper.getPoojaluSubMenuList(Id));
            recyclerView.setAdapter(poojaluSubMenuAdapter);

        }
        else {
            recyclerView.setVisibility(View.GONE);

        }
    }
}