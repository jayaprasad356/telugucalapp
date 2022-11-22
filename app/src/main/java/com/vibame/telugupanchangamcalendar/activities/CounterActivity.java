package com.vibame.telugupanchangamcalendar.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vibame.telugupanchangamcalendar.R;

public class CounterActivity extends AppCompatActivity {

    TextView counterText;
    Button plusBtn, minusBtn, resetBtn;
    int mounter = 0;
    ImageView imgBack;


    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_counter);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        resetBtn = findViewById(R.id.resetBtn);
        counterText = findViewById(R.id.counterTxt);
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(v -> onBackPressed());
        plusBtn.setOnClickListener(view -> {
            mounter = mounter + 1;
            counterText.setText(Integer.toString(mounter));
        });
        minusBtn.setOnClickListener(view -> {
            mounter = mounter - 1;
            counterText.setText(Integer.toString(mounter));
        });
        resetBtn.setOnClickListener(view -> {
            mounter = 0;
            counterText.setText(Integer.toString(mounter));
        });
    }
}