package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vibame.telugupanchangamcalendar.R;

public class SimpleInterestActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText edYear,edMonth,edInterestAmount,edAmount,edInterest;
    LinearLayout llTime;
    Button btnCalculate;
    TextView txt1,txt2;



    boolean rb1 = false, rb2 = false;


    private RadioGroup radioGroup;
    RadioButton radioButton;


    Spinner SimpleInterestspinner;
    String[] spinner = { "Simple Interest", "Pricipal",
            "Interest Rate", "Time Period" };


    int a,b,c,d,e,f,m;

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest);


        SimpleInterestspinner = findViewById(R.id.SimpleInterestspinner);
        SimpleInterestspinner.setOnItemSelectedListener(this);

        radioGroup = findViewById(R.id.radioGroup);
        edYear = findViewById(R.id.edYear);
        edMonth = findViewById(R.id.edMonth);
        edAmount = findViewById(R.id.edAmount);
        edInterest = findViewById(R.id.edInterest);
        llTime = findViewById(R.id.llTime);
        edInterestAmount = findViewById(R.id.edInterestAmount);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        btnCalculate = findViewById(R.id.btnCalculate);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override


                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {

                        // Get the selected Radio Button
                         radioButton = group.findViewById(checkedId);

                         index = group.indexOfChild(radioButton);

                        // Add logic here

                        switch (index) {
                            case 0: // first button

                                edMonth.setVisibility(View.GONE);
                                edYear.setVisibility(View.VISIBLE);


                                break;
                            case 1: // secondbutton
                                rb2 = true;
                                edMonth.setVisibility(View.VISIBLE);
                                edYear.setVisibility(View.GONE);


                                break;
                        }

                    }
                });

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinner);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SimpleInterestspinner.setAdapter(ad);




        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (index == 0)
                {

                    a = Integer.parseInt(edAmount.getText().toString());
                    b = Integer.parseInt(edInterest.getText().toString());
                    c = Integer.parseInt(edYear.getText().toString());

                    d=(a*b*c)/100;
                    int e=a+d;
                    txt1.setText("Total Interest Is :"+String.valueOf(d));
                    txt2.setText("Total Amount is : "+String.valueOf(e));
                }

                else if(index == 1)  {

                    a = Integer.parseInt(edAmount.getText().toString());
                    b = Integer.parseInt(edInterest.getText().toString());
                    m = Integer.parseInt(edMonth.getText().toString());
                    f = (100*12);


                    d=(a*b*m)/f;
                    int e=a+d;
                    txt1.setText("Total Interest Is :"+String.valueOf(d));
                    txt2.setText("Total Amount is : "+String.valueOf(e));

                }






            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {






        if(position == 0)
        //Simple Interest
        {

            edAmount.setVisibility(View.VISIBLE);
            edInterestAmount.setVisibility(View.GONE);
            edInterest.setVisibility(View.VISIBLE);
            llTime.setVisibility(View.VISIBLE);

            Toast.makeText(getApplicationContext(), spinner[position], Toast.LENGTH_LONG).show();
        }
        else if(position == 1)

        //Principle
        {

            edAmount.setVisibility(View.GONE);
            edInterestAmount.setVisibility(View.VISIBLE);
            edInterest.setVisibility(View.VISIBLE);
            llTime.setVisibility(View.VISIBLE);

            Toast.makeText(getApplicationContext(), spinner[position], Toast.LENGTH_LONG).show();

        }
        else if(position == 2)
        //Interest Rate

        {

            edAmount.setVisibility(View.VISIBLE);
            edInterestAmount.setVisibility(View.VISIBLE);
            edInterest.setVisibility(View.GONE);

            llTime.setVisibility(View.VISIBLE);

            Toast.makeText(getApplicationContext(), spinner[position], Toast.LENGTH_LONG).show();

        }

        else if(position == 3)
        //Time Period
        {

            edAmount.setVisibility(View.VISIBLE);
            edInterestAmount.setVisibility(View.VISIBLE);
            edInterest.setVisibility(View.VISIBLE);

            llTime.setVisibility(View.GONE);

            Toast.makeText(getApplicationContext(), spinner[position], Toast.LENGTH_LONG).show();

        }



        }





    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

