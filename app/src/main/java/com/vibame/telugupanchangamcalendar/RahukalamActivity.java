package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

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
import java.util.HashMap;

public class RahukalamActivity extends AppCompatActivity {

    ImageButton ibNextYear,ibPreviousYear;
    TextView tvYear;
    int Year = 2022;
    TextView tvMonday,tvTuesday,tvWednesday, tvThursday,tvFriday,tvSaturday,tvSunday;
    ImageView imgBack;
    Activity activity;
    TextView tvRahukalam,tvYamagandam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rahukalam);
        activity = RahukalamActivity.this;


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
        tvRahukalam = findViewById(R.id.tvRahukalam);
        tvYamagandam = findViewById(R.id.tvYamagandam);
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
        params.put(Constant.RAHUKALAM,"1");
        params.put(Constant.DAY,day);
        params.put(Constant.YEAR,tvYear.getText().toString().trim());
        ApiConfig.RequestToVolley((result, response) -> {
            Log.d("GOWRI_PAN",response);
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        tvRahukalam.setText(jsonArray.getJSONObject(0).getString(Constant.RAHUKALAM));
                        tvYamagandam.setText(jsonArray.getJSONObject(0).getString(Constant.YAMANGANDAM));
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

                    }else {
                        tvRahukalam.setText("-");
                        tvYamagandam.setText("-");
                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.PANCHANGAM_LIST_URL,params,true);






    }
}