package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.material.appbar.AppBarLayout;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.source.C3709a;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;

public class GstCalulatorActivity extends AppCompatActivity {



    /* renamed from: b */
    public String[] f2344b = {"Select GST Rate", "GST 0.25%", "GST 3%", "GST 5%", "GST 12%", "GST 18%", "GST 28%", "Custom GST Rate"};

    /* renamed from: c */
    public EditText f2345c;

    /* renamed from: d */
    public EditText f2346d;

    /* renamed from: e */
    public WebView f2347e;

    /* renamed from: f */
    public RelativeLayout f2348f;

    /* renamed from: g */
    public RadioGroup f2349g;

    /* renamed from: h */
    public int f2350h = 1;

    /* renamed from: i */
    public Spinner f2351i;

    /* renamed from: j */
    public ScrollView f2352j;

    /* renamed from: k */
    public RelativeLayout f2353k;

    /* renamed from: l */
    public C0619z5 f2354l = new C0619z5();

    /* renamed from: m */
    public long f2355m;

    /* renamed from: n */
    public Toolbar f2356n;

    /* renamed from: o */
    public AppBarLayout f2357o;

    /* renamed from: p */
    public Button f2358p;

    /* renamed from: q */
    public LinearLayout f2359q;

    ImageView imgBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst_calulator);

        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());


        imgBack = findViewById(R.id.imgBack);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });





        StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a.append(this.f2354l.mo2460d(this, "fess_title"));

        StringBuilder a2 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a2.append(this.f2354l.mo2460d(this, "fess_title"));

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.sharemainlayy);
        this.f2359q = linearLayout;
        linearLayout.setVisibility(View.GONE);
        this.f2345c = (EditText) findViewById(R.id.e_principal_gst);
        this.f2346d = (EditText) findViewById(R.id.custom_gst);
        this.f2349g = (RadioGroup) findViewById(R.id.radio_gst);
        this.f2358p = (Button) findViewById(R.id.calculate_gst);
        this.f2353k = (RelativeLayout) findViewById(R.id.rel_gst);
        this.f2352j = (ScrollView) findViewById(R.id.scroll);
        this.f2348f = (RelativeLayout) findViewById(R.id.result_relative);
        this.f2349g.setOnCheckedChangeListener(new C0663b());
        this.f2345c.addTextChangedListener(new C0664c());
        this.f2346d.addTextChangedListener(new C0665d());
        this.f2351i = (Spinner) findViewById(R.id.spinner_id_gst);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, f2344b);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        this.f2351i.setAdapter(arrayAdapter);
        this.f2351i.setOnItemSelectedListener(new C0666e());
        this.f2358p.setOnClickListener(new C0667f());
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ads_lay);
        if (this.f2354l.mo2459c(this, "Main_Daily_Click") == 1) {
            this.f2354l.mo2458b(this, "add_remove").booleanValue();
        }
        ((CardView) findViewById(R.id.but_card)).setCardBackgroundColor(C0530r6.m1145d((Context) this));
        ((CardView) findViewById(R.id.card1)).setCardBackgroundColor(C0530r6.m1145d((Context) this));
        ((CardView) findViewById(R.id.card2)).setCardBackgroundColor(C0530r6.m1145d((Context) this));
        ((RelativeLayout) findViewById(R.id.relative_head)).setBackgroundColor(C0530r6.m1145d((Context) this));
//        this.f2356n.setBackgroundColor(C0530r6.m1145d((Context) this));
//        this.f2357o.setBackgroundColor(C0530r6.m1145d((Context) this));


    }


    /* renamed from: calculator.GstCalulatorActivity$a */
    public class C0661a implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ String f2360b;

        /* renamed from: c */
        public final /* synthetic */ int f2361c;

        /* renamed from: calculator.GstCalulatorActivity$a$a */
        public class C0662a implements Runnable {
            public C0662a() {
            }

            public void run() {
                ScrollView scrollView = GstCalulatorActivity.this.f2352j;
                scrollView.scrollTo(0, scrollView.getBottom());
            }
        }

        public C0661a(String str, int i) {
            this.f2360b = str;
            this.f2361c = i;
        }

        public void onClick(View view) {
            GstCalulatorActivity.this.f2347e.loadDataWithBaseURL("same://ur/l/tat/does/fine/work/work", "data", "text/html", "utf-8", (String) null);
            int round = Math.round(Float.valueOf(Float.parseFloat(this.f2360b)).floatValue());
            if (round % 5 != 0) {
                int i = round % 10;
                if (i >= 3) {
                    if (i >= 3 && i < 5) {
                        round += 5 - i;
                    } else if (i < 8) {
                        i -= 5;
                    } else if (i >= 8) {
                        round += 10 - i;
                    }
                }
                round -= i;
            }
            Float valueOf = Float.valueOf(Float.parseFloat(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED + round) / 2.0f);
            String str = "<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>";
            int i2 = this.f2361c;
            if (i2 == 1) {
                StringBuilder c = C3709a.m6148c(str, "<tr><td>Purchase Amount</td><td>₹ ");
                C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c, "<tr><td>SGST</td><td>₹ ");
                C3709a.m6142b("%.3f", new Object[]{valueOf}, c, "</td></tr><tr><td>CGST</td><td>₹ ");
                c.append(String.format("%.3f", new Object[]{valueOf}));
                c.append("</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                c.append(round);
                c.append(".00</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                str = C3709a.m6085a("%.2f", new Object[]{Float.valueOf(Float.parseFloat(GstCalulatorActivity.this.f2345c.getText().toString()) + ((float) round))}, c, "</td></tr>");
            } else if (i2 == 2) {
                StringBuilder c2 = C3709a.m6148c(str, "<tr><td>Purchase Amount</td><td>₹ ");
                C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c2, "<tr><td>SGST</td><td>₹ ");
                C3709a.m6142b("%.3f", new Object[]{valueOf}, c2, "</td></tr><tr><td>CGST</td><td>₹ ");
                c2.append(String.format("%.3f", new Object[]{valueOf}));
                c2.append("</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                c2.append(round);
                c2.append(".00</td></tr><tr><td>Amount Without GST</td><td>₹ ");
                C3709a.m6142b("%.2f", new Object[]{Float.valueOf(C3709a.m6062a(GstCalulatorActivity.this.f2345c) - ((float) round))}, c2, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                str = C3709a.m6085a("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c2, "</td></tr>");
            }
            GstCalulatorActivity.this.f2347e.loadDataWithBaseURL("same://ur/l/tat/does/not/work", C3709a.m6137b(str, "</table></body></html>"), "text/html", "utf-8", (String) null);
            GstCalulatorActivity.this.f2352j.post(new C0662a());
        }
    }

    /* renamed from: calculator.GstCalulatorActivity$b */
    public class C0663b implements RadioGroup.OnCheckedChangeListener {
        public C0663b() {
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.gst_exclude) {
                GstCalulatorActivity gstCalulation = GstCalulatorActivity.this;
                gstCalulation.f2350h = 1;
                gstCalulation.f2348f.removeAllViews();
                GstCalulatorActivity.this.f2359q.setVisibility(View.GONE);
            } else if (i == R.id.gst_include) {
                GstCalulatorActivity gstCalulation2 = GstCalulatorActivity.this;
                gstCalulation2.f2350h = 2;
                gstCalulation2.f2348f.removeAllViews();
                GstCalulatorActivity.this.f2359q.setVisibility(View.GONE);
            }
        }
    }

    /* renamed from: calculator.GstCalulatorActivity$c */
    public class C0664c implements TextWatcher {
        public C0664c() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            GstCalulatorActivity.this.f2348f.removeAllViews();
            GstCalulatorActivity.this.f2359q.setVisibility(View.GONE);
        }
    }

    /* renamed from: calculator.GstCalulatorActivity$d */
    public class C0665d implements TextWatcher {
        public C0665d() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            GstCalulatorActivity.this.f2348f.removeAllViews();
            GstCalulatorActivity.this.f2359q.setVisibility(View.GONE);
        }
    }

    /* renamed from: calculator.GstCalulatorActivity$e */
    public class C0666e implements AdapterView.OnItemSelectedListener {
        public C0666e() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == 7) {
                GstCalulatorActivity.this.f2353k.setVisibility(View.VISIBLE);
            } else {
                GstCalulatorActivity.this.f2353k.setVisibility(View.GONE);
            }
            GstCalulatorActivity.this.f2348f.removeAllViews();
            GstCalulatorActivity.this.f2359q.setVisibility(View.GONE);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: calculator.GstCalulatorActivity$f */
    public class C0667f implements View.OnClickListener {
        public C0667f() {
        }

        public void onClick(View view) {
            if (GstCalulatorActivity.this.f2345c.getText().toString().equals(".") || C3709a.m6150d(GstCalulatorActivity.this.f2345c) <= 0 || C3709a.m6150d(GstCalulatorActivity.this.f2345c) >= 11 || ((double) C3709a.m6062a(GstCalulatorActivity.this.f2345c)) <= 0.01d) {
                GstCalulatorActivity.this.f2345c.requestFocus();
                Toast.makeText(GstCalulatorActivity.this, "Enter the purchase amount", Toast.LENGTH_SHORT).show();
            } else if (GstCalulatorActivity.this.f2351i.getSelectedItemPosition() == 0) {
                Toast.makeText(GstCalulatorActivity.this, "Please Select GST Rate", Toast.LENGTH_SHORT).show();
            } else if (GstCalulatorActivity.this.f2351i.getSelectedItemPosition() == 1) {
                GstCalulatorActivity gstCalulation = GstCalulatorActivity.this;
                int i = gstCalulation.f2350h;
                if (i == 1) {
                    double a = (double) C3709a.m6062a(gstCalulation.f2345c);
                    Double.isNaN(a);
                    double d = (a * 0.25d) / 100.0d;
                    String format = String.format("%.2f", new Object[]{Double.valueOf(d)});
                    Float valueOf = Float.valueOf(Float.parseFloat(format) / 2.0f);
                    StringBuilder c = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                    C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c, "<tr><td><b>SGST</td><td><b>₹ ");
                    C3709a.m6142b("%.3f", new Object[]{valueOf}, c, "</td></tr><tr><td>CGST</td><td>₹ ");
                    C3709a.m6142b("%.3f", new Object[]{valueOf}, c, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                    C3709a.m6142b("%.2f", new Object[]{Double.valueOf(d)}, c, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                    double a2 = (double) C3709a.m6062a(GstCalulatorActivity.this.f2345c);
                    Double.isNaN(a2);
                   GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{Double.valueOf(d + a2)}, c, "</td></tr>"), "</table></body></html>"), format, 1);
                } else if (i == 2) {
                    double a3 = (double) C3709a.m6062a(gstCalulation.f2345c);
                    Double.isNaN(a3);
                    double d2 = (a3 * 0.25d) / 100.25d;
                    String format2 = String.format("%.2f", new Object[]{Double.valueOf(d2)});
                    new Float(2.0f);
                    Float valueOf2 = Float.valueOf(Float.parseFloat(format2) / 2.0f);
                    PrintStream printStream = System.out;
                    String str = format2;
                    printStream.println("aaa ===== " + valueOf2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>");
                    sb.append("<tr><td>Purchase Amount</td><td>₹ ");
                    C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, sb, "<tr><td><b>SGST</td><td><b>₹ ");
                    C3709a.m6142b("%.3f", new Object[]{valueOf2}, sb, "</td></tr><tr><td>CGST</td><td>₹ ");
                    C3709a.m6142b("%.3f", new Object[]{valueOf2}, sb, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                    C3709a.m6142b("%.2f", new Object[]{Double.valueOf(d2)}, sb, "</td></tr><tr><td>Amount Without GST</td><td>₹ ");
                    double a4 = (double) C3709a.m6062a(GstCalulatorActivity.this.f2345c);
                    Double.isNaN(a4);
                    C3709a.m6142b("%.2f", new Object[]{Double.valueOf(a4 - d2)}, sb, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                  GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, sb, "</td></tr>"), "</table></body></html>"), str, 2);
                }
            } else {
                String str2 = "</table></body></html>";
                String str3 = "</td></tr>";
                Object obj = ".";
                if (GstCalulatorActivity.this.f2351i.getSelectedItemPosition() == 2) {
                    new Float(2.0f);
                    GstCalulatorActivity gstCalulation2 = GstCalulatorActivity.this;
                    int i2 = gstCalulation2.f2350h;
                    String str4 = "</td></tr><tr><td>Amount Without GST</td><td>₹ ";
                    if (i2 == 1) {
                        Float valueOf3 = Float.valueOf((Float.parseFloat(gstCalulation2.f2345c.getText().toString()) * 3.0f) / 100.0f);
                        String format3 = String.format("%.2f", new Object[]{valueOf3});
                        new Float(2.0f);
                        Float valueOf4 = Float.valueOf(Float.parseFloat(format3) / 2.0f);
                        StringBuilder c2 = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c2, "<tr><td><b>SGST</td><td><b>₹ ");
                        C3709a.m6142b("%.3f", new Object[]{valueOf4}, c2, "</td></tr><tr><td>CGST</td><td>₹ ");
                        C3709a.m6142b("%.3f", new Object[]{valueOf4}, c2, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{valueOf3}, c2, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                      GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{Float.valueOf(Float.parseFloat(GstCalulatorActivity.this.f2345c.getText().toString()) + valueOf3.floatValue())}, c2, str3), str2), format3, 1);
                    } else if (i2 == 2) {
                        Float valueOf5 = Float.valueOf((Float.parseFloat(gstCalulation2.f2345c.getText().toString()) * 3.0f) / 103.0f);
                        String format4 = String.format("%.2f", new Object[]{valueOf5});
                        new Float(2.0f);
                        Float valueOf6 = Float.valueOf(Float.parseFloat(format4) / 2.0f);
                        PrintStream printStream2 = System.out;
                        String str5 = format4;
                        printStream2.println("aaa ===== " + valueOf6);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>");
                        sb2.append("<tr><td>Purchase Amount</td><td>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, sb2, "<tr><td>SGST</td><td>₹ ");
                        C3709a.m6142b("%.3f", new Object[]{valueOf6}, sb2, "</td></tr><tr><td>CGST</td><td>₹ ");
                        C3709a.m6142b("%.3f", new Object[]{valueOf6}, sb2, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{valueOf5}, sb2, str4);
                        C3709a.m6142b("%.2f", new Object[]{Float.valueOf(C3709a.m6062a(GstCalulatorActivity.this.f2345c) - valueOf5.floatValue())}, sb2, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                      GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, sb2, str3), str2), str5, 2);
                    }
                } else if (GstCalulatorActivity.this.f2351i.getSelectedItemPosition() == 3) {
                    new Float(2.0f);
                    GstCalulatorActivity gstCalulation3 = GstCalulatorActivity.this;
                    int i3 = gstCalulation3.f2350h;
                    if (i3 == 1) {
                        Float valueOf7 = Float.valueOf((Float.parseFloat(gstCalulation3.f2345c.getText().toString()) * 5.0f) / 100.0f);
                        String format5 = String.format("%.2f", new Object[]{valueOf7});
                        new Float(2.0f);
                        Float valueOf8 = Float.valueOf(Float.parseFloat(format5) / 2.0f);
                        StringBuilder c3 = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c3, "<tr><td>SGST</td><td>₹ ");
                        C3709a.m6142b("%.3f", new Object[]{valueOf8}, c3, "</td></tr><tr><td>CGST</td><td>₹ ");
                        C3709a.m6142b("%.3f", new Object[]{valueOf8}, c3, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{valueOf7}, c3, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                       GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{Float.valueOf(Float.parseFloat(GstCalulatorActivity.this.f2345c.getText().toString()) + valueOf7.floatValue())}, c3, str3), str2), format5, 1);
                    } else if (i3 == 2) {
                        Float valueOf9 = Float.valueOf((Float.parseFloat(gstCalulation3.f2345c.getText().toString()) * 5.0f) / 105.0f);
                        String format6 = String.format("%.2f", new Object[]{valueOf9});
                        String str6 = str2;
                        new Float(2.0f);
                        Float valueOf10 = Float.valueOf(Float.parseFloat(format6) / 2.0f);
                        PrintStream printStream3 = System.out;
                        String str7 = format6;
                        printStream3.println("aaa ===== " + valueOf10);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>");
                        sb3.append("<tr><td>Purchase Amount</td><td>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, sb3, "<tr><td>SGST</td><td>₹ ");
                        C3709a.m6142b("%.3f", new Object[]{valueOf10}, sb3, "</td></tr><tr><td>CGST</td><td>₹ ");
                        C3709a.m6142b("%.3f", new Object[]{valueOf10}, sb3, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{valueOf9}, sb3, "</td></tr><tr><td>Amount Without GST</td><td>₹ ");
                        C3709a.m6142b("%.2f", new Object[]{Float.valueOf(C3709a.m6062a(GstCalulatorActivity.this.f2345c) - valueOf9.floatValue())}, sb3, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                       GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, sb3, str3), str6), str7, 2);
                    }
                } else {
                    String str8 = str2;
                    if (GstCalulatorActivity.this.f2351i.getSelectedItemPosition() == 4) {
                        new Float(2.0f);
                        GstCalulatorActivity gstCalulation4 = GstCalulatorActivity.this;
                        int i4 = gstCalulation4.f2350h;
                        if (i4 == 1) {
                            Float valueOf11 = Float.valueOf((Float.parseFloat(gstCalulation4.f2345c.getText().toString()) * 12.0f) / 100.0f);
                            String format7 = String.format("%.2f", new Object[]{valueOf11});
                            new Float(2.0f);
                            Float valueOf12 = Float.valueOf(Float.parseFloat(format7) / 2.0f);
                            StringBuilder c4 = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c4, "<tr><td>SGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf12}, c4, "</td></tr><tr><td>CGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf12}, c4, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{valueOf11}, c4, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                          GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{Float.valueOf(Float.parseFloat(GstCalulatorActivity.this.f2345c.getText().toString()) + valueOf11.floatValue())}, c4, str3), str8), format7, 1);
                        } else if (i4 == 2) {
                            Float valueOf13 = Float.valueOf((Float.parseFloat(gstCalulation4.f2345c.getText().toString()) * 12.0f) / 112.0f);
                            String format8 = String.format("%.2f", new Object[]{valueOf13});
                            new Float(2.0f);
                            Float valueOf14 = Float.valueOf(Float.parseFloat(format8) / 2.0f);
                            StringBuilder c5 = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c5, "<tr><td>SGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf14}, c5, "</td></tr><tr><td>CGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf14}, c5, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{valueOf13}, c5, "</td></tr><tr><td>Amount Without GST</td><td>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{Float.valueOf(C3709a.m6062a(GstCalulatorActivity.this.f2345c) - valueOf13.floatValue())}, c5, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                            GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c5, str3), str8), format8, 2);
                        }
                    } else if (GstCalulatorActivity.this.f2351i.getSelectedItemPosition() == 5) {
                        new Float(2.0f);
                        GstCalulatorActivity gstCalulation5 = GstCalulatorActivity.this;
                        int i5 = gstCalulation5.f2350h;
                        if (i5 == 1) {
                            Float valueOf15 = Float.valueOf((Float.parseFloat(gstCalulation5.f2345c.getText().toString()) * 18.0f) / 100.0f);
                            String format9 = String.format("%.2f", new Object[]{valueOf15});
                            new Float(2.0f);
                            Float valueOf16 = Float.valueOf(Float.parseFloat(format9) / 2.0f);
                            StringBuilder c6 = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c6, "<tr><td>SGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf16}, c6, "</td></tr><tr><td>CGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf16}, c6, "</td></tr><tr><td><b>Total GST</td><td>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{valueOf15}, c6, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                           GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{Float.valueOf(Float.parseFloat(GstCalulatorActivity.this.f2345c.getText().toString()) + valueOf15.floatValue())}, c6, str3), str8), format9, 1);
                        } else if (i5 == 2) {
                            Float valueOf17 = Float.valueOf((Float.parseFloat(gstCalulation5.f2345c.getText().toString()) * 18.0f) / 118.0f);
                            String format10 = String.format("%.2f", new Object[]{valueOf17});
                            new Float(2.0f);
                            Float valueOf18 = Float.valueOf(Float.parseFloat(format10) / 2.0f);
                            StringBuilder c7 = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c7, "<tr><td>SGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf18}, c7, "</td></tr><tr><td>CGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf18}, c7, "</td></tr><tr><td>Total GST</td><td><b>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{valueOf17}, c7, "</td></tr><tr><td>Amount Without GST</td><td>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{Float.valueOf(C3709a.m6062a(GstCalulatorActivity.this.f2345c) - valueOf17.floatValue())}, c7, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                           GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c7, str3), str8), format10, 2);
                        }
                    } else if (GstCalulatorActivity.this.f2351i.getSelectedItemPosition() == 6) {
                        new Float(2.0f);
                        GstCalulatorActivity gstCalulation6 = GstCalulatorActivity.this;
                        int i6 = gstCalulation6.f2350h;
                        if (i6 == 1) {
                            Float valueOf19 = Float.valueOf((Float.parseFloat(gstCalulation6.f2345c.getText().toString()) * 28.0f) / 100.0f);
                            String format11 = String.format("%.2f", new Object[]{valueOf19});
                            new Float(2.0f);
                            Float valueOf20 = Float.valueOf(Float.parseFloat(format11) / 2.0f);
                            StringBuilder c8 = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c8, "<tr><td>SGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf20}, c8, "</td></tr><tr><td>CGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf20}, c8, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{valueOf19}, c8, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                           GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{Float.valueOf(Float.parseFloat(GstCalulatorActivity.this.f2345c.getText().toString()) + valueOf19.floatValue())}, c8, str3), str8), format11, 1);
                        } else if (i6 == 2) {
                            Float valueOf21 = Float.valueOf((Float.parseFloat(gstCalulation6.f2345c.getText().toString()) * 28.0f) / 128.0f);
                            String format12 = String.format("%.2f", new Object[]{valueOf21});
                            new Float(2.0f);
                            Float valueOf22 = Float.valueOf(Float.parseFloat(format12) / 2.0f);
                            StringBuilder c9 = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c9, "<tr><td>SGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf22}, c9, "</td></tr><tr><td>CGST</td><td>₹ ");
                            C3709a.m6142b("%.3f", new Object[]{valueOf22}, c9, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{valueOf21}, c9, "</td></tr><tr><td>Amount Without GST</td><td>₹ ");
                            C3709a.m6142b("%.2f", new Object[]{Float.valueOf(C3709a.m6062a(GstCalulatorActivity.this.f2345c) - valueOf21.floatValue())}, c9, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                           GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c9, str3), str8), format12, 2);
                        }
                    } else if (GstCalulatorActivity.this.f2351i.getSelectedItemPosition() == 7) {
                        if (!GstCalulatorActivity.this.f2346d.getText().toString().equals(obj) && C3709a.m6150d(GstCalulatorActivity.this.f2346d) > 0) {
                            String str9 = "</td></tr><tr><td>Amount Without GST</td><td>₹ ";
                            if (((double) C3709a.m6062a(GstCalulatorActivity.this.f2346d)) > 0.01d) {
                                double parseDouble = Double.parseDouble(GstCalulatorActivity.this.f2346d.getText().toString());
                                new Float(2.0f).floatValue();
                                GstCalulatorActivity gstCalulation7 = GstCalulatorActivity.this;
                                int i7 = gstCalulation7.f2350h;
                                if (i7 == 1) {
                                    double parseDouble2 = (Double.parseDouble(gstCalulation7.f2345c.getText().toString()) * parseDouble) / 100.0d;
                                    String format13 = String.format("%.2f", new Object[]{Double.valueOf(parseDouble2)});
                                    new Float(2.0f);
                                    Float valueOf23 = Float.valueOf(Float.parseFloat(format13) / 2.0f);
                                    StringBuilder c10 = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                                    C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c10, "<tr><td>SGST</td><td>₹ ");
                                    C3709a.m6142b("%.3f", new Object[]{valueOf23}, c10, "</td></tr><tr><td>CGST</td><td>₹ ");
                                    C3709a.m6142b("%.3f", new Object[]{valueOf23}, c10, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                                    C3709a.m6142b("%.2f", new Object[]{Double.valueOf(parseDouble2)}, c10, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                                    double a5 = (double) C3709a.m6062a(GstCalulatorActivity.this.f2345c);
                                    Double.isNaN(a5);
                                 GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{Double.valueOf(parseDouble2 + a5)}, c10, str3), str8), format13, 1);
                                } else if (i7 == 2) {
                                    String str10 = str3;
                                    double a6 = (double) C3709a.m6062a(gstCalulation7.f2345c);
                                    Double.isNaN(a6);
                                    double d3 = (a6 * parseDouble) / (parseDouble + 100.0d);
                                    String format14 = String.format("%.2f", new Object[]{Double.valueOf(d3)});
                                    new Float(2.0f);
                                    Float valueOf24 = Float.valueOf(Float.parseFloat(format14) / 2.0f);
                                    StringBuilder c11 = C3709a.m6148c("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>", "<tr><td>Purchase Amount</td><td>₹ ");
                                    C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c11, "<tr><td>SGST</td><td>₹ ");
                                    C3709a.m6142b("%.3f", new Object[]{valueOf24}, c11, "</td></tr><tr><td>CGST</td><td>₹ ");
                                    C3709a.m6142b("%.3f", new Object[]{valueOf24}, c11, "</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                                    C3709a.m6142b("%.2f", new Object[]{Double.valueOf(d3)}, c11, str9);
                                    double a7 = (double) C3709a.m6062a(GstCalulatorActivity.this.f2345c);
                                    Double.isNaN(a7);
                                    C3709a.m6142b("%.2f", new Object[]{Double.valueOf(a7 - d3)}, c11, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                                   GstCalulatorActivity.this.mo2543a(C3709a.m6137b(C3709a.m6085a("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c11, str10), str8), format14, 2);
                                }
                            }
                        }
                        GstCalulatorActivity.this.f2346d.requestFocus();
                        Toast.makeText(GstCalulatorActivity.this, "Enter GST (%)", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            C0530r6.m1129a((Context) GstCalulatorActivity.this, view);
        }
    }


    /* renamed from: calculator.GstCalulatorActivity$h */
    public class C0670h extends WebViewClient {

        /* renamed from: calculator.GstCalulatorActivity$h$a */
        public class C0671a implements Runnable {
            public C0671a() {
            }

            public void run() {
                ScrollView scrollView = GstCalulatorActivity.this.f2352j;
                scrollView.scrollTo(0, scrollView.getBottom());
            }
        }

        public C0670h() {
        }

        public void onPageFinished(WebView webView, String str) {
            GstCalulatorActivity.this.f2352j.post(new C0671a());
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }
    }

    /* renamed from: calculator.GstCalulatorActivity$i */
//    public class C0672i implements View.OnClickListener {
//        public C0672i() {
//        }
//
//        public void onClick(View view) {
//            if (Build.VERSION.SDK_INT < 23) {
//                GstCalulatorActivity.this.mo2545e();
//            } else if (C2021a.m4388a(GstCalulatorActivity.this.getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
//                GstCalulatorActivity.this.mo2545e();
//            } else {
//                GstCalulatorActivity gstCalulation = GstCalulatorActivity.this;
//                if (Build.VERSION.SDK_INT < 23) {
//                    gstCalulation.mo2545e();
//                } else if (gstCalulation.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != PackageManager.PERMISSION_GRANTED) {
//                    Dialog dialog = new Dialog(gstCalulation);
//                    dialog.setContentView(R.layout.permission_dialog_layout);
//                    TextView textView = (TextView) dialog.findViewById(R.id.permission_ok);
//                    TextView textView2 = (TextView) dialog.findViewById(R.id.txt);
//                    if (gstCalulation.f2354l.mo2459c(gstCalulation, "permission") == 2) {
//                        textView2.setText("సమాచారాన్ని భాగస్వామ్యం చేయడానికి మీరు సెట్టింగుల విభాగంలో నిల్వ అనుమతిని అనుమతించాలి");
//                    } else {
//                        textView2.setText("సమాచారాన్ని భాగస్వామ్యం చేయడానికి క్రింది అనుమతులను అనుమతించండి");
//                    }
//                    textView.setOnClickListener(new C2944g(gstCalulation, dialog));
//                    dialog.show();
//                } else {
//                    gstCalulation.mo2545e();
//                }
//            }
//        }
//    }

    /* renamed from: calculator.GstCalulatorActivity$j */
    public class C0673j implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ String f2376b;

        /* renamed from: c */
        public final /* synthetic */ int f2377c;

        /* renamed from: calculator.GstCalulatorActivity$j$a */
        public class C0674a implements Runnable {
            public C0674a() {
            }

            public void run() {
                ScrollView scrollView = GstCalulatorActivity.this.f2352j;
                scrollView.scrollTo(0, scrollView.getBottom());
            }
        }

        public C0673j(String str, int i) {
            this.f2376b = str;
            this.f2377c = i;
        }

        public void onClick(View view) {
            int round = Math.round(Float.valueOf(Float.parseFloat(this.f2376b)).floatValue());
            Float valueOf = Float.valueOf(Float.parseFloat(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED + round) / 2.0f);
            int i = this.f2377c;
            String str = "<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px<b>GST Calculation</caption>";
            if (i == 1) {
                StringBuilder c = C3709a.m6148c(str, "<tr><td>Purchase Amount</td><td>₹ ");
                C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c, "<tr><td>SGST</td><td>₹ ");
                C3709a.m6142b("%.3f", new Object[]{valueOf}, c, "</td></tr><tr><td>CGST</td><td>₹ ");
                c.append(String.format("%.3f", new Object[]{valueOf}));
                c.append("</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                c.append(round);
                c.append(".00</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                str = C3709a.m6085a("%.2f", new Object[]{Float.valueOf(Float.parseFloat(GstCalulatorActivity.this.f2345c.getText().toString()) + ((float) round))}, c, "</td></tr>");
            } else if (i == 2) {
                StringBuilder c2 = C3709a.m6148c(str, "<tr><td>Purchase Amount</td><td>₹ ");
                C3709a.m6142b("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c2, "<tr><td>SGST</td><td>₹ ");
                C3709a.m6142b("%.3f", new Object[]{valueOf}, c2, "</td></tr><tr><td>CGST</td><td>₹ ");
                c2.append(String.format("%.3f", new Object[]{valueOf}));
                c2.append("</td></tr><tr><td><b>Total GST</td><td><b>₹ ");
                c2.append(round);
                c2.append(".00</td></tr><tr><td>Amount Without GST</td><td>₹ ");
                C3709a.m6142b("%.2f", new Object[]{Float.valueOf(C3709a.m6062a(GstCalulatorActivity.this.f2345c) - ((float) round))}, c2, "</td></tr><tr><td>Total Amount With GST</td><td>₹ ");
                str = C3709a.m6085a("%.2f", new Object[]{C3709a.m6135b(GstCalulatorActivity.this.f2345c)}, c2, "</td></tr>");
            }
            GstCalulatorActivity.this.f2347e.loadDataWithBaseURL("same://ur/l/tat/does/not/work", C3709a.m6137b(str, "</table></body></html>"), "text/html", "utf-8", (String) null);
            GstCalulatorActivity.this.f2352j.post(new C0674a());
        }
    }

    /* renamed from: a */
    public void mo2543a(String str, String str2, int i) {
        this.f2348f.removeAllViews();
        View inflate = ((LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.share_print, (ViewGroup) null);
        this.f2359q.setVisibility(View.VISIBLE);
        this.f2347e = (WebView) inflate.findViewById(R.id.anspart);
        this.f2347e.getSettings().setJavaScriptEnabled(true);
        this.f2347e.setWebChromeClient(new WebChromeClient());
        this.f2347e.getSettings().setAppCacheEnabled(true);
        this.f2347e.setWebViewClient(new C0670h());
        this.f2347e.loadDataWithBaseURL("same://ur/l/tat/does/not/work/gst", str, "text/html", "UTF-8", (String) null);
     //   ((ImageView) findViewById(R.id.imgshare)).setOnClickListener(new C0672i());
        ((Button) findViewById(R.id.paise)).setOnClickListener(new C0673j(str2, i));
        ((Button) findViewById(R.id.rupees)).setOnClickListener(new C0661a(str2, i));
        this.f2348f.addView(inflate);
    }

    /* renamed from: d */
//    public final File mo2544d() {
//        this.f2355m = System.currentTimeMillis();
//        StringBuilder a = C3709a.m6100a("GST_");
//        a.append(this.f2355m);
//        a.append(".pdf");
//        String sb = a.toString();
//        File externalFilesDir = getExternalFilesDir("/Nithra/Telegu Calendar");
//        PrintStream printStream = System.out;
//        printStream.println("dir==1" + externalFilesDir);
//        if (!externalFilesDir.exists()) {
//            externalFilesDir.mkdirs();
//        }
//        PrintStream printStream2 = System.out;
//        printStream2.println("dir==" + externalFilesDir);
//        File file = new File(externalFilesDir, sb);
//        if (file.exists()) {
//            file.delete();
//        }
//        file.createNewFile();
//        return file;
//    }

    /* renamed from: e */
//    public void mo2545e() {
//        Handler handler = new Handler((Looper) Objects.requireNonNull(Looper.myLooper()));
//        ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("PDF Generating...");
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//        try {
//            File d = mo2544d();
//            new C2945h(getApplicationContext(), this.f2347e.createPrintDocumentAdapter(), d).mo9934a(new C0668g(handler, progressDialog));
//        } catch (IOException e) {
//            e.printStackTrace();
//            PrintStream printStream = System.out;
//            printStream.println("dir==" + e);
//        }
//    }

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
        if (this.f2354l.mo2459c(this, "Main_Daily_Click") != 1) {
            this.f2354l.mo2458b(this, "add_remove").booleanValue();
        }
    }
}