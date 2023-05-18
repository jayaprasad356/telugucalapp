package com.vibame.telugupanchangamcalendar;

import static com.vibame.telugupanchangamcalendar.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vibame.telugupanchangamcalendar.activities.CalendarNewActivity;
import com.vibame.telugupanchangamcalendar.activities.PanchangamActivity;
import com.vibame.telugupanchangamcalendar.helper.ApiConfig;
import com.vibame.telugupanchangamcalendar.helper.Constant;
import com.vibame.telugupanchangamcalendar.helper.Session;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class DailyActivity extends AppCompatActivity implements SwipeableScrollView.SwipeListener{


    TextView tvDate, tvDate1, tvtext1, tvtext2, tvtext3, tvtext4, tvtext5, tvtext6, tvSunrise, tvSunset, tvMoonRise, tvMoonset, tvFestival;
    TextView tvThithi, TVNakshathram, tvYogam, tvKaranam, tvAbhijithMuhurtham, tvBhramaMuhurtham, tvAmruthaKalam, tvRahukalam, tvYamagandam, tvDhurmuhurtham, tvVarjyam, tvGulika;
    TextView tvhc1, tvhc2, tvhc3, tvhc4, tvhc5, tvhc6, tvhc7, tvhc8, tvhc9, tvhc10, tvhc11, tvhc12;
    CardView arrowright, arrowleft, cal_card;
    ImageButton ivArrowRight, ivArrowLeft;
    Activity activity;
    Session session;
    Calendar calendar;
    Calendar targetCalendar, startCalendar;
    String dateString;
    Date clickedDate = null;
    String currentMonth;
    String[] monthNames;
    int monthIndex;

    private RelativeLayout relativeLayout;
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
        setContentView(R.layout.activity_daily);

        activity = this;
        session = new Session(activity);
        tvDate = findViewById(R.id.tvDate);
        tvDate1 = findViewById(R.id.tvDate1);
        arrowright = findViewById(R.id.arrowright);
        arrowleft = findViewById(R.id.arrowleft);
        ivArrowRight = findViewById(R.id.ivArrowRight);
        ivArrowLeft = findViewById(R.id.ivArrowLeft);
        relativeLayout = findViewById(R.id.slider);
        tvtext1 = findViewById(R.id.tvtext1);
        tvtext2 = findViewById(R.id.tvtext2);
        tvtext3 = findViewById(R.id.tvtext3);
        tvtext4 = findViewById(R.id.tvtext4);
        tvtext5 = findViewById(R.id.tvtext5);
        tvtext6 = findViewById(R.id.tvtext6);
        tvSunrise = findViewById(R.id.tvSunrise);
        tvSunset = findViewById(R.id.tvSunset);
        tvMoonRise = findViewById(R.id.tvMoonrise);
        tvMoonset = findViewById(R.id.tvMoonset);
        tvFestival = findViewById(R.id.tvFestival);
        tvThithi = findViewById(R.id.tvTithi);
        TVNakshathram = findViewById(R.id.tvNakshatra);
        tvYogam = findViewById(R.id.tvYoga);
        tvKaranam = findViewById(R.id.tvKarana);
        tvAbhijithMuhurtham = findViewById(R.id.tvAbhijitMuhurta);
        tvBhramaMuhurtham = findViewById(R.id.tvBrahmamuhurta);
        tvAmruthaKalam = findViewById(R.id.tvAmritakalam);
        tvRahukalam = findViewById(R.id.tvRahukalam);
        tvYamagandam = findViewById(R.id.tvYamagandam);
        tvDhurmuhurtham = findViewById(R.id.tvDurMuhurtham);
        tvVarjyam = findViewById(R.id.tvVarjyam);
        tvGulika = findViewById(R.id.tvGulikaKalam);
        tvhc1 = findViewById(R.id.tvhc1);
        tvhc2 = findViewById(R.id.tvhc2);
        tvhc3 = findViewById(R.id.tvhc3);
        tvhc4 = findViewById(R.id.tvhc4);
        tvhc5 = findViewById(R.id.tvhc5);
        tvhc6 = findViewById(R.id.tvhc6);
        tvhc7 = findViewById(R.id.tvhc7);
        tvhc8 = findViewById(R.id.tvhc8);
        tvhc9 = findViewById(R.id.tvhc9);
        tvhc10 = findViewById(R.id.tvhc10);
        tvhc11 = findViewById(R.id.tvhc11);
        tvhc12 = findViewById(R.id.tvhc12);
        cal_card = findViewById(R.id.cal_card);




        scrollView = findViewById(R.id.scroll_view);
        scrollView.setSwipeListener(this);




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



        cal_card.setOnClickListener(v -> {
            Intent intent = new Intent(activity, MontlyActivity.class);
            intent.putExtra("year",year);
            intent.putExtra("month",monthIndex);


            startActivity(intent);
        });


        arrowright.setOnClickListener(v -> {

            forward();

        });
        arrowleft.setOnClickListener(v -> {

            backward();


        });
        ivArrowLeft.setOnClickListener(v -> {
            backward();
        });
        ivArrowRight.setOnClickListener(v -> {
            forward();
        });


    }

    private void panchangamlist(String date) {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constant.DATE, date);
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        Log.d("panchangamlist", response);
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        Gson g = new Gson();

                        tvtext1.setText(jsonArray.getJSONObject(0).getString("text1"));
                        tvtext2.setText(jsonArray.getJSONObject(0).getString("text2"));
                        tvtext3.setText(jsonArray.getJSONObject(0).getString("text3"));
                        tvtext4.setText(jsonArray.getJSONObject(0).getString("text4"));
                        tvtext5.setText(jsonArray.getJSONObject(0).getString("text5"));
                        tvtext6.setText(jsonArray.getJSONObject(0).getString("text6"));
                        tvSunrise.setText(jsonArray.getJSONObject(0).getString("sunrise"));
                        tvSunset.setText(jsonArray.getJSONObject(0).getString("sunset"));
                        tvMoonRise.setText(jsonArray.getJSONObject(0).getString("moonrise"));
                        tvMoonset.setText(jsonArray.getJSONObject(0).getString("moonset"));
                        tvFestival.setText(jsonArray.getJSONObject(0).getString("festivals"));
                        tvThithi.setText(jsonArray.getJSONObject(0).getString("thidhi"));
                        TVNakshathram.setText(jsonArray.getJSONObject(0).getString("nakshatram"));
                        tvYogam.setText(jsonArray.getJSONObject(0).getString("yogam"));
                        tvKaranam.setText(jsonArray.getJSONObject(0).getString("karanam"));
                        tvAbhijithMuhurtham.setText(jsonArray.getJSONObject(0).getString("abhijith_muhurtham"));
                        tvBhramaMuhurtham.setText(jsonArray.getJSONObject(0).getString("bhrama_muhurtham"));
                        tvAmruthaKalam.setText(jsonArray.getJSONObject(0).getString("amrutha_kalam"));
                        tvRahukalam.setText(jsonArray.getJSONObject(0).getString("rahukalam"));
                        tvYamagandam.setText(jsonArray.getJSONObject(0).getString("yamakandam"));
                        tvDhurmuhurtham.setText(jsonArray.getJSONObject(0).getString("dhurmuhurtham"));
                        tvVarjyam.setText(jsonArray.getJSONObject(0).getString("varjyam"));
                        tvGulika.setText(jsonArray.getJSONObject(0).getString("gulika"));
                        tvhc1.setText(jsonArray.getJSONObject(0).getString("hc1"));
                        tvhc2.setText(jsonArray.getJSONObject(0).getString("hc2"));
                        tvhc3.setText(jsonArray.getJSONObject(0).getString("hc3"));
                        tvhc4.setText(jsonArray.getJSONObject(0).getString("hc4"));
                        tvhc5.setText(jsonArray.getJSONObject(0).getString("hc5"));
                        tvhc6.setText(jsonArray.getJSONObject(0).getString("hc6"));
                        tvhc7.setText(jsonArray.getJSONObject(0).getString("hc7"));
                        tvhc8.setText(jsonArray.getJSONObject(0).getString("hc8"));
                        tvhc9.setText(jsonArray.getJSONObject(0).getString("hc9"));
                        tvhc10.setText(jsonArray.getJSONObject(0).getString("hc10"));
                        tvhc11.setText(jsonArray.getJSONObject(0).getString("hc11"));
                        tvhc12.setText(jsonArray.getJSONObject(0).getString("hc12"));
                    } else {
                        tvtext1.setText("");
                        tvtext2.setText("");
                        tvtext3.setText("");
                        tvtext4.setText("");
                        tvtext5.setText("");
                        tvtext6.setText("");
                        tvSunrise.setText("");
                        tvSunset.setText("");
                        tvMoonRise.setText("");
                        tvMoonset.setText("");
                        tvFestival.setText("");
                        tvThithi.setText("");
                        TVNakshathram.setText("");
                        tvYogam.setText("");
                        tvKaranam.setText("");
                        tvAbhijithMuhurtham.setText("");
                        tvBhramaMuhurtham.setText("");
                        tvAmruthaKalam.setText("");
                        tvRahukalam.setText("");
                        tvYamagandam.setText("");
                        tvDhurmuhurtham.setText("");
                        tvVarjyam.setText("");
                        tvGulika.setText("");
                        tvhc1.setText("");
                        tvhc2.setText("");
                        tvhc3.setText("");
                        tvhc4.setText("");
                        tvhc5.setText("");
                        tvhc6.setText("");
                        tvhc7.setText("");
                        tvhc8.setText("");
                        tvhc9.setText("");
                        tvhc10.setText("");
                        tvhc11.setText("");
                        tvhc12.setText("");


                        Toast.makeText(activity, jsonObject.getString(Constant.MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.PANCHANGAMLIST_BYDATE, params, true);


    }

    @SuppressLint("ResourceType")
    private void backward() {


        if (calendar.after(startCalendar)) {

            relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_out_left));


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
            relativeLayout.startAnimation(AnimationUtils.loadAnimation(activity, R.xml.slide_in_right));
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


    private void updateUI(Date date) {



        // Format the date as a string
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        dateString = dateFormat.format(date);



        // Update your UI elements with the new date
        // For example, if you have a TextView to display the date:
        tvDate.setText(dateString.toString());
        tvDate1.setText(dateString.toString());

        String Date = dateFormat.format(date);
        panchangamlist(Date);

        arrowleft.setEnabled(true);
        ivArrowLeft.setEnabled(true);

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


    @Override
    public void onBackPressed() {
        // Add your desired behavior here

        Intent intent = new Intent(DailyActivity.this, CalendarNewActivity.class);
        startActivity(intent);

    }

}


