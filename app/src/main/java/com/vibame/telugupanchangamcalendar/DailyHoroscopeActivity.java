package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.FestivalAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Festival;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class DailyHoroscopeActivity extends AppCompatActivity {

    TextView tvHoroscopeTitle,tvRaasi,tvDescription,tvDate;

    Activity activity;
    Session session;
    String raasi;
    int year;
    Calendar calendar;
    String rasi;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_horoscope);
        activity = this;
        session = new Session(activity);


        tvHoroscopeTitle = findViewById(R.id.tvHoroscopeTitle);
        tvHoroscopeTitle.setText(getIntent().getStringExtra(Constant.TITLE)+" - "+getIntent().getStringExtra("Name"));
        raasi = getIntent().getStringExtra("Name");


        if (raasi.equals("మేషరాశి")) {
            rasi = "Mesham";
        } else if (raasi.equals("వృషభరాశి")) {
            rasi = "Vrushabham";
        } else if (raasi.equals("మిథునరాశి")) {
            rasi = "Midhunam";
        } else if (raasi.equals("కర్కాటకరాశి")) {
            rasi = "Karkatakam";
        } else if (raasi.equals("సింహరాశి")) {
            rasi = "Simham";
        } else if (raasi.equals("కన్యారాశి")) {
            rasi = "Kanya";
        } else if (raasi.equals("తులారాశి")) {
            rasi = "Thula";
        } else if (raasi.equals("వృశ్చిక రాశి")) {
            rasi = "Vruschikam";
        } else if (raasi.equals("ధనూరాశి")) {
            rasi = "Dhanussu";
        } else if (raasi.equals("మకరరాశి")) {
            rasi = "Makaram";
        } else if (raasi.equals("కుంభరాశి")) {
            rasi = "Kumbham";
        } else if (raasi.equals("మీనరాశి")) {
            rasi = "Meenam";
        }

        tvRaasi = findViewById(R.id.tvRaasi);
        tvDescription = findViewById(R.id.tvDescription);
        tvDate = findViewById(R.id.tvDate);

        // get corrent year
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        tvDate.setText(year+" - "+ raasi);




        horoscope();


    }

    private void horoscope() {



        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.TYPE,"Daily");
        params.put(Constant.RASI,rasi);
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        Log.d("dailyhoroscope",response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();



                        tvDescription.setText(jsonArray.getJSONObject(0).getString("description"));
                        tvRaasi.setText(jsonArray.getJSONObject(0).getString("title"));
                        //tvDate.setText("("+jsonArray.getJSONObject(0).getString("date")+")");




                    }else {


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.HOROSCOPE_LIST,params,true);



    }

}