package com.vibame.telugupanchangamcalendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.internal.AccountType;

public class InternetSpeedMeterActivity extends AppCompatActivity {

    ImageView imgBack;
    Button button;
    TextView tvSpeed;
    Activity activity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_speed_meter);

        imgBack = findViewById(R.id.imgBack);
        button = findViewById(R.id.checkSpeed);
        tvSpeed = findViewById(R.id.speed);
        activity = InternetSpeedMeterActivity.this;

        imgBack.setOnClickListener(v -> onBackPressed());
        button.setOnClickListener(view -> {
            ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            if (netInfo != null) {
                NetworkCapabilities nc = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    nc = cm.getNetworkCapabilities(cm.getActiveNetwork());
                }
                int downSpeed = nc.getLinkDownstreamBandwidthKbps() / 1000;
                int upSpeed = nc.getLinkUpstreamBandwidthKbps() / 1000;
                tvSpeed.setText("Download Speed :" + downSpeed + "Mbps\nUpload Speed :" + upSpeed + "Mbps");
            } else {
                tvSpeed.setText("");
                Toast.makeText(activity, "Please Turn ON Mobile Network", Toast.LENGTH_SHORT).show();
            }

        });


    }
}