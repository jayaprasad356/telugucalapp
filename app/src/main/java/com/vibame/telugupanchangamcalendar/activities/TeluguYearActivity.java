package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.TeluguYearsAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.TeluguYear;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class TeluguYearActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telugu_year);

        recyclerView = findViewById(R.id.Telugu_rcView);
        imgBack = findViewById(R.id.imgBack);
        activity = TeluguYearActivity.this;


        imgBack.setOnClickListener(view -> onBackPressed());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadTeluguYears();
    }
    private void loadTeluguYears() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.TELUGU_SAWANCHARALU, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<TeluguYear> teluguYears = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                TeluguYear group = g.fromJson(jsonObject1.toString(), TeluguYear.class);
                                teluguYears.add(group);
                            } else {
                                break;
                            }
                        }
                        TeluguYearsAdapter adapter = new TeluguYearsAdapter(activity, teluguYears);
                        recyclerView.setAdapter(adapter);
                    } else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.TELUGU_SAMKRUTHAM_URL, params, true);

    }
}