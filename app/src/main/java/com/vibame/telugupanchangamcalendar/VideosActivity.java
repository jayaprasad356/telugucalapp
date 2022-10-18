package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.IMAGE_LIST_URL;
import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;
import static com.vibame.telugupanchangamcalendar.helper.Constant.VIDEO_LIST;
import static com.vibame.telugupanchangamcalendar.helper.Constant.VIDEO_LIST_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.ImageViewAdapter;
import com.vibame.telugupanchangamcalendar.adapter.VideoViewAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.ImagesView;
import com.vibame.telugupanchangamcalendar.model.VideoTab;
import com.vibame.telugupanchangamcalendar.model.VideosView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class VideosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    ImageView imgBack;
    VideoViewAdapter videoViewAdapter;
    String VideoCategoryId;
    EditText etSearch;
    TextView tvTitle;
    String Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        activity = VideosActivity.this;
        VideoCategoryId = getIntent().getStringExtra(Constant.VIDEO_CATEGORY_ID);
        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);
        etSearch = findViewById(R.id.etSearch);
        tvTitle = findViewById(R.id.tvTitle);
        Title = getIntent().getStringExtra(Constant.NAME);
        tvTitle.setText(Title);



        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(gridLayoutManager);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("")){
                    searchVideo(editable.toString());

                }

            }
        });
        videos();
    }
    private void searchVideo(String s)
    {
        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.VIDEO_CATEGORY_ID,VideoCategoryId);
        params.put(Constant.VIDEO,s);
        ApiConfig.RequestToVolley((result, response) -> {
            Log.d("VID_RES",response + VideoCategoryId);
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<VideosView> videosViews = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                VideosView group = g.fromJson(jsonObject1.toString(),VideosView.class);
                                videosViews.add(group);
                            } else {
                                break;
                            }
                        }
                        videoViewAdapter = new VideoViewAdapter(activity,videosViews);
                        recyclerView.setAdapter(videoViewAdapter);
                    }else {
                        ArrayList<VideosView> videosViews = new ArrayList<>();
                        videoViewAdapter = new VideoViewAdapter(activity,videosViews);
                        recyclerView.setAdapter(videoViewAdapter);


                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.SEARCH_VIDEO_URL,params,true);


    }

    private void videos() {
        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.VIDEO_CATEGORY_ID,VideoCategoryId);
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<VideosView> videosViews = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                VideosView group = g.fromJson(jsonObject1.toString(),VideosView.class);
                                videosViews.add(group);
                            } else {
                                break;
                            }
                        }
                        videoViewAdapter = new VideoViewAdapter(activity,videosViews);
                        recyclerView.setAdapter(videoViewAdapter);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, VIDEO_LIST_URL,params,true);


    }
}