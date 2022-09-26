package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MonthlyHoroscopeActivity extends AppCompatActivity {
    RelativeLayout rlc1,rlc2,rlc3,rlc4,rlc5,rlc6,rlc7,rlc8,rlc9,rlc10,rlc12,rlc11;
    Activity activity;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_horoscope);
        activity = MonthlyHoroscopeActivity.this;


        rlc1 = findViewById(R.id.rlc1);
        rlc2 = findViewById(R.id.rlc2);
        rlc3 = findViewById(R.id.rlc3);
        rlc4 = findViewById(R.id.rlc4);
        rlc5 = findViewById(R.id.rlc5);
        rlc6 = findViewById(R.id.rlc6);
        rlc7 = findViewById(R.id.rlc7);
        rlc8 = findViewById(R.id.rlc8);
        rlc9 = findViewById(R.id.rlc9);
        rlc10 = findViewById(R.id.rlc10);
        rlc11 = findViewById(R.id.rlc11);
        rlc12 = findViewById(R.id.rlc12);
        imgBack = findViewById(R.id.imgBack);

        rlc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });
        rlc11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RaasiDetailsActivity.class);
                startActivity(intent);
            }
        });


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}