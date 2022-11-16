package com.vibame.telugupanchangamcalendar.activities;



import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.vibame.telugupanchangamcalendar.source.C3709a;


/* renamed from: l.g */
public class C2944g implements View.OnClickListener {

    /* renamed from: b */
    public final /* synthetic */ Dialog f10279b;

    /* renamed from: c */
    public final /* synthetic */ GstCalulatorActivity f10280c;

    public C2944g(GstCalulatorActivity gstCalulation, Dialog dialog) {
        this.f10280c = gstCalulation;
        this.f10279b = dialog;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onClick(View view) {
        GstCalulatorActivity gstCalulation = this.f10280c;
        if (gstCalulation.f2354l.mo2459c(gstCalulation, "permission") == 2) {
            Intent c = C3709a.m6147c(268435456, "android.settings.APPLICATION_DETAILS_SETTINGS");
            c.setData(Uri.fromParts("package", this.f10280c.getApplicationContext().getPackageName(), (String) null));
            this.f10280c.startActivity(c);
            this.f10279b.dismiss();
            return;
        }
        this.f10280c.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 153);
        this.f10279b.dismiss();
    }
}

