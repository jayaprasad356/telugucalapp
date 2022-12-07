package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vibame.telugupanchangamcalendar.HeightWeightChartsActivity;
import com.vibame.telugupanchangamcalendar.IfscActivity;
import com.vibame.telugupanchangamcalendar.InternetSpeedMeterActivity;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.TeluguKeyboardActivity;
import com.vibame.telugupanchangamcalendar.helper.Constant;

public class SmartToolsActivity extends AppCompatActivity {



    CardView cvSimpleInterest, cvCompoundInterest, cvHeightweightcharts, cvTelugukeyboard,cvInternetspeedmeter, cvUnitconverter, cvGstcalculator, cvTraker, cvPercentageConventer, cvNotes, cvDateplus, cvSpeechtoText, cvCompass,cvMileageCalculator;
    CardView cvEmi,cvIfsc, cvPostalTracker, cvPnrStatus, cvCourierStatus, cvWorldClock, cvTexttoSpeech, cvToss, cvStopWatch, cvNUmbertoText, cvCounter;
    ImageView ivClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_tools);


        Dialog dialog = new Dialog(SmartToolsActivity.this);

        cvCompass = findViewById(R.id.cvCompass);
        cvSimpleInterest = findViewById(R.id.cvSimpleInterest);
        cvCompoundInterest = findViewById(R.id.cvCompoundInterest);
        cvInternetspeedmeter = findViewById(R.id.cvInternetspeedmeter);
        cvTelugukeyboard = findViewById(R.id.cvTelugukeyboard);
        cvHeightweightcharts = findViewById(R.id.cvHeightweightcharts);
        cvUnitconverter = findViewById(R.id.cvUnitconverter);
        cvEmi = findViewById(R.id.cvEmi);
        cvIfsc = findViewById(R.id.cvIfsc);
        cvGstcalculator = findViewById(R.id.cvGstcalculator);
        cvTraker = findViewById(R.id.cvTraker);
        cvWorldClock = findViewById(R.id.cvWorldClock);
        cvTexttoSpeech = findViewById(R.id.cvTexttoSpeech);
        cvToss = findViewById(R.id.cvToss);
        cvPercentageConventer = findViewById(R.id.cvPercentageConventer);
        cvNotes = findViewById(R.id.cvNotes);
        cvStopWatch = findViewById(R.id.cvStopWatch);
        cvNUmbertoText = findViewById(R.id.cvNUmbertoText);
        cvDateplus = findViewById(R.id.cvDateplus);
        cvSpeechtoText = findViewById(R.id.cvSpeechtoText);
        cvMileageCalculator = findViewById(R.id.cvMileageCalculator);
        cvCounter=findViewById(R.id.cvCounter);



        cvSimpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, SimpleInterestActivity.class);
                startActivity(intent);
            }
        });
        cvHeightweightcharts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, HeightWeightChartsActivity.class);
                startActivity(intent);
            }
        });
        cvTelugukeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, TeluguKeyboardActivity.class);
                startActivity(intent);
            }
        });
        cvIfsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, IfscActivity.class);
                startActivity(intent);
            }
        });
        cvCompoundInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, CompoundInterestActivity.class);
                startActivity(intent);
            }
        });
        cvInternetspeedmeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, InternetSpeedMeterActivity.class);
                startActivity(intent);
            }
        });
        cvUnitconverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, ConvertActivity.class);
                startActivity(intent);
            }
        });
        cvDateplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, DateplusActivity.class);
                startActivity(intent);
            }
        });
        cvMileageCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, MileageCalculatorActivity.class);
                startActivity(intent);
            }
        });
        cvSpeechtoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, SpeechtoTextActivity.class);
                startActivity(intent);
            }
        });
        cvPercentageConventer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, PercentageCalculatorActivity.class);
                startActivity(intent);
            }
        });
        cvNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });
        cvStopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, StopWatchActivity.class);
                startActivity(intent);
            }
        });
        cvToss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, CoinTossActivity.class);
                startActivity(intent);
            }
        });
        cvTexttoSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, TextToSpeechActivity.class);
                startActivity(intent);
            }
        });
        cvWorldClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, WorldClockActivity.class);
                startActivity(intent);
            }
        });
        cvEmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, EMICalculatorActivity.class);
                startActivity(intent);
            }
        });
        cvNUmbertoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, NumbertoWordsActivity.class);
                startActivity(intent);
            }
        });
        cvGstcalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartToolsActivity.this, GstCalulatorActivity.class);
                startActivity(intent);
            }
        });
        cvCompass.setOnClickListener(view -> {
            Intent intent = new Intent(SmartToolsActivity.this, CompassActivity.class);
            startActivity(intent);
        });
        cvCounter.setOnClickListener(view -> {
            Intent intent = new Intent(SmartToolsActivity.this, CounterActivity.class);
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

                        Intent intent = new Intent(SmartToolsActivity.this, TrackerActivity.class);
                        intent.putExtra("link", Constant.POSTAL_TRACKER_URL);
                        startActivity(intent);

                    }
                });
                cvPnrStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, "okay clicked", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SmartToolsActivity.this, TrackerActivity.class);
                        intent.putExtra("link", Constant.PNR_TRACKER_URL);
                        startActivity(intent);

                    }
                });
                cvCourierStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        dialog.dismiss();
//                        Toast.makeText(MainActivity.this, "okay clicked", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SmartToolsActivity.this, TrackerActivity.class);
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


    }
}