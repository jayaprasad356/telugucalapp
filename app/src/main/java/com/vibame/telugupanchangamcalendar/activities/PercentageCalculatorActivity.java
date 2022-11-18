package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.source.C3709a;

import java.text.DecimalFormat;

public class PercentageCalculatorActivity extends AppCompatActivity {


    /* renamed from: b */
    public TextInputLayout f36570b;

    /* renamed from: c */
    public TextInputLayout f36571c;

    /* renamed from: d */
    public TextInputEditText f36572d;

    /* renamed from: e */
    public TextInputEditText f36573e;

    /* renamed from: f */
    public TextInputEditText f36574f;

    /* renamed from: g */
    public int f36575g = 0;

    /* renamed from: h */
    public TextView f36576h;

    /* renamed from: i */
    public Toolbar f36577i;

    /* renamed from: j */
    public C0619z5 f36578j;

    /* renamed from: k */
    public AppBarLayout f36579k;


    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage_calculator);




        this.f36578j = new C0619z5();
        this.f36572d = (TextInputEditText) findViewById(R.id.ed_total_price);
        this.f36570b = (TextInputLayout) findViewById(R.id.ed_decress_value_lay);
        this.f36571c = (TextInputLayout) findViewById(R.id.txt_final_value_lay);
        this.f36573e = (TextInputEditText) findViewById(R.id.ed_discount_price);
        this.f36574f = (TextInputEditText) findViewById(R.id.ed_discount_percentage);
        this.f36576h = (TextView) findViewById(R.id.txt_finalvalue);

        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });







        StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a.append(this.f36578j.mo2460d(this, "fess_title"));

        StringBuilder a2 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a2.append(this.f36578j.mo2460d(this, "fess_title"));

        this.f36573e.setOnTouchListener(new C10294a());
        this.f36574f.setOnTouchListener(new C10295b());
        this.f36572d.addTextChangedListener(new C10296c());
        this.f36573e.addTextChangedListener(new C10297d());
        this.f36574f.addTextChangedListener(new C10298e());
        ((CardView) findViewById(R.id.but_card)).setCardBackgroundColor(C0530r6.m1145d((Context) this));
        ((Button) findViewById(R.id.btncalculate)).setOnClickListener(new C10299f());
//        this.f36577i.setBackgroundColor(C0530r6.m1145d((Context) this));
//        this.f36579k.setBackgroundColor(C0530r6.m1145d((Context) this));
    }



    /* renamed from: smart_tools.PercentageCalculatorActivity$a */
    public class C10294a implements View.OnTouchListener {
        public C10294a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            PercentageCalculatorActivity percentage_Activity = PercentageCalculatorActivity.this;
            percentage_Activity.f36575g = 1;
            if (percentage_Activity.f36572d.getText().toString().length() != 0) {
                return false;
            }
            C0530r6.m1144c(PercentageCalculatorActivity.this, "Please Enter the Total Price");
            return true;
        }
    }

    /* renamed from: smart_tools.PercentageCalculatorActivity$b */
    public class C10295b implements View.OnTouchListener {
        public C10295b() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            PercentageCalculatorActivity percentage_Activity = PercentageCalculatorActivity.this;
            percentage_Activity.f36575g = 2;
            if (percentage_Activity.f36572d.getText().toString().length() != 0) {
                return false;
            }
            C0530r6.m1144c(PercentageCalculatorActivity.this, "Please Enter the Total Price");
            return true;
        }
    }

    /* renamed from: smart_tools.PercentageCalculatorActivity$c */
    public class C10296c implements TextWatcher {
        public C10296c() {
        }

        public void afterTextChanged(Editable editable) {
            PercentageCalculatorActivity.this.f36572d.getText().toString().length();
            if (PercentageCalculatorActivity.this.f36572d.getText().toString().length() == 0) {
                PercentageCalculatorActivity.this.f36574f.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                PercentageCalculatorActivity.this.f36573e.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                PercentageCalculatorActivity.this.f36576h.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            }
            if (PercentageCalculatorActivity.this.f36572d.length() == 1) {
                if (PercentageCalculatorActivity.this.f36572d.getText().toString().equals(".")) {
                    return;
                }
            } else if (PercentageCalculatorActivity.this.f36572d.length() == 2 && (PercentageCalculatorActivity.this.f36572d.getText().toString().contains(".") || PercentageCalculatorActivity.this.f36572d.getText().toString().equals(".0") || Integer.parseInt(PercentageCalculatorActivity.this.f36572d.getText().toString()) == 0)) {
                return;
            }
            if (!PercentageCalculatorActivity.this.f36572d.getText().toString().contains("NaN") && !PercentageCalculatorActivity.this.f36572d.getText().toString().contains("Na") && !PercentageCalculatorActivity.this.f36572d.getText().toString().contains("N")) {
                PercentageCalculatorActivity percentage_Activity = PercentageCalculatorActivity.this;
                int i = percentage_Activity.f36575g;
                if (i == 1) {
                    if (percentage_Activity.f36572d.getText().toString().length() != 0) {
                        if (PercentageCalculatorActivity.this.f36573e.getText().toString().length() == 0) {
                            PercentageCalculatorActivity.this.f36574f.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                            PercentageCalculatorActivity.this.f36576h.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                            return;
                        }
                        double parseDouble = Double.parseDouble(PercentageCalculatorActivity.this.f36572d.getText().toString());
                        double parseDouble2 = Double.parseDouble(PercentageCalculatorActivity.this.f36573e.getText().toString());
                        TextInputEditText textInputEditText = PercentageCalculatorActivity.this.f36574f;
                        StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                        a.append(PercentageCalculatorActivity.this.mo23215a(100.0d / (parseDouble / parseDouble2)));
                        a.append(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                        textInputEditText.setText(a.toString());
                        TextView textView = PercentageCalculatorActivity.this.f36576h;
                        StringBuilder a2 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                        a2.append(PercentageCalculatorActivity.this.mo23215a(parseDouble - parseDouble2));
                        a2.append(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                        textView.setText(a2.toString());
                    }
                } else if (i == 2 && percentage_Activity.f36572d.getText().toString().length() != 0) {
                    if (PercentageCalculatorActivity.this.f36574f.getText().toString().length() == 0) {
                        PercentageCalculatorActivity.this.f36573e.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                        PercentageCalculatorActivity.this.f36576h.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                        return;
                    }
                    double parseDouble3 = Double.parseDouble(PercentageCalculatorActivity.this.f36572d.getText().toString());
                    double parseDouble4 = (parseDouble3 / 100.0d) * Double.parseDouble(PercentageCalculatorActivity.this.f36574f.getText().toString());
                    TextInputEditText textInputEditText2 = PercentageCalculatorActivity.this.f36573e;
                    StringBuilder a3 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    a3.append(PercentageCalculatorActivity.this.mo23215a(parseDouble4));
                    textInputEditText2.setText(a3.toString());
                    double parseDouble5 = parseDouble3 - Double.parseDouble(PercentageCalculatorActivity.this.f36573e.getText().toString());
                    TextView textView2 = PercentageCalculatorActivity.this.f36576h;
                    StringBuilder a4 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    a4.append(PercentageCalculatorActivity.this.mo23215a(parseDouble5));
                    a4.append(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    textView2.setText(a4.toString());
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: smart_tools.PercentageCalculatorActivity$d */
    public class C10297d implements TextWatcher {
        public C10297d() {
        }

        public void afterTextChanged(Editable editable) {
            PercentageCalculatorActivity percentage_Activity = PercentageCalculatorActivity.this;
            if (percentage_Activity.f36575g != 1) {
                return;
            }
            if (percentage_Activity.f36572d.getText().toString().length() == 0) {
                C0530r6.m1144c(PercentageCalculatorActivity.this, "Please Enter the Total Price");
            } else if (PercentageCalculatorActivity.this.f36573e.getText().toString().length() == 0) {
                PercentageCalculatorActivity.this.f36574f.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                PercentageCalculatorActivity.this.f36576h.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            } else {
                if (PercentageCalculatorActivity.this.f36573e.length() == 1) {
                    if (PercentageCalculatorActivity.this.f36573e.getText().toString().equals(".")) {
                        return;
                    }
                } else if (PercentageCalculatorActivity.this.f36573e.length() == 2 && (PercentageCalculatorActivity.this.f36573e.getText().toString().contains(".") || PercentageCalculatorActivity.this.f36573e.getText().toString().equals(".0") || Integer.parseInt(PercentageCalculatorActivity.this.f36573e.getText().toString()) == 0)) {
                    return;
                }
                if (PercentageCalculatorActivity.this.f36572d.length() == 1) {
                    if (PercentageCalculatorActivity.this.f36572d.getText().toString().equals(".")) {
                        return;
                    }
                } else if (PercentageCalculatorActivity.this.f36572d.length() == 2 && (PercentageCalculatorActivity.this.f36572d.getText().toString().equals(".0") || Integer.parseInt(PercentageCalculatorActivity.this.f36572d.getText().toString()) == 0)) {
                    return;
                }
                if (!PercentageCalculatorActivity.this.f36574f.getText().toString().contains("NaN") && !PercentageCalculatorActivity.this.f36574f.getText().toString().contains("Na") && !PercentageCalculatorActivity.this.f36574f.getText().toString().contains("N")) {
                    double parseDouble = Double.parseDouble(PercentageCalculatorActivity.this.f36572d.getText().toString());
                    double parseDouble2 = Double.parseDouble(PercentageCalculatorActivity.this.f36573e.getText().toString());
                    TextInputEditText textInputEditText = PercentageCalculatorActivity.this.f36574f;
                    StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    a.append(PercentageCalculatorActivity.this.mo23215a(100.0d / (parseDouble / parseDouble2)));
                    a.append(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    textInputEditText.setText(a.toString());
                    double d = parseDouble - parseDouble2;
                    TextView textView = PercentageCalculatorActivity.this.f36576h;
                    StringBuilder a2 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    a2.append(PercentageCalculatorActivity.this.mo23215a(d));
                    a2.append(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    textView.setText(a2.toString());
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: smart_tools.PercentageCalculatorActivity$e */
    public class C10298e implements TextWatcher {
        public C10298e() {
        }

        public void afterTextChanged(Editable editable) {
            PercentageCalculatorActivity percentage_Activity = PercentageCalculatorActivity.this;
            if (percentage_Activity.f36575g != 2) {
                return;
            }
            if (percentage_Activity.f36572d.getText().toString().length() == 0) {
                C0530r6.m1144c(PercentageCalculatorActivity.this, "Please Enter the Total Price");
            } else if (PercentageCalculatorActivity.this.f36574f.getText().toString().length() == 0) {
                PercentageCalculatorActivity.this.f36573e.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                PercentageCalculatorActivity.this.f36576h.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            } else {
                if (PercentageCalculatorActivity.this.f36573e.length() == 1) {
                    if (PercentageCalculatorActivity.this.f36573e.getText().toString().equals(".")) {
                        return;
                    }
                } else if (PercentageCalculatorActivity.this.f36573e.length() == 2) {
                    if (!PercentageCalculatorActivity.this.f36573e.getText().toString().equals(".0")) {
                        if (!PercentageCalculatorActivity.this.f36573e.getText().toString().contains(".") && Integer.parseInt(PercentageCalculatorActivity.this.f36573e.getText().toString()) == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (PercentageCalculatorActivity.this.f36572d.length() == 1) {
                    if (PercentageCalculatorActivity.this.f36572d.getText().toString().equals(".")) {
                        return;
                    }
                } else if (PercentageCalculatorActivity.this.f36572d.length() == 2 && (PercentageCalculatorActivity.this.f36572d.getText().toString().equals(".0") || Integer.parseInt(PercentageCalculatorActivity.this.f36572d.getText().toString()) == 0)) {
                    return;
                }
                if ((PercentageCalculatorActivity.this.f36574f.length() != 1 || !PercentageCalculatorActivity.this.f36574f.getText().toString().equals(".")) && !PercentageCalculatorActivity.this.f36574f.getText().toString().contains("NaN") && !PercentageCalculatorActivity.this.f36574f.getText().toString().contains("Na") && !PercentageCalculatorActivity.this.f36574f.getText().toString().contains("N")) {
                    double parseDouble = Double.parseDouble(PercentageCalculatorActivity.this.f36572d.getText().toString());
                    double parseDouble2 = (parseDouble / 100.0d) * Double.parseDouble(PercentageCalculatorActivity.this.f36574f.getText().toString());
                    TextInputEditText textInputEditText = PercentageCalculatorActivity.this.f36573e;
                    StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    a.append(PercentageCalculatorActivity.this.mo23215a(parseDouble2));
                    textInputEditText.setText(a.toString());
                    double parseDouble3 = parseDouble - Double.parseDouble(PercentageCalculatorActivity.this.f36573e.getText().toString());
                    TextView textView = PercentageCalculatorActivity.this.f36576h;
                    StringBuilder a2 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    a2.append(PercentageCalculatorActivity.this.mo23215a(parseDouble3));
                    a2.append(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    textView.setText(a2.toString());
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: smart_tools.PercentageCalculatorActivity$f */
    public class C10299f implements View.OnClickListener {
        public C10299f() {
        }

        public void onClick(View view) {
        }
    }

    /* renamed from: a */
    public double mo23215a(double d) {
        return Double.valueOf(new DecimalFormat("#.##").format(d)).doubleValue();
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.f36578j.mo2459c(this, "Main_Daily_Click") == 1) {
            finish();
            onBackPressed();
            return;
        }
        finish();
    }
}