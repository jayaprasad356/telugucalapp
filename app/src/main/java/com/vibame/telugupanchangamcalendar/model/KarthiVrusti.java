package com.vibame.telugupanchangamcalendar.model;

public class KarthiVrusti {
    String id,karthi,nakshathram,pravesham,rashi,ganam,karthi_result,date_month;

    public KarthiVrusti(String id, String karthi, String nakshathram, String pravesham, String rashi, String ganam, String karthi_result, String date_month) {
        this.id = id;
        this.karthi = karthi;
        this.nakshathram = nakshathram;
        this.pravesham = pravesham;
        this.rashi = rashi;
        this.ganam = ganam;
        this.karthi_result = karthi_result;
        this.date_month = date_month;
    }

    public String getDate_month() {
        return date_month;
    }

    public void setDate_month(String date_month) {
        this.date_month = date_month;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKarthi() {
        return karthi;
    }

    public void setKarthi(String karthi) {
        this.karthi = karthi;
    }

    public String getNakshathram() {
        return nakshathram;
    }

    public void setNakshathram(String nakshathram) {
        this.nakshathram = nakshathram;
    }

    public String getPravesham() {
        return pravesham;
    }

    public void setPravesham(String pravesham) {
        this.pravesham = pravesham;
    }

    public String getRashi() {
        return rashi;
    }

    public void setRashi(String rashi) {
        this.rashi = rashi;
    }

    public String getGanam() {
        return ganam;
    }

    public void setGanam(String ganam) {
        this.ganam = ganam;
    }

    public String getKarthi_result() {
        return karthi_result;
    }

    public void setKarthi_result(String karthi_result) {
        this.karthi_result = karthi_result;
    }
}

