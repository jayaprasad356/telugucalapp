package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamAdapter;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamMenuAdapter;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Ramayanam;
import com.vibame.telugupanchangamcalendar.model.RamayanamMenu;

import java.util.ArrayList;

public class RamyanamMenuActivity extends AppCompatActivity {

    TextView tvHead;
    String Tittle;
    ImageView imgBack;
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    RamayanamMenuAdapter ramayanamMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramyanam_menu);


        tvHead = findViewById(R.id.tvHead);

        Tittle = getIntent().getStringExtra(Constant.RAMAYAM_MENU);
        tvHead.setText(Tittle);


        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> onBackPressed());

        RecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(linearLayoutManager);


        menu_list();


    }

    private void menu_list() {


        ArrayList<RamayanamMenu> ramayanamMenus = new ArrayList<>();



        RamayanamMenu rings1 = new RamayanamMenu("Ramayanam Import");
        RamayanamMenu rings2 = new RamayanamMenu("Ramayanam Import");
        RamayanamMenu rings3 = new RamayanamMenu("Ramayanam Import");



        ramayanamMenus.add(rings1);
        ramayanamMenus.add(rings2);
        ramayanamMenus.add(rings3);




        ramayanamMenuAdapter = new RamayanamMenuAdapter(this,ramayanamMenus);
        RecyclerView.setAdapter(ramayanamMenuAdapter);



    }




}