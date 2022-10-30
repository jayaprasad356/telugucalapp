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
import com.vibame.telugupanchangamcalendar.adapter.AksharaluAdaptor;
import com.vibame.telugupanchangamcalendar.adapter.AnkeluAdapter;
import com.vibame.telugupanchangamcalendar.adapter.RashuluAdaptor;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.AksharaluModel;
import com.vibame.telugupanchangamcalendar.model.AnkeluData;
import com.vibame.telugupanchangamcalendar.model.RashuluModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class AksharaluActivity extends AppCompatActivity {
    ImageView imgBack;

    private RecyclerView AksharaluRecycler;
    private AksharaluAdaptor aksharaluAdaptor;
    private ArrayList<AksharaluModel> aksharaluModelArrayList;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aksharalu);
        activity = this;
        AksharaluRecycler = findViewById(R.id.AksharaluRecycler);
        AksharaluRecycler.setLayoutManager(new LinearLayoutManager(activity));
        AksharaluRecycler.setHasFixedSize(true);
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        loadAksharaluData();

    }

    private void loadAksharaluData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.TELUGU_AKSHARALU, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<AksharaluModel> aksharaluModels = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                AksharaluModel group = g.fromJson(jsonObject1.toString(), AksharaluModel.class);
                                aksharaluModels.add(group);
                            } else {
                                break;
                            }
                        }
                        AksharaluAdaptor adapter = new AksharaluAdaptor(activity, aksharaluModels);
                        AksharaluRecycler.setAdapter(adapter);
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