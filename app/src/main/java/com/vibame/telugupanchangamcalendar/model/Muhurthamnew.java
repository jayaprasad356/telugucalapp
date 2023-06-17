package com.vibame.telugupanchangamcalendar.model;

public class Muhurthamnew {
    String id,month,year,text1;

    public Muhurthamnew(String id, String month, String year, String text1) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.text1 = text1;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }
}

