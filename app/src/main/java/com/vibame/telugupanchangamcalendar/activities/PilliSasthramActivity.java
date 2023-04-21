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
import com.vibame.telugupanchangamcalendar.adapter.PilliAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.KakiData;
import com.vibame.telugupanchangamcalendar.model.PilliSasthramData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class PilliSasthramActivity extends AppCompatActivity {
    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilli_sasthram);
        recyclerView = findViewById(R.id.pilli_rcView);
        imgBack = findViewById(R.id.back_opt);

        activity = PilliSasthramActivity.this;
        imgBack.setOnClickListener(view -> onBackPressed());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadPilliSasthramData();
    }

    private void loadPilliSasthramData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.PILLI_SASTHRAM, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<PilliSasthramData> pilliSasthramData = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                PilliSasthramData group = g.fromJson(jsonObject1.toString(), PilliSasthramData.class);
                                pilliSasthramData.add(group);
                            } else {
                                break;
                            }
                        }
                        PilliAdapter adapter = new PilliAdapter(activity, pilliSasthramData);
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