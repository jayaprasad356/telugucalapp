package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.GowriAdapter;
import com.vibame.telugupanchangamcalendar.adapter.ThidhiluAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Gowri;
import com.vibame.telugupanchangamcalendar.model.Thidhilu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ThidhiluActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    ThidhiluAdapter thidhiluAdapter;
    ImageButton ibNextYear,ibPreviousYear;
    TextView tvYear;
    int Year = 2022;
    ImageView imgBack;
    TextView tvJanuary,tvFebruary,tvMarch,tvApril,tvMay,tvJune,tvJuly,tvAugust,tvSeptember,tvOctober,tvNovember,tvDecember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thidhilu);

        activity = ThidhiluActivity.this;

        recyclerView = findViewById(R.id.recyclerView);
        tvYear = findViewById(R.id.tvYear);
        ibNextYear = findViewById(R.id.ibNextYear);
        ibPreviousYear = findViewById(R.id.ibPreviousYear);
        imgBack = findViewById(R.id.imgBack);
        tvJanuary = findViewById(R.id.tvJanuary);
        tvFebruary = findViewById(R.id.tvFebruary);
        tvMarch = findViewById(R.id.tvMarch);
        tvApril = findViewById(R.id.tvApril);
        tvMay = findViewById(R.id.tvMay);
        tvJune = findViewById(R.id.tvJune);
        tvJuly = findViewById(R.id.tvJuly);
        tvAugust = findViewById(R.id.tvAugust);
        tvSeptember = findViewById(R.id.tvSeptember);
        tvOctober = findViewById(R.id.tvOctober);
        tvNovember = findViewById(R.id.tvNovember);
        tvDecember = findViewById(R.id.tvDecember);



        ibNextYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year ++;
                tvYear.setText("" + Year);

            }
        });
        ibPreviousYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year --;
                tvYear.setText("" + Year);


            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tvJanuary.setOnClickListener(view -> {
            unselecctallday();
            tvJanuary.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("January");


        });

        tvFebruary.setOnClickListener(view -> {
            unselecctallday();
            tvFebruary.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("February");

        });
        tvMarch.setOnClickListener(view -> {
            unselecctallday();
            tvMarch.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("March");

        });
        tvApril.setOnClickListener(view -> {
            unselecctallday();
            tvApril.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("April");

        });
        tvMay.setOnClickListener(view -> {
            unselecctallday();
            tvMay.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("May");

        });
        tvJune.setOnClickListener(view -> {
            unselecctallday();
            tvJune.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("June");

        });
        tvJuly.setOnClickListener(view -> {
            unselecctallday();
            tvJuly.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("July");

        });
        tvAugust.setOnClickListener(view -> {
            unselecctallday();
            tvAugust.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("August");

        });
        tvSeptember.setOnClickListener(view -> {
            unselecctallday();
            tvSeptember.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("September");

        });
        tvOctober.setOnClickListener(view -> {
            unselecctallday();
            tvOctober.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("October");

        });
        tvNovember.setOnClickListener(view -> {
            unselecctallday();
            tvNovember.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("November");

        });
        tvDecember.setOnClickListener(view -> {
            unselecctallday();
            tvDecember.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("December");

        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2);
        recyclerView.setLayoutManager(gridLayoutManager);

    }
    private void unselecctallday()
    {
        tvJanuary.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvFebruary.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvMarch.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvApril.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvMay.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvJune.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvJuly.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvAugust.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvSeptember.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvOctober.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvNovember.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvDecember.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));

    }

    private void list(String month) {
        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.THIDHI,"1");
        params.put(Constant.MONTH,month);
        params.put(Constant.YEAR,tvYear.getText().toString().trim());
        ApiConfig.RequestToVolley((result, response) -> {
            Log.d("GOWRI_PAN",response);
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<Thidhilu> thidhilus = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                Thidhilu group = g.fromJson(jsonObject1.toString(),Thidhilu.class);
                                thidhilus.add(group);
                            } else {
                                break;
                            }
                        }
                        thidhiluAdapter = new ThidhiluAdapter(activity,thidhilus);
                        recyclerView.setAdapter(thidhiluAdapter);
                    }else {
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.PANCHANGAM_LIST_URL,params,true);







    }
}