package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.BHAKTHI_ARTICLES_LIST;
import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.NetiArticlesAdaptor;
import com.vibame.telugupanchangamcalendar.adapter.OldArticlesAdaptor;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.NetiData;
import com.vibame.telugupanchangamcalendar.model.OldData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class OldArticlesActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;
    OldArticlesAdaptor oldArticlesAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_articles);

        recyclerView = findViewById(R.id.Old_recyclerView);
        imgBack = findViewById(R.id.imgBack);
        activity = OldArticlesActivity.this;

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        oldarticles();
    }

    private void oldarticles() {



        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.old_ARTICLES, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<OldData> oldData = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                OldData group = g.fromJson(jsonObject1.toString(),OldData.class);
                                oldData.add(group);
                            } else {
                                break;
                            }
                        }


                        oldArticlesAdaptor = new OldArticlesAdaptor(this,oldData);
                        recyclerView.setAdapter(oldArticlesAdaptor);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, BHAKTHI_ARTICLES_LIST,params,true);





    }
}