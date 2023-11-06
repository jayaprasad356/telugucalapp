package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.vibame.telugupanchangamcalendar.adapter.GrahaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.VideoLiveAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.Video;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class VideoLiveActivity extends AppCompatActivity {

    Activity activity;
    RecyclerView recyclerView;
    VideoLiveAdapter videoLiveAdapter;
    ImageView imgBack;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_live);
        activity = VideoLiveActivity.this;

        databaseHelper = new DatabaseHelper(activity);
        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);

        videolist();
        videolive();


    }

    private void videolist() {
        HashMap<String, String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        Log.d("Festivallise", response);
                        JSONArray jsonArray3 = jsonObject.getJSONArray(Constant.DATA);

                        for (int i = 0; i < jsonArray3.length(); i++) {
                            JSONObject jsonObject1 = jsonArray3.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToVideo(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.LINK),jsonObject1.getString(Constant.IMAGE));


                            } else {
                                break;
                            }
                        }

                        videolive();


                    } else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.VIDEO_LIST_URI, params, true);
    }


    private void videolive() {
        Log.d("VIDEO_LIVE",databaseHelper.getVideoesCount() + "");

        if (databaseHelper.getVideoList().size() !=0){
            videoLiveAdapter = new VideoLiveAdapter(activity, databaseHelper.getVideoList());
            recyclerView.setAdapter(videoLiveAdapter);
            recyclerView.setVisibility(View.VISIBLE);


        }
        else {
            recyclerView.setVisibility(View.GONE);

        }
    }
}