package com.vibame.telugupanchangamcalendar.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vibame.telugupanchangamcalendar.HoroscopeActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.Constant;

public class HoroscopeFragment extends Fragment {

    LinearLayout llDailyhoroscope, llWYearlyHoroscope, llWeeklyHoroscope, llMonthlyHoroscope;


    public HoroscopeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_horoscope, container, false);


        llDailyhoroscope = root.findViewById(R.id.llDailyhoroscope);
        llMonthlyHoroscope = root.findViewById(R.id.llMonthlyHoroscope);
        llWYearlyHoroscope = root.findViewById(R.id.llWYearlyHoroscope);
        llWeeklyHoroscope = root.findViewById(R.id.llWeeklyHoroscope);

        llDailyhoroscope.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), HoroscopeActivity.class);
            intent.putExtra(Constant.HOROSCOPE,"Daily");
            startActivity(intent);
        });
        llWeeklyHoroscope.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), HoroscopeActivity.class);
            intent.putExtra(Constant.HOROSCOPE,"Weekly");
            startActivity(intent);
        });
        llWYearlyHoroscope.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), HoroscopeActivity.class);
            intent.putExtra(Constant.HOROSCOPE,"Yearly");
            startActivity(intent);
        });

        llMonthlyHoroscope.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), HoroscopeActivity.class);
            intent.putExtra(Constant.HOROSCOPE,"Monthly");
            startActivity(intent);
        });


        return root;

    }
}