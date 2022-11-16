package com.vibame.telugupanchangamcalendar.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.EMICalculatorActivity;
import com.vibame.telugupanchangamcalendar.activities.SimpleInterestActivity;

public class SmartToolsFragment extends Fragment {


    CardView cvSimpleInterest;
    CardView cvEmi;



    public SmartToolsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_smart_tools, container, false);


        cvSimpleInterest=root.findViewById(R.id.cvSimpleInterest);
        cvEmi=root.findViewById(R.id.cvEmi);

        cvSimpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SimpleInterestActivity.class);
                startActivity(intent);
            }
        });
        cvEmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EMICalculatorActivity.class);
                startActivity(intent);
            }
        });


        return root;
    }
}