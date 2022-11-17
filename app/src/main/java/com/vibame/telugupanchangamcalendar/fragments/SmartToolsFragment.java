package com.vibame.telugupanchangamcalendar.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.EMICalculatorActivity;
import com.vibame.telugupanchangamcalendar.activities.GstCalulatorActivity;
import com.vibame.telugupanchangamcalendar.activities.SimpleInterestActivity;
import com.vibame.telugupanchangamcalendar.activities.TrackerActivity;
import com.vibame.telugupanchangamcalendar.activities.WorldClockActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;

public class SmartToolsFragment extends Fragment {


    CardView cvSimpleInterest,cvGstcalculator,cvTraker;
    CardView cvEmi,cvPostalTracker,cvPnrStatus,cvCourierStatus,cvWorldClock;
    ImageView ivClose;



    public SmartToolsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_smart_tools, container, false);


        Dialog dialog = new Dialog(getActivity());


        cvSimpleInterest=root.findViewById(R.id.cvSimpleInterest);
        cvEmi=root.findViewById(R.id.cvEmi);
        cvGstcalculator=root.findViewById(R.id.cvGstcalculator);
        cvTraker = root.findViewById(R.id.cvTraker);
        cvWorldClock = root.findViewById(R.id.cvWorldClock);

        cvSimpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SimpleInterestActivity.class);
                startActivity(intent);
            }
        });
        cvWorldClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WorldClockActivity.class);
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
        cvGstcalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GstCalulatorActivity.class);
                startActivity(intent);
            }
        });
        cvTraker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.dialog_layout);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

//                okay_text = dialog.findViewById(R.id.okay_text);
//                cancel_text = dialog.findViewById(R.id.cancel_text);
                cvPostalTracker = dialog.findViewById(R.id.cvPostalTracker);
                ivClose = dialog.findViewById(R.id.ivClose);
                cvPnrStatus = dialog.findViewById(R.id.cvPnrStatus);
                cvCourierStatus = dialog.findViewById(R.id.cvCourierStatus);



                cvPostalTracker.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, "okay clicked", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getActivity(), TrackerActivity.class);
                        intent.putExtra("link",Constant.POSTAL_TRACKER_URL);
                        startActivity(intent);

                    }
                });
                cvPnrStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, "okay clicked", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getActivity(), TrackerActivity.class);
                        intent.putExtra("link",Constant.PNR_TRACKER_URL);
                        startActivity(intent);

                    }
                });
                cvCourierStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, "okay clicked", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getActivity(), TrackerActivity.class);
                        intent.putExtra("link",Constant.COURIER_TRACKER_URL);
                        startActivity(intent);

                    }
                });

                ivClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        });

        return root;
    }
}