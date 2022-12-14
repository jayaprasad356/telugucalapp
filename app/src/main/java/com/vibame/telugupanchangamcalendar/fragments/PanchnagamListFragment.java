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
import com.vibame.telugupanchangamcalendar.RahukalamActivity;
import com.vibame.telugupanchangamcalendar.ThidhiluActivity;
import com.vibame.telugupanchangamcalendar.activities.HoraChakramActivity;
import com.vibame.telugupanchangamcalendar.activities.KaranamActivity;
import com.vibame.telugupanchangamcalendar.activities.YogamActivity;


public class PanchnagamListFragment extends Fragment {

    LinearLayout llThidhi,llGowri,llRahukalam,llHora,llKaranam,llYogam;



    public PanchnagamListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_panchnagam_list, container, false);


        llThidhi = root.findViewById(R.id.llThidhi);
        llGowri = root.findViewById(R.id.llGowri);
        llRahukalam = root.findViewById(R.id.llRahukalam);
        llHora = root.findViewById(R.id.llHora);
        llKaranam = root.findViewById(R.id.llKaranam);
        llYogam = root.findViewById(R.id.llYogam);

        llThidhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThidhiluActivity.class);
                startActivity(intent);
            }
        });
        llGowri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GowriPanchangamActivity.class);
                startActivity(intent);
            }
        });
        llRahukalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RahukalamActivity.class);
                startActivity(intent);
            }
        });
        llHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HoraChakramActivity.class);
                startActivity(intent);
            }
        });
        llKaranam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KaranamActivity.class);
                startActivity(intent);

            }
        });

        llYogam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), YogamActivity.class);
                startActivity(intent);

            }
        });



        return root;
    }
}