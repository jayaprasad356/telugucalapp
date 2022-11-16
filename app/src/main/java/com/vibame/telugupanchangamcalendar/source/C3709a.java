package com.vibame.telugupanchangamcalendar.source;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: o.a.c.a.a */
/* compiled from: outline */
public class C3709a {
    /* renamed from: a */
    public static float m6061a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    /* renamed from: a */
    public static float m6062a(EditText editText) {
        return Float.parseFloat(editText.getText().toString());
    }

    /* renamed from: a */
    public static float m6063a(AppCompatEditText appCompatEditText) {
        return Float.valueOf(appCompatEditText.getText().toString()).floatValue();
    }


    /* renamed from: a */
    public static Bundle m6066a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    /* renamed from: a */

    /* renamed from: a */
    public static View m6068a(Dialog dialog, int i, int i2, int i3) {
        dialog.getWindow().setLayout(i, i2);
        return dialog.findViewById(i3);
    }

    /* renamed from: a */
    public static AdManagerAdRequest m6069a() {
        return new AdManagerAdRequest.Builder().build();
    }


    /* renamed from: a */
    public static String m6071a(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6072a(int i, String str, int i2, String str2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6073a(Cursor cursor, int i, String str, String str2, StringBuilder sb) {
        sb.append(cursor.getString(i).replace(str, str2));
        return sb.toString();
    }



    /* renamed from: a */
    public static String m6079a(Class cls, StringBuilder sb, String str, String str2) {
        sb.append(cls.getSimpleName());
        sb.append(str);
        sb.append(cls.getSimpleName());
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6080a(String str, int i) {
        return str + i;
    }

    /* renamed from: a */
    public static String m6081a(String str, long j) {
        return str + j;
    }

    /* renamed from: a */
    public static String m6082a(String str, Uri uri) {
        return str + uri;
    }

    /* renamed from: a */
    public static String m6083a(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    /* renamed from: a */
    public static String m6084a(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* renamed from: a */
    public static String m6085a(String str, Object[] objArr, StringBuilder sb, String str2) {
        sb.append(String.format(str, objArr));
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6086a(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6087a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6088a(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6089a(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6090a(Calendar calendar, int i, StringBuilder sb) {
        sb.append(calendar.get(i));
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6091a(HashMap hashMap, String str, StringBuilder sb) {
        sb.append(hashMap.get(str));
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6093a(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public static StringBuilder m6095a(int i, String str) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        return sb;
    }


    /* renamed from: a */
    public static StringBuilder m6097a(EditText editText, StringBuilder sb, Intent intent, String str, String str2) {
        sb.append(editText.getText().toString());
        intent.putExtra(str, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        return sb2;
    }

    /* renamed from: a */
    public static StringBuilder m6098a(TextView textView, String str, String str2) {
        textView.setText(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        return sb;
    }

    /* renamed from: a */
    public static StringBuilder m6100a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    /* renamed from: a */
    public static StringBuilder m6101a(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }


    /* renamed from: a */
    public static StringBuilder m6103a(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    /* renamed from: a */
    public static StringBuilder m6104a(HashMap hashMap, String str, String str2, String str3) {
        hashMap.put(str, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        return sb;
    }

    /* renamed from: a */
    public static void m6108a(Cursor cursor, int i, StringBuilder sb, TextView textView) {
        sb.append(cursor.getString(i));
        textView.setText(sb.toString());
    }


    /* renamed from: a */
    public static void m6110a(AppCompatEditText appCompatEditText, StringBuilder sb) {
        sb.append(appCompatEditText.getText().toString());
    }

    /* renamed from: a */
    public static void m6111a(AppCompatSpinner appCompatSpinner, StringBuilder sb, TextView textView, LinearLayout linearLayout, View view) {
        sb.append(appCompatSpinner.getSelectedItem().toString());
        textView.setText(sb.toString());
        linearLayout.addView(view);
    }

    /* renamed from: a */
    public static void m6113a(String str, int i, PrintStream printStream) {
        printStream.println(str + i);
    }

    /* renamed from: a */
    public static void m6114a(String str, Exception exc, PrintStream printStream) {
        printStream.println(str + exc);
    }

    /* renamed from: a */
    public static void m6115a(String str, String str2, TextView textView) {
        textView.setText(str + str2);
    }

    /* renamed from: a */
    public static void m6116a(String str, String str2, PrintStream printStream) {
        printStream.println(str + str2);
    }

    /* renamed from: a */
    public static void m6117a(StringBuilder sb, String str, Intent intent, String str2) {
        sb.append(str);
        intent.putExtra(str2, sb.toString());
    }

    /* renamed from: a */
    public static void m6118a(StringBuilder sb, String str, TextView textView) {
        sb.append(str);
        textView.setText(sb.toString());
    }

    /* renamed from: a */
    public static void m6119a(StringBuilder sb, String str, PrintStream printStream) {
        sb.append(str);
        printStream.println(sb.toString());
    }

    /* renamed from: a */
    public static void m6121a(Locale locale, long j, TextView textView) {
        textView.setText(NumberFormat.getInstance(locale).format(j));
    }


    /* renamed from: a */
    public static boolean m6129a(View view, String str) {
        return view.getTag().toString().equals(str);
    }

    /* renamed from: a */
    public static boolean m6130a(TextView textView, String str) {
        return textView.getText().toString().equals(str);
    }

    /* renamed from: a */
    public static boolean m6131a(AppCompatEditText appCompatEditText, String str) {
        return appCompatEditText.getText().toString().equals(str);
    }

    /* renamed from: a */
    public static boolean m6132a(HashMap hashMap, String str, String str2) {
        return hashMap.get(str).toString().equals(str2);
    }

    /* renamed from: b */
    public static int m6133b(int i, int i2, int i3, int i4) {
        return ((i * i2) / i3) + i4;
    }

    /* renamed from: b */
    public static int m6134b(AppCompatEditText appCompatEditText) {
        return appCompatEditText.getText().toString().length();
    }

    /* renamed from: b */
    public static Float m6135b(EditText editText) {
        return Float.valueOf(Float.parseFloat(editText.getText().toString()));
    }


    /* renamed from: b */
    public static String m6137b(String str, String str2) {
        return str + str2;
    }

    /* renamed from: b */
    public static StringBuilder m6138b(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(str);
        return sb;
    }

    /* renamed from: b */
    public static StringBuilder m6139b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    /* renamed from: b */
    public static void m6141b(String str, int i, String str2) {
        Log.d(str2, str + i);
    }

    /* renamed from: b */
    public static void m6142b(String str, Object[] objArr, StringBuilder sb, String str2) {
        sb.append(String.format(str, objArr));
        sb.append(str2);
    }

    /* renamed from: b */
    public static void m6143b(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    /* renamed from: c */
    public static int m6145c(EditText editText) {
        return Integer.parseInt(editText.getText().toString());
    }

    /* renamed from: c */
    public static int m6146c(AppCompatEditText appCompatEditText) {
        return appCompatEditText.getText().toString().trim().length();
    }

    /* renamed from: c */
    public static Intent m6147c(int i, String str) {
        Intent intent = new Intent();
        intent.addFlags(i);
        intent.setAction(str);
        return intent;
    }

    /* renamed from: c */
    public static StringBuilder m6148c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    /* renamed from: c */
    public static void m6149c(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        Log.w(str4, sb.toString());
    }

    /* renamed from: d */
    public static int m6150d(EditText editText) {
        return editText.getText().toString().length();
    }

    /* renamed from: d */
    public static HashMap m6151d(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        return hashMap;
    }

}
