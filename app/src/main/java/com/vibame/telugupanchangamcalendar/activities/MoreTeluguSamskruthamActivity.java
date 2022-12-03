package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.vibame.telugupanchangamcalendar.AnkeluActivity;
import com.vibame.telugupanchangamcalendar.R;

public class MoreTeluguSamskruthamActivity extends AppCompatActivity {

    LinearLayout llTeluguYear,llRashulu,llMonth,llAnkelu,llAksharalu,llGuninthalu,llJanapadha,llKulavruthulu,llPakshamulu;
    LinearLayout llNavagrahalu,llRuthuvulu,llKolathalu,llPrasadhamnames,llLagnalu,llThidhiadhi,llWeeknames,llFruitnames,llPushapalu;
    Activity activity;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_telugu_samskrutham);
        activity = new MoreTeluguSamskruthamActivity();


        llTeluguYear = findViewById(R.id.llTeluguYear);
        llRashulu = findViewById(R.id.llRashulu);
        llMonth = findViewById(R.id.llMonth);
        llAnkelu = findViewById(R.id.llAnkelu);
        llAksharalu = findViewById(R.id.llAksharalu);
        llGuninthalu = findViewById(R.id.llGuninthalu);
        llJanapadha = findViewById(R.id.llJanapadha);
        llKulavruthulu = findViewById(R.id.llKulavruthulu);
        llNavagrahalu = findViewById(R.id.llNavagrahalu);
        llRuthuvulu = findViewById(R.id.llRuthuvulu);
        llKolathalu = findViewById(R.id.llKolathalu);
        llPrasadhamnames = findViewById(R.id.llPrasadhamnames);
        llLagnalu = findViewById(R.id.llLagnalu);
        llThidhiadhi = findViewById(R.id.llThidhiadhi);
        llWeeknames = findViewById(R.id.llWeeknames);
        llFruitnames = findViewById(R.id.llFruitnames);
        llPakshamulu = findViewById(R.id.llPakshamulu);
        llPushapalu = findViewById(R.id.llPushapalu);

        llTeluguYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, TeluguYearActivity.class);
                startActivity(intent);
            }
        });
        llRashulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RashuluActivity.class);
                startActivity(intent);
            }
        });
        llMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MonthActivity.class);
                startActivity(intent);
            }
        });


        llAnkelu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, AnkeluActivity.class);
                startActivity(intent);
            }
        });
        llAksharalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, AksharaluActivity.class);
                startActivity(intent);
            }
        });
        llGuninthalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, GunintaluActivity.class);
                startActivity(intent);
            }
        });
        llJanapadha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, JanaPadhaActivity.class);
                startActivity(intent);
            }
        });
        llKulavruthulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, KulaVurthaActivity.class);
                startActivity(intent);
            }
        });
        llNavagrahalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, NavaGrahaluActivity.class);
                startActivity(intent);
            }
        });
        llRuthuvulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RuthuvuluActivity.class);
                startActivity(intent);
            }
        });
        llKolathalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, KolathaluActivity.class);
                startActivity(intent);
            }
        });
        llPrasadhamnames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PrasadhamNamesActivity.class);
                startActivity(intent);
            }
        });
        llLagnalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, LagnaluActivity.class);
                startActivity(intent);
            }
        });
        llThidhiadhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ThidhiAdhiActivity.class);
                startActivity(intent);
            }
        });
        llWeeknames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, WeekNamesActivity.class);
                startActivity(intent);
            }
        });
        llFruitnames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, FruitNamesActivity.class);
                startActivity(intent);
            }
        });
        llPakshamulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PakahamuluActivity.class);
                startActivity(intent);
            }
        });
        llPushapalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PushapaluActivity.class);
                startActivity(intent);
            }
        });
    }
}