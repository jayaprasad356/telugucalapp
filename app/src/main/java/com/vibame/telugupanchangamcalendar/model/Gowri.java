package com.vibame.telugupanchangamcalendar.model;

public class Gowri {
    String id,time,morning,night;

    public Gowri(String id, String time, String morning, String night) {
        this.id = id;
        this.time = time;
        this.morning = morning;
        this.night = night;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }
}

