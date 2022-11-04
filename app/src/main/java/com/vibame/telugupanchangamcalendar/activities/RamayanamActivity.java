package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.GowriAdapter;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamAdapter;
import com.vibame.telugupanchangamcalendar.model.Gowri;
import com.vibame.telugupanchangamcalendar.model.Ramayanam;
import com.vibame.telugupanchangamcalendar.model.RamayanamMenu;

import java.util.ArrayList;

public class RamayanamActivity extends AppCompatActivity {

    ImageView imgBack;
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    RamayanamAdapter ramayanamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramayanam);


        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> onBackPressed());

        RecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(linearLayoutManager);


        menu_list();


    }

    private void menu_list() {


        ArrayList<Ramayanam> ramayanam = new ArrayList<>();



        Ramayanam rings1 = new Ramayanam("Ramayanam Import");
        Ramayanam rings2 = new Ramayanam("Ramayanam Import");
        Ramayanam rings3 = new Ramayanam("Ramayanam Import");



        ramayanam.add(rings1);
        ramayanam.add(rings2);
        ramayanam.add(rings3);




        ramayanamAdapter = new RamayanamAdapter(this,ramayanam);
        RecyclerView.setAdapter(ramayanamAdapter);



    }
}
