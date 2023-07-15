package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamAdapter;
import com.vibame.telugupanchangamcalendar.adapter.RamayanamMenuAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Ramayanam;
import com.vibame.telugupanchangamcalendar.model.RamayanamMenu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RamyanamMenuActivity extends AppCompatActivity {

    TextView tvHead;
    String Tittle, ramayam_id;
    ImageView imgBack;
    Activity activity;
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    Session session;
    int TotalSize,First_size ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramyanam_menu);
        activity = this;
        session = new Session(activity);
        tvHead = findViewById(R.id.tvHead);

        Tittle = getIntent().getStringExtra(Constant.RAMAYAM_MENU);
        ramayam_id = getIntent().getStringExtra(Constant.RAMAYANAM_ID);

        tvHead.setText(Tittle);


        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> onBackPressed());

        RecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(linearLayoutManager);




        loadApiData();
        size();


    }

    private void size() {
        Map<String, String> params = new HashMap<>();
        Log.d("ramayam_id", session.getData(Constant.ID));
        params.put(session.getData(Constant.MENU), "1");
        params.put(Constant.ID, session.getData(Constant.ID));
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

                        int size = ramayanamMenus.size();
                        int final_size = size - 1;

                        TotalSize  = Integer.parseInt(jsonArray.getJSONObject(final_size).getString("id"));
                        session.setData(Constant.TOTAL_SIZE, String.valueOf(TotalSize));


                 //       First_size = Integer.parseInt(jsonArray.getJSONObject(0).getString("id"));
                     //   session.setData(Constant.FIRST_SIZE, String.valueOf(First_size));

                 //    Toast.makeText(activity, ""+First_size, Toast.LENGTH_SHORT).show();

                        //   Toast.makeText(activity, ""+final_size, Toast.LENGTH_SHORT).show();

                        //  Toast.makeText(activity, ""+ jsonArray.getJSONObject(final_size).getString("id"), Toast.LENGTH_SHORT).show();


                        // Toast.makeText(activity, ""+ramayanamMenus.size(), Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.MAHA_PURANALU_URL, params, true);
    }

    private void loadApiData() {
        Map<String, String> params = new HashMap<>();
        Log.d("ramayam_id", session.getData(Constant.ID));
        params.put(session.getData(Constant.MENU), "1");
        params.put(Constant.ID, session.getData(Constant.ID));
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