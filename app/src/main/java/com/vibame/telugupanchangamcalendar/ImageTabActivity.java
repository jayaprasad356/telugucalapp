package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.adapter.ImageTabAdapter;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.ImageTab;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ImageTabActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    ImageView imgBack;
    ImageTabAdapter imageTabAdapter;
    CardView cardTradingImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_tab);


        activity = ImageTabActivity.this;




        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);
        cardTradingImage = findViewById(R.id.cardTradingImage);


        cardTradingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity,TradingImageActivity.class);
                startActivity(intent);

            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(gridLayoutManager);


        images();
    }

    private void images() {

        ArrayList<ImageTab> imageTabs = new ArrayList<>();

        ImageTab imageTab1 = new ImageTab("","Good Morning","");
        ImageTab imageTab2 = new ImageTab("","Good Morning","");
        ImageTab imageTab3 = new ImageTab("","Good Morning","");
        ImageTab imageTab4 = new ImageTab("","Good Morning","");

        imageTabs.add(imageTab1);
        imageTabs.add(imageTab2);
        imageTabs.add(imageTab3);
        imageTabs.add(imageTab4);

        imageTabAdapter = new ImageTabAdapter(activity,imageTabs);
        recyclerView.setAdapter(imageTabAdapter);


    }
}