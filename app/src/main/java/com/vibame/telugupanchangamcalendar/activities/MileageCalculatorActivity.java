package com.vibame.telugupanchangamcalendar.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.material.appbar.AppBarLayout;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.source.C3709a;

import java.math.BigDecimal;

public class MileageCalculatorActivity extends AppCompatActivity {



    /* renamed from: b */
    public AppCompatEditText f36511b;

    /* renamed from: c */
    public AppCompatEditText f36512c;

    /* renamed from: d */
    public AppCompatEditText f36513d;

    /* renamed from: e */
    public AppCompatEditText f36514e;

    /* renamed from: f */
    public TextView f36515f;

    /* renamed from: g */
    public TextView f36516g;

    /* renamed from: h */
    public TextView f36517h;

    /* renamed from: i */
    public int f36518i = 0;

    /* renamed from: j */
    public int f36519j = 0;

    /* renamed from: k */
    public Float f36520k;

    /* renamed from: l */
    public Float f36521l;

    /* renamed from: m */
    public Float f36522m;

    /* renamed from: n */
    public Float f36523n;

    /* renamed from: o */
    public Float f36524o;

    /* renamed from: p */
    public C0619z5 f36525p = new C0619z5();

    /* renamed from: q */
    public int f36526q = 0;

    /* renamed from: r */
    public int f36527r = 0;

    /* renamed from: s */
    public BigDecimal f36528s;

    /* renamed from: t */
    public BigDecimal f36529t;

    /* renamed from: u */
    public BigDecimal f36530u;

    /* renamed from: v */
    public LinearLayout f36531v;

    /* renamed from: w */
    public Button f36532w;

    /* renamed from: x */
    public AppBarLayout f36533x;

    /* renamed from: y */
    public Toolbar f36534y;

    ImageView imgBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mileage_calculator);


        StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a.append(this.f36525p.mo2460d(this, "fess_title"));

        StringBuilder a2 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a2.append(this.f36525p.mo2460d(this, "fess_title"));

        imgBack = findViewById(R.id.imgBack);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        this.f36511b = (AppCompatEditText) findViewById(R.id.start_reading);
        this.f36512c = (AppCompatEditText) findViewById(R.id.end_reading);
        this.f36513d = (AppCompatEditText) findViewById(R.id.cnsume_fuel);
        this.f36514e = (AppCompatEditText) findViewById(R.id.Fuel_price);
        this.f36515f = (TextView) findViewById(R.id.calculate);
        this.f36516g = (TextView) findViewById(R.id.btn_clear);
        this.f36517h = (TextView) findViewById(R.id.btn_reset);
        ((CardView) findViewById(R.id.card1)).setCardBackgroundColor(C0530r6.m1145d((Context) this));
        ((CardView) findViewById(R.id.card2)).setCardBackgroundColor(C0530r6.m1145d((Context) this));
        ((CardView) findViewById(R.id.card3)).setCardBackgroundColor(C0530r6.m1145d((Context) this));
        int c = this.f36525p.mo2459c(this, "last_reading");
        this.f36527r = c;
        if (c != 0) {
            AppCompatEditText appCompatEditText = this.f36511b;
            StringBuilder a3 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            a3.append(this.f36527r);
            appCompatEditText.setText(a3.toString());
            this.f36512c.requestFocus();
        } else {
            this.f36511b.requestFocus();
        }
        this.f36515f.setOnClickListener(new C10285a());
        this.f36516g.setOnClickListener(new C10286b());
        this.f36517h.setOnClickListener(new C10287c());
//        this.f36534y.setBackgroundColor(C0530r6.m1145d((Context) this));
//        this.f36533x.setBackgroundColor(C0530r6.m1145d((Context) this));
    }


    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: smart_tools.MileageCalculatorActivity$a */
    public class C10285a implements View.OnClickListener {
        public C10285a() {
        }

        public void onClick(View view) {
            if (C3709a.m6134b(MileageCalculatorActivity.this.f36511b) == 0) {
                C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Start Reading");
            } else if (C3709a.m6131a(MileageCalculatorActivity.this.f36511b, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Start Reading");
            } else if (C3709a.m6131a(MileageCalculatorActivity.this.f36512c, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                C0530r6.m1144c(MileageCalculatorActivity.this, "Enter End Reading");
            } else if (C3709a.m6131a(MileageCalculatorActivity.this.f36513d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Fuel Quantity");
            } else {
                if (C3709a.m6134b(MileageCalculatorActivity.this.f36513d) == 1) {
                    if (C3709a.m6131a(MileageCalculatorActivity.this.f36513d, ".")) {
                        C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Valid Fuel Quantity");
                        return;
                    } else if (C3709a.m6131a(MileageCalculatorActivity.this.f36513d, "0")) {
                        C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Valid Fuel Quantity");
                        return;
                    }
                } else if (C3709a.m6134b(MileageCalculatorActivity.this.f36513d) == 2 && C3709a.m6131a(MileageCalculatorActivity.this.f36513d, ".0")) {
                    C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Valid Fuel Quantity");
                    return;
                }
                if (MileageCalculatorActivity.this.f36513d.length() == 1) {
                    if (C3709a.m6131a(MileageCalculatorActivity.this.f36513d, ".")) {
                        return;
                    }
                } else if (MileageCalculatorActivity.this.f36513d.length() == 2) {
                    if (!C3709a.m6131a(MileageCalculatorActivity.this.f36513d, ".0")) {
                        if (!MileageCalculatorActivity.this.f36513d.getText().toString().contains(".") && Integer.parseInt(MileageCalculatorActivity.this.f36513d.getText().toString()) == 0) {
                            C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Valid Fuel Quantity");
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (C3709a.m6131a(MileageCalculatorActivity.this.f36514e, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                    C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Fuel Cost");
                    return;
                }
                if (C3709a.m6134b(MileageCalculatorActivity.this.f36514e) == 1) {
                    if (C3709a.m6131a(MileageCalculatorActivity.this.f36514e, ".")) {
                        C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Valid Fuel Cost");
                        return;
                    } else if (C3709a.m6131a(MileageCalculatorActivity.this.f36514e, "0")) {
                        C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Valid Fuel Cost");
                        return;
                    }
                } else if (C3709a.m6134b(MileageCalculatorActivity.this.f36514e) == 2 && C3709a.m6131a(MileageCalculatorActivity.this.f36514e, ".0")) {
                    C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Valid Fuel Cost");
                    return;
                }
                if (MileageCalculatorActivity.this.f36514e.getText().toString().contains(".") || Integer.parseInt(MileageCalculatorActivity.this.f36514e.getText().toString()) != 0) {
                    MileageCalculatorActivity fuelcost_Activity = MileageCalculatorActivity.this;
                    fuelcost_Activity.f36518i = Integer.parseInt(fuelcost_Activity.f36511b.getText().toString());
                    MileageCalculatorActivity fuelcost_Activity2 = MileageCalculatorActivity.this;
                    fuelcost_Activity2.f36519j = Integer.parseInt(fuelcost_Activity2.f36512c.getText().toString());
                    MileageCalculatorActivity fuelcost_Activity3 = MileageCalculatorActivity.this;
                    fuelcost_Activity3.f36521l = Float.valueOf(Float.parseFloat(fuelcost_Activity3.f36513d.getText().toString()));
                    MileageCalculatorActivity fuelcost_Activity4 = MileageCalculatorActivity.this;
                    fuelcost_Activity4.f36520k = Float.valueOf(Float.parseFloat(fuelcost_Activity4.f36514e.getText().toString()));
                    MileageCalculatorActivity fuelcost_Activity5 = MileageCalculatorActivity.this;
                    int i = fuelcost_Activity5.f36519j;
                    if (i <= fuelcost_Activity5.f36518i) {
                        C0530r6.m1144c(fuelcost_Activity5, "End reading must greater than start reading");
                        MileageCalculatorActivity.this.f36512c.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                        return;
                    }
                    fuelcost_Activity5.f36525p.mo2455a((Context) fuelcost_Activity5, "last_reading", i);
                    MileageCalculatorActivity fuelcost_Activity6 = MileageCalculatorActivity.this;
                    int i2 = fuelcost_Activity6.f36519j - fuelcost_Activity6.f36518i;
                    fuelcost_Activity6.f36526q = i2;
                    fuelcost_Activity6.f36522m = Float.valueOf(((float) i2) / fuelcost_Activity6.f36521l.floatValue());
                    MileageCalculatorActivity fuelcost_Activity7 = MileageCalculatorActivity.this;
                    fuelcost_Activity7.f36523n = Float.valueOf(fuelcost_Activity7.f36520k.floatValue() / ((float) MileageCalculatorActivity.this.f36526q));
                    MileageCalculatorActivity fuelcost_Activity8 = MileageCalculatorActivity.this;
                    fuelcost_Activity8.f36524o = Float.valueOf(fuelcost_Activity8.f36520k.floatValue() / MileageCalculatorActivity.this.f36521l.floatValue());
                    MileageCalculatorActivity fuelcost_Activity9 = MileageCalculatorActivity.this;
                    fuelcost_Activity9.f36528s = MileageCalculatorActivity.m21254a(fuelcost_Activity9.f36523n.floatValue(), 2);
                    MileageCalculatorActivity fuelcost_Activity10 = MileageCalculatorActivity.this;
                    fuelcost_Activity10.f36529t = MileageCalculatorActivity.m21254a(fuelcost_Activity10.f36524o.floatValue(), 2);
                    MileageCalculatorActivity fuelcost_Activity11 = MileageCalculatorActivity.this;
                    fuelcost_Activity11.f36530u = MileageCalculatorActivity.m21254a(fuelcost_Activity11.f36522m.floatValue(), 2);
                    MileageCalculatorActivity fuelcost_Activity12 = MileageCalculatorActivity.this;
                    if (fuelcost_Activity12 != null) {

                        Dialog dialog=new Dialog(MileageCalculatorActivity.this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                        dialog.setContentView(R.layout.fuelresultnew_dialog);
                        fuelcost_Activity12.f36532w = (Button) dialog.findViewById(R.id.ok);
                        fuelcost_Activity12.f36531v = (LinearLayout) dialog.findViewById(R.id.sharelayout);
                        dialog.show();
                        String num = Integer.toString(fuelcost_Activity12.f36518i);
                        String num2 = Integer.toString(fuelcost_Activity12.f36519j);
                        String f = Float.toString(fuelcost_Activity12.f36521l.floatValue());
                        String f2 = Float.toString(fuelcost_Activity12.f36520k.floatValue());
                        String num3 = Integer.toString(fuelcost_Activity12.f36526q);
                        String valueOf = String.valueOf(fuelcost_Activity12.f36530u);
                        Dialog dialog2 = dialog;
                        String valueOf2 = String.valueOf(fuelcost_Activity12.f36528s);
                        TextView textView = (TextView) dialog.findViewById(R.id.set_costperltr);
                        String valueOf3 = String.valueOf(fuelcost_Activity12.f36529t);
                        ((TextView) dialog.findViewById(R.id.set_sdistance)).setText(num);
                        ((TextView) dialog.findViewById(R.id.set_edistance)).setText(num2);
                        ((TextView) dialog.findViewById(R.id.set_fquantity)).setText(f);
                        ((TextView) dialog.findViewById(R.id.set_fcost)).setText(f2);
                        ((TextView) dialog.findViewById(R.id.set_totalkm)).setText(num3);
                        ((TextView) dialog.findViewById(R.id.set_mileage)).setText(valueOf);
                        ((TextView) dialog.findViewById(R.id.set_costperkm)).setText(valueOf2);
                        textView.setText(valueOf3);
                        fuelcost_Activity12.f36532w.setOnClickListener(new C10237j(fuelcost_Activity12, dialog2));
                        return;
                    }
                    throw null;
                }
                C0530r6.m1144c(MileageCalculatorActivity.this, "Enter Valid Fuel Cost");
            }
        }
    }

    /* renamed from: smart_tools.MileageCalculatorActivity$b */
    public class C10286b implements View.OnClickListener {
        public C10286b() {
        }

        public void onClick(View view) {
            MileageCalculatorActivity fuelcost_Activity = MileageCalculatorActivity.this;
            if (fuelcost_Activity.f36527r == 0 || fuelcost_Activity.f36511b.getText().toString().isEmpty()) {
                MileageCalculatorActivity.this.f36511b.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                MileageCalculatorActivity.this.f36512c.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                MileageCalculatorActivity.this.f36513d.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                MileageCalculatorActivity.this.f36514e.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                MileageCalculatorActivity.this.f36511b.requestFocus();
                return;
            }
            MileageCalculatorActivity.this.f36512c.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            MileageCalculatorActivity.this.f36513d.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            MileageCalculatorActivity.this.f36514e.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            MileageCalculatorActivity.this.f36512c.requestFocus();
        }
    }

    /* renamed from: smart_tools.MileageCalculatorActivity$c */
    public class C10287c implements View.OnClickListener {
        public C10287c() {
        }

        public void onClick(View view) {
            MileageCalculatorActivity.this.f36511b.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            MileageCalculatorActivity.this.f36512c.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            MileageCalculatorActivity.this.f36513d.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            MileageCalculatorActivity.this.f36514e.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            MileageCalculatorActivity.this.f36511b.requestFocus();
            MileageCalculatorActivity fuelcost_Activity = MileageCalculatorActivity.this;
            fuelcost_Activity.f36525p.mo2455a((Context) fuelcost_Activity, "last_reading", 0);
        }
    }

    /* renamed from: a */
    public static BigDecimal m21254a(float f, int i) {
        return new BigDecimal(Float.toString(f)).setScale(i, 4);
    }
}