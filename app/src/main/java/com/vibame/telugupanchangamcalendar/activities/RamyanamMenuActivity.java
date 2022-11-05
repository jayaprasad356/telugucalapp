package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamAdapter;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamMenuAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Ramayanam;
import com.vibame.telugupanchangamcalendar.model.RamayanamMenu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RamyanamMenuActivity extends AppCompatActivity {

    TextView tvHead;
    String Tittle,id,ramayam_id;
    ImageView imgBack;
    Activity activity;
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    RamayanamMenuAdapter ramayanamMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramyanam_menu);
        activity = this;

        tvHead = findViewById(R.id.tvHead);

        Tittle = getIntent().getStringExtra(Constant.RAMAYAM_MENU);
        id=getIntent().getStringExtra(Constant.ID);
        ramayam_id=getIntent().getStringExtra(Constant.RAMAYANAM_ID);

        tvHead.setText(Tittle);


        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> onBackPressed());

        RecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(linearLayoutManager);


        loadApiData();


    }

    private void loadApiData() {
        Map<String, String> params = new HashMap<>();
        params.put(Constant.RAMAYANAM_MENU, "1");
        params.put(Constant.RAMAYANAM_ID, id);
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<RamayanamMenu> ramayanamMenus = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                RamayanamMenu group = g.fromJson(jsonObject1.toString(), RamayanamMenu.class);
                                ramayanamMenus.add(group);
                            } else {
                                break;
                            }
                        }
                        RamayanamMenuAdapter adapter = new RamayanamMenuAdapter(ramayanamMenus, activity);
                        RecyclerView.setAdapter(adapter);
                    } else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.MAHA_PURANALU_URL, params, true);
    }
}