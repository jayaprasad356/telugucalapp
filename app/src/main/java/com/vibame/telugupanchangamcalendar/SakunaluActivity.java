package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.activities.HoraChakramActivity;

public class SakunaluActivity extends AppCompatActivity {
    ImageView imgBack;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sakunalu);

        imgBack = findViewById(R.id.imgBack);
        activity = SakunaluActivity.this;

//        imgBack.findViewById(R.id.imgBack);
//
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}