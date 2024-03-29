package com.vibame.telugupanchangamcalendar.activities;

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

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.KolathaluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.RuthuvuluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.TeluguYearsAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Kolathalu;
import com.vibame.telugupanchangamcalendar.model.Ruthuvulu;
import com.vibame.telugupanchangamcalendar.model.TeluguYear;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class KolathaluActivity extends AppCompatActivity {

    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolathalu);

        recyclerView = findViewById(R.id.Telugu_rcView);
        imgBack = findViewById(R.id.imgBack);
        activity = KolathaluActivity.this;


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadApiData();
    }

    private void loadApiData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.KOLATHALU, "1");

        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);

                        Gson g = new Gson();
                        ArrayList<Kolathalu> kolathalus = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            if (jsonObject1 != null) {
                                Kolathalu group = g.fromJson(jsonObject1.toString(), Kolathalu.class);
                                kolathalus.add(group);
                            } else {
                                break;
                            }
                        }


                        KolathaluAdapter adapter = new KolathaluAdapter(activity, kolathalus);
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