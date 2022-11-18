package com.vibame.telugupanchangamcalendar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.material.appbar.AppBarLayout;
import com.vibame.telugupanchangamcalendar.R;
import com.vibame.telugupanchangamcalendar.source.C3709a;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StopWatchActivity extends AppCompatActivity {


    public Runnable f36637A = new C10319d();

    /* renamed from: b */
    public TextView f36638b;

    /* renamed from: c */
    public TextView f36639c;

    /* renamed from: d */
    public TextView f36640d;

    /* renamed from: e */
    public TextView f36641e;

    /* renamed from: f */
    public Button f36642f;

    /* renamed from: g */
    public Button f36643g;

    /* renamed from: h */
    public Button f36644h;

    /* renamed from: i */
    public long f36645i;

    /* renamed from: j */
    public long f36646j;

    /* renamed from: k */
    public long f36647k;

    /* renamed from: l */
    public long f36648l = 0;

    /* renamed from: m */
    public Handler f36649m;

    /* renamed from: n */
    public int f36650n;

    /* renamed from: o */
    public int f36651o;

    /* renamed from: p */
    public int f36652p;

    /* renamed from: q */
    public int f36653q;

    /* renamed from: r */
    public ListView f36654r;

    /* renamed from: s */
    public String[] f36655s = new String[0];

    /* renamed from: t */
    public List<String> f36656t;

    /* renamed from: u */
    public ArrayAdapter<String> f36657u;

    /* renamed from: v */
    public int f36658v = 0;

    /* renamed from: w */
    public int f36659w = 0;

    /* renamed from: x */
    public C0619z5 f36660x;

    ImageView imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);


        this.f36660x = new C0619z5();

        StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a.append(this.f36660x.mo2460d(this, "fess_title"));


        StringBuilder a2 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a2.append(this.f36660x.mo2460d(this, "fess_title"));

        this.f36638b = (TextView) findViewById(R.id.textView);
        this.f36639c = (TextView) findViewById(R.id.textView2);
        this.f36640d = (TextView) findViewById(R.id.textView4);
        this.f36641e = (TextView) findViewById(R.id.textView6);
        this.f36642f = (Button) findViewById(R.id.button);
        this.f36643g = (Button) findViewById(R.id.button3);
        this.f36644h = (Button) findViewById(R.id.button4);
        this.f36654r = (ListView) findViewById(R.id.listview1);


        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        this.f36644h.setEnabled(false);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ads_lay);
        this.f36649m = new Handler((Looper) Objects.requireNonNull(Looper.myLooper()));
        this.f36656t = new ArrayList(Arrays.asList(this.f36655s));
        this.f36657u = new ArrayAdapter<>(this, R.layout.spinner_item, this.f36656t);
        this.f36654r.setBackgroundColor(-7829368);
        this.f36654r.setAdapter(this.f36657u);
        this.f36642f.setOnClickListener(new C10316a());
        this.f36643g.setOnClickListener(new C10317b());
        this.f36644h.setOnClickListener(new C10318c());
//        this.f36661y.setBackgroundColor(C0530r6.m1145d((Context) this));
//        this.f36662z.setBackgroundColor(C0530r6.m1145d((Context) this));
        
        

    }


    /* renamed from: stop_watch.StopWatchActivity$a */
    public class C10316a implements View.OnClickListener {
        public C10316a() {
        }

        public void onClick(View view) {
            StopWatchActivity main_stop = StopWatchActivity.this;
            if (main_stop.f36658v == 0) {
                main_stop.f36644h.setEnabled(true);
                StopWatchActivity.this.f36642f.setText("STOP");
                StopWatchActivity.this.f36642f.setBackgroundColor(Color.parseColor("#ca4952"));
                StopWatchActivity main_stop2 = StopWatchActivity.this;
                main_stop2.f36658v = 1;
                main_stop2.f36646j = (long) ((int) SystemClock.elapsedRealtime());
                PrintStream printStream = System.out;
                StringBuilder a = C3709a.m6100a("vfbjkbvk :");
                a.append(StopWatchActivity.this.f36646j);
                printStream.println(a.toString());
                StopWatchActivity main_stop3 = StopWatchActivity.this;
                main_stop3.f36649m.postDelayed(main_stop3.f36637A, 0);
                StopWatchActivity.this.f36643g.setEnabled(false);
                return;
            }
            main_stop.f36644h.setEnabled(false);
            StopWatchActivity.this.f36642f.setText("Start");
            StopWatchActivity.this.f36642f.setBackgroundColor(Color.parseColor("#0ac9e2"));
            StopWatchActivity main_stop4 = StopWatchActivity.this;
            main_stop4.f36658v = 0;
            main_stop4.f36647k += main_stop4.f36645i;
            main_stop4.f36649m.removeCallbacks(main_stop4.f36637A);
            StopWatchActivity.this.f36643g.setEnabled(true);
        }
    }

    /* renamed from: stop_watch.StopWatchActivity$b */
    public class C10317b implements View.OnClickListener {
        public C10317b() {
        }

        public void onClick(View view) {
            StopWatchActivity main_stop = StopWatchActivity.this;
            main_stop.f36659w = 0;
            main_stop.f36645i = 0;
            main_stop.f36646j = 0;
            main_stop.f36647k = 0;
            main_stop.f36648l = 0;
            main_stop.f36650n = 0;
            main_stop.f36651o = 0;
            main_stop.f36652p = 0;
            main_stop.f36638b.setText("00");
            StopWatchActivity.this.f36639c.setText("00");
            StopWatchActivity.this.f36640d.setText("00");
            StopWatchActivity.this.f36641e.setText("00");
            StopWatchActivity.this.f36656t.clear();
            StopWatchActivity.this.f36657u.notifyDataSetChanged();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: stop_watch.StopWatchActivity$c */
    public class C10318c implements View.OnClickListener {
        public C10318c() {
        }

        public void onClick(View view) {
            StopWatchActivity main_stop = StopWatchActivity.this;
            main_stop.f36659w++;
            List<String> list = main_stop.f36656t;
            StringBuilder a = C3709a.m6100a("Lap");
            a.append(StopWatchActivity.this.f36659w);
            a.append(" ");
            a.append(StopWatchActivity.this.f36638b.getText().toString());
            a.append(":");
            a.append(StopWatchActivity.this.f36639c.getText().toString());
            a.append(":");
            a.append(StopWatchActivity.this.f36640d.getText().toString());
            a.append(":");
            a.append(StopWatchActivity.this.f36641e.getText().toString());
            list.add(a.toString());
            StopWatchActivity.this.f36657u.notifyDataSetChanged();
        }
    }

    /* renamed from: stop_watch.StopWatchActivity$d */
    public class C10319d implements Runnable {
        public C10319d() {
        }

        public void run() {
            StopWatchActivity main_stop = StopWatchActivity.this;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            StopWatchActivity main_stop2 = StopWatchActivity.this;
            main_stop.f36645i = (long) ((int) (elapsedRealtime - main_stop2.f36646j));
            long j = main_stop2.f36647k + main_stop2.f36645i;
            main_stop2.f36648l = j;
            int i = (int) (j / 1000);
            main_stop2.f36650n = i;
            int i2 = i / 60;
            main_stop2.f36651o = i2;
            main_stop2.f36650n = i % 60;
            main_stop2.f36653q = i2 / 60;
            main_stop2.f36651o = i2 % 60;
            main_stop2.f36652p = (int) (j % 100);
            TextView textView = main_stop2.f36638b;
            StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            a.append(StopWatchActivity.this.f36653q);
            textView.setText(a.toString());
            TextView textView2 = StopWatchActivity.this.f36639c;
            StringBuilder a2 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            a2.append(StopWatchActivity.this.f36651o);
            textView2.setText(a2.toString());
            TextView textView3 = StopWatchActivity.this.f36640d;
            StringBuilder a3 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            a3.append(StopWatchActivity.this.f36650n);
            textView3.setText(a3.toString());
            TextView textView4 = StopWatchActivity.this.f36641e;
            StringBuilder a4 = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            a4.append(StopWatchActivity.this.f36652p);
            textView4.setText(a4.toString());
            StopWatchActivity.this.f36649m.postDelayed(this, 0);
        }
    }

}