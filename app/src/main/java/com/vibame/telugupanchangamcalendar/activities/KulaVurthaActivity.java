package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.GunintaluAdaptor;
import com.vibame.telugupanchangamcalendar.adapter.KulaVurthaAdaptor;
import com.vibame.telugupanchangamcalendar.adapter.RashuluAdaptor;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Guninthalu;
import com.vibame.telugupanchangamcalendar.model.KulaVurthala;
import com.vibame.telugupanchangamcalendar.model.RashuluModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class KulaVurthaActivity extends AppCompatActivity {

    private RecyclerView KulaVurthaReccycler;
    private KulaVurthaAdaptor kulaVurthaAdaptor;
    private ArrayList<KulaVurthala> kulaVurthalaArrayList;
    private Activity activity;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kula_vurtha);
        activity = this;

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        KulaVurthaReccycler = findViewById(R.id.VruthuluRecycler);
        KulaVurthaReccycler.setLayoutManager(new LinearLayoutManager(activity));
        KulaVurthaReccycler.setHasFixedSize(true);
        loadApiData();
    }

    private void loadApiData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.VRUTHULU, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<KulaVurthala> kulaVurthalas = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                KulaVurthala group = g.fromJson(jsonObject1.toString(), KulaVurthala.class);
                                kulaVurthalas.add(group);
                            } else {
                                break;
                            }
                        }
                        KulaVurthaAdaptor adapter = new KulaVurthaAdaptor(activity, kulaVurthalas);
                        KulaVurthaReccycler.setAdapter(adapter);
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