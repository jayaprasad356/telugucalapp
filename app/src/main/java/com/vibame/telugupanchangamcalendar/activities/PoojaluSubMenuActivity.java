package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.Constant;

public class PoojaluSubMenuActivity extends AppCompatActivity {
    TextView tvTitle;
    String Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poojalu_sub_menu);
        tvTitle = findViewById(R.id.tvTitle);
        Title = getIntent().getStringExtra(Constant.TITLE);

        tvTitle.setText(Title);

    }
}