package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.BHAKTHI_ARTICLES_LIST;
import static com.vibame.telugupanchangamcalendar.helper.Constant.IMAGE_LIST_URL;
import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.ImageViewAdapter;
import com.vibame.telugupanchangamcalendar.adapter.NetiArticlesAdaptor;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.ImagesView;
import com.vibame.telugupanchangamcalendar.model.NetiData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class NetiArticlesActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;
    NetiArticlesAdaptor newArticlesAdaptor;
    Session session;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neti_articles);

        recyclerView = findViewById(R.id.New_recyclerView);
        imgBack = findViewById(R.id.imgBack);
        activity = NetiArticlesActivity.this;
        session = new Session(activity);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        newarticles();
    }

    private void newarticles() {



        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.NETI_ARTICLES, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<NetiData> netiData = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                NetiData group = g.fromJson(jsonObject1.toString(),NetiData.class);
                                netiData.add(group);
                            } else {
                                break;
                            }
                        }

                        newArticlesAdaptor = new NetiArticlesAdaptor(this,netiData);
                        recyclerView.setAdapter(newArticlesAdaptor);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, BHAKTHI_ARTICLES_LIST,params,true);






    }
}