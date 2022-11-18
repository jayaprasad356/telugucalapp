package com.vibame.telugupanchangamcalendar.activities;



import android.app.DatePickerDialog;
import android.widget.DatePicker;

import com.vibame.telugupanchangamcalendar.source.C3709a;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/* renamed from: k0.i */
public class C10236i implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a */
    public final /* synthetic */ DateplusActivity f36320a;

    public C10236i(DateplusActivity dateplus_MainActivity) {
        this.f36320a = dateplus_MainActivity;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        DateplusActivity dateplus_MainActivity = this.f36320a;
        dateplus_MainActivity.f36486t = i;
        dateplus_MainActivity.f36485s = i2 + 1;
        dateplus_MainActivity.f36484r = i3;
        dateplus_MainActivity.f36488v = Calendar.getInstance();
        this.f36320a.f36488v.set(5, i3);
        this.f36320a.f36488v.set(2, i2);
        this.f36320a.f36488v.set(1, i);
        DateplusActivity dateplus_MainActivity2 = this.f36320a;
        dateplus_MainActivity2.f36487u = dateplus_MainActivity2.f36488v.getTime();
        PrintStream printStream = System.out;
        StringBuilder a = C3709a.m6100a("today==");
        a.append(this.f36320a.f36487u);
        printStream.println(a.toString());
        this.f36320a.f36470d.setText(new SimpleDateFormat("dd-MMM-yyyy").format(this.f36320a.f36487u));
    }
}

