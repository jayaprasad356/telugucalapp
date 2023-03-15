package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.model.Gowri;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class GowriPanchangamActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    GowriAdapter gowriAdapter;
    ImageButton ibNextYear,ibPreviousYear;
    TextView tvMonday,tvTuesday,tvWednesday, tvThursday,tvFriday,tvSaturday,tvSunday,tvYear;
    int Year = 2022;
    ImageView imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gowri_panchangam);

        activity = GowriPanchangamActivity.this;






        recyclerView = findViewById(R.id.recyclerView);
        tvYear = findViewById(R.id.tvYear);
        ibNextYear = findViewById(R.id.ibNextYear);
        ibPreviousYear = findViewById(R.id.ibPreviousYear);
        tvMonday = findViewById(R.id.tvMonday);
        tvTuesday = findViewById(R.id.tvTuesday);
        tvWednesday = findViewById(R.id.tvWednesday);
        tvThursday = findViewById(R.id.tvThursday);
        tvFriday = findViewById(R.id.tvFriday);
        tvSaturday = findViewById(R.id.tvSaturday);
        tvSunday = findViewById(R.id.tvSunday);
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ibNextYear.setOnClickListener(v -> {
            Year ++;
            tvYear.setText("" + Year);

        });
        ibPreviousYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year --;
                tvYear.setText("" + Year);


            }
        });

        // Get the current day of the week
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Map the day of the week to a string
        String dayOfWeekString = "";
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                dayOfWeekString = "Sunday";
                unselecctallday();
                tvSunday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Sunday");
                break;
            case Calendar.MONDAY:
                dayOfWeekString = "Monday";
                unselecctallday();
                tvMonday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Monday");
                break;
            case Calendar.TUESDAY:
                dayOfWeekString = "Tuesday";
                unselecctallday();
                tvTuesday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Tuesday");
                break;
            case Calendar.WEDNESDAY:
                dayOfWeekString = "Wednesday";
                unselecctallday();
                tvWednesday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Wednesday");
                break;
            case Calendar.THURSDAY:
                dayOfWeekString = "Thursday";
                unselecctallday();
                tvThursday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Thursday");
                break;
            case Calendar.FRIDAY:
                dayOfWeekString = "Friday";
                unselecctallday();
                tvFriday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Friday");
                break;
            case Calendar.SATURDAY:
                dayOfWeekString = "Saturday";
                unselecctallday();
                tvSaturday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Saturday");
                break;
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);

        tvMonday.setOnClickListener(view -> {
            unselecctallday();
            tvMonday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("Monday");
        });
        tvTuesday.setOnClickListener(view -> {
            unselecctallday();
            tvTuesday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("Tuesday");
        });
        tvWednesday.setOnClickListener(view -> {
            unselecctallday();
            tvWednesday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("Wednesday");
        });
        tvThursday.setOnClickListener(view -> {
            unselecctallday();
            tvThursday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("Thursday");
        });
        tvFriday.setOnClickListener(view -> {
            unselecctallday();
            tvFriday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("Friday");
        });
        tvSaturday.setOnClickListener(view -> {
            unselecctallday();
            tvSaturday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("Saturday");
        });
        tvSunday.setOnClickListener(view -> {
            unselecctallday();
            tvSunday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
            list("Sunday");
        });




    }

    private void unselecctallday()
    {
        tvMonday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvTuesday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvWednesday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvThursday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvFriday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvSaturday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvSunday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));

    }

    private void list(String day) {
        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.GOWRI,"1");
        params.put(Constant.DAY,day);
        params.put(Constant.YEAR,tvYear.getText().toString().trim());
        ApiConfig.RequestToVolley((result, response) -> {
            Log.d("GOWRI_PAN",response);
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();
                        ArrayList<Gowri> gowris = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                Gowri group = g.fromJson(jsonObject1.toString(),Gowri.class);
                                gowris.add(group);
                            } else {
                                break;
                            }
                        }
                        gowriAdapter = new GowriAdapter(activity,gowris);
                        recyclerView.setAdapter(gowriAdapter);
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