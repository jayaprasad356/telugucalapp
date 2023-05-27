package com.vibame.telugupanchangamcalendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vibame.telugupanchangamcalendar.adapter.Slider.Dailypanchangam1Adapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.DailyModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Dailypanchangam2Activity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Activity activity;
    private Dailypanchangam1Adapter mAdapter;
    Session session;
    Calendar calendar;
    Calendar targetCalendar,startCalendar;
    String dateString;
    String currentMonth;
    String[] monthNames;
    int monthIndex;
    Date clickedDate = null;
    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailypanchangam1);

        activity = Dailypanchangam2Activity.this;

        mViewPager = findViewById(R.id.viewPager);



        String date = getIntent().getStringExtra("clickedDate");


// Convert the date string to a Date object
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        try {
            clickedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar = Calendar.getInstance();
        calendar.setTime(clickedDate);

        updateUI(clickedDate);


        targetCalendar = Calendar.getInstance();
        targetCalendar.set(Calendar.YEAR, 2024);
        targetCalendar.set(Calendar.MONTH, Calendar.APRIL);
        targetCalendar.set(Calendar.DAY_OF_MONTH, 9);



        int year = calendar.get(Calendar.YEAR);
        monthIndex = calendar.get(Calendar.MONTH);
        monthNames = new DateFormatSymbols().getMonths();
        currentMonth = monthNames[monthIndex];


        startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.MONTH,Calendar.MARCH);
        startCalendar.set(Calendar.YEAR, 2023);
        startCalendar.set(Calendar.DAY_OF_MONTH , 22);





        // Add a ViewPager.OnPageChangeListener to handle left and right slide events
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int previousPosition = 0;
            private boolean isSlideHandled = false;
            private boolean isInitialOpen = true;

            @Override
            public void onPageSelected(int position) {
                if (isInitialOpen) {
                    isInitialOpen = false;
                    previousPosition = position;
                    return;
                }

                if (!isSlideHandled) {
                    if (position > previousPosition) {
                        // Forward slide (next day)
                        forward();
                    } else {
                        // Backward slide (previous day)
                        backward();
                    }

                    isSlideHandled = true;
                } else {
                    isSlideHandled = false;
                }

                previousPosition = position;
            }


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Not needed for this implementation
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Not needed for this implementation
            }
        });

    }

    private void updateUI(Date date) {
        // Format the date as a string
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        dateString = dateFormat.format(date);

        // Update your UI elements with the new date
        // For example, if you have a TextView to display the date:
//        tvDate.setText(dateString.toString());
//        tvDate1.setText(dateString.toString());

        String Date = dateFormat.format(date);
        panchangamlist(Date);

//        arrowleft.setEnabled(true);
//        ivArrowLeft.setEnabled(true);

    }

    @SuppressLint("ResourceType")
    private void backward() {


        if (calendar.after(startCalendar)) {



            int year = calendar.get(Calendar.YEAR);
            monthIndex = calendar.get(Calendar.MONTH);
            monthNames = new DateFormatSymbols().getMonths();
            currentMonth = monthNames[monthIndex];
            // move the calendar one day back the date

            calendar.add(Calendar.DAY_OF_YEAR, -1);

            updateUI(calendar.getTime());

        }


//
//            arrowleft.setEnabled(false);
//            ivArrowLeft.setEnabled(false);


    }

    @SuppressLint("ResourceType")
    private void forward() {


        if (calendar.before(targetCalendar)) {

            // Move the calendar one day forward
            calendar.add(Calendar.DAY_OF_YEAR, 1);

            int year = calendar.get(Calendar.YEAR);
            monthIndex = calendar.get(Calendar.MONTH);
            monthNames = new DateFormatSymbols().getMonths();
            currentMonth = monthNames[monthIndex];
            // Update your UI with the new date
            updateUI(calendar.getTime());




        }
    }



    private void panchangamlist(String date) {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.DATE, date);
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(Constant.SUCCESS)) {
                        Log.d("panchangamlist", response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson gson = new Gson();

                        // Parse JSON array into ArrayList of SlideModel
                        ArrayList<DailyModel> slideList = gson.fromJson(jsonArray.toString(), new TypeToken<ArrayList<DailyModel>>() {}.getType());

                        // Create SliderPagerAdapter instance and pass the slideList
                        mAdapter = new Dailypanchangam1Adapter(this, slideList);

                        // Set the adapter to your ViewPager
                        mViewPager.setAdapter(mAdapter);

                        // Set the current position to 400
                        int currentPosition = 400;
                        mViewPager.setCurrentItem(currentPosition, false);
                    } else {
                        Toast.makeText(this, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, this, Constant.PANCHANGAMLIST_BYDATE, params, true);
    }

    public void previousDay() {
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);

    }

    public void nextDay() {

        mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
    }

    public void showCalendar() {

        Intent intent = new Intent(activity, MontlyActivity.class);
        intent.putExtra("year",year);
        intent.putExtra("month",monthIndex);
        startActivity(intent);

    }
}
