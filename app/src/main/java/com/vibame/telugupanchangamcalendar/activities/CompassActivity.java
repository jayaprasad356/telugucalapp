package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorManager;
import android.os.Bundle;

import com.vibame.telugupanchangamcalendar.R;

public class CompassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");

    }
}