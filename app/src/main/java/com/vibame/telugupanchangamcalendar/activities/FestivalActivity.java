package com.vibame.telugupanchangamcalendar.activities;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
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
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.SwipeRecyclerView;
import com.vibame.telugupanchangamcalendar.SwipeableScrollView;
import com.vibame.telugupanchangamcalendar.adapter.FestivalAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.model.Festival;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class FestivalActivity extends AppCompatActivity   implements SwipeableScrollView.SwipeListener  {
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
    RecyclerView recyclerView;
    FestivalAdapter festivalAdapter;
    String year;
    String[] montharray = {"జనవరి ", "ఫిబ్రవరి ", "మార్చి ", "ఏప్రిల్ ", "మే ", "జూన్ ", "జూలై ", "ఆగస్టు ", "సెప్టెంబర్ ", "అక్టోబర్ ", "నవంబర్ ", "డిసెంబర్ "};
    Calendar calendar;
    Calendar targetCalendar;
    RelativeLayout relativeLayout;
    private SwipeableScrollView scrollView;






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
        setContentView(R.layout.activity_festival);
        imgLeft = findViewById(R.id.arrowleft);
        imgRight = findViewById(R.id.arrowright);
        ivArrowRight = findViewById(R.id.ivArrowRight);
        ivArrowLeft = findViewById(R.id.ivArrowLeft);
        tvMonthYear = findViewById(R.id.tvMonthYear);
        recyclerView = findViewById(R.id.recyclerView);


        activity = FestivalActivity.this;

        databaseHelper = new DatabaseHelper(activity);
       // recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        recyclerView.setLayoutManager(new GridLayoutManager(activity,1));


        relativeLayout = findViewById(R.id.slider);
        scrollView = findViewById(R.id.scroll_view);
        scrollView.setSwipeListener(this);


        targetCalendar = Calendar.getInstance();
        targetCalendar.set(Calendar.YEAR, 2024);
        targetCalendar.set(Calendar.MONTH, Calendar.APRIL);
        targetCalendar.set(Calendar.DAY_OF_MONTH, 9);
        cal.add(Calendar.MONTH, monthcount);
        calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        year = String.valueOf(calendar.get(Calendar.YEAR));
        month_year = dateFormat.format(cal.getTime());
        String month = String.valueOf(calendar.get(Calendar.MONTH));





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

        tvMonthYear.setText(setTeluguMonth(month_year)+year);

        festivalList(month, getYearNum());

    }

    @SuppressLint("ResourceType")
    private void right() {

        if (getYearNum().equals("2023")&&getMonthNum().equals("12")) {



        }

        else {

            relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_in_right));
            Date dateFormat = null;
            try {
                dateFormat = df.parse(month_year);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            c.setTime(dateFormat);
            c.add(Calendar.MONTH, 1);
            String month = String.valueOf(c.get(Calendar.MONTH));
            month_year = df.format(c.getTime());
            year = String.valueOf(c.get(Calendar.YEAR));
            tvMonthYear.setText(setTeluguMonth(month_year)+year);
            festivalList(month, getYearNum());


        }


    }

    @SuppressLint("ResourceType")
    private void left() {




        if (getYearNum().equals("2023")&&getMonthNum().equals("01")) {





        }


        else {

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
            String month = String.valueOf(c.get(Calendar.MONTH));
            tvMonthYear.setText(setTeluguMonth(month_year)+year);
            festivalList(month, getYearNum());





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


    private void festivalList(String monthNum, String yearNum) {


        String Month = monthNum;

        if (monthNum.equals("0")){

            Month = "January";
        }

        else if (monthNum.equals("1")){

            Month = "February";
        }

        else if (monthNum.equals("2")){

            Month = "March";
        }

        else if (monthNum.equals("3")){

            Month = "April";
        }

        else if (monthNum.equals("4")){

            Month = "May";
        }

        else if (monthNum.equals("5")){

            Month = "June";
        }

        else if (monthNum.equals("6")){

            Month = "July";
        }

        else if (monthNum.equals("7")){

            Month = "August";
        }

        else if (monthNum.equals("8")){

            Month = "September";
        }

        else if (monthNum.equals("9")){

            Month = "October";
        }

        else if (monthNum.equals("10")){

            Month = "November";
        }

        else if (monthNum.equals("11")){

            Month = "December";
        }


        










        HashMap<String,String> params = new HashMap<>();
        params.put(Constant.MONTH,Month);
        params.put(Constant.YEAR,yearNum);
        ApiConfig.RequestToVolley((result, response) -> {
            if(result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getBoolean(SUCCESS)){
                        Log.d("Festivallise",response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();


                        recyclerView.setVisibility(View.VISIBLE);
                        ArrayList<Festival> festivals = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            if (jsonObject1 != null) {
                                Festival group = g.fromJson(jsonObject1.toString(), Festival.class);
                                festivals.add(group);
                            } else {
                                break;
                            }
                        }

                        festivalAdapter = new FestivalAdapter(FestivalActivity.this,festivals);
                        recyclerView.setAdapter(festivalAdapter);


                    }else {

                        recyclerView.setVisibility(View.GONE);

                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },activity, Constant.MONTH_FESTIVAL,params,true);




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





}