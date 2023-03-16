package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;

public class WeeklyHoroscopeActivity extends AppCompatActivity {


    TextView tvHoroscopeTitle,tvRaasi,tvDescription,tvDate;

    Activity activity;
    Session session;
    String raasi;
    int year;
    Calendar calendar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_horoscope);

        activity = this;
        session = new Session(activity);


        tvHoroscopeTitle = findViewById(R.id.tvHoroscopeTitle);
        tvHoroscopeTitle.setText(getIntent().getStringExtra(Constant.TITLE)+" - "+getIntent().getStringExtra("Name"));
        raasi = getIntent().getStringExtra("Name");

        tvRaasi = findViewById(R.id.tvRaasi);
        tvDescription = findViewById(R.id.tvDescription);
        tvDate = findViewById(R.id.tvDate);

        // get corrent year
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);




        horoscope();


    }

    private void horoscope() {



        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.TYPE,"Weekly");
        params.put(Constant.RASI,raasi);
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        Log.d("dailyhoroscope",response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();


                        tvRaasi.setText(year+" - "+jsonArray.getJSONObject(0).getString("rasi"));
                        tvDescription.setText(jsonArray.getJSONObject(0).getString("description"));
                        tvDate.setText("("+jsonArray.getJSONObject(0).getString("week")+")");




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