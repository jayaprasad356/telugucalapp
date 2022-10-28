package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.KakiAdapter;
import com.vibame.telugupanchangamcalendar.adapter.KukutaAdapter;
import com.vibame.telugupanchangamcalendar.adapter.KukutaMenu2Adapter;
import com.vibame.telugupanchangamcalendar.adapter.PilliAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.KakiData;
import com.vibame.telugupanchangamcalendar.model.KukutaSasthramData;
import com.vibame.telugupanchangamcalendar.model.KukutaSasthramMenu2Data;
import com.vibame.telugupanchangamcalendar.model.PilliSasthramData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class KukutaSaathramActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView, hen_start_rcView;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kukuta_saathram);

        recyclerView = findViewById(R.id.pilli_rcView);
        hen_start_rcView = findViewById(R.id.hen_start_rcView);
        imgBack = findViewById(R.id.back_opt);
        title = findViewById(R.id.tvHead);
        title.setText(R.string.kukuta_sasthram);


        activity = KukutaSaathramActivity.this;
        imgBack.setOnClickListener(view -> onBackPressed());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);


        hen_start_rcView.setLayoutManager(linearLayoutManager1);
        loadKukutaSasthramData();

        loadKukutaSasthramMenuData();

    }

    private void loadKukutaSasthramMenuData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.KUKUTA_SASTHRAM_MENU, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<KukutaSasthramMenu2Data> kukutaSasthramMenu2Data = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                KukutaSasthramMenu2Data group = g.fromJson(jsonObject1.toString(), KukutaSasthramMenu2Data.class);
                                kukutaSasthramMenu2Data.add(group);
                            } else {
                                break;
                            }
                        }
                        KukutaMenu2Adapter adapter = new KukutaMenu2Adapter(activity, kukutaSasthramMenu2Data);
                        hen_start_rcView.setAdapter(adapter);
                    } else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.SAKUNA_SASTHRAM_URL, params, true);


    }

    private void loadKukutaSasthramData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.KUKUTA_SASTHRAM, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<KukutaSasthramData> kukutaSasthramData = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                KukutaSasthramData group = g.fromJson(jsonObject1.toString(), KukutaSasthramData.class);
                                kukutaSasthramData.add(group);
                            } else {
                                break;
                            }
                        }
                        KukutaAdapter adapter = new KukutaAdapter(activity, kukutaSasthramData);
                        recyclerView.setAdapter(adapter);
                    } else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.SAKUNA_SASTHRAM_URL, params, true);

    }
}