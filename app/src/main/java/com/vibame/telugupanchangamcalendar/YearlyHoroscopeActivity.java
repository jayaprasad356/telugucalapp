package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.FestivalAdapter;
import com.vibame.telugupanchangamcalendar.adapter.YearlyHoroscopeAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Festival;
import com.vibame.telugupanchangamcalendar.model.YearlyHoroscope;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class YearlyHoroscopeActivity extends AppCompatActivity {

    TextView tvHoroscopeTitle, tvRaasi, tvDescription, tvTitle;
    TextView tvtext1, tvtext2, tvtext3, tvtext4,tvDate;
    Activity activity;
    Session session;
    String raasi;
    int year;
    Calendar calendar;
    RecyclerView recyclerView;
    YearlyHoroscopeAdapter adapter;
    String rasi;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly_horoscope);

        activity = this;
        session = new Session(activity);


        tvHoroscopeTitle = findViewById(R.id.tvHoroscopeTitle);
        tvHoroscopeTitle.setText(getIntent().getStringExtra(Constant.TITLE) + " - " + getIntent().getStringExtra("Name"));
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
        tvTitle = findViewById(R.id.tvTitle);
        tvtext1 = findViewById(R.id.tvtext1);
        tvtext2 = findViewById(R.id.tvtext2);
        tvtext3 = findViewById(R.id.tvtext3);
        tvtext4 = findViewById(R.id.tvtext4);
        tvDate = findViewById(R.id.tvDate);


        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        // get corrent year
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);


        tvDate.setText(year + " - " + raasi);

        horoscope();
        horoscopeVarient();


    }

    private void horoscopeVarient() {


        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.TYPE, "Yearly");
        params.put(Constant.RASI, rasi);
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        Log.d("Yearlyhoroscope", response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        JSONObject jsonarray2 = jsonArray.getJSONObject(0);
                        JSONArray files = jsonarray2.getJSONArray(Constant.YEARLY_HOROSCOPE_VARIANT);
                        Gson g = new Gson();
                        ArrayList<YearlyHoroscope> yearlyHoroscopes = new ArrayList<>();
                        for (int i = 0; i < files.length(); i++) {
                            JSONObject jsonObject1 = files.getJSONObject(i);
                            if (jsonObject1 != null) {
                                Log.d("Varine", jsonObject1.toString());
                                YearlyHoroscope group = g.fromJson(jsonObject1.toString(), YearlyHoroscope.class);
                                yearlyHoroscopes.add(group);
                            } else {
                                break;
                            }
                        }
                        adapter = new YearlyHoroscopeAdapter(activity, yearlyHoroscopes);
                        recyclerView.setAdapter(adapter);


                    } else {


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.HOROSCOPE_LIST, params, true);


    }


    private void horoscope() {


        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.TYPE, "Yearly");
        params.put(Constant.RASI, rasi);
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        Log.d("Yearlyhoroscope", response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        JSONObject jsonarray2 = jsonArray.getJSONObject(0);
                        JSONArray files = jsonarray2.getJSONArray(Constant.YEARLY_HOROSCOPE_VARIANT);

                        Gson g = new Gson();



                        tvDescription.setText(jsonArray.getJSONObject(0).getString("description"));
                        tvTitle.setText(jsonArray.getJSONObject(0).getString("title"));
                        tvtext1.setText(jsonArray.getJSONObject(0).getString("adhayam"));
                        tvtext2.setText(jsonArray.getJSONObject(0).getString("vyayam"));
                        tvtext3.setText(jsonArray.getJSONObject(0).getString("rajapujyam"));
                        tvtext4.setText(jsonArray.getJSONObject(0).getString("aavamanam"));


                    } else {


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.HOROSCOPE_LIST, params, true);


    }

}