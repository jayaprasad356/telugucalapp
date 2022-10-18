package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.IMAGE_URL;
import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

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

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.ImageTabAdapter;
import com.vibame.telugupanchangamcalendar.adapter.ImageViewAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.ImageTab;
import com.vibame.telugupanchangamcalendar.model.ImagesView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ImageTabActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    ImageView imgBack;
    ImageTabAdapter imageTabAdapter;
    CardView cardTradingImage;
    ImageView imgTrend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_tab);
        imgTrend = findViewById(R.id.imgTrend);
        activity = ImageTabActivity.this;
        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);
        cardTradingImage = findViewById(R.id.cardTradingImage);


        cardTradingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, TrendingImageActivity.class);
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
        trendingImageList();
    }

    private void trendingImageList()
    {
        HashMap<String,String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);

                        String image = jsonArray.getJSONObject(0).getString(Constant.IMAGE);
                        Glide.with(activity).load(image).into(imgTrend);

                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.TRENDING_IMAGES_LIST_URL,params,false);

    }

    private void images() {

        HashMap<String,String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<ImageTab> imageTabs = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                ImageTab group = g.fromJson(jsonObject1.toString(), ImageTab.class);
                                imageTabs.add(group);
                            } else {
                                break;
                            }
                        }
                        imageTabAdapter = new ImageTabAdapter(activity,imageTabs);
                        recyclerView.setAdapter(imageTabAdapter);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, IMAGE_URL,params,true);




    }
}