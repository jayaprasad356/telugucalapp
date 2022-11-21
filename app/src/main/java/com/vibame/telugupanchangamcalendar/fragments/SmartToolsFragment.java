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

import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.activities.CoinTossActivity;
import com.vibame.telugupanchangamcalendar.activities.CompassActivity;
import com.vibame.telugupanchangamcalendar.activities.DateplusActivity;
import com.vibame.telugupanchangamcalendar.activities.EMICalculatorActivity;
import com.vibame.telugupanchangamcalendar.activities.GstCalulatorActivity;
import com.vibame.telugupanchangamcalendar.activities.MileageCalculatorActivity;
import com.vibame.telugupanchangamcalendar.activities.NotesActivity;
import com.vibame.telugupanchangamcalendar.activities.NumbertoWordsActivity;
import com.vibame.telugupanchangamcalendar.activities.PercentageCalculatorActivity;
import com.vibame.telugupanchangamcalendar.activities.SimpleInterestActivity;
import com.vibame.telugupanchangamcalendar.activities.SpeechtoTextActivity;
import com.vibame.telugupanchangamcalendar.activities.StopWatchActivity;
import com.vibame.telugupanchangamcalendar.activities.TextToSpeechActivity;
import com.vibame.telugupanchangamcalendar.activities.TrackerActivity;
import com.vibame.telugupanchangamcalendar.activities.WorldClockActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;

public class SmartToolsFragment extends Fragment {


    CardView cvSimpleInterest, cvGstcalculator, cvTraker, cvPercentageConventer, cvNotes, cvDateplus, cvSpeechtoText, cvCompass,cvMileageCalculator;
    CardView cvEmi, cvPostalTracker, cvPnrStatus, cvCourierStatus, cvWorldClock, cvTexttoSpeech, cvToss, cvStopWatch, cvNUmbertoText;
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

        cvCompass = root.findViewById(R.id.cvCompass);
        cvSimpleInterest = root.findViewById(R.id.cvSimpleInterest);
        cvEmi = root.findViewById(R.id.cvEmi);
        cvGstcalculator = root.findViewById(R.id.cvGstcalculator);
        cvTraker = root.findViewById(R.id.cvTraker);
        cvWorldClock = root.findViewById(R.id.cvWorldClock);
        cvTexttoSpeech = root.findViewById(R.id.cvTexttoSpeech);
        cvToss = root.findViewById(R.id.cvToss);
        cvPercentageConventer = root.findViewById(R.id.cvPercentageConventer);
        cvNotes = root.findViewById(R.id.cvNotes);
        cvStopWatch = root.findViewById(R.id.cvStopWatch);
        cvNUmbertoText = root.findViewById(R.id.cvNUmbertoText);
        cvDateplus = root.findViewById(R.id.cvDateplus);
        cvSpeechtoText = root.findViewById(R.id.cvSpeechtoText);
        cvMileageCalculator = root.findViewById(R.id.cvMileageCalculator);

        cvSimpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SimpleInterestActivity.class);
                startActivity(intent);
            }
        });
        cvDateplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DateplusActivity.class);
                startActivity(intent);
            }
        });
        cvMileageCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MileageCalculatorActivity.class);
                startActivity(intent);
            }
        });
        cvSpeechtoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SpeechtoTextActivity.class);
                startActivity(intent);
            }
        });
        cvPercentageConventer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PercentageCalculatorActivity.class);
                startActivity(intent);
            }
        });
        cvNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), NotesActivity.class);
//                startActivity(intent);
            }
        });
        cvStopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StopWatchActivity.class);
                startActivity(intent);
            }
        });
        cvToss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), CoinTossActivity.class);
//                startActivity(intent);
            }
        });
        cvTexttoSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TextToSpeechActivity.class);
                startActivity(intent);
            }
        });
        cvWorldClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), WorldClockActivity.class);
//                startActivity(intent);
            }
        });
        cvEmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EMICalculatorActivity.class);
                startActivity(intent);
            }
        });
        cvNUmbertoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NumbertoWordsActivity.class);
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
        cvCompass.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), CompassActivity.class);
            startActivity(intent);
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
                        intent.putExtra("link", Constant.POSTAL_TRACKER_URL);
                        startActivity(intent);

                    }
                });
                cvPnrStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, "okay clicked", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getActivity(), TrackerActivity.class);
                        intent.putExtra("link", Constant.PNR_TRACKER_URL);
                        startActivity(intent);

                    }
                });
                cvCourierStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, "okay clicked", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getActivity(), TrackerActivity.class);
                        intent.putExtra("link", Constant.COURIER_TRACKER_URL);
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