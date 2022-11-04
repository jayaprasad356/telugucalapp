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
import com.vibame.telugupanchangamcalendar.adapter.RamayanamMenuAdapter;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamSubMenuAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.RamayanamMenu;
import com.vibame.telugupanchangamcalendar.model.RamayanamSubMenu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RamayamSubMenuActivity extends AppCompatActivity {


    TextView tvHead;
    String Tittle,id,ramayam_id;
    ImageView imgBack;
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    RamayanamSubMenuAdapter ramayanamSubMenuAdapter;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramayam_sub_menu);

        activity = RamayamSubMenuActivity.this;


        tvHead = findViewById(R.id.tvHead);
        id=getIntent().getStringExtra(Constant.ID);
        ramayam_id=getIntent().getStringExtra(Constant.RAMAYANAM_ID);


        Tittle = getIntent().getStringExtra(Constant.RAMAYAM_MENU);
        tvHead.setText(Tittle);


        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> onBackPressed());

        RecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(linearLayoutManager);


        menu_list();
    }

    private void menu_list() {






        Map<String, String> params = new HashMap<>();
        params.put(Constant.RAMAYANAM_SUB_MENU, "1");
        params.put(Constant.RAMAYANAM_MENU_ID, id);
        params.put(Constant.RAMAYANAM_ID,ramayam_id);
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<RamayanamSubMenu> ramayanamSubMenus = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                RamayanamSubMenu group = g.fromJson(jsonObject1.toString(), RamayanamSubMenu.class);
                                ramayanamSubMenus.add(group);
                            } else {
                                break;
                            }
                        }
                        ramayanamSubMenuAdapter = new RamayanamSubMenuAdapter(this,ramayanamSubMenus);
                        RecyclerView.setAdapter(ramayanamSubMenuAdapter);
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