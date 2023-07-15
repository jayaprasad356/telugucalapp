package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vibame.telugupanchangamcalendar.adapter.Slider.Dailypanchangam1Adapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.DailyModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Dailypanchangam1Activity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Activity activity;
    private Dailypanchangam1Adapter mAdapter;
    Session session;
    Calendar calendar;
    Calendar targetCalendar, startCalendar;
    String dateString;
    String currentMonth;
    String[] monthNames;
    int monthIndex;
    int year;
    String Date;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailypanchangam1);

        activity = Dailypanchangam1Activity.this;
        session = new Session(activity);

        databaseHelper = new DatabaseHelper(activity);

        dailyPanchangam(Date);

        mViewPager = findViewById(R.id.viewPager);


        targetCalendar = Calendar.getInstance();
        targetCalendar.set(Calendar.YEAR, 2024);
        targetCalendar.set(Calendar.MONTH, Calendar.APRIL);
        targetCalendar.set(Calendar.DAY_OF_MONTH, 9);
        calendar = Calendar.getInstance();
        updateUI(calendar.getTime());

        year = calendar.get(Calendar.YEAR);
        monthIndex = calendar.get(Calendar.MONTH);
        monthNames = new DateFormatSymbols().getMonths();
        currentMonth = monthNames[monthIndex];


        startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.MONTH, Calendar.MARCH);
        startCalendar.set(Calendar.YEAR, 2023);
        startCalendar.set(Calendar.DAY_OF_MONTH, 22);

        //panchangam_list();



//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            private int currentPosition = 400;
//
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                // Not needed for left/right slide detection
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                if (position > currentPosition) {
//
//                    // Move the calendar one day forward
//                    calendar.add(Calendar.DAY_OF_YEAR, 1);
//                    int year = calendar.get(Calendar.YEAR);
//                    monthIndex = calendar.get(Calendar.MONTH);
//                    monthNames = new DateFormatSymbols().getMonths();
//                    currentMonth = monthNames[monthIndex];
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//                    dateString = dateFormat.format(calendar.getTime());
//                    String  Date = dateFormat.format(calendar.getTime());
//                    panchangamlist(Date);
//                    mViewPager.setCurrentItem(currentPosition, false);
//
//
//                    // User swiped from left to right (right slide)
//                    // Perform actions for right slide
//                } else if (position < currentPosition) {
//
//
//                    mViewPager.setCurrentItem(currentPosition, false);
//                    int year = calendar.get(Calendar.YEAR);
//                    monthIndex = calendar.get(Calendar.MONTH);
//                    monthNames = new DateFormatSymbols().getMonths();
//                    currentMonth = monthNames[monthIndex];
//                    // move the calendar one day back the date
//                    calendar.add(Calendar.DAY_OF_YEAR, -1);
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//                    dateString = dateFormat.format(calendar.getTime());
//                    String  Date = dateFormat.format(calendar.getTime());
//                    panchangamlist(Date);
//
//
//
//                    // User swiped from right to left (left slide)
//                    // Perform actions for left slide
//                }
//
//                currentPosition = position;
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                // Not needed for left/right slide detection
//            }
//        });







//
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            private int previousPosition = 0;
//            private boolean isSlideHandled = false;
//            private boolean isInitialOpen = true;
//
//            @Override
//            public void onPageSelected(int position) {
//                if (isInitialOpen) {
//                    isInitialOpen = false;
//                    previousPosition = position;
//                    return;
//                }
//
//                if (!isSlideHandled) {
//                    if (position > previousPosition) {
//                        // Forward slide (next day)
//                        forward();
//                    } else {
//                        // Backward slide (previous day)
//                        backward();
//                    }
//
//                    isSlideHandled = true;
//                } else {
//                    isSlideHandled = false;
//                }
//
//                previousPosition = position;
//            }
//
//
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                // Not needed for this implementation
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                // Not needed for this implementation
//            }
//        });

    }

    private void panchangam_list() {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.ALL, "1");
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                databaseHelper.AddToPanchangam(
                                        jsonObject1.getString(Constant.ID),
                                        jsonObject1.getString(Constant.DATE),
                                        jsonObject1.getString(Constant.SUNRISE),
                                        jsonObject1.getString(Constant.SUNSET),
                                        jsonObject1.getString(Constant.MOONRISE),
                                        jsonObject1.getString(Constant.MOONSET),
                                        jsonObject1.getString(Constant.TEXT1),
                                        jsonObject1.getString(Constant.TEXT2),
                                        jsonObject1.getString(Constant.TEXT3),
                                        jsonObject1.getString(Constant.TEXT4),
                                        jsonObject1.getString(Constant.TEXT5),
                                        jsonObject1.getString(Constant.TEXT6),
                                        jsonObject1.getString(Constant.FESTIVALS),
                                        jsonObject1.getString(Constant.THIDHI),
                                        jsonObject1.getString(Constant.NAKSHATRAM),
                                        jsonObject1.getString(Constant.YOGAM),
                                        jsonObject1.getString(Constant.KARANAM),
                                        jsonObject1.getString(Constant.ABHIJITH_MUHURTHAM),
                                        jsonObject1.getString(Constant.BHRAMA_MUHURTHAM),
                                        jsonObject1.getString(Constant.AMRUTHA_KALAM),
                                        jsonObject1.getString(Constant.RAHUKALAM),
                                        jsonObject1.getString(Constant.YAMAKANDAM),
                                        jsonObject1.getString(Constant.DHURMUHURTHAM),
                                        jsonObject1.getString(Constant.VARJYAM),
                                        jsonObject1.getString(Constant.GULIKA),
                                        jsonObject1.getString(Constant.HC1),
                                        jsonObject1.getString(Constant.HC2),
                                        jsonObject1.getString(Constant.HC3),
                                        jsonObject1.getString(Constant.HC4),
                                        jsonObject1.getString(Constant.HC5),
                                        jsonObject1.getString(Constant.HC6),
                                        jsonObject1.getString(Constant.HC7),
                                        jsonObject1.getString(Constant.HC8),
                                        jsonObject1.getString(Constant.HC9),
                                        jsonObject1.getString(Constant.HC10),
                                        jsonObject1.getString(Constant.HC11),
                                        jsonObject1.getString(Constant.HC12)
                                );


                            } else {
                                break;
                            }
                        }

                    } else {
                        Toast.makeText(this, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, this, Constant.PANCHANGAM_LIST, params, true);
    }

    private void updateUI(Date date) {
        // Format the date as a string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        dateString = dateFormat.format(date);

        // Update your UI elements with the new date
        // For example, if you have a TextView to display the date:
//        tvDate.setText(dateString.toString());
//        tvDate1.setText(dateString.toString());

       String  Date = dateFormat.format(date);
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




        mAdapter = new Dailypanchangam1Adapter(this, databaseHelper.getDailyPanchangam(date));
        mViewPager.setAdapter(mAdapter);
        int currentPosition = 400;
                       mViewPager.setCurrentItem(currentPosition, false);


//        HashMap<String, String> params = new HashMap<>();
//        params.put(Constant.DATE, date);
//        ApiConfig.RequestToVolley((result, response) -> {
//            if (result) {
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    if (jsonObject.getBoolean(SUCCESS)) {
//                        Log.d("panchangamlist", response);
//                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
//                        Gson gson = new Gson();
//
//                        // Parse JSON array into ArrayList of SlideModel
//                        ArrayList<DailyModel> slideList = gson.fromJson(jsonArray.toString(), new TypeToken<ArrayList<DailyModel>>() {
//                        }.getType());
//
//                        // Create SliderPagerAdapter instance and pass the slideList
////                        mAdapter = new Dailypanchangam1Adapter(this, slideList);
////
////                        // Set the adapter to your ViewPager
////                        mViewPager.setAdapter(mAdapter);
////
////                        // Set the current position to 400
////                        int currentPosition = 400;
////                        mViewPager.setCurrentItem(currentPosition, false);
//                    } else {
//                        Toast.makeText(this, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }, this, Constant.PANCHANGAMLIST_BYDATE, params, true);
    }

    public void previousDay() {
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
        backward();

    }

    public void nextDay() {
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
        forward();
    }

    public void showCalendar() {

        Intent intent = new Intent(activity, MontlyActivity.class);
        intent.putExtra("year", year);
        intent.putExtra("month", monthIndex);
        startActivity(intent);

    }


    private void dailyPanchangam(String Date) {
        HashMap<String, String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        Log.d("", response);
                        JSONArray jsonArray3 = jsonObject.getJSONArray(Constant.DATA);

                        for (int i = 0; i < jsonArray3.length(); i++) {
                            JSONObject jsonObject1 = jsonArray3.getJSONObject(i);
                            if (jsonObject1 != null) {
//                                databaseHelper.AddToDailyPanchangam(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.MONTH),jsonObject1.getString(Constant.YEAR),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.DESCRIPTION));

                                databaseHelper.AddToDailyPanchangam(
                                        jsonObject1.getString(Constant.ID),
                                        jsonObject1.getString(Constant.DATE),
                                        jsonObject1.getString(Constant.TEXT1),
                                        jsonObject1.getString(Constant.TEXT2),
                                        jsonObject1.getString(Constant.TEXT3),
                                        jsonObject1.getString(Constant.TEXT4),
                                        jsonObject1.getString(Constant.TEXT5),
                                        jsonObject1.getString(Constant.TEXT6),
                                        jsonObject1.getString(Constant.SUNRISE),
                                        jsonObject1.getString(Constant.SUNSET),
                                        jsonObject1.getString(Constant.MOONRISE),
                                        jsonObject1.getString(Constant.MOONSET),
                                        jsonObject1.getString(Constant.FESTIVALS),
                                        jsonObject1.getString(Constant.THIDHI),
                                        jsonObject1.getString(Constant.NAKSHATRAM),
                                        jsonObject1.getString(Constant.YOGAM),
                                        jsonObject1.getString(Constant.KARANAM),
                                        jsonObject1.getString(Constant.ABHIJITH_MUHURTHAM),
                                        jsonObject1.getString(Constant.BHRAMA_MUHURTHAM),
                                        jsonObject1.getString(Constant.AMRUTHA_KALAM),
                                        jsonObject1.getString(Constant.RAHUKALAM),
                                        jsonObject1.getString(Constant.YAMAKANDAM),
                                        jsonObject1.getString(Constant.DHURMUHURTHAM),
                                        jsonObject1.getString(Constant.VARJYAM),
                                        jsonObject1.getString(Constant.GULIKA),
                                        jsonObject1.getString(Constant.HC1),
                                        jsonObject1.getString(Constant.HC2),
                                        jsonObject1.getString(Constant.HC3),
                                        jsonObject1.getString(Constant.HC4),
                                        jsonObject1.getString(Constant.HC5),
                                        jsonObject1.getString(Constant.HC6),
                                        jsonObject1.getString(Constant.HC7),
                                        jsonObject1.getString(Constant.HC8),
                                        jsonObject1.getString(Constant.HC9),
                                        jsonObject1.getString(Constant.HC10),
                                        jsonObject1.getString(Constant.HC11),
                                        jsonObject1.getString(Constant.HC12)
                                );

//                                Toast.makeText(activity, "Daily Panchangam Added Successfully", Toast.LENGTH_SHORT).show();
//                                panchangamlist(Date);
//
//
//                                databaseHelper.getDailyPanchangam().size();
//                                Log.d("dailyPanchangamList", String.valueOf(databaseHelper.getDailyPanchangam().size()));
                             //   tvTitle.setText(databaseHelper.getsubha_muhurtham(Month,year).get(0).getText1());


//                              Toast.makeText(activity, ""+Date, Toast.LENGTH_SHORT).show();
//


//                                festivalAdapter = new FestivalAdapter(FestivalActivity.this,databaseHelper.getmonthFestivalList(date));
//                                recyclerView.setAdapter(festivalAdapter);

                            } else {
                                break;
                            }
                        }


                    } else {


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.DAILY_PANCHANGAM_LIST, params, true);

    }

}
