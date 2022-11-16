package com.vibame.telugupanchangamcalendar.activities;


import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.RequestConfiguration;

/* renamed from: b0.c.a.z5 */
public class C0619z5 {

    /* renamed from: a */
    public SharedPreferences f2201a;

    /* renamed from: b */
    public SharedPreferences.Editor f2202b;

    /* renamed from: a */
    public void mo2457a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", 0);
        this.f2201a = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.f2202b = edit;
        edit.putString(str, str2);
        this.f2202b.commit();
    }

    /* renamed from: b */
    public Boolean mo2458b(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", 0);
        this.f2201a = sharedPreferences;
        return Boolean.valueOf(sharedPreferences.getBoolean(str, false));
    }

    /* renamed from: c */
    public int mo2459c(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", 0);
        this.f2201a = sharedPreferences;
        return sharedPreferences.getInt(str, 0);
    }

    /* renamed from: d */
    public String mo2460d(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", 0);
        this.f2201a = sharedPreferences;
        return sharedPreferences.getString(str, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
    }

    /* renamed from: e */
    public void mo2461e(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", 0);
        this.f2201a = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.f2202b = edit;
        edit.remove(str);
        this.f2202b.commit();
    }

    /* renamed from: a */
    public void mo2455a(Context context, String str, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", 0);
        this.f2201a = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.f2202b = edit;
        edit.putInt(str, i);
        this.f2202b.commit();
    }

    /* renamed from: a */
    public void mo2456a(Context context, String str, Boolean bool) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", 0);
        this.f2201a = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.f2202b = edit;
        edit.putBoolean(str, bool.booleanValue());
        this.f2202b.commit();
    }

    /* renamed from: a */
    public Boolean mo2454a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", 0);
        this.f2201a = sharedPreferences;
        return Boolean.valueOf(sharedPreferences.getBoolean(str, true));
    }
}

