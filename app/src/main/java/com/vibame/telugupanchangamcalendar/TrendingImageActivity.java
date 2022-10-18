package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.IMAGE_LIST_URL;
import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;
import static com.vibame.telugupanchangamcalendar.helper.Constant.TRENDING_IMAGES_LIST_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.ImageViewAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.ImagesView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class TrendingImageActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Activity activity;
    ImageView imgBack;
    ImageViewAdapter imageViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_image);


        activity = TrendingImageActivity.this;


        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);



        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2);
        recyclerView.setLayoutManager(gridLayoutManager);



        images();

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
                        ArrayList<ImagesView> imagesViews = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                ImagesView group = g.fromJson(jsonObject1.toString(),ImagesView.class);
                                imagesViews.add(group);
                            } else {
                                break;
                            }
                        }
                        imageViewAdapter = new ImageViewAdapter(activity,imagesViews);
                        recyclerView.setAdapter(imageViewAdapter);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.TRENDING_IMAGES_LIST_URL,params,true);

    }


}