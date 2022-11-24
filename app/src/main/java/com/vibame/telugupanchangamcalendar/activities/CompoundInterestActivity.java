package com.vibame.telugupanchangamcalendar.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.installations.Utils;
import com.vibame.telugupanchangamcalendar.R;

import java.text.DecimalFormat;

public class CompoundInterestActivity extends AppCompatActivity {

    ImageView imgBack;




    EditText etInterestRate;
    EditText etPrincipal;
    EditText etTenure;
    RadioButton rbTenureYears;
    RadioButton rbTenureMonth;
    Spinner spCompoundingFrequency;



    TextView tvCompoundAmount;
    TextView tvCompoundPR;
    TextView tvPrincipalAmount;
    TextView tvTotalAmount;
    Button Calbtn;

    InputMethodManager inputMethodManager;
    LinearLayout calculateemi_ll_visible;
    Double f3855n,f3858q,f3860s,f3859r,f3856o,f3857p;
    boolean f3852k = true;
    boolean f3851j = true;

    String f3853l = "₹";
    Button reset;


    @SuppressWarnings("unused")
    public final static double DOUBLE_EPSILON = Double.longBitsToDouble(1);

    @SuppressWarnings("unused")
    public final static float FLOAT_EPSILON = Float.intBitsToFloat(1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_interest);

        etInterestRate = findViewById(R.id.etInterestRate);
        etPrincipal = findViewById(R.id.etPrincipal);
        etTenure = findViewById(R.id.etTenure);
        rbTenureYears = findViewById(R.id.rbTenureYears);
        rbTenureMonth = findViewById(R.id.rbTenureMonth);
        spCompoundingFrequency = findViewById(R.id.spCompoundingFrequency);
        tvCompoundAmount = findViewById(R.id.tvCompoundAmount);
        tvCompoundPR = findViewById(R.id.tvCompoundPR);
        tvPrincipalAmount = findViewById(R.id.tvPrincipalAmount);
        calculateemi_ll_visible = findViewById(R.id.calculateemi_ll_visible);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        Calbtn = findViewById(R.id.Calbtn);

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        etPrincipal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String trim = etPrincipal.getText().toString().replaceAll(",", "").trim();
                if (trim.length() > 0) {
                    etPrincipal.removeTextChangedListener(this);
                    String trim2 = Constant_CurrencyFormat.rupeeFormat(trim).trim();
                    etPrincipal.setText(trim2);
                    etPrincipal.addTextChangedListener(this);
                    EditText editText = etPrincipal;
                    editText.setSelection(editText.getText().toString().trim().length());
                } else {
                    etPrincipal.removeTextChangedListener(this);
                    etPrincipal.setText("");
                    etPrincipal.addTextChangedListener(this);
                    EditText editText2 = etPrincipal;
                    editText2.setSelection(editText2.getText().toString().trim().length());
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        rbTenureYears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               etTenure.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2)});
               f3851j = false;
               f3852k = true;


            }
        });
        rbTenureMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               etTenure.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
               f3851j = true;
               etTenure.setError((CharSequence) null);
                if (f3851j) {

                }
                if (f3852k) {
                    f3852k = false;
                }

            }
        });






        Calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(v)) {
                    calculate();
                }

            }
        });




    }




    public void onCalculate(View view) {

    }

    private void calculate()
    {
        f3855n = Double.valueOf(Double.parseDouble(clearFormet(etPrincipal.getText().toString())));
        f3858q = Double.valueOf(Double.parseDouble(clearFormet(etInterestRate.getText().toString())));
        if (f3855n.doubleValue() <= DOUBLE_EPSILON) {
            return;
        }
        if (f3858q.doubleValue() <= DOUBLE_EPSILON || f3858q.doubleValue() >= 1000.0d) {
            Toast.makeText(this, "Interest Rate must be less than 1000", Toast.LENGTH_SHORT).show();
            return;
        }
        Double valueOf = Double.valueOf(f3852k ? Double.parseDouble(etTenure.getText().toString()) : Double.parseDouble(etTenure.getText().toString()) / 12.0d);
        f3860s = valueOf;
        if (valueOf.doubleValue() > DOUBLE_EPSILON && f3860s.doubleValue() <= 999.0d) {
            if (spCompoundingFrequency.getSelectedItemPosition() == 0) {
                f3859r = Double.valueOf(1.0d);
            } else if (spCompoundingFrequency.getSelectedItemPosition() == 1) {
                f3859r = Double.valueOf(2.0d);
            } else if (spCompoundingFrequency.getSelectedItemPosition() == 2) {
                f3859r = Double.valueOf(4.0d);
            } else if (spCompoundingFrequency.getSelectedItemPosition() == 3) {
                f3859r = Double.valueOf(12.0d);
            } else if (spCompoundingFrequency.getSelectedItemPosition() == 4) {
                f3859r = Double.valueOf(26.07d);
            } else if (spCompoundingFrequency.getSelectedItemPosition() == 5) {
                f3859r = Double.valueOf(52.14d);
            } else if (spCompoundingFrequency.getSelectedItemPosition() == 6) {
                f3859r = Double.valueOf(365.0d);
            }
            calculateemi_ll_visible.setVisibility(View.VISIBLE);
            f3856o = Double.valueOf((f3855n.doubleValue() * Math.pow(((f3858q.doubleValue() / 100.0d) / f3859r.doubleValue()) + 1.0d, f3859r.doubleValue() * f3860s.doubleValue())) - f3855n.doubleValue());
            f3857p = Double.valueOf(f3856o.doubleValue() + f3855n.doubleValue());
            TextView textView = tvCompoundAmount;
            textView.setText(f3853l + " " + Constant_CurrencyFormatDoller.dollerFormat(String.valueOf(f3856o), f3853l));
            TextView textView2 = tvTotalAmount;
            textView2.setText(f3853l + " " + Constant_CurrencyFormatDoller.dollerFormat(String.valueOf(f3857p), f3853l));
            TextView textView3 = tvPrincipalAmount;
            textView3.setText(f3853l + " " + Constant_CurrencyFormatDoller.dollerFormat(String.valueOf(f3855n), f3853l));
            TextView textView4 = tvCompoundPR;
            textView4.setText(new DecimalFormat("##.##").format((double) ((float) ((f3856o.doubleValue() * 100.0d) / f3857p.doubleValue()))) + "%");
        }
    }




    public String clearFormet(String str) {
        return str.toString().replaceAll("[^\\d.]+", "");
    }

    @SuppressLint("WrongConstant")
    private boolean validate(View rootview)
    {

        inputMethodManager = (InputMethodManager) getSystemService("input_method");
        inputMethodManager.hideSoftInputFromWindow(rootview.getWindowToken(), 0);

        if (etPrincipal.getText().toString().equals("")) {
            etPrincipal.setError("Enter Principal");
            etPrincipal.requestFocus();
            return false;
        }else if (etInterestRate.getText().toString().equals("")) {
            etInterestRate.setError("Enter Rate of Return");
            etInterestRate.requestFocus();
            return false;
        }else if (etTenure.getText().toString().equals("")) {
            etTenure.setError("Enter Tenure");
            etTenure.requestFocus();
            return false;
        }
        Double valueOf = Double.valueOf(Double.parseDouble(etPrincipal.getText().toString().replaceAll(",", "")));
        Double valueOf2 = Double.valueOf(Double.parseDouble(etInterestRate.getText().toString()));
        Double valueOf3 = Double.valueOf(Double.parseDouble(etTenure.getText().toString()));

        if (valueOf.doubleValue() <= DOUBLE_EPSILON) {
            etPrincipal.setError("Enter the value more than zero");
            etPrincipal.requestFocus();
            return false;
        } else if (valueOf2.doubleValue() <= DOUBLE_EPSILON || valueOf2.doubleValue() >= 100.0d) {
            etInterestRate.setError("Enter the value between 0.1 to 99.99");
            etInterestRate.requestFocus();
            return false;
        }else if (valueOf3.doubleValue() <= DOUBLE_EPSILON) {
            etTenure.setError("Enter the value more than zero");
            etTenure.requestFocus();
            return false;
        }
        return true;
    }





}