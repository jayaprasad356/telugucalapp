package com.vibame.telugupanchangamcalendar.activities;

import android.app.DatePickerDialog;
import android.widget.DatePicker;

import com.vibame.telugupanchangamcalendar.source.C3709a;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* renamed from: k0.h */
public class C10235h implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a */
    public final /* synthetic */ DateplusActivity f36319a;

    public C10235h(DateplusActivity dateplus_MainActivity) {
        this.f36319a = dateplus_MainActivity;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        DateplusActivity dateplus_MainActivity = this.f36319a;
        dateplus_MainActivity.f36486t = i;
        dateplus_MainActivity.f36485s = i2 + 1;
        dateplus_MainActivity.f36484r = i3;
        dateplus_MainActivity.f36488v = Calendar.getInstance();
        DateplusActivity dateplus_MainActivity2 = this.f36319a;
        dateplus_MainActivity2.f36488v.set(5, dateplus_MainActivity2.f36484r);
        DateplusActivity dateplus_MainActivity3 = this.f36319a;
        dateplus_MainActivity3.f36488v.set(2, dateplus_MainActivity3.f36485s - 1);
        DateplusActivity dateplus_MainActivity4 = this.f36319a;
        dateplus_MainActivity4.f36488v.set(1, dateplus_MainActivity4.f36486t);
        DateplusActivity dateplus_MainActivity5 = this.f36319a;
        dateplus_MainActivity5.f36487u = dateplus_MainActivity5.f36488v.getTime();
        PrintStream printStream = System.out;
        StringBuilder a = C3709a.m6100a("today==");
        a.append(this.f36319a.f36487u);
        printStream.println(a.toString());
        this.f36319a.f36470d.setText(new SimpleDateFormat("dd-MMM-yyyy").format(this.f36319a.f36487u));
    }
}