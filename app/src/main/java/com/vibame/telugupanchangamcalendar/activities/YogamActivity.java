package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.KaranamAdapter;
import com.vibame.telugupanchangamcalendar.adapter.YogamAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Karanam;
import com.vibame.telugupanchangamcalendar.model.Yogam;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class YogamActivity extends AppCompatActivity {
    ImageView imgBack;
    RecyclerView recyclerView;
    Activity activity;
    YogamAdapter yogamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yogam);
        imgBack = findViewById(R.id.imgBack);
        activity = YogamActivity.this;
        recyclerView = findViewById(R.id.recyclerView);
        imgBack.setOnClickListener(view -> {
            onBackPressed();
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        karanamList();
    }

    private void karanamList() {
        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.YOGAM,"1");
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<Yogam> yogams = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                Yogam group = g.fromJson(jsonObject1.toString(),Yogam.class);
                                yogams.add(group);
                            } else {
                                break;
                            }
                        }
                        yogamAdapter = new YogamAdapter(activity,yogams);
                        recyclerView.setAdapter(yogamAdapter);
                    }else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.PANCHANGAM_LIST_URL,params,true);

    }

}