package com.vibame.telugupanchangamcalendar.activities;

/* renamed from: o.e.e.k.c.c.a */
public abstract class C7812a implements C7855m, Comparable<C7812a> {
    /* renamed from: a */
    public final int compareTo(C7812a aVar) {
        Class<?> cls = getClass();
        Class<?> cls2 = aVar.getClass();
        if (cls != cls2) {
            return cls.getName().compareTo(cls2.getName());
        }
        return mo20379b(aVar);
    }

    /* renamed from: b */
    public abstract int mo20379b(C7812a aVar);

    /* renamed from: e */
    public abstract String mo20381e();
}

