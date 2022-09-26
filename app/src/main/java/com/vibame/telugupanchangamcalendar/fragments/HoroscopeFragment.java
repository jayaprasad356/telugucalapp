package com.vibame.telugupanchangamcalendar.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vibame.telugupanchangamcalendar.DailyHoroscopeActivity;
import com.vibame.telugupanchangamcalendar.MonthlyHoroscopeActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.WeeklyHoroscopeActivity;
import com.vibame.telugupanchangamcalendar.YearlyHoroscopeActivity;

public class HoroscopeFragment extends Fragment {

    LinearLayout llDailyhoroscope,llWYearlyHoroscope,llWeeklyHoroscope,llMonthlyHoroscope;


    public HoroscopeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View   root = inflater.inflate(R.layout.fragment_horoscope, container, false);


        llDailyhoroscope = root.findViewById(R.id.llDailyhoroscope);
        llMonthlyHoroscope = root.findViewById(R.id.llMonthlyHoroscope);
        llWYearlyHoroscope = root.findViewById(R.id.llWYearlyHoroscope);
        llWeeklyHoroscope = root.findViewById(R.id.llWeeklyHoroscope);

        llDailyhoroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DailyHoroscopeActivity.class);
                startActivity(intent);
            }
        });
        llWeeklyHoroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WeeklyHoroscopeActivity.class);
                startActivity(intent);
            }
        });
        llWYearlyHoroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YearlyHoroscopeActivity.class);
                startActivity(intent);
            }
        });

        llMonthlyHoroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MonthlyHoroscopeActivity.class);
                startActivity(intent);
            }
        });


      return root;

    }
}