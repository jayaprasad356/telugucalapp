package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.AboutMahaBharadhamAdapter;
import com.vibame.telugupanchangamcalendar.adapter.MahaBharathamMenuAdapter;
import com.vibame.telugupanchangamcalendar.model.MahaBharadhamMenu;

public class AboutMahaBharathamActivity extends AppCompatActivity {
    ImageView imgBack;
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    private Activity activity;
    private TextView about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_maha_bharatham);
        activity = this;
        MahaBharadhamMenu[] mahaBharadhamMenus = new MahaBharadhamMenu[]{
                new MahaBharadhamMenu("1. People in Maha bharadham"),
                new MahaBharadhamMenu("2. Pharbava Nama Year"),
                new MahaBharadhamMenu("3. Pharbava Nama Year"),
                new MahaBharadhamMenu("4. Pharbava Nama Year"),
                new MahaBharadhamMenu("5. Pharbava Nama Year"),
                new MahaBharadhamMenu("6. Pharbava Nama Year"),
                new MahaBharadhamMenu("7. Pharbava Nama Year"),
                new MahaBharadhamMenu("8. Pharbava Nama Year"),
        };
        RecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        AboutMahaBharadhamAdapter adapter = new AboutMahaBharadhamAdapter(mahaBharadhamMenus, activity);
        RecyclerView.setAdapter(adapter);
        RecyclerView.setHasFixedSize(true);
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> onBackPressed());
    }
}