package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.helper.Constant;

public class MontliHoroscopeActivity extends AppCompatActivity {

    TextView tvHoroscopeTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_montli_horoscope);



        tvHoroscopeTitle = findViewById(R.id.tvHoroscopeTitle);
        tvHoroscopeTitle.setText(getIntent().getStringExtra(Constant.TITLE)+" - "+getIntent().getStringExtra("Name"));


    }
}