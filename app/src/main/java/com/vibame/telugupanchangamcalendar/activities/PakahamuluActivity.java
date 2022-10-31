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

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.FruitsNamesAdapter;
import com.vibame.telugupanchangamcalendar.adapter.MonthAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PakshamuluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PushapaluAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.FruitsNames;
import com.vibame.telugupanchangamcalendar.model.MonthData;
import com.vibame.telugupanchangamcalendar.model.Pakshamulu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class PakahamuluActivity extends AppCompatActivity {

    ImageView imgBack, image;
    Activity activity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakahamulu);
        ArrayList<Pakshamulu> pakshamulus;

        recyclerView = findViewById(R.id.month_rcView);
        imgBack = findViewById(R.id.imgBack);
        activity = PakahamuluActivity.this;
        image = findViewById(R.id.image);
        Pakshamulu pakshamulu = new Pakshamulu();
        Glide.with(activity).load(pakshamulu.getImageUrl()).into(image);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadRashuluData();
    }

    private void loadRashuluData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.PAKSHAMULU, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<Pakshamulu> pakshamulus = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                Pakshamulu group = g.fromJson(jsonObject1.toString(), Pakshamulu.class);
                                pakshamulus.add(group);
                            } else {
                                break;
                            }
                        }
                        PakshamuluAdapter adapter = new PakshamuluAdapter(activity, pakshamulus);
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