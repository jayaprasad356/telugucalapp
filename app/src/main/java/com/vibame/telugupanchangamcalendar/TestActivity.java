package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.PanchangamTabAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.Panchangam;
import com.vibame.telugupanchangamcalendar.model.PanchangamTab;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        activity = TestActivity.this;

        databaseHelper = new DatabaseHelper(activity);
        //getDatalist();


        //databaseHelper.AddToPanchangam("3","2022-11-01","15:25","16:25","17:26","18:27","Diwali");
        //databaseHelper.AddToPanchangamTab("1","1","hi","hello");

       Log.d("PANARRAY", databaseHelper.getmodelPanchangamList("2022-09-17").get(0).getId());


    }

    private void getDatalist()
    {
        Map<String, String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {


                        JSONObject object = new JSONObject(response);
                        JSONArray jsonArray = object.getJSONArray(Constant.DATA);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {

                            } else {
                                break;
                            }
                        }


                    }
                    else {


                    }
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, activity, Constant.ALLDATALIST_URL, params,true);


    }
}