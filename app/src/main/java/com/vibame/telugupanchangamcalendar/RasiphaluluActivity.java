package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.vibame.telugupanchangamcalendar.helper.Constant;

public class RasiphaluluActivity extends AppCompatActivity {

    LinearLayout llDailyhoroscope, llWYearlyHoroscope, llWeeklyHoroscope, llMonthlyHoroscope;
    Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasiphalulu);
        activity = RasiphaluluActivity.this;

        llDailyhoroscope = findViewById(R.id.llDailyhoroscope);
        llMonthlyHoroscope = findViewById(R.id.llMonthlyHoroscope);
        llWYearlyHoroscope = findViewById(R.id.llWYearlyHoroscope);
        llWeeklyHoroscope = findViewById(R.id.llWeeklyHoroscope);

        llDailyhoroscope.setOnClickListener(v -> {
            Intent intent = new Intent(activity, HoroscopeActivity.class);
            intent.putExtra(Constant.HOROSCOPE,"Daily");
            startActivity(intent);
        });
        llWeeklyHoroscope.setOnClickListener(v -> {
            Intent intent = new Intent(activity, HoroscopeActivity.class);
            intent.putExtra(Constant.HOROSCOPE,"Weekly");
            startActivity(intent);
        });
        llWYearlyHoroscope.setOnClickListener(v -> {
            Intent intent = new Intent(activity, HoroscopeActivity.class);
            intent.putExtra(Constant.HOROSCOPE,"Yearly");
            startActivity(intent);
        });

        llMonthlyHoroscope.setOnClickListener(v -> {
            Intent intent = new Intent(activity, HoroscopeActivity.class);
            intent.putExtra(Constant.HOROSCOPE,"Monthly");
            startActivity(intent);
        });


    }
}