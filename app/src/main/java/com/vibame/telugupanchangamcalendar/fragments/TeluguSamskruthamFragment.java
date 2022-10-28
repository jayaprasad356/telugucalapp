package com.vibame.telugupanchangamcalendar.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vibame.telugupanchangamcalendar.GowriPanchangamActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.MonthActivity;
import com.vibame.telugupanchangamcalendar.activities.TeluguYearActivity;


public class TeluguSamskruthamFragment extends Fragment {

    LinearLayout llTeluguYear,llMonth;


    public TeluguSamskruthamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_telugu_samskrutham, container, false);


        llTeluguYear = root.findViewById(R.id.llTeluguYear);
        llMonth = root.findViewById(R.id.llMonth);

        llTeluguYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeluguYearActivity.class);
                startActivity(intent);
            }
        });
        llMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MonthActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}