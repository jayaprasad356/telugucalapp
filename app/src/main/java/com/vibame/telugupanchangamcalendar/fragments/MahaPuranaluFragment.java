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
import com.vibame.telugupanchangamcalendar.helper.Session;

public class MahaPuranaluFragment extends Fragment {

    LinearLayout mahaBharatham, ramayanam, bhagvathGeetha, bhagvatham, sethakamulu, sivaPuranam;
    Activity mahaBharathamActivity,ramayanamActivity;
    Session session;
    Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_maha_puranalu, container, false);
        activity = getActivity();
        session = new Session(activity);
        mahaBharatham = root.findViewById(R.id.maha_bharatham);
        ramayanam = root.findViewById(R.id.ramayanam);
        bhagvathGeetha = root.findViewById(R.id.bhagvath_geetha);
        bhagvatham = root.findViewById(R.id.bhagvatham);
        sethakamulu = root.findViewById(R.id.sethakamulu);
        sivaPuranam = root.findViewById(R.id.shiva_puranam);


        ramayanam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"ramayanam");
                session.setData(Constant.MENU,"ramayanam_menu");
                session.setData(Constant.SUBMENU,"ramayanam_submenu");
                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Ramayanam");
                startActivity(intent);

            }
        });
        mahaBharatham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"mahabharatham");
                session.setData(Constant.MENU,"mahabharatham_menu");
                session.setData(Constant.SUBMENU,"mahabharatham_submenu");
                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Maha Bharatham");
                startActivity(intent);

            }
        });
        bhagvathGeetha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"bhagawath_geetha");
                session.setData(Constant.MENU,"bhagawath_geetha_menu");
                session.setData(Constant.SUBMENU,"bhagawath_geetha_submenu");
                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Bhagvath Geetha");
                startActivity(intent);

            }
        });
        bhagvatham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"bhagawatham");
                session.setData(Constant.MENU,"bhagawatham_menu");
                session.setData(Constant.SUBMENU,"bhagawatham_submenu");
                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Bhagvatham");
                startActivity(intent);

            }
        });
        sethakamulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"telugu_sethakamulu");
                session.setData(Constant.MENU,"telugu_sethakamulu_menu");
                session.setData(Constant.SUBMENU,"telugu_sethakamulu_submenu");
                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Sethakamulu");
                startActivity(intent);

            }
        });
        sivaPuranam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setData(Constant.TAB,"shivapuranam");
                session.setData(Constant.MENU,"");
                session.setData(Constant.SUBMENU,"shivapuranam_menu");
                Intent intent = new Intent(getActivity(),RamayanamActivity.class);
                intent.putExtra(Constant.TITLE,"Shiva Puranam");
                startActivity(intent);

            }
        });


        // Inflate the layout for this fragment
        return root;
    }


}