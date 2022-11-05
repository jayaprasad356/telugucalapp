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
import com.vibame.telugupanchangamcalendar.activities.RamayanamActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;

public class MahaPuranaluFragment extends Fragment {

    LinearLayout mahaBharatham, ramayanam, bhagvathGeetha, bhagvatham, sethakamulu, sivaPuranam;
    Activity mahaBharathamActivity,ramayanamActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_maha_puranalu, container, false);
        mahaBharatham = root.findViewById(R.id.maha_bharatham);
        ramayanam = root.findViewById(R.id.ramayanam);
        bhagvathGeetha = root.findViewById(R.id.bhagvath_geetha);
        bhagvatham = root.findViewById(R.id.bhagvatham);
        sethakamulu = root.findViewById(R.id.sethakamulu);
        sivaPuranam = root.findViewById(R.id.shiva_puranam);


        ramayanam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Rayanam");
                startActivity(intent);

            }
        });
        mahaBharatham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Maha Bharatham");
                startActivity(intent);

            }
        });
        bhagvathGeetha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Bhagvath Geetha");
                startActivity(intent);

            }
        });
        bhagvatham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Bhagvatham");
                startActivity(intent);

            }
        });
        sethakamulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Sethakamulu");
                startActivity(intent);

            }
        });
        sivaPuranam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Shiva Puranam");
                startActivity(intent);

            }
        });
        // Inflate the layout for this fragment
        return root;
    }


}