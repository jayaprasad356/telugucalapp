package com.vibame.telugupanchangamcalendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HeightWeightChartsActivity extends AppCompatActivity {

    ImageView imgBack;
    RadioButton maleBtn, femaleBtn;
    ImageView genderImage;
    TextView hText, wText;
    LinearLayout mainLayout;
    Spinner spinner;
    String view;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_weight_charts);
        maleBtn = findViewById(R.id.male_but);
        femaleBtn = findViewById(R.id.female_but);
        genderImage = findViewById(R.id.img);
        hText = findViewById(R.id.h_txt);
        wText = findViewById(R.id.w_txt);
        mainLayout = findViewById(R.id.main_lay);
        spinner = findViewById(R.id.bulid_age_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                showHW(item);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        maleBtn.setOnClickListener(view -> visible("male"));
        femaleBtn.setOnClickListener(view -> visible("female"));


        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(v -> onBackPressed());
    }

    private void showHW(String item) {
        this.view = item;
        if (maleBtn.isChecked() || femaleBtn.isChecked()) {
            if (maleBtn.isChecked()) {
                loadMaleChart(item);
            } else {
                loadFemaleChart(item);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void loadFemaleChart(String item) {
        switch (item) {
            case "New Born Baby":
                hText.setText("49.69 cm");
                wText.setText("3.2 kg");
                break;
            case "3 Month":
                hText.setText("60.2 cm");
                wText.setText("5.4 kg");
                break;
            case "6 Month":
                hText.setText("66.6 cm");
                wText.setText("7.2 kg");

                break;
            case "9 Month":
                hText.setText("71.1 cm");
                wText.setText("8.6 kg");

                break;
            case "1 Year":
                hText.setText("75.0 cm");
                wText.setText("9.5 kg");

                break;
            case "2 Year":
                hText.setText("84.5 cm");
                wText.setText("11.8 kg");
                break;
            case "3 Year":
                hText.setText("93.9 cm");
                wText.setText("14.1 kg");

                break;
            case "4 Year":

                hText.setText("101.6 cm");
                wText.setText("16.0 kg");
                break;
            case "5 Year":
                hText.setText("108.4 cm");
                wText.setText("17.7 kg");
                break;
            case "6 Year":
                hText.setText("114.6 cm");
                wText.setText("19.5 kg");
                break;
            case "7 Year":
                hText.setText("120.6 cm");
                wText.setText("21.8 kg");

                break;
            case "8 Year":
                hText.setText("126.4 cm");
                wText.setText("24.8 kg");
                break;
            case "9 Year":
                hText.setText("132.2 cm");
                wText.setText("28.5 kg");

                break;
            case "10 Year":

                hText.setText("138.3 cm");
                wText.setText("32.5 kg");
                break;
            case "11 Year":
                hText.setText("142.0 cm");
                wText.setText("33.7 kg");
                break;
            case "12 Year":
                hText.setText("148.0 cm");
                wText.setText("38.7 kg");

                break;
            case "13 Year":
                hText.setText("150.0 cm");
                wText.setText("44.0 gm");
                break;
            case "14 Year":
                hText.setText("155.0 cm");
                wText.setText("48.0 kg");

                break;
            case "15 Year":
                hText.setText("161.0 cm");
                wText.setText("51.5 kg");

                break;
            case "16 Year":
                hText.setText("162.0 cm");
                wText.setText("53.0 kg");
                break;
            case "17 Year":

                hText.setText("163.0 cm");
                wText.setText("54.0 kg");
                break;
            case "18 Year":
                hText.setText("164.0 cm");
                wText.setText("54.4.0 kg");
                break;
            case "Select Age":
                hText.setText("0 cm");
                wText.setText("0 kg");
                break;
        }

    }

    @SuppressLint("SetTextI18n")
    private void loadMaleChart(String item) {
        switch (item) {
            case "New Born Baby":
                hText.setText("50.5 cm");
                wText.setText("3.3 kg");
                break;
            case "3 Month":
                hText.setText("61.1 cm");
                wText.setText("6.0 kg");
                break;
            case "6 Month":
                hText.setText("67.8 cm");
                wText.setText("7.8 kg");

                break;
            case "9 Month":
                hText.setText("72.3 cm");
                wText.setText("9.2 kg");

                break;
            case "1 Year":
                hText.setText("76.1 cm");
                wText.setText("10.2 kg");

                break;
            case "2 Year":
                hText.setText("85.6 cm");
                wText.setText("12.3 kg");
                break;
            case "3 Year":
                hText.setText("94.9 cm");
                wText.setText("14.6 kg");

                break;
            case "4 Year":

                hText.setText("102.9 cm");
                wText.setText("16.7 kg");
                break;
            case "5 Year":
                hText.setText("109.9 cm");
                wText.setText("18.7 kg");
                break;
            case "6 Year":
                hText.setText("116.1 cm");
                wText.setText("20.7 kg");
                break;
            case "7 Year":
                hText.setText("121.7 cm");
                wText.setText("22.9 kg");

                break;
            case "8 Year":
                hText.setText("127.0 cm");
                wText.setText("25.3 kg");
                break;
            case "9 Year":
                hText.setText("132.2 cm");
                wText.setText("28.1 kg");

                break;
            case "10 Year":

                hText.setText("137.5 cm");
                wText.setText("31.4 kg");
                break;
            case "11 Year":
                hText.setText("140.0 cm");
                wText.setText("32.2 kg");
                break;
            case "12 Year":
                hText.setText("147.0 cm");
                wText.setText("37.0 kg");

                break;
            case "13 Year":
                hText.setText("153.0 cm");
                wText.setText("40.9 gm");
                break;
            case "14 Year":
                hText.setText("160.0 cm");
                wText.setText("47.0 kg");

                break;
            case "15 Year":
                hText.setText("166.0 cm");
                wText.setText("52.6 kg");

                break;
            case "16 Year":
                hText.setText("171.0 cm");
                wText.setText("58.0 kg");
                break;
            case "17 Year":

                hText.setText("175.0 cm");
                wText.setText("62.7 kg");
                break;
            case "18 Year":
                hText.setText("177.0 cm");
                wText.setText("65.0 kg");
                break;
            case "Select Age":
                hText.setText("0 cm");
                wText.setText("0 kg");
                break;
        }
    }

    private void visible(String gender) {
        if (gender.equals("female")) {
            genderImage.setImageResource(R.drawable.girl_hw);
            if (!view.isEmpty())
                loadFemaleChart(view);
        } else {
            genderImage.setImageResource(R.drawable.boy_hw);
            if (!view.isEmpty())
                loadMaleChart(view);
        }
        mainLayout.setVisibility(View.VISIBLE);


    }
}