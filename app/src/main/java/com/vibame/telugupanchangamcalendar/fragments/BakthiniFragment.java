package com.vibame.telugupanchangamcalendar.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vibame.telugupanchangamcalendar.ImageTabActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.VideoTabActivity;


public class BakthiniFragment extends Fragment {

    CardView cardVideoTab,cardImageTab;



    public BakthiniFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_bakthini, container, false);

        cardImageTab = root.findViewById(R.id.cardImageTab);
        cardVideoTab = root.findViewById(R.id.cardVideoTab);


        cardImageTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ImageTabActivity.class);
                startActivity(intent);
            }
        });
        cardVideoTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VideoTabActivity.class);
                startActivity(intent);
            }
        });



        return  root;
    }

}