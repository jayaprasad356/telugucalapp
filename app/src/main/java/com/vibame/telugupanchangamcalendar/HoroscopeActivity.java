package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.helper.Constant;

public class HoroscopeActivity extends AppCompatActivity {
    TextView tvHoroscopeTitle;
    ImageView imgBack;
    Activity activity;
    LinearLayout ll1,ll2,ll3,ll4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);
        imgBack = findViewById(R.id.imgBack);
        tvHoroscopeTitle = findViewById(R.id.tvHoroscopeTitle);
        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        ll3 = findViewById(R.id.ll3);
        ll4 = findViewById(R.id.ll4);

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, HoroscopeListActivity.class);
                intent.putExtra("value", "1");
                intent.putExtra(Constant.TITLE, "ధిన ఫలాలు");
                startActivity(intent);
            }
        });
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, HoroscopeListActivity.class);
                intent.putExtra("value", "2");
                intent.putExtra(Constant.TITLE, "వార ఫలాలు");
                startActivity(intent);
            }
        });
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, HoroscopeListActivity.class);
                intent.putExtra("value", "3");
                intent.putExtra(Constant.TITLE, "మాస ఫలాలు");
                startActivity(intent);
            }
        });
        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, HoroscopeListActivity.class);
                intent.putExtra("value", "4");
                intent.putExtra(Constant.TITLE, "వార్షిక  ఫలాలు");
                startActivity(intent);
            }
        });



        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        activity = HoroscopeActivity.this;




    }
}