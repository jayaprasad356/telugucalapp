package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RahukalamActivity extends AppCompatActivity {

    ImageButton ibNextYear,ibPreviousYear;
    TextView tvYear;
    int Year = 2022;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rahukalam);


        tvYear = findViewById(R.id.tvYear);
        ibNextYear = findViewById(R.id.ibNextYear);
        ibPreviousYear = findViewById(R.id.ibPreviousYear);



        ibNextYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year ++;
                tvYear.setText("" + Year);

            }
        });
        ibPreviousYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year --;
                tvYear.setText("" + Year);


            }
        });

    }
}