package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.adapter.GowriAdapter;
import com.vibame.telugupanchangamcalendar.adapter.HolidaysAdapter;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;
import com.vibame.telugupanchangamcalendar.helper.Session;
import com.vibame.telugupanchangamcalendar.model.Gowri;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class GowriPanchangamActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity;
    GowriAdapter gowriAdapter;
    ImageButton ibPrevious, ibNext;
    TextView tvMonday, tvTuesday, tvWednesday, tvThursday, tvFriday, tvSaturday, tvSunday, tvYear;
    int Year = 2022;
    ImageView imgBack;
    Calendar calendar;
    String dateString;
    String dayOfWeekString = "";
    String dayName = "";
    int currentDay, clickedDay;
    DatabaseHelper databaseHelper;
    String Day;
    Session session;
    private HorizontalScrollView scrollview;


    private RelativeLayout relativeLayout;
    private SwipeableScrollView scrollView;

    private final GestureDetector gestureDetector = new GestureDetector(activity, new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (Math.abs(velocityX) > Math.abs(velocityY)) {
                if (e1.getX() < e2.getX()) {
                    // Swipe right
                    if (!dayOfWeekString.equals("Sunday"))
                        onSwipeRight();
                } else {
                    if (!dayOfWeekString.equals("Saturday"))
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
        setContentView(R.layout.activity_gowri_panchangam);

        activity = GowriPanchangamActivity.this;

        databaseHelper = new DatabaseHelper(activity);
        session=new Session(activity);



        // get the current date

        scrollview =  findViewById(R.id.scrollview);




        recyclerView = findViewById(R.id.recyclerView);
        tvYear = findViewById(R.id.tvYear);
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
        relativeLayout = findViewById(R.id.slider);


        // Get the current day of the week
        calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String dateString = dateFormat.format(date);
        SimpleDateFormat dayformat = new SimpleDateFormat("EEEE", Locale.getDefault());
        dayName = dayformat.format(date);

        tvMonday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedDay = 1;
                unselecctallday();
                tvMonday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Monday");


            }
        });
        tvTuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedDay = 2;
                unselecctallday();
                tvTuesday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Tuesday");


            }
        });
        tvWednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedDay = 3;
                unselecctallday();
                tvWednesday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Wednesday");

            }
        });
        tvThursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedDay = 4;
                unselecctallday();
                tvThursday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Thursday");

            }
        });
        tvFriday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedDay = 5;
                unselecctallday();
                tvFriday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Friday");
            }
        });

        tvSaturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedDay = 6;
                unselecctallday();
                tvSaturday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Saturday");

            }
        });
        tvSunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedDay = 7;
                unselecctallday();
                tvSunday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Sunday");


            }
        });


        // Map the day of the week to a string

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
                scrollRight();
                break;
            case Calendar.FRIDAY:
                dayOfWeekString = "Friday";
                unselecctallday();
                tvFriday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Friday");
                scrollRight();
                break;
            case Calendar.SATURDAY:
                dayOfWeekString = "Saturday";
                unselecctallday();
                tvSaturday.setTextColor(ContextCompat.getColor(activity, R.color.calHeaderT));
                list("Saturday");
                scrollRight();
                break;
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);

        Gowrilist();

    }


    private void unselecctallday() {
        tvMonday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvTuesday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvWednesday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvThursday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvFriday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvSaturday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));
        tvSunday.setTextColor(ContextCompat.getColor(activity, R.color.colorBlack));

    }

    private void Gowrilist() {
        HashMap<String, String> params = new HashMap<>();
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray3 = jsonObject.getJSONArray(Constant.DATA);

                        for (int i = 0; i < jsonArray3.length(); i++) {
                            JSONObject jsonObject1 = jsonArray3.getJSONObject(i);
                            if (jsonObject1 != null) {
//                                databaseHelper.AddToHolidays(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.MONTH),jsonObject1.getString(Constant.YEAR),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.DESCRIPTION));
                                databaseHelper.AddToGowri(jsonObject1.getString(Constant.ID), jsonObject1.getString(Constant.DAY), jsonObject1.getString(Constant.TIME), jsonObject1.getString(Constant.MORNING), jsonObject1.getString(Constant.NIGHT));


                                gowriAdapter = new GowriAdapter(GowriPanchangamActivity.this, databaseHelper.getGowriList(Day));
                                recyclerView.setAdapter(gowriAdapter);
                                session.setBoolean(Constant.GOWRI_DATA,true);

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
        }, activity, Constant.GOWRI_LIST, params, true);

//       if(session.getBoolean(Constant.GOWRI_DATA)){
//           gowriAdapter = new GowriAdapter(GowriPanchangamActivity.this, databaseHelper.getGowriList(Day));
//           recyclerView.setAdapter(gowriAdapter);
//       }else {
//
//        HashMap<String, String> params = new HashMap<>();
//        ApiConfig.RequestToVolley((result, response) -> {
//            if (result) {
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    if (jsonObject.getBoolean(SUCCESS)) {
//                        JSONArray jsonArray3 = jsonObject.getJSONArray(Constant.DATA);
//
//                        for (int i = 0; i < jsonArray3.length(); i++) {
//                            JSONObject jsonObject1 = jsonArray3.getJSONObject(i);
//                            if (jsonObject1 != null) {
////                                databaseHelper.AddToHolidays(jsonObject1.getString(Constant.ID),jsonObject1.getString(Constant.MONTH),jsonObject1.getString(Constant.YEAR),jsonObject1.getString(Constant.TITLE),jsonObject1.getString(Constant.DESCRIPTION));
//                                databaseHelper.AddToGowri(jsonObject1.getString(Constant.ID), jsonObject1.getString(Constant.DAY), jsonObject1.getString(Constant.TIME), jsonObject1.getString(Constant.MORNING), jsonObject1.getString(Constant.NIGHT));
//
//
//                                gowriAdapter = new GowriAdapter(GowriPanchangamActivity.this, databaseHelper.getGowriList(Day));
//                                recyclerView.setAdapter(gowriAdapter);
//                                session.setBoolean(Constant.GOWRI_DATA,true);
//
//                            } else {
//                                break;
//                            }
//                        }
//
//
//                    } else {
//
//
//                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }, activity, Constant.GOWRI_LIST, params, true);

//    }

}
    private void list(String day) {

         Day = day;

//        HashMap<String, String> params = new HashMap<>();
//        params.put(Constant.GOWRI, "1");
//        params.put(Constant.DAY, day);
//        ApiConfig.RequestToVolley((result, response) -> {
//            Log.d("GOWRI_PAN", response);
//            if (result) {
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    if (jsonObject.getBoolean(SUCCESS)) {
//                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
//                        Gson g = new Gson();
//                        ArrayList<Gowri> gowris = new ArrayList<>();
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                            if (jsonObject1 != null) {
//                                recyclerView.setVisibility(View.VISIBLE);
//                                Gowri group = g.fromJson(jsonObject1.toString(), Gowri.class);
//                                gowris.add(group);
//                            }
//
//                            else {
//
//                                Toast.makeText(activity, "No data found", Toast.LENGTH_SHORT).show();
//                            }
//
//                        }
//                        gowriAdapter = new GowriAdapter(activity, gowris);
//                        recyclerView.setAdapter(gowriAdapter);
//                    } else {
//
//                        recyclerView.setVisibility(View.GONE);
//                       Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }, activity, Constant.PANCHANGAM_LIST_URL, params, true);
//
//
//
//        gowriAdapter = new GowriAdapter(activity, gowris);
//        recyclerView.setAdapter(gowriAdapter);


        gowriAdapter = new GowriAdapter(GowriPanchangamActivity.this,databaseHelper.getGowriList(day));
        recyclerView.setAdapter(gowriAdapter);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void onSwipeLeft() {
        // Handle swipe left

        forward();
    }

    public void onSwipeRight() {
        // Handle swipe right
        backward();
    }


    @SuppressLint("ResourceType")
    private void backward() {


        calendar.add(Calendar.DAY_OF_YEAR, -1);
        relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_out_left));
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
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
        updateUI(calendar.getTime());


    }

    @SuppressLint("ResourceType")
    private void forward() {


        relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_in_right));
        // Move the calendar one day forward
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
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
        // Update your UI with the new date
        updateUI(calendar.getTime());


    }


    private void updateUI(Date date) {
        // Format the date as a string
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        dateString = dateFormat.format(date);

        // Update your UI elements with the new date
        // For example, if you have a TextView to display the date:
        String Date = dateFormat.format(date);
        list(Date);


    }

    private void scrollRight() {
        // Scroll the HorizontalScrollView to the right
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
            }
        });
    }


}