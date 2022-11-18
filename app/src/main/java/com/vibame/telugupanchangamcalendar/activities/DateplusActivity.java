package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.material.appbar.AppBarLayout;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.source.C3709a;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateplusActivity extends AppCompatActivity {

    /* renamed from: b */
    public TextView f36468b;

    /* renamed from: c */
    public TextView f36469c;

    /* renamed from: d */
    public TextView f36470d;

    /* renamed from: e */
    public AppCompatEditText f36471e;

    /* renamed from: f */
    public Button f36472f;

    /* renamed from: g */
    public Button f36473g;

    /* renamed from: h */
    public Button f36474h;

    /* renamed from: i */
    public CardView f36475i;

    /* renamed from: j */
    public int f36476j = 0;

    /* renamed from: k */
    public String f36477k = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

    /* renamed from: l */
    public AppBarLayout f36478l;

    /* renamed from: m */
    public Toolbar f36479m;

    /* renamed from: n */
    public C0619z5 f36480n;

    /* renamed from: o */
    public CardView f36481o;

    /* renamed from: p */
    public CardView f36482p;

    /* renamed from: q */
    public CardView f36483q;

    /* renamed from: r */
    public int f36484r;

    /* renamed from: s */
    public int f36485s;

    /* renamed from: t */
    public int f36486t;

    /* renamed from: u */
    public Date f36487u;

    /* renamed from: v */
    public Calendar f36488v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateplus);


        this.f36480n = new C0619z5();
        this.f36479m = (Toolbar) findViewById(R.id.app_bar);
        this.f36478l = (AppBarLayout) findViewById(R.id.app_bar_lay);

        StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a.append(this.f36480n.mo2460d(this, "fess_title"));

        StringBuilder a2 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a2.append(this.f36480n.mo2460d(this, "fess_title"));

        this.f36472f = (Button) findViewById(R.id.findplus);
        this.f36473g = (Button) findViewById(R.id.findminus);
        this.f36471e = (AppCompatEditText) findViewById(R.id.getcount);
        this.f36468b = (TextView) findViewById(R.id.resultdate);
        this.f36469c = (TextView) findViewById(R.id.resultday);
        this.f36470d = (TextView) findViewById(R.id.currentdate);
        this.f36474h = (Button) findViewById(R.id.clear1);
        this.f36475i = (CardView) findViewById(R.id.card_view2);
        this.f36481o = (CardView) findViewById(R.id.but_card1);
        this.f36482p = (CardView) findViewById(R.id.but_card2);
        this.f36483q = (CardView) findViewById(R.id.but_card3);
        this.f36481o.setCardBackgroundColor(C0530r6.m1145d((Context) this));
        this.f36482p.setCardBackgroundColor(C0530r6.m1145d((Context) this));
        this.f36483q.setCardBackgroundColor(C0530r6.m1145d((Context) this));
        Calendar instance = Calendar.getInstance();
        this.f36488v = instance;
        this.f36487u = instance.getTime();
        PrintStream printStream = System.out;
        StringBuilder a3 = C3709a.m6100a("today==");
        a3.append(this.f36487u);
        printStream.println(a3.toString());
        this.f36470d.setText(new SimpleDateFormat("dd-MMM-yyyy").format(this.f36487u));
        this.f36484r = this.f36488v.get(5);
        this.f36485s = this.f36488v.get(2) + 1;
        this.f36486t = this.f36488v.get(1);
        ((ImageView) findViewById(R.id.edit_icon)).setOnClickListener(new C10229b(this));
        this.f36470d.setOnClickListener(new C10230c(this));
        this.f36474h.setOnClickListener(new C10228a(this));
        this.f36472f.setOnClickListener(new C10231d(this));
        this.f36473g.setOnClickListener(new C10232e(this));
//        this.f36479m.setBackgroundColor(C0530r6.m1145d((Context) this));
//        this.f36478l.setBackgroundColor(C0530r6.m1145d((Context) this));
    }

    public /* synthetic */ void mo23178a(View view) {
        new DatePickerDialog(this, new C10235h(this), this.f36486t, this.f36485s - 1, this.f36484r).show();
    }

    /* renamed from: b */
    public /* synthetic */ void mo23180b(View view) {
        new DatePickerDialog(this, new C10236i(this), this.f36486t, this.f36485s - 1, this.f36484r).show();
    }

    /* renamed from: c */
    public /* synthetic */ void mo23181c(View view) {
        this.f36471e.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        this.f36475i.setVisibility(View.GONE);
    }

    /* renamed from: d */
    public /* synthetic */ void mo23182d(View view) {
        C0530r6.m1129a((Context) this, view);
        String obj = this.f36471e.getText().toString();
        this.f36477k = obj;
        if (!obj.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            this.f36475i.setVisibility(View.VISIBLE);
            this.f36474h.setVisibility(View.VISIBLE);
            this.f36483q.setVisibility(View.VISIBLE);
            try {
                this.f36476j = Integer.parseInt(this.f36477k);
                PrintStream printStream = System.out;
                printStream.println("entered number=" + this.f36476j);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(this.f36487u);
            instance.add(6, this.f36476j);
            int i = instance.get(7);
            mo23179b(i);
            Date time = instance.getTime();
            PrintStream printStream2 = System.out;
            printStream2.println("newdate==" + time);
            this.f36468b.setText(new SimpleDateFormat("dd-MMM-yyyy").format(time));
            mo23179b(i);
            return;
        }
        C0530r6.m1144c(this, "Enter the days");
    }

    /* renamed from: e */
    public /* synthetic */ void mo23183e(View view) {
        C0530r6.m1129a((Context) this, view);
        String obj = this.f36471e.getText().toString();
        this.f36477k = obj;
        if (!obj.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            this.f36475i.setVisibility(View.VISIBLE);
            this.f36474h.setVisibility(View.VISIBLE);
            this.f36483q.setVisibility(View.VISIBLE);
            try {
                this.f36476j = Integer.parseInt(this.f36477k);
                PrintStream printStream = System.out;
                printStream.println("entered number=" + this.f36476j);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(this.f36487u);
            instance.add(6, -this.f36476j);
            Date time = instance.getTime();
            String format = new SimpleDateFormat("dd-MMM-yyyy").format(time);
            PrintStream printStream2 = System.out;
            printStream2.println("newdate2==" + time);
            this.f36468b.setText(format);
            mo23179b(instance.get(7));
            return;
        }
        C0530r6.m1144c(this, "Enter the days");
    }


    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: b */
    public final void mo23179b(int i) {
        switch (i) {
            case 1:
                this.f36469c.setText("Sunday");
                return;
            case 2:
                this.f36469c.setText("Monday");
                return;
            case 3:
                this.f36469c.setText("Tuesday");
                return;
            case 4:
                this.f36469c.setText("Wednesday");
                return;
            case 5:
                this.f36469c.setText("Thursday");
                return;
            case 6:
                this.f36469c.setText("Friday");
                return;
            case 7:
                this.f36469c.setText("Saturday");
                return;
            default:
                this.f36469c.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                return;
        }
    }


}