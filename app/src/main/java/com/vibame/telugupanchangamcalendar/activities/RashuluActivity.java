package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.ID;
import static com.vibame.telugupanchangamcalendar.helper.Constant.MESSAGE;
import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;
import static com.vibame.telugupanchangamcalendar.helper.Constant.TITLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.RashuluAdaptor;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.RashuluModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class RashuluActivity extends AppCompatActivity {

    ImageView imgBack;

    private RecyclerView RashuluRecycler;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rashulu);
        activity = this;
        RashuluRecycler = findViewById(R.id.RashuluRecycler);
        RashuluRecycler.setLayoutManager(new LinearLayoutManager(activity));
        RashuluRecycler.setHasFixedSize(true);
        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(view -> onBackPressed());
        loadRashuluData();
    }


    private void loadRashuluData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.RASHULU, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                Log.d("res",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
//                        Log.d("msg", jsonObject.getString(MESSAGE));
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<RashuluModel> rashuluModels = new ArrayList<>();
                        Log.d("msg",    jsonArray.getJSONObject(2).getString(Constant.ID));

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                RashuluModel group = g.fromJson(jsonObject1.toString(), RashuluModel.class);
                                rashuluModels.add(group);
                            } else {
                                break;
                            }
                        }
                        RashuluAdaptor adapter = new RashuluAdaptor(activity, rashuluModels);
                        RashuluRecycler.setAdapter(adapter);
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