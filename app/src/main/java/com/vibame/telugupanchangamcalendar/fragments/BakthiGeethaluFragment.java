package com.vibame.telugupanchangamcalendar.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vibame.telugupanchangamcalendar.AudioLiveActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.VideoLiveActivity;


public class BakthiGeethaluFragment extends Fragment {

    CardView cardVideolive,cardAudiolive;


    public BakthiGeethaluFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_bakthi_geethalu, container, false);


        cardVideolive = root.findViewById(R.id.cardVideolive);
        cardAudiolive = root.findViewById(R.id.cardAudiolive);

        cardVideolive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VideoLiveActivity.class);
                startActivity(intent);
            }
        });
        cardAudiolive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AudioLiveActivity.class);
                startActivity(intent);
            }
        });

        return  root;

    }
}