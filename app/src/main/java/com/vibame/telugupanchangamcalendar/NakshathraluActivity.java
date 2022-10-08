package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.NakshatharaluAdapter;
import com.vibame.telugupanchangamcalendar.model.Nakshatharalu;

import java.util.ArrayList;

public class NakshathraluActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    NakshatharaluAdapter nakshatharaluAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nakshathralu);
        activity = NakshathraluActivity.this;

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        nakshatharalu();
    }

    private void nakshatharalu() {
        ArrayList<Nakshatharalu> nakshatharalus= new ArrayList<>();
        Nakshatharalu nakshatharalu1 = new Nakshatharalu("","Star name","");
        Nakshatharalu nakshatharalu2 = new Nakshatharalu("","Star name","");
        Nakshatharalu nakshatharalu3 = new Nakshatharalu("","Star name","");

        nakshatharalus.add(nakshatharalu1);
        nakshatharalus.add(nakshatharalu2);
        nakshatharalus.add(nakshatharalu3);


        nakshatharaluAdapter = new NakshatharaluAdapter(activity,nakshatharalus);
        recyclerView.setAdapter(nakshatharaluAdapter);
    }
}