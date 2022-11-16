package com.vibame.telugupanchangamcalendar.source;


import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.vibame.telugupanchangamcalendar.activities.EMICalculatorActivity;

/* renamed from: l.d */
public class C2940d extends WebViewClient {

    /* renamed from: a */
    public final /* synthetic */ EMICalculatorActivity f10274a;

    /* renamed from: l.d$a */
    public class C2941a implements Runnable {
        public C2941a() {
        }

        public void run() {
            EMICalculatorActivity eMICalulcation = C2940d.this.f10274a;
            eMICalulcation.f2323g.scrollTo(0, eMICalulcation.f2325i.getBottom());
        }
    }

    public C2940d(EMICalculatorActivity eMICalulcation) {
        this.f10274a = eMICalulcation;
    }

    public void onPageFinished(WebView webView, String str) {
        new Handler().postDelayed(new C2941a(), 100);
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
