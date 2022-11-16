package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.material.appbar.AppBarLayout;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.source.C2940d;
import com.vibame.telugupanchangamcalendar.source.C3709a;

import java.io.File;
import java.io.PrintStream;

public class EMICalculatorActivity extends AppCompatActivity {
    /* renamed from: b */
    public EditText f2318b;

    /* renamed from: c */
    public EditText f2319c;

    /* renamed from: d */
    public EditText f2320d;



    /* renamed from: f */
    public WebView f2322f;

    /* renamed from: g */
    public ScrollView f2323g;

    /* renamed from: h */
    public RelativeLayout f2324h;

    /* renamed from: i */
    public Button f2325i;

    /* renamed from: j */
    public RadioGroup f2326j;

    /* renamed from: k */
    public int f2327k = 1;

    /* renamed from: l */
    public String f2328l = "Enter Number Of Years";

    /* renamed from: m */
    public String f2329m = "Number Of Years";
    /* renamed from: o */
    public long f2331o;



    /* renamed from: r */
    public LinearLayout f2334r;

    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emicalculator);


        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.sharemainlayy);
        this.f2334r = linearLayout;
        linearLayout.setVisibility(View.GONE);
        this.f2318b = (EditText) findViewById(R.id.e_principal);
        this.f2319c = (EditText) findViewById(R.id.e_intrest);
        this.f2320d = (EditText) findViewById(R.id.e_time);
        this.f2325i = (Button) findViewById(R.id.calculate);
        this.f2326j = (RadioGroup) findViewById(R.id.radio_time);
        this.f2324h = (RelativeLayout) findViewById(R.id.result_relative);
        this.f2323g = (ScrollView) findViewById(R.id.scroll);
        this.f2326j.setOnCheckedChangeListener(new C0654a());
        this.f2318b.addTextChangedListener(new C0655b());
        this.f2319c.addTextChangedListener(new C0656c());
        this.f2320d.addTextChangedListener(new C0657d());
        this.f2325i.setOnClickListener(new C0658e());

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ads_lay);
//        if (this.f2330n.mo2459c(this, "Main_Daily_Click") == 1) {
//            this.f2330n.mo2458b(this, "add_remove").booleanValue();
//        }

    }
    public class C0654a implements RadioGroup.OnCheckedChangeListener {
        public C0654a() {
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.radio_years) {
                EMICalculatorActivity EMICalculatorActivity = EMICalculatorActivity.this;
                EMICalculatorActivity.f2327k = 1;
                EMICalculatorActivity.f2320d.setHint("Number of Years");
                EMICalculatorActivity EMICalculatorActivity2 = EMICalculatorActivity.this;
                EMICalculatorActivity2.f2328l = "Enter Number Of Years";
                EMICalculatorActivity2.f2329m = "Number Of Years";
                EMICalculatorActivity2.f2324h.removeAllViews();
                EMICalculatorActivity.this.f2334r.setVisibility(View.GONE);
            } else if (i == R.id.radio_months) {
                EMICalculatorActivity EMICalculatorActivity3 = EMICalculatorActivity.this;
                EMICalculatorActivity3.f2327k = 2;
                EMICalculatorActivity3.f2320d.setHint("Number of Months");
                EMICalculatorActivity EMICalculatorActivity4 = EMICalculatorActivity.this;
                EMICalculatorActivity4.f2328l = "Enter Number Of Months";
                EMICalculatorActivity4.f2329m = "Number Of Months";
                EMICalculatorActivity4.f2324h.removeAllViews();
                EMICalculatorActivity.this.f2334r.setVisibility(View.GONE);
            }
        }
    }

    /* renamed from: calculator.EMICalculatorActivity$b */
    public class C0655b implements TextWatcher {
        public C0655b() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EMICalculatorActivity.this.f2324h.removeAllViews();
            EMICalculatorActivity.this.f2334r.setVisibility(View.GONE);
        }
    }

    /* renamed from: calculator.EMICalculatorActivity$c */
    public class C0656c implements TextWatcher {
        public C0656c() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EMICalculatorActivity.this.f2324h.removeAllViews();
            EMICalculatorActivity.this.f2334r.setVisibility(View.GONE);
        }
    }

    /* renamed from: calculator.EMICalculatorActivity$d */
    public class C0657d implements TextWatcher {
        public C0657d() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EMICalculatorActivity.this.f2324h.removeAllViews();
            EMICalculatorActivity.this.f2334r.setVisibility(View.GONE);
        }
    }

    /* renamed from: calculator.EMICalculatorActivity$e */
    public class C0658e implements View.OnClickListener {
        public C0658e() {
        }

        public void onClick(View view) {
            String str;
            float f;
            float f2;
            String str2;
            String str3;
            if (C3709a.m6150d(EMICalculatorActivity.this.f2318b) > 10 || EMICalculatorActivity.this.f2318b.getText().toString().trim().length() == 0 || EMICalculatorActivity.this.f2318b.getText().toString().equals(".") || ((double) C3709a.m6062a(EMICalculatorActivity.this.f2318b)) < 0.01d) {
                EMICalculatorActivity.this.f2318b.requestFocus();
                Toast.makeText(EMICalculatorActivity.this, "Enter Principal Amount", Toast.LENGTH_SHORT).show();
            } else if (C3709a.m6150d(EMICalculatorActivity.this.f2319c) > 5 || EMICalculatorActivity.this.f2319c.getText().toString().trim().length() == 0 || EMICalculatorActivity.this.f2319c.getText().toString().equals(".") || ((double) C3709a.m6062a(EMICalculatorActivity.this.f2319c)) < 0.01d) {
                EMICalculatorActivity.this.f2319c.requestFocus();
                Toast.makeText(EMICalculatorActivity.this, "Enter Annual Interest Rate in (%)", Toast.LENGTH_SHORT).show();
            } else if (C3709a.m6150d(EMICalculatorActivity.this.f2320d) > 3 || EMICalculatorActivity.this.f2320d.getText().toString().trim().length() == 0 || EMICalculatorActivity.this.f2320d.getText().toString().equals(".") || ((double) C3709a.m6062a(EMICalculatorActivity.this.f2320d)) < 0.01d) {
                EMICalculatorActivity.this.f2320d.requestFocus();
                EMICalculatorActivity EMICalculatorActivity = EMICalculatorActivity.this;
                StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                a.append(EMICalculatorActivity.this.f2328l);
                Toast.makeText(EMICalculatorActivity, a.toString(), Toast.LENGTH_SHORT).show();
            } else {
                float a2 = C3709a.m6062a(EMICalculatorActivity.this.f2318b);
                float a3 = C3709a.m6062a(EMICalculatorActivity.this.f2319c);
                float a4 = C3709a.m6062a(EMICalculatorActivity.this.f2320d);
                int i = EMICalculatorActivity.this.f2327k;
                if (i != 2 && i == 1) {
                    a4 *= 12.0f;
                }
                if (a4 < 12.0f) {
                    str = "<tr><th>EMI</th><th>Payment to Interest</th><th>Payment to Principal</th><th>Left Principal</th></tr>" + "<tr><td colspan=4 bgcolor=#F0AF00 style=color:#FFFFFF;><b>Year " + 1 + " (" + a4 + " Terms)</td></tr>";
                } else {
                    str = "<tr><th>EMI</th><th>Payment to Interest</th><th>Payment to Principal</th><th>Left Principal</th></tr>" + "<tr><td colspan=4 bgcolor=#F0AF00 style=color:#FFFFFF;><b>Year " + 1 + " (12 Terms)</td></tr>";
                }
                float f3 = (a3 / 100.0f) / 12.0f;
                double d = (double) (f3 * a2);
                String str4 = str;
                Double.isNaN(d);
                float pow = (float) (d / (1.0d - Math.pow((double) (1.0f + f3), (double) (-a4))));
                String str5 = str4;
                float f4 = a2;
                int i2 = 1;
                int i3 = 2;
                int i4 = 1;
                float f5 = 0.0f;
                while (true) {
                    float f6 = (float) i2;
                    if (f6 > a4) {
                        break;
                    }
                    float f7 = f4 * f3;
                    float f8 = pow - f7;
                    float f9 = f5 + f7;
                    f4 -= f8;
                    if (f4 < 5.0f) {
                        f4 = 0.0f;
                    }
                    float f10 = f3;
                    if (i4 % 2 != 0) {
                        f2 = f9;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str5);
                        sb.append("<tr><td>");
                        sb.append(i4);
                        sb.append("</td><td>₹ ");
                        f = a2;
                        C3709a.m6142b("%.2f", new Object[]{Float.valueOf(f7)}, sb, "</td><td>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{Float.valueOf(f8)}, sb, "</td><td>₹ ");
                        str2 = C3709a.m6085a("%.2f", new Object[]{Float.valueOf(f4)}, sb, "</td></tr>");
                    } else {
                        f = a2;
                        f2 = f9;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str5);
                        sb2.append("<tr bgcolor=#808080><td>");
                        sb2.append(i4);
                        sb2.append("</td><td>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{Float.valueOf(f7)}, sb2, "</td><td>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{Float.valueOf(f8)}, sb2, "</td><td>₹ ");
                        str2 = C3709a.m6085a("%.2f", new Object[]{Float.valueOf(f4)}, sb2, "</td></tr>");
                    }
                    i4++;
                    if (f6 == a4 || i2 % 12 != 0) {
                        str5 = str2;
                    } else {
                        int i5 = ((int) a4) - i2;
                        if (i5 < 12) {
                            str3 = i5 + " Terms";
                        } else {
                            str3 = "12 Terms";
                        }
                        i3++;
                        str5 = str2 + "<tr><td colspan=4 bgcolor=#F0AF00 style=color:#FFFFFF;><b>Year " + i3 + " (" + str3 + ")</td></tr>";
                        i4 = 1;
                    }
                    i2++;
                    f3 = f10;
                    f5 = f2;
                    a2 = f;
                }
                float f11 = a2;
                StringBuilder a5 = C3709a.m6100a("<tr><td colspan=3 style=font-size:16px;><b>Monthly EMI Amount</td><td style=font-size:16px;><b>₹ ");
                C3709a.m6142b("%.2f", new Object[]{Float.valueOf(pow)}, a5, "</td></tr><tr><td colspan=3><b>Loan Amount</td><td><b>₹ ");
                C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(EMICalculatorActivity.this.f2318b)}, a5, "</td></tr><tr><td colspan=3><b>Total Interest</td><td><b>₹ ");
                C3709a.m6142b("%.2f", new Object[]{Float.valueOf(f5)}, a5, "</td></tr><tr><td colspan=3><b>Total Payable Amount</td><td><b>₹ ");
                C3709a.m6142b("%.2f", new Object[]{Float.valueOf(f5 + f11)}, a5, "</td></tr><tr><td colspan=3><b>Annual Interest</td><td><b>");
                C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(EMICalculatorActivity.this.f2319c)}, a5, " %</td></tr><tr><td colspan=3><b>");
                a5.append(EMICalculatorActivity.this.f2329m);
                a5.append("</td><td><b>");
                a5.append(EMICalculatorActivity.this.f2320d.getText().toString());
                a5.append("</td></tr>");
                String a6 = C3709a.m6084a("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;} </style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px><b>EMI Calculation</caption>", a5.toString(), C3709a.m6137b(str5, "</table></body></html>"));
                EMICalculatorActivity EMICalculatorActivity2 = EMICalculatorActivity.this;
                EMICalculatorActivity2.f2324h.removeAllViews();
                View inflate = ((LayoutInflater) EMICalculatorActivity2.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.share_print, (ViewGroup) null);
                EMICalculatorActivity2.f2334r.setVisibility(0);
                EMICalculatorActivity2.f2324h.addView(inflate);
                EMICalculatorActivity2.f2322f = (WebView) inflate.findViewById(R.id.anspart);
                EMICalculatorActivity2.f2322f.getSettings().setJavaScriptEnabled(true);
                EMICalculatorActivity2.f2322f.setWebChromeClient(new WebChromeClient());
                EMICalculatorActivity2.f2322f.getSettings().setAppCacheEnabled(true);
                EMICalculatorActivity2.f2322f.setWebViewClient(new C2940d(EMICalculatorActivity2));
                EMICalculatorActivity2.f2322f.loadDataWithBaseURL("same://ur/l/tat/does/not/work/emi", a6, "text/html", "UTF-View.GONE", (String) null);
            }
            EMICalculatorActivity.this.f2320d.requestFocus();
            ((InputMethodManager) EMICalculatorActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(EMICalculatorActivity.this.getCurrentFocus().getWindowToken(), 0);
        }
    }



    public void onBackPressed() {
        finish();
    }



    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }


    public void onResume() {
        super.onResume();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ads_lay);
//        if (this.f2330n.mo2459c(this, "Main_Daily_Click") != 1) {
//            this.f2330n.mo2458b(this, "add_remove").booleanValue();
//        }
    }
}
