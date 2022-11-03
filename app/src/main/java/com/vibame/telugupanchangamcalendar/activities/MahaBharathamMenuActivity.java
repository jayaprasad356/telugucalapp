package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.RaasiDetailsActivity;
import com.vibame.telugupanchangamcalendar.adapter.KolathaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.MahaBharathamMenuAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Kolathalu;
import com.vibame.telugupanchangamcalendar.model.MahaBharadhamMenu;

public class MahaBharathamMenuActivity extends AppCompatActivity {
    ImageView imgBack;
    private RecyclerView RecyclerView;
    private Activity activity;
    private TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maha_bharatham_menu);
        activity = this;
        MahaBharadhamMenu[] mahaBharadhamMenus = new MahaBharadhamMenu[]{
                new MahaBharadhamMenu("1. Pharbava Nama Year"),
                new MahaBharadhamMenu("2. Pharbava Nama Year"),
                new MahaBharadhamMenu("4. Pharbava Nama Year"),
                new MahaBharadhamMenu("5. Pharbava Nama Year"),
                new MahaBharadhamMenu("6. Pharbava Nama Year"),
                new MahaBharadhamMenu("7. Pharbava Nama Year"),
                new MahaBharadhamMenu("8. Pharbava Nama Year"),
        };
        RecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        about=findViewById(R.id.tv_title);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, AboutMahaBharathamActivity.class);
                startActivity(intent);
            }
        });
        MahaBharathamMenuAdapter adapter = new MahaBharathamMenuAdapter(mahaBharadhamMenus, activity);
        RecyclerView.setAdapter(adapter);
        RecyclerView.setHasFixedSize(true);
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> onBackPressed());


    }
}