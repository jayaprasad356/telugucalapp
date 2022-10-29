package com.vibame.telugupanchangamcalendar.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vibame.telugupanchangamcalendar.AnkeluActivity;
import com.vibame.telugupanchangamcalendar.GowriPanchangamActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.AksharaluActivity;
import com.vibame.telugupanchangamcalendar.activities.FruitNamesActivity;
import com.vibame.telugupanchangamcalendar.activities.GunintaluActivity;
import com.vibame.telugupanchangamcalendar.activities.JanaPadhaActivity;
import com.vibame.telugupanchangamcalendar.activities.KolathaluActivity;
import com.vibame.telugupanchangamcalendar.activities.KulaVurthaActivity;
import com.vibame.telugupanchangamcalendar.activities.LagnaluActivity;
import com.vibame.telugupanchangamcalendar.activities.MonthActivity;
import com.vibame.telugupanchangamcalendar.activities.NavaGrahaluActivity;
import com.vibame.telugupanchangamcalendar.activities.PakahamuluActivity;
import com.vibame.telugupanchangamcalendar.activities.PrasadhamNamesActivity;
import com.vibame.telugupanchangamcalendar.activities.PushapaluActivity;
import com.vibame.telugupanchangamcalendar.activities.RashuluActivity;
import com.vibame.telugupanchangamcalendar.activities.RuthuvuluActivity;
import com.vibame.telugupanchangamcalendar.activities.TeluguYearActivity;
import com.vibame.telugupanchangamcalendar.activities.ThidhiAdhiActivity;
import com.vibame.telugupanchangamcalendar.activities.WeekNamesActivity;


public class TeluguSamskruthamFragment extends Fragment {

    LinearLayout llTeluguYear,llRashulu,llMonth,llAnkelu,llAksharalu,llGuninthalu,llJanapadha,llKulavruthulu,llPakshamulu;
    LinearLayout llNavagrahalu,llRuthuvulu,llKolathalu,llPrasadhamnames,llLagnalu,llThidhiadhi,llWeeknames,llFruitnames,llPushapalu;


    public TeluguSamskruthamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_telugu_samskrutham, container, false);


        llTeluguYear = root.findViewById(R.id.llTeluguYear);
        llRashulu = root.findViewById(R.id.llRashulu);
        llMonth = root.findViewById(R.id.llMonth);
        llAnkelu = root.findViewById(R.id.llAnkelu);
        llAksharalu = root.findViewById(R.id.llAksharalu);
        llGuninthalu = root.findViewById(R.id.llGuninthalu);
        llJanapadha = root.findViewById(R.id.llJanapadha);
        llKulavruthulu = root.findViewById(R.id.llKulavruthulu);
        llNavagrahalu = root.findViewById(R.id.llNavagrahalu);
        llRuthuvulu = root.findViewById(R.id.llRuthuvulu);
        llKolathalu = root.findViewById(R.id.llKolathalu);
        llPrasadhamnames = root.findViewById(R.id.llPrasadhamnames);
        llLagnalu = root.findViewById(R.id.llLagnalu);
        llThidhiadhi = root.findViewById(R.id.llThidhiadhi);
        llWeeknames = root.findViewById(R.id.llWeeknames);
        llFruitnames = root.findViewById(R.id.llFruitnames);
        llPakshamulu = root.findViewById(R.id.llPakshamulu);
        llPushapalu = root.findViewById(R.id.llPushapalu);

        llTeluguYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeluguYearActivity.class);
                startActivity(intent);
            }
        });
        llRashulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RashuluActivity.class);
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
        llAnkelu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnkeluActivity.class);
                startActivity(intent);
            }
        });
        llAksharalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AksharaluActivity.class);
                startActivity(intent);
            }
        });
        llGuninthalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GunintaluActivity.class);
                startActivity(intent);
            }
        });
        llJanapadha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JanaPadhaActivity.class);
                startActivity(intent);
            }
        });
        llKulavruthulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KulaVurthaActivity.class);
                startActivity(intent);
            }
        });
        llNavagrahalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NavaGrahaluActivity.class);
                startActivity(intent);
            }
        });
        llRuthuvulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RuthuvuluActivity.class);
                startActivity(intent);
            }
        });
        llKolathalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KolathaluActivity.class);
                startActivity(intent);
            }
        });
        llPrasadhamnames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PrasadhamNamesActivity.class);
                startActivity(intent);
            }
        });
        llLagnalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LagnaluActivity.class);
                startActivity(intent);
            }
        });
        llThidhiadhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThidhiAdhiActivity.class);
                startActivity(intent);
            }
        });
        llWeeknames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WeekNamesActivity.class);
                startActivity(intent);
            }
        });
        llFruitnames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FruitNamesActivity.class);
                startActivity(intent);
            }
        });
        llPakshamulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PakahamuluActivity.class);
                startActivity(intent);
            }
        });
        llPushapalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PushapaluActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}