package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.IMAGE_URL;
import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;
import static com.vibame.telugupanchangamcalendar.helper.Constant.VIDEO_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.ImageTabAdapter;
import com.vibame.telugupanchangamcalendar.adapter.VideosTabAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.ImageTab;
import com.vibame.telugupanchangamcalendar.model.VideoTab;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class VideoTabActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    ImageView imgBack;
    VideosTabAdapter videosTabAdapter;
    CardView cardTradingImage;
    ImageView imgTrend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_tab);
        activity = VideoTabActivity.this;
        imgTrend = findViewById(R.id.imgTrend);
        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);
        cardTradingImage = findViewById(R.id.cardTradingImage);


        cardTradingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity,TrendingVideosActivity.class);
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


        videos();
        trendingVideoList();

    }
    private void trendingVideoList()
    {
        HashMap<String,String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {
            Log.d("VIDEO_TREND",response);
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);

                        String image = jsonArray.getJSONObject(0).getString(Constant.VIDEO);
                        Glide.with(activity).load(image).into(imgTrend);

                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.TRENDING_VIDEOS_LIST_URL,params,false);

    }


    private void videos() {

        HashMap<String,String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<VideoTab> videoTabs = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                VideoTab group = g.fromJson(jsonObject1.toString(), VideoTab.class);
                                videoTabs.add(group);
                            } else {
                                break;
                            }
                        }
                        videosTabAdapter = new VideosTabAdapter(activity,videoTabs);
                        recyclerView.setAdapter(videosTabAdapter);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, VIDEO_URL,params,true);






    }
}