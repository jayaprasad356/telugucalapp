package com.vibame.telugupanchangamcalendar;

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
import com.vibame.telugupanchangamcalendar.activities.TeluguYearActivity;
import com.vibame.telugupanchangamcalendar.adapter.AnkeluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.TeluguYearsAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.AnkeluData;
import com.vibame.telugupanchangamcalendar.model.TeluguYear;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class AnkeluActivity extends AppCompatActivity {


    ImageView imgBack;
    Activity activity;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ankelu);
        recyclerView = findViewById(R.id.Telugu_rcView);

        imgBack = findViewById(R.id.imgBack);
        activity = AnkeluActivity.this;


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadAnkeluData();
    }

    private void loadAnkeluData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.TELUGU_ANKELU, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<AnkeluData> ankeluData = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                AnkeluData group = g.fromJson(jsonObject1.toString(), AnkeluData.class);
                                ankeluData.add(group);
                            } else {
                                break;
                            }
                        }
                        AnkeluAdapter adapter = new AnkeluAdapter(activity, ankeluData);
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