package com.vibame.telugupanchangamcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.YearTabAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.YearTab;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RaasiDetailsActivity extends AppCompatActivity {
    ImageView imgBack;
    TextView tvRaasi,tvTitle,tvDate,tvDescription,tvLuckyNumber,tvLuckyColor,tvTreatment,tvHealth,tvWealth,tvFamily,tvThings,tvProfession,tvMarried;
    String Raasi,Horoscope;
    Activity activity;
    LinearLayout lHoroscope;
    RecyclerView recyclerView;
    YearTabAdapter yearTabAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raasi_details);
        Raasi = getIntent().getStringExtra(Constant.RASI);
        Horoscope = getIntent().getStringExtra(Constant.HOROSCOPE);
        imgBack = findViewById(R.id.imgBack);
        tvRaasi = findViewById(R.id.tvRaasi);
        tvTitle = findViewById(R.id.tvTitle);
        tvDate = findViewById(R.id.tvDate);
        tvDescription = findViewById(R.id.tvDescription);
        tvLuckyNumber = findViewById(R.id.tvLuckyNumber);
        tvLuckyColor = findViewById(R.id.tvLuckyColor);
        tvTreatment = findViewById(R.id.tvTreatment);
        tvHealth = findViewById(R.id.tvHealth);
        tvWealth = findViewById(R.id.tvWealth);
        tvFamily = findViewById(R.id.tvFamily);
        tvThings =  findViewById(R.id.tvThings);
        tvProfession =  findViewById(R.id.tvProfession);
        tvMarried =   findViewById(R.id.tvMarried);
        lHoroscope =   findViewById(R.id.lHoroscope);
        recyclerView =   findViewById(R.id.recyclerView);
        activity = RaasiDetailsActivity.this;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        imgBack.setOnClickListener(v -> onBackPressed());


        tvTitle.setText(Raasi + " Rasi Phalalu");


        tvRaasi.setText(Raasi);
        if (Horoscope.equals("Daily")){
            apiDaily(Horoscope);
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("EEEE MMMM dd,yyyy", Locale.getDefault());
            String todayDate = df.format(c);
            tvDate.setText("("+todayDate+")");

        }else if (Horoscope.equals("Weekly")){
            lHoroscope.setVisibility(View.GONE);
            apiRaasi(Horoscope);
            DateFormat format = new SimpleDateFormat("dd MMM yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            String[] days = new String[7];
            for (int i = 0; i < 7; i++)
            {
                days[i] = format.format(calendar.getTime());
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            tvDate.setText("("+days[0] + " - "+days[6]+")");
        }else if (Horoscope.equals("Monthly")){
            lHoroscope.setVisibility(View.GONE);
            apiRaasi(Horoscope);
            DateFormat dateFormat = new SimpleDateFormat("( MMMM,yyyy )");
            Date date = new Date();
            tvDate.setText(dateFormat.format(date));
        }else if (Horoscope.equals("Yearly")){
            lHoroscope.setVisibility(View.GONE);
            apiYearRaasi(Horoscope);
            DateFormat dateFormat = new SimpleDateFormat("( yyyy )");
            Date date = new Date();
            tvDate.setText(dateFormat.format(date));
        }

    }

    private void apiYearRaasi(String type) {
        Map<String, String> params = new HashMap<>();
        params.put(Constant.TYPE,type);
        params.put(Constant.RASI,Raasi);
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        JSONObject object = new JSONObject(response);
                        JSONArray jsonArray1 = object.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<YearTab> yearTabs = new ArrayList<>();
                        JSONObject jsonObject0 = jsonArray1.getJSONObject(0);
                        JSONArray jsonArray = jsonObject0.getJSONArray(Constant.YEARLY_HOROSCOPE_VARIANT);



                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            if (jsonObject1 != null) {
                                YearTab group = g.fromJson(jsonObject1.toString(), YearTab.class);
                                yearTabs.add(group);
                            } else {
                                break;
                            }
                        }
                        yearTabAdapter = new YearTabAdapter(activity, yearTabs);
                        recyclerView.setAdapter(yearTabAdapter);


                    } else {
                        Toast.makeText(activity, "" + String.valueOf(jsonObject.getString(Constant.MESSAGE)), Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.HOROSCOPE_URL, params, true);

    }

    private void apiRaasi(String type)
    {
        Map<String, String> params = new HashMap<>();
        params.put(Constant.TYPE,type);
        params.put(Constant.RASI,Raasi);
        ApiConfig.RequestToVolley((result, response) -> {
            Log.d("HOROSCOPE",type+response);
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {

                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        tvDescription.setText(jsonArray.getJSONObject(0).getString(Constant.DESCRIPTION));



                    }

                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, activity, Constant.HOROSCOPE_URL, params,true);



    }

    private void apiDaily(String type)
    {
        Map<String, String> params = new HashMap<>();
        params.put(Constant.TYPE,type);
        params.put(Constant.RASI,Raasi);
        ApiConfig.RequestToVolley((result, response) -> {
            Log.d("HOROSCOPE",response);
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        lHoroscope.setVisibility(View.VISIBLE);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        tvDescription.setText(jsonArray.getJSONObject(0).getString(Constant.DESCRIPTION));
                        tvLuckyNumber.setText("Lucky number :- "+jsonArray.getJSONObject(0).getString(Constant.LUCKYNUMBER));
                        tvLuckyColor.setText("Lucky color :- "+jsonArray.getJSONObject(0).getString(Constant.LUCKYCOLOR));
                        tvTreatment.setText("Treatement :- "+jsonArray.getJSONObject(0).getString(Constant.TREATMENT));
                        tvHealth.setText("Health: "+jsonArray.getJSONObject(0).getString(Constant.HEALTH));
                        tvWealth.setText("Wealth: "+jsonArray.getJSONObject(0).getString(Constant.WEALTH));
                        tvFamily.setText("Family: "+jsonArray.getJSONObject(0).getString(Constant.FAMILY));
                        tvThings.setText("Things related to love: "+jsonArray.getJSONObject(0).getString(Constant.THINGS_LOVE));
                        tvProfession.setText("Profession: "+jsonArray.getJSONObject(0).getString(Constant.PROFESSION));
                        tvMarried.setText("Married Life: "+jsonArray.getJSONObject(0).getString(Constant.MARRIED_LIFE));



                    }

                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, activity, Constant.HOROSCOPE_URL, params,true);


    }


}