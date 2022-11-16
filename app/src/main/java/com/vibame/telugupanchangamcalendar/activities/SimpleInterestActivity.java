package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.material.appbar.AppBarLayout;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.helper.Constant;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;

public class SimpleInterestActivity extends AppCompatActivity {
    public String[] siarray = {"Simple Interest", "Principal", "Interest Rate", "Time period"};
    public EditText e_principal,e_intrest,e_time;
    public WebView anspart;
    public Button calculate;
    public RelativeLayout result_relative;
    public ScrollView scroll;
    public RadioGroup radio_time;
    public int a = 10, b = 5;
    public int c = 3;
    public int d = 1;
    public String hinttxt = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

    public String hinttxt2 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

    public String hintxt3 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    public long timemilli;

    RadioButton radio_years,radio_months;
    public LinearLayout linearLayout;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest);
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());


        //tringBuilder a = Constant.strbappend(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
//        a.append(this.f2396r.mo2460d(this, "fess_title"));
        //toolbar.setTitle((CharSequence) a.toString());
        //C1495a supportActionBar = getSupportActionBar();
        //StringBuilder a2 = Constant.strbappend(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
//        a2.append(this.f2396r.mo2460d(this, "fess_title"));
        //supportActionBar.mo6752a((CharSequence) a2.toString());
        linearLayout = (LinearLayout) findViewById(R.id.sharemainlayy);
        linearLayout.setVisibility(View.GONE);
        e_principal = (EditText) findViewById(R.id.e_principal);
        imgBack = findViewById(R.id.imgBack);
        e_intrest = (EditText) findViewById(R.id.e_intrest);
        e_time = (EditText) findViewById(R.id.e_time);
        calculate = (Button) findViewById(R.id.calculate);
        radio_time = (RadioGroup) findViewById(R.id.radio_time);
        scroll = (ScrollView) findViewById(R.id.scroll);
        result_relative = (RelativeLayout) findViewById(R.id.result_relative);
        radio_years = findViewById(R.id.radio_years);
        radio_months = findViewById(R.id.radio_months);
        radio_time.setOnCheckedChangeListener(new C0675a());
        e_principal.addTextChangedListener(new C0676b());
        e_intrest.addTextChangedListener(new C0677c());
        e_time.addTextChangedListener(new C0678d());
        Spinner spinner = (Spinner) findViewById(R.id.spinner_id);
        spinner.setOnItemSelectedListener(new C0679e());
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, siarray);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(arrayAdapter);
        calculate.setOnClickListener(new C0680f(spinner));
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ads_lay);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
//        if(.f2396r.mo2459c(this, "Main_Daily_Click") == 1) {
//            this.f2396r.mo2458b(this, "add_remove").booleanValue();
//        }
    }
    public class C0675a implements RadioGroup.OnCheckedChangeListener {
        public C0675a() {
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.radio_years) {
                SimpleInterestActivity SimpleInterestActivity = SimpleInterestActivity.this;
                d = 1;
                e_time.setHint("Number of Years");
                SimpleInterestActivity SimpleInterestActivity2 = SimpleInterestActivity.this;
                hintxt3 = "Enter Number Of Years";
                result_relative.removeAllViews();
                linearLayout.setVisibility(View.GONE);
            } else if (i == R.id.radio_months) {
                SimpleInterestActivity SimpleInterestActivity3 = SimpleInterestActivity.this;
                d = 2;
                e_time.setHint("Number of Months");
                SimpleInterestActivity SimpleInterestActivity4 = SimpleInterestActivity.this;
                hintxt3 = "Enter Number Of Months";
                result_relative.removeAllViews();
                linearLayout.setVisibility(View.GONE);
            }
        }
    }

    /* renamed from: calculator.SimpleInterestActivity$b */
    public class C0676b implements TextWatcher {
        public C0676b() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            result_relative.removeAllViews();
            linearLayout.setVisibility(View.GONE);
        }
    }

    /* renamed from: calculator.SimpleInterestActivity$c */
    public class C0677c implements TextWatcher {
        public C0677c() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            result_relative.removeAllViews();
            linearLayout.setVisibility(View.GONE);
        }
    }

    /* renamed from: calculator.SimpleInterestActivity$d */
    public class C0678d implements TextWatcher {
        public C0678d() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            result_relative.removeAllViews();
            linearLayout.setVisibility(View.GONE);
        }
    }

    /* renamed from: calculator.SimpleInterestActivity$e */
    public class C0679e implements AdapterView.OnItemSelectedListener {
        public C0679e() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = i;
            if (i2 == 0) {

                radio_time.setVisibility(View.VISIBLE);
                e_principal.setHint("Principal Amount ₹");
                SimpleInterestActivity SimpleInterestActivity = SimpleInterestActivity.this;
                hinttxt = "Enter Principal Amount";
                a = 10;
                int i3 = d;
                if (i3 == 1) {
                    e_time.setHint("Number of Years");
                    hintxt3 = "Enter Number Of Years";
                } else if (i3 == 2) {
                    e_time.setHint("Number of Months");
                    hintxt3 = "Enter Number Of Months";
                }
                SimpleInterestActivity SimpleInterestActivity2 = SimpleInterestActivity.this;
                b = 5;
                c = 3;
                e_intrest.setHint("Annual Interest Rate (%)");
                SimpleInterestActivity SimpleInterestActivity3 = SimpleInterestActivity.this;
                hinttxt2 = "Enter Annual Interest Rate in (%)";
                e_principal.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_intrest.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_time.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_time.setInputType(2);
            } else if (i2 == 1) {
                radio_time.setVisibility(View.VISIBLE);
                e_principal.setHint("Interest Amount ₹");
                SimpleInterestActivity SimpleInterestActivity4 = SimpleInterestActivity.this;
                hinttxt = "Enter Interest Amount";
                a = 10;
                b = 5;
                c = 3;
                int i4 = d;
                if (i4 == 1) {
                    e_time.setHint("Number of Years");
                    hintxt3 = "Enter Number Of Years";
                } else if (i4 == 2) {
                    e_time.setHint("Number of Months");
                    hintxt3 = "Enter Number Of Months";
                }
                e_intrest.setHint("Annual Interest Rate (%)");
                SimpleInterestActivity SimpleInterestActivity5 = SimpleInterestActivity.this;
                hinttxt2 = "Enter Annual Interest Rate in (%)";
                e_principal.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_intrest.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_time.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_time.setInputType(2);
            } else if (i2 == 2) {
                radio_time.setVisibility(View.VISIBLE);
                e_intrest.setHint("Interest Amount ₹");
                SimpleInterestActivity SimpleInterestActivity6 = SimpleInterestActivity.this;
                hinttxt2 = "Enter Interest Amount";
                int i5 = d;
                if (i5 == 1) {
                    e_time.setHint("Number of Years");
                    hintxt3 = "Enter Number Of Years";
                } else if (i5 == 2) {
                    e_time.setHint("Number of Months");
                    hintxt3 = "Enter Number Of Months";
                }
                e_principal.setHint("Principal Amount ₹");
                SimpleInterestActivity SimpleInterestActivity7 = SimpleInterestActivity.this;
                hinttxt = "Enter Principal Amount";
                a = 10;
                b = 10;
                c = 3;
                e_principal.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_intrest.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_time.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_time.setInputType(2);
            } else if (i2 == 3) {
                radio_time.setVisibility(View.GONE);
                e_intrest.setHint("Interest Amount ₹");
                SimpleInterestActivity SimpleInterestActivity8 = SimpleInterestActivity.this;
                hinttxt2 = "Enter Interest Amount";
                e_time.setHint("Annual Interest Rate (%)");
                SimpleInterestActivity SimpleInterestActivity9 = SimpleInterestActivity.this;
                hintxt3 = "Enter Annual Interest Rate in (%)";
                e_principal.setHint("Principal Amount ₹");
                SimpleInterestActivity SimpleInterestActivity10 = SimpleInterestActivity.this;
                hinttxt = "Enter Principal Amount";
                a = 10;
                b = 10;
                c = 5;
                e_principal.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_intrest.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_time.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                e_time.setInputType(8194);
            }
            result_relative.removeAllViews();
            linearLayout.setVisibility(View.GONE);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
    public class C0680f implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Spinner f2406b;

        public C0680f(Spinner spinner) {
            this.f2406b = spinner;
        }

        public void onClick(View view) {
            float f;
            float f2;
            float f3;
            int d = Constant.etLengthConversion(e_principal);
            SimpleInterestActivity SimpleInterestActivity = SimpleInterestActivity.this;
            int i = a;
            String str = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            if (d > i || e_principal.getText().toString().trim().length() == 0 || e_principal.getText().toString().equals(".") || ((double) Constant.floatConvert(e_principal)) < 0.01d) {
                e_principal.requestFocus();
                SimpleInterestActivity SimpleInterestActivity2 = SimpleInterestActivity.this;
                StringBuilder a = Constant.strbappend(str);
                a.append(hinttxt);
                Toast.makeText(SimpleInterestActivity2, a.toString(), Toast.LENGTH_SHORT).show();
            } else {
                int d2 = Constant.etLengthConversion(e_intrest);
                SimpleInterestActivity SimpleInterestActivity3 = SimpleInterestActivity.this;
                if (d2 > b || e_intrest.getText().toString().trim().length() == 0 || e_intrest.getText().toString().equals(".") || ((double) Constant.floatConvert(e_intrest)) < 0.01d) {
                    e_intrest.requestFocus();
                    SimpleInterestActivity SimpleInterestActivity4 = SimpleInterestActivity.this;
                    StringBuilder a2 = Constant.strbappend(str);
                    a2.append(hinttxt2);
                    Toast.makeText(SimpleInterestActivity4, a2.toString(),Toast.LENGTH_SHORT).show();
                } else {
                    int d3 = Constant.etLengthConversion(e_time);
                    SimpleInterestActivity SimpleInterestActivity5 = SimpleInterestActivity.this;
                    if (d3 > c || e_time.getText().toString().trim().length() == 0 || e_time.getText().toString().equals(".") || ((double) Constant.floatConvert(e_time)) < 0.01d) {
                        e_time.requestFocus();
                        SimpleInterestActivity SimpleInterestActivity6 = SimpleInterestActivity.this;
                        StringBuilder a3 = Constant.strbappend(str);
                        a3.append(hintxt3);
                        Toast.makeText(SimpleInterestActivity6, a3.toString(), Toast.LENGTH_SHORT).show();
                    } else if (this.f2406b.getSelectedItemPosition() == 0) {
                        SimpleInterestActivity SimpleInterestActivity7 = SimpleInterestActivity.this;
                        int i2 = 1;
                        if (radio_years.isChecked()) {
                            f3 = (Float.parseFloat(e_time.getText().toString()) * (Float.parseFloat(e_intrest.getText().toString()) * Constant.floatConvert(e_principal))) / 100.0f;
                            str = "Number of Years ";
                        } else if (radio_months.isChecked()) {
                            f3 = (Float.parseFloat(e_time.getText().toString()) * (Float.parseFloat(e_intrest.getText().toString()) * Constant.floatConvert(e_principal))) / 1200.0f;
                            str = "Number of Months ";
                        } else {
                            f3 = 0.0f;
                        }
                        StringBuilder c = Constant.strbappend2("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body  ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px><b>Simple Interest</caption>", "<tr><td><b>Simple Interest</td><td><b>₹ ");
                        Constant.strappendbuild("%.2f", new Object[]{Float.valueOf(f3)}, c, "</td></tr><tr><td>Principal Amount</td><td>₹ ");
                        c.append(e_principal.getText().toString());
                        c.append(".00</td></tr><tr><td>Annual Interest Rate (%)</td><td>");
                        c.append(e_intrest.getText().toString());
                        c.append(" %</td></tr><tr><td>");
                        c.append(str);
                        c.append("</td><td>");
                        c.append(e_time.getText().toString());
                        c.append("</td></tr>");
                        SimpleInterestActivity.this.mo2568a(Constant.addStr(c.toString(), "</table></body></html>"));
                    } else if (this.f2406b.getSelectedItemPosition() == 1) {
                        SimpleInterestActivity SimpleInterestActivity8 = SimpleInterestActivity.this;
                        int i3 = d;
                        if (radio_years.isChecked()) {
                            f2 = (Float.parseFloat(e_principal.getText().toString()) * 100.0f) / (Float.parseFloat(e_time.getText().toString()) * Constant.floatConvert(e_intrest));
                            str = "Number of Years ";
                        } else if (radio_months.isChecked()) {
                            f2 = (Float.parseFloat(e_principal.getText().toString()) * 1200.0f) / (Float.parseFloat(e_time.getText().toString()) * Constant.floatConvert(e_intrest));
                            str = "Number of Months ";
                        } else {
                            f2 = 0.0f;
                        }
                        StringBuilder c2 = Constant.strbappend2("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body  ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px><b>Simple Interest</caption>", "<tr><td><b>Principal Amount</td><td><b>₹ ");
                        Constant.strappendbuild("%.2f", new Object[]{Float.valueOf(f2)}, c2, "</td></tr><tr><td>Simple Interest</td><td>₹ ");
                        c2.append(e_principal.getText().toString());
                        c2.append("</td></tr><tr><td>Annual Interest Rate (%)</td><td>");
                        c2.append(e_intrest.getText().toString());
                        c2.append(" %</td></tr><tr><td>");
                        c2.append(str);
                        c2.append("</td><td>");
                        c2.append(e_time.getText().toString());
                        c2.append("</td></tr>");
                        SimpleInterestActivity.this.mo2568a(Constant.addStr(c2.toString(), "</table></body></html>"));
                    } else if (this.f2406b.getSelectedItemPosition() == 2) {
                        SimpleInterestActivity SimpleInterestActivity9 = SimpleInterestActivity.this;
                        int i4 = d;
                        if (radio_years.isChecked()) {
                            f = (Float.parseFloat(e_intrest.getText().toString()) * 100.0f) / (Float.parseFloat(e_time.getText().toString()) * Constant.floatConvert(e_principal));
                            str = "Number of Years ";
                        } else if (radio_months.isChecked()) {
                            f = (Float.parseFloat(e_intrest.getText().toString()) * 1200.0f) / (Float.parseFloat(e_time.getText().toString()) * Constant.floatConvert(e_principal));
                            str = "Number of Months ";
                        } else {
                            f = 0.0f;
                        }
                        StringBuilder c3 = Constant.strbappend2("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body  ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px><b>Simple Interest</caption>", "<tr><td><b>Annual Interest Rate (%)</td><td><b>");
                        Constant.strappendbuild("%.2f", new Object[]{Float.valueOf(f)}, c3, " %</td></tr><tr><td>Principal Amount</td><td>₹ ");
                        c3.append(e_principal.getText().toString());
                        c3.append("</td></tr><tr><td>Simple Interest</td><td>₹ ");
                        c3.append(e_intrest.getText().toString());
                        c3.append("</td></tr><tr><td>");
                        c3.append(str);
                        c3.append("</td><td>");
                        c3.append(e_time.getText().toString());
                        c3.append("</td></tr>");
                        SimpleInterestActivity.this.mo2568a(Constant.addStr(c3.toString(), "</table></body></html>"));
                    } else if (this.f2406b.getSelectedItemPosition() == 3) {
                        float parseFloat = (Float.parseFloat(e_intrest.getText().toString()) * 100.0f) / (Float.parseFloat(e_time.getText().toString()) * Constant.floatConvert(e_principal));
                        StringBuilder c4 = Constant.strbappend2("<!DOCTYPE html><html><head><style>caption{border: 2px solid #000000;}table, th, td {border: 2px solid #000000;border-collapse: collapse;color:#000000;padding: 5px;font-size:18px;}</style></head> <body  ><table style=width:100%><caption style=color:#000000;font-size:23px;padding: 5px><b>Simple Interest</caption>", "<tr><td><b>Number of Years<br>Number of Months</td><td><b>");
                        Constant.strappendbuild("%.2f", new Object[]{Float.valueOf(parseFloat)}, c4, "<br>");
                        Constant.strappendbuild("%.2f", new Object[]{Float.valueOf(parseFloat * 12.0f)}, c4, "</td></tr><tr><td>Principal Amount</td><td>₹ ");
                        c4.append(e_principal.getText().toString());
                        c4.append("</td></tr><tr><td>Simple Interest</td><td>₹ ");
                        c4.append(e_intrest.getText().toString());
                        c4.append("</td></tr><tr><td>Annual Interest Rate (%)</td><td>");
                        c4.append(e_time.getText().toString());
                        c4.append(" %</td></tr>");
                        SimpleInterestActivity.this.mo2568a(Constant.addStr(c4.toString(), "</table></body></html>"));
                    }
                }
            }
            e_time.requestFocus();
            ((InputMethodManager) SimpleInterestActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(SimpleInterestActivity.this.getCurrentFocus().getWindowToken(), 0);
        }
    }
    public void mo2570e() {
        Handler handler = new Handler((Looper) Objects.requireNonNull(Looper.myLooper()));
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("PDF Generating...");
        progressDialog.setCancelable(false);
        progressDialog.show();
//        try {
//            File d = mo2569d();
//            //new C2945h(getApplicationContext(), anspart.createPrintDocumentAdapter(), d).mo9934a(new C0681g(handler, progressDialog));
//        } catch (IOException e) {
//            e.printStackTrace();
//            PrintStream printStream = System.out;
//            printStream.println("dir==" + e);
//        }
    }
    public final File mo2569d() {
        timemilli = System.currentTimeMillis();
        StringBuilder a = Constant.strbappend("Simple_interest");
        a.append(timemilli);
        a.append(".pdf");
        String sb = a.toString();
        File externalFilesDir = getExternalFilesDir("/Nithra/Telegu Calendar");
        PrintStream printStream = System.out;
        printStream.println("dir==1" + externalFilesDir);
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        PrintStream printStream2 = System.out;
        printStream2.println("dir==" + externalFilesDir);
        File file = new File(externalFilesDir, sb);
        if (file.exists()) {
            file.delete();
        }
        //file.createNewFile();
        return file;
    }
    public void mo2568a(String str) {
        result_relative.removeAllViews();
        View inflate = ((LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.share_print, (ViewGroup) null);
        result_relative.addView(inflate);
        linearLayout.setVisibility(View.VISIBLE);
        anspart = (WebView) inflate.findViewById(R.id.anspart);
        anspart.getSettings().setJavaScriptEnabled(true);
        anspart.setWebChromeClient(new WebChromeClient());
        anspart.getSettings().setAppCacheEnabled(true);
        //anspart.setWebViewClient(new C0683h());
        anspart.loadDataWithBaseURL("same://ur/l/tat/does/not/work/simple_interest", str, "text/html", "UTF-8", (String) null);
        ((ImageView) findViewById(R.id.imgshare)).setOnClickListener(new C0685i());
    }
    public class C0685i implements View.OnClickListener {
        public C0685i() {
        }

        public void onClick(View view) {
            if (Build.VERSION.SDK_INT < 23) {
                SimpleInterestActivity.this.mo2570e();
            }
//            else if (C2021a.m4388a(SimpleInterestActivity.this.getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
//                SimpleInterestActivity.this.mo2570e();
//            }
            else {
                SimpleInterestActivity SimpleInterestActivity = SimpleInterestActivity.this;
                if (Build.VERSION.SDK_INT < 23) {
                    SimpleInterestActivity.mo2570e();
                } else if (SimpleInterestActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != PackageManager.PERMISSION_GRANTED) {
                    Dialog dialog = new Dialog(SimpleInterestActivity);
                    dialog.setContentView(R.layout.permission_dialog_layout);
                    TextView textView = (TextView) dialog.findViewById(R.id.permission_ok);
                    TextView textView2 = (TextView) dialog.findViewById(R.id.txt);
//                    if (SimpleInterestActivity.f2396r.mo2459c(SimpleInterestActivity, "permission") == 2) {
//                        textView2.setText("సమాచారాన్ని భాగస్వామ్యం చేయడానికి మీరు సెట్టింగుల విభాగంలో నిల్వ అనుమతిని అనుమతించాలి");
//                    } else {
//                        textView2.setText("సమాచారాన్ని భాగస్వామ్యం చేయడానికి క్రింది అనుమతులను అనుమతించండి");
//                    }
                    //textView.setOnClickListener(new C2947i(SimpleInterestActivity, dialog));
                    dialog.show();
                } else {
                    SimpleInterestActivity.mo2570e();
                }
            }
        }
        public class C0683h extends WebViewClient {

            /* renamed from: calculator.SimpleInterestActivity$h$a */
            public class C0684a implements Runnable {
                public C0684a() {
                }

                public void run() {
                    SimpleInterestActivity SimpleInterestActivity = SimpleInterestActivity.this;
                    scroll.scrollTo(0, calculate.getBottom());
                }
            }

            public C0683h() {
            }

            public void onPageFinished(WebView webView, String str) {
                new Handler().postDelayed(new C0684a(), 100);
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
    }
//    public class C0681g implements C2945h.C2946a {
//
//        /* renamed from: a */
//        public final /* synthetic */ Handler f2408a;
//
//        /* renamed from: b */
//        public final /* synthetic */ ProgressDialog f2409b;
//
//        /* renamed from: calculator.SimpleInterestActivity$g$a */
//        public class C0682a implements Runnable {
//            public C0682a() {
//            }
//
//            public void run() {
//                SimpleInterestActivity SimpleInterestActivity = SimpleInterestActivity.this;
//                StringBuilder a = Constant.strbappend("/Nithra/Telegu Calendar/Simple_interest");
//                a.append(timemilli);
//                a.append(".pdf");
//                File externalFilesDir = SimpleInterestActivity.getExternalFilesDir(a.toString());
//                SimpleInterestActivity SimpleInterestActivity2 = SimpleInterestActivity.this;
//                Uri a2 = FileProvider.m294a(SimpleInterestActivity2, SimpleInterestActivity.this.getPackageName() + RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, externalFilesDir);
//                PrintStream printStream = System.out;
//                printStream.println("pdfFile : " + externalFilesDir);
//                Intent intent = new Intent("android.intent.action.SEND");
//                intent.setType("application/pdf");
//                intent.putExtra("android.intent.extra.STREAM", a2);
//                SimpleInterestActivity.this.startActivity(Intent.createChooser(intent, "Share Via"));
//                C0681g.this.f2409b.dismiss();
//            }
//        }
//
//        public C0681g(Handler handler, ProgressDialog progressDialog) {
//            this.f2408a = handler;
//            this.f2409b = progressDialog;
//        }
//
//        /* renamed from: a */
//        public void mo2525a() {
//            this.f2408a.postDelayed(new C0682a(), 500);
//        }
//
//        /* renamed from: b */
//        public void mo2526b() {
//            this.f2409b.dismiss();
//            Toast.makeText(SimpleInterestActivity.this, "Sorry please try again...", 0).show();
//        }
//    }
//


}