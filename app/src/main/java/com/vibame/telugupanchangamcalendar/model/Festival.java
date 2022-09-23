package com.vibame.telugupanchangamcalendar.model;

public class Festival {
    String id,date,festival;

    public Festival(String id, String date, String festival) {
        this.id = id;
        this.date = date;
        this.festival = festival;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFestival() {
        return festival;
    }

    public void setFestival(String festival) {
        this.festival = festival;
    }
}

