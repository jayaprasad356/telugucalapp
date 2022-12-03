package com.vibame.telugupanchangamcalendar.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.adapter.FestivalAdapter;
import com.vibame.telugupanchangamcalendar.adapter.PanchangamTabAdapter;
import com.vibame.telugupanchangamcalendar.helper.DatabaseHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class FestivalFragment extends Fragment {
    View root;
    ImageView imgLeft,imgRight;
    TextView tvMonthYear;
    String month_year;
    int monthcount = 0;
    Calendar cal=Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
    Calendar c = Calendar.getInstance();
    DatabaseHelper databaseHelper;
    Activity activity;
    RecyclerView recyclerView;
    FestivalAdapter festivalAdapter;
    String MonthYear = "";
    String[] montharray = {"జనవరి", "ఫిబ్రవరి", "మార్చి", "ఏప్రిల్", "మే", "జూన్", "జూలై", "ఆగస్టు", "సెప్టెంబర్", "అక్టోబర్", "నవంబర్", "డిసెంబర్"};


    public FestivalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_festival, container, false);
        imgLeft = root.findViewById(R.id.imgLeft);
        imgRight = root.findViewById(R.id.imgRight);
        tvMonthYear = root.findViewById(R.id.tvMonthYear);
        recyclerView = root.findViewById(R.id.recyclerView);


        activity = getActivity();

        databaseHelper = new DatabaseHelper(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));



        cal.add(Calendar.MONTH, monthcount);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        month_year = dateFormat.format(cal.getTime());


        tvMonthYear.setText(setTeluguMonth(month_year));

        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date dateFormat = null;
                try {
                    dateFormat = df.parse(month_year);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                c.setTime(dateFormat);
                c.add(Calendar.MONTH, -1);

                month_year = df.format(c.getTime());
                tvMonthYear.setText(setTeluguMonth(month_year));
                festivalList(getMonthNum(),getYearNum());

            }
        });
        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date dateFormat = null;
                try {
                    dateFormat = df.parse(month_year);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                c.setTime(dateFormat);
                c.add(Calendar.MONTH, 1);
                month_year = df.format(c.getTime());
                tvMonthYear.setText(setTeluguMonth(month_year));
                festivalList(getMonthNum(), getYearNum());

            }
        });
        festivalList(getMonthNum(), getYearNum());

        return root;
    }

    private String setTeluguMonth(String month_year)
    {
        int index = month_year.indexOf(' ');
        String month = month_year.substring(0, index);
        int p = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December").indexOf(month);
        String teluguMonth = montharray[p];
        return teluguMonth;
    }

    private String getMonthNum() {
        Date newDate = null;
        try {
            newDate = df.parse(""+month_year);
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
            newDate = df.parse(""+month_year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String date = format.format(newDate);
        return date;
    }


    private void festivalList(String monthNum, String yearNum)
    {
        if (databaseHelper.getmodelFestivalList(monthNum,yearNum).size() !=0){
            Log.d("festival",databaseHelper.getmodelFestivalList(monthNum,yearNum).toString());
            festivalAdapter = new FestivalAdapter(activity, databaseHelper.getmodelFestivalList(monthNum,yearNum));
            recyclerView.setAdapter(festivalAdapter);

        }
        else {
            recyclerView.setVisibility(View.GONE);

        }


    }
}