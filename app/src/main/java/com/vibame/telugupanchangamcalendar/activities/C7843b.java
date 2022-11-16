package com.vibame.telugupanchangamcalendar.activities;


/* renamed from: o.e.e.k.d.b */
public final class C7843b {

    /* renamed from: a */
    public final byte[] f30493a;

    /* renamed from: b */
    public final int f30494b;

    /* renamed from: c */
    public final int f30495c;

    public C7843b(byte[] bArr) {
        int length = bArr.length;
        if (length < 0) {
            throw new IllegalArgumentException("end < start");
        } else if (length <= bArr.length) {
            this.f30493a = bArr;
            this.f30494b = 0;
            this.f30495c = length - 0;
        } else {
            throw new IllegalArgumentException("end > bytes.length");
        }
    }
}
