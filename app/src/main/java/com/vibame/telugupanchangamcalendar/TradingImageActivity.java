package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.adapter.ImageTabAdapter;
import com.vibame.telugupanchangamcalendar.adapter.ImageViewAdapter;
import com.vibame.telugupanchangamcalendar.model.ImageTab;
import com.vibame.telugupanchangamcalendar.model.ImagesView;

import java.util.ArrayList;

public class TradingImageActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Activity activity;
    ImageView imgBack;
    ImageViewAdapter imageViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trading_image);


        activity = TradingImageActivity.this;


        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);



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

        ArrayList<ImagesView> imagesViews = new ArrayList<>();

        ImagesView imageTab1 = new ImagesView("","");
        ImagesView imageTab2 = new ImagesView("","");
        ImagesView imageTab3 = new ImagesView("","");
        ImagesView imageTab4 = new ImagesView("","");

        imagesViews.add(imageTab1);
        imagesViews.add(imageTab2);
        imagesViews.add(imageTab3);
        imagesViews.add(imageTab4);

        imageViewAdapter = new ImageViewAdapter(activity,imagesViews);
        recyclerView.setAdapter(imageViewAdapter);

    }


}