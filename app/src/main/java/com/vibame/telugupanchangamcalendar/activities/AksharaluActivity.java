package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.AksharaluAdaptor;
import com.vibame.telugupanchangamcalendar.adapter.RashuluAdaptor;
import com.vibame.telugupanchangamcalendar.model.AksharaluModel;
import com.vibame.telugupanchangamcalendar.model.RashuluModel;

import java.util.ArrayList;

public class AksharaluActivity extends AppCompatActivity {
    ImageView imgBack;

    private RecyclerView AksharaluRecycler;
    private AksharaluAdaptor aksharaluAdaptor;
    private ArrayList<AksharaluModel> aksharaluModelArrayList;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aksharalu);
        activity = this;
        AksharaluRecycler = findViewById(R.id.AksharaluRecycler);
        AksharaluRecycler.setLayoutManager(new LinearLayoutManager(activity));
        AksharaluRecycler.setHasFixedSize(true);
        BuildRecycler();

        imgBack = findViewById(R.id.imgBack);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void BuildRecycler() {
        aksharaluModelArrayList = new ArrayList<>();
        aksharaluModelArrayList.add(new AksharaluModel("Acchu","1\n2\n3\n4\n"));
        aksharaluModelArrayList.add(new AksharaluModel("Hallu","1\n2\n3\n4\n5\n6"));
        aksharaluModelArrayList.add(new AksharaluModel("Ubhaya","1\n2\n3"));

        aksharaluAdaptor = new AksharaluAdaptor(aksharaluModelArrayList,activity);
        AksharaluRecycler.setAdapter(aksharaluAdaptor);
    }
}