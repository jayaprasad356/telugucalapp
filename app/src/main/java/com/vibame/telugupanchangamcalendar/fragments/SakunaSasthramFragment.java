package com.vibame.telugupanchangamcalendar.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.SakunaluActivity;
import com.vibame.telugupanchangamcalendar.activities.KakiActivity;


public class SakunaSasthramFragment extends Fragment {

    LinearLayout sakunalu, kaki;
    Activity sakunaActivity, kakiActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_sakuna_sasthram, container, false);
        sakunalu = root.findViewById(R.id.sakunalu);
        kaki = root.findViewById(R.id.kaki);

        sakunaActivity = new SakunaluActivity();
        kakiActivity = new KakiActivity();

        loadSakunaSastharam(sakunalu, sakunaActivity);
        loadSakunaSastharam(kaki, kakiActivity);


        return root;

    }

    private void loadSakunaSastharam(LinearLayout linearLayout, Activity activity) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity.getClass());
                startActivity(intent);

            }
        });
    }
}