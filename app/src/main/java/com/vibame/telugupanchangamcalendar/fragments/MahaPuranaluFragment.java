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
import com.vibame.telugupanchangamcalendar.activities.MahaBharathamActivity;

public class MahaPuranaluFragment extends Fragment {

    LinearLayout mahaBharatham, ramayanam, bhagvathGeetha, bhagvatham, sethakamulu, sivaPuranam;
    Activity mahaBharathamActivity;

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
        mahaBharathamActivity= new MahaBharathamActivity();

        loadActivity(mahaBharathamActivity, mahaBharatham);
        // Inflate the layout for this fragment
        return root;
    }

    private void loadActivity(Activity activity, LinearLayout linearLayout) {
        linearLayout.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), activity.getClass());
            startActivity(intent);

        });
    }
}