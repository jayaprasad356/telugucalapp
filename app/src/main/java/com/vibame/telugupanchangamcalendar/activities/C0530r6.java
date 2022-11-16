package com.vibame.telugupanchangamcalendar.activities;


import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.google.android.gms.ads.RequestConfiguration;
import com.vibame.telugupanchangamcalendar.source.C3709a;

import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;


/* renamed from: b0.c.a.r6 */
public class C0530r6 {

    /* renamed from: a */
    public static ProgressDialog f2050a;

    /* renamed from: b */
    public static String[] f2051b = {"జనవరి", "ఫిబ్రవరి", "మార్చి", "ఏప్రిల్", "మే", "జూన్", "జూలై", "ఆగస్టు", "సెప్టెంబర్", "అక్టోబర్", "నవంబర్", "డిసెంబర్"};

    /* renamed from: c */
    public static String[] f2052c = {"ఆదివారము", "సోమవారము", "మంగళవారము", "బుధవారము", "గురువారము", "శుక్రవారము", "శనివారము"};

    /* renamed from: a */
    public static void m1130a(Context context, String str) {
        String str2 = "#3A7CEC";
        if (context.getSharedPreferences("pref", 0).getInt("tab_flag", 0) == 0) {
            str2 = context.getSharedPreferences("pref", 0).getString("color_codee", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        } else if (context.getSharedPreferences("pref", 0).getInt("tab_flag", 0) != 1) {
            if (context.getSharedPreferences("pref", 0).getInt("tab_flag", 0) == 2) {
                str2 = "#C79500";
            } else if (context.getSharedPreferences("pref", 0).getInt("tab_flag", 0) == 3) {
                str2 = "#274200";
            } else if (context.getSharedPreferences("pref", 0).getInt("tab_flag", 0) == 4) {
                str2 = "#6FBF00";
            }
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            C1737a aVar = new C1737a();
            intent.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", ActivityOptions.makeCustomAnimation(context, 17432578, 17432579).toBundle());
            aVar.f6943a = Integer.valueOf(Color.parseColor(str2) | -16777216);
            if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
                Bundle bundle = new Bundle();
                bundle.putBinder("android.support.customtabs.extra.SESSION", (IBinder) null);
                intent.putExtras(bundle);
            }
            intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
            Integer num = aVar.f6943a;
            Bundle bundle2 = new Bundle();
            if (num != null) {
                bundle2.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
            }
            intent.putExtras(bundle2);
            intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
            C1741e eVar = new C1741e(intent, (Bundle) null);
            eVar.f6948a.setData(Uri.parse(str));
            C2021a.m4391a(context, eVar.f6948a, eVar.f6949b);
        } catch (ActivityNotFoundException | NullPointerException e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.VIEW");
                intent2.addCategory("android.intent.category.BROWSABLE");
                intent2.setData(Uri.parse(str));
                context.startActivity(intent2);
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static int m1138b(String str) {
        if (str.equals("జనవరి")) {
            return 1;
        }
        if (str.equals("ఫిబ్రవరి")) {
            return 2;
        }
        if (str.equals("మార్చి")) {
            return 3;
        }
        if (str.equals("ఏప్రిల్")) {
            return 4;
        }
        if (str.equals("మే")) {
            return 5;
        }
        if (str.equals("జూన్")) {
            return 6;
        }
        if (str.equals("జూలై")) {
            return 7;
        }
        if (str.equals("ఆగస్టు")) {
            return 8;
        }
        if (str.equals("సెప్టెంబర్")) {
            return 9;
        }
        if (str.equals("అక్టోబర్")) {
            return 10;
        }
        if (str.equals("నవంబర్")) {
            return 11;
        }
        return str.equals("డిసెంబర్") ? 12 : 0;
    }

    /* renamed from: c */
    public static int m1142c(String str) {
        if (str.equals("ఆదివారము")) {
            return 0;
        }
        if (str.equals("సోమవారము")) {
            return 1;
        }
        if (str.equals("మంగళవారము")) {
            return 2;
        }
        if (str.equals("బుధవారము")) {
            return 3;
        }
        if (str.equals("గురువారము")) {
            return 4;
        }
        if (str.equals("శుక్రవారము")) {
            return 5;
        }
        if (str.equals("శనివారము")) {
            return 6;
        }
        return 0;
    }

    /* renamed from: d */
    public static void m1147d(Context context, String str) {
        Toast.makeText(context, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED + str, Toast.LENGTH_SHORT).show();
    }

    /* renamed from: e */
    public static boolean m1148e(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= 23) {
            if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
                return false;
            }
            if (!networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) && !networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return false;
            }
        } else if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        } else {
            if (!(activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 0)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public static int m1149f(Context context) {
        PackageInfo packageInfo;
        long j;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            j = packageInfo.getLongVersionCode();
        } else {
            j = (long) packageInfo.versionCode;
        }
        return (int) j;
    }

    /* renamed from: g */
    public static String m1150g(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo.versionName;
    }

    /* renamed from: d */
    public static String m1146d(String str) {
        return str.length() == 1 ? C3709a.m6137b("0", str) : str;
    }

    /* renamed from: d */
    public static int m1145d(Context context) {
        C0619z5 z5Var = new C0619z5();
        if (z5Var.mo2460d(context, "color_codee").equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            z5Var.mo2457a(context, "color_codee", "#CC004C");
        }
        if (z5Var.mo2459c(context, "tab_flag") == 0) {
            return Color.parseColor(z5Var.mo2460d(context, "color_codee"));
        }
        if (z5Var.mo2459c(context, "tab_flag") == 1) {
            return Color.parseColor("#3A7CEC");
        }
        if (z5Var.mo2459c(context, "tab_flag") == 2) {
            return Color.parseColor("#C79500");
        }
        if (z5Var.mo2459c(context, "tab_flag") == 3) {
            return Color.parseColor("#274200");
        }
        if (z5Var.mo2459c(context, "tab_flag") == 4) {
            return Color.parseColor("#6FBF00");
        }
        return z5Var.mo2459c(context, "color_vibrant");
    }

    /* renamed from: c */
    public static void m1144c(Context context, String str) {
        Toast makeText = Toast.makeText(context, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED + str, 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* renamed from: c */
    public static String m1143c(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    /* renamed from: b */
    public static String m1140b(int i) {
        Calendar instance = Calendar.getInstance();
        if (i != 0) {
            instance.add(5, i);
        }
        int i2 = instance.get(2);
        int i3 = instance.get(1);
        StringBuilder b = C3709a.m6138b(instance.get(5), "/");
        b.append(i2 + 1);
        b.append("/");
        b.append(i3);
        return b.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b9  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Boolean m1139b(android.content.Context r12) {
        /*
            java.lang.String r0 = "pref"
            java.lang.String r1 = "clr_chace"
            java.lang.String r2 = ""
            r3 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            java.util.Calendar r5 = java.util.Calendar.getInstance()
            long r5 = r5.getTimeInMillis()
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat
            java.lang.String r8 = "dd/M/yyyy"
            r7.<init>(r8)
            java.util.Date r8 = new java.util.Date
            r8.<init>(r5)
            java.lang.String r5 = r7.format(r8)
            java.util.StringTokenizer r6 = new java.util.StringTokenizer
            java.lang.String r8 = "/"
            r6.<init>(r5, r8)
            java.lang.String r5 = r6.nextToken()
            int r5 = java.lang.Integer.parseInt(r5)
            java.lang.String r9 = r6.nextToken()
            int r9 = java.lang.Integer.parseInt(r9)
            java.lang.String r6 = r6.nextToken()
            int r6 = java.lang.Integer.parseInt(r6)
            r10 = 1
            int r9 = r9 - r10
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r5)
            r11.append(r8)
            r11.append(r9)
            r11.append(r8)
            r11.append(r6)
            java.lang.String r5 = r11.toString()
            r6 = 0
            java.util.Date r8 = r7.parse(r5)     // Catch:{ ParseException -> 0x0084 }
            android.content.SharedPreferences r9 = r12.getSharedPreferences(r0, r3)     // Catch:{ ParseException -> 0x0082 }
            java.lang.String r9 = r9.getString(r1, r2)     // Catch:{ ParseException -> 0x0082 }
            boolean r9 = r9.equals(r2)     // Catch:{ ParseException -> 0x0082 }
            if (r9 != 0) goto L_0x007c
            android.content.SharedPreferences r5 = r12.getSharedPreferences(r0, r3)     // Catch:{ ParseException -> 0x0082 }
            java.lang.String r5 = r5.getString(r1, r2)     // Catch:{ ParseException -> 0x0082 }
            java.util.Date r5 = r7.parse(r5)     // Catch:{ ParseException -> 0x0082 }
            goto L_0x0080
        L_0x007c:
            java.util.Date r5 = r7.parse(r5)     // Catch:{ ParseException -> 0x0082 }
        L_0x0080:
            r6 = r5
            goto L_0x0090
        L_0x0082:
            r5 = move-exception
            goto L_0x0086
        L_0x0084:
            r5 = move-exception
            r8 = r6
        L_0x0086:
            r5.printStackTrace()
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r7 = "clr_chace : error"
            r5.println(r7)
        L_0x0090:
            android.content.SharedPreferences r12 = r12.getSharedPreferences(r0, r3)
            java.lang.String r12 = r12.getString(r1, r2)
            boolean r12 = r12.equals(r2)
            java.lang.String r0 = "clr_chace : "
            if (r12 == 0) goto L_0x00b9
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r10)
            java.io.PrintStream r12 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r4)
            java.lang.String r0 = r1.toString()
            r12.println(r0)
            goto L_0x00d7
        L_0x00b9:
            int r12 = r8.compareTo(r6)
            if (r12 < 0) goto L_0x00d7
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r10)
            java.io.PrintStream r12 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r4)
            java.lang.String r0 = r1.toString()
            r12.println(r0)
        L_0x00d7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p016b0.p028c.p029a.C0530r6.m1139b(android.content.Context):java.lang.Boolean");
    }

    /* renamed from: a */
    public static ProgressDialog m1125a(Context context, String str, Boolean bool) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        f2050a = progressDialog;
        progressDialog.setMessage(str);
        f2050a.setCancelable(bool.booleanValue());
        return f2050a;
    }

    /* renamed from: a */
    public static String[] m1135a(int i) {
        String[] strArr = new String[i];
        for (int i2 = 0; i2 > i; i2++) {
            strArr[i2] = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        return strArr;
    }


    /* renamed from: b */
    public static void m1141b(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        StringBuilder a = C3709a.m6100a("calendar://telugu_calendar/share:");
        a.append(str.replaceAll("%", "%25"));
        intent.setData(Uri.parse(a.toString()));
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static String[] m1137a(String[] strArr, String[] strArr2) {
        String[] strArr3 = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    /* renamed from: a */
    public static String m1128a(String str) {
        String[] split = str.split("\\ ")[0].split("\\-");
        StringBuilder a = C3709a.m6100a(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        a.append(split[2]);
        a.append("/");
        a.append(split[1]);
        a.append("/");
        a.append(split[0]);
        return a.toString();
    }

    /* renamed from: a */
    public static String m1126a() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        String str3 = Build.BRAND;
        return C3709a.m6087a(C3709a.m6103a(str, "-", str2, "-", str3), "-", Build.PRODUCT);
    }


    /* renamed from: a */
    public static void m1132a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("des", str);
        contentValues.put("date", str2);
        contentValues.put("time", str3);
        contentValues.put("day", str4);
        contentValues.put("month", str5);
        contentValues.put("year", str6);
        contentValues.put("isremaind", str7);
        contentValues.put("isclose", "0");
        PrintStream printStream = System.out;
        printStream.println("data_insert == " + contentValues);
        sQLiteDatabase.insert("notes", (String) null, contentValues);
    }

    /* renamed from: a */
    public static void m1133a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("des", str);
        contentValues.put("date", str8);
        contentValues.put("time", str3);
        contentValues.put("day", str4);
        contentValues.put("month", str5);
        contentValues.put("year", str6);
        contentValues.put("isremaind", str7);
        contentValues.put("isclose", 0);
        PrintStream printStream = System.out;
        printStream.println("data_update == " + contentValues);
        sQLiteDatabase.update("notes", contentValues, "id='" + str2 + "'", (String[]) null);
    }

    /* renamed from: a */
    public static int m1124a(Context context, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        int i = 0;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = context.openOrCreateDatabase("myDB1", 0, (SQLiteDatabase.CursorFactory) null);
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select id from notes where date = '" + str + "' AND time = '" + str2 + "' AND des = '" + str3 + "' order by id desc limit 1", (String[]) null);
            if (rawQuery.getCount() != 0) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /* renamed from: a */
    public static void m1131a(Context context, String str, int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(new SimpleDateFormat("dd/M/yyyy").format(new Date((((long) i) * 86400000) + Calendar.getInstance().getTimeInMillis())), "/");
        int parseInt = Integer.parseInt(stringTokenizer.nextToken());
        int parseInt2 = Integer.parseInt(stringTokenizer.nextToken());
        int parseInt3 = Integer.parseInt(stringTokenizer.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append(parseInt);
        sb.append("/");
        sb.append(parseInt2 - 1);
        sb.append("/");
        sb.append(parseInt3);
        String sb2 = sb.toString();
        SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
        edit.putString(str, sb2);
        edit.commit();
    }

    /* renamed from: a */
    public static boolean m1134a(File file) {
        if (file != null && file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!m1134a(new File(file, file2))) {
                    return false;
                }
            }
            return file.delete();
        } else if (file == null || !file.isFile()) {
            return false;
        } else {
            return file.delete();
        }
    }


    /* renamed from: a */
    public static void m1129a(Context context, View view) {
        ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
