package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.FestivalAdapter;
import com.vibame.telugupanchangamcalendar.adapter.MuhurthamnewAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.Muhurthamnew;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class MuhurthamActivity extends AppCompatActivity  implements  SwipeableScrollView.SwipeListener{


    CardView imgLeft, imgRight;
    ImageButton ivArrowRight, ivArrowLeft;
    TextView tvMonthYear;
    String month_year;
    int monthcount = 0;
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
    Calendar c = Calendar.getInstance();
    DatabaseHelper databaseHelper;
    Activity activity;
    FestivalAdapter festivalAdapter;
    String year;
    String[] montharray = {"జనవరి ", "ఫిబ్రవరి ", "మార్చి ", "ఏప్రిల్ ", "మే ", "జూన్ ", "జూలై ", "ఆగస్టు ", "సెప్టెంబర్ ", "అక్టోబర్ ", "నవంబర్ ", "డిసెంబర్ "};
    Calendar calendar;
    Calendar targetCalendar;
    RelativeLayout relativeLayout;
    private SwipeableScrollView scrollView;
    ImageView imgBack;
    RecyclerView recyclerView;
    TextView tvTitle;
    MuhurthamnewAdapter adapter;


    private final GestureDetector gestureDetector = new GestureDetector(activity, new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (Math.abs(velocityX) > Math.abs(velocityY)) {
                if (e1.getX() < e2.getX()) {
                    // Swipe right
                    onSwipeRight();
                } else {
                    // Swipe left
                    onSwipeLeft();
                }
                return true;
            }
            return false;
        }
    });

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muhurtham2);
        imgLeft = findViewById(R.id.arrowleft);
        imgRight = findViewById(R.id.arrowright);
        ivArrowRight = findViewById(R.id.ivArrowRight);
        ivArrowLeft = findViewById(R.id.ivArrowLeft);
        tvMonthYear = findViewById(R.id.tvMonthYear);
        imgBack = findViewById(R.id.imgBack);


        activity = MuhurthamActivity.this;


        tvTitle = findViewById(R.id.tvtext1);
        scrollView = findViewById(R.id.scroll_view);
        scrollView.setSwipeListener(this);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        relativeLayout = findViewById(R.id.slider);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);



        targetCalendar = Calendar.getInstance();
        targetCalendar.set(Calendar.YEAR, 2024);
        targetCalendar.set(Calendar.MONTH, Calendar.APRIL);
        targetCalendar.set(Calendar.DAY_OF_MONTH, 9);
        cal.add(Calendar.MONTH, monthcount);
        calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        year = String.valueOf(calendar.get(Calendar.YEAR));
        month_year = dateFormat.format(cal.getTime());


        ivArrowLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                left();


            }
        });

        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                left();


            }
        });
        ivArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                right();


            }
        });
        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                right();


            }
        });

        tvMonthYear.setText(setTeluguMonth(month_year) + year);


        String month = String.valueOf(calendar.get(Calendar.MONTH));
        Muhurtham(month);


    }

    @SuppressLint("ResourceType")
    private void right() {

        if (getYearNum().equals("2024") && getMonthNum().equals("04")) {


        } else {

            relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_in_right));
            Date dateFormat = null;
            try {
                dateFormat = df.parse(month_year);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            c.setTime(dateFormat);
            c.add(Calendar.MONTH, 1);
            month_year = df.format(c.getTime());
            year = String.valueOf(c.get(Calendar.YEAR));
            tvMonthYear.setText(setTeluguMonth(month_year) + year);
            String month = String.valueOf(c.get(Calendar.MONTH));
            Muhurtham(month);


        }


    }

    @SuppressLint("ResourceType")
    private void left() {


        if (getYearNum().equals("2023") && getMonthNum().equals("01")) {


        } else {

            Date dateFormat = null;
            relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_out_left));

            try {
                dateFormat = df.parse(month_year);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            c.setTime(dateFormat);
            c.add(Calendar.MONTH, -1);

            year = String.valueOf(c.get(Calendar.YEAR));
            month_year = df.format(c.getTime());
            tvMonthYear.setText(setTeluguMonth(month_year) + year);
            String month = String.valueOf(c.get(Calendar.MONTH));
            Muhurtham(month);


        }


    }

    private String setTeluguMonth(String month_year) {
        int index = month_year.indexOf(' ');
        String month = month_year.substring(0, index);
        int p = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December").indexOf(month);
        String teluguMonth = montharray[p];
        return teluguMonth;
    }

    private String getMonthNum() {
        Date newDate = null;
        try {
            newDate = df.parse("" + month_year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("MM");
        String date = format.format(newDate);
        return date;
    }


    private String getYearNum() {
        Date newDate = null;
        try {
            newDate = df.parse("" + month_year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String date = format.format(newDate);
        return date;
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void onSwipeLeft() {
        right();

    }

    public void onSwipeRight() {
        left();
    }


    private void Muhurtham(String month) {


        String Month = month;

        if (month.equals("0")){

            Month = "January";
        }

        else if (month.equals("1")){

            Month = "February";
        }

        else if (month.equals("2")){

            Month = "March";
        }

        else if (month.equals("3")){

            Month = "April";
        }

        else if (month.equals("4")){

            Month = "May";
        }

        else if (month.equals("5")){

            Month = "June";
        }

        else if (month.equals("6")){

            Month = "July";
        }

        else if (month.equals("7")){

            Month = "August";
        }

        else if (month.equals("8")){

            Month = "September";
        }

        else if (month.equals("9")){

            Month = "October";
        }

        else if (month.equals("10")){

            Month = "November";
        }

        else if (month.equals("11")){

            Month = "December";
        }


        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.MONTH,Month);
        params.put(Constant.YEAR,year);


        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){

                        recyclerView.setVisibility(View.VISIBLE);
                        Log.e("suba",response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        JSONObject jsonarray2= jsonArray.getJSONObject(0);
                        JSONArray files = jsonarray2.getJSONArray(Constant.SUBHA_MUHURTHAM_VARIANT);
                        Gson g = new Gson();
                        ArrayList<Muhurthamnew> muhurthamnews = new ArrayList<>();
                        for (int i = 0; i < files.length(); i++) {
                            JSONObject jsonObject1 = files.getJSONObject(i);
                            if (jsonObject1 != null) {
                                Log.d("Varine",jsonObject1.toString());
                                Muhurthamnew group = g.fromJson(jsonObject1.toString(), Muhurthamnew.class);
                                muhurthamnews.add(group);
                            } else {
                                break;
                            }
                        }
                        adapter = new MuhurthamnewAdapter(activity,muhurthamnews);
                        recyclerView.setAdapter(adapter);

                        tvTitle.setText(jsonArray.getJSONObject(0).getString("text1"));




                    }else {

                        recyclerView.setVisibility(View.GONE);


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.SUBHA_MUHURTHAMULU_LIST,params,true);





    }


}