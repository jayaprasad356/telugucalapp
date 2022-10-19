package com.vibame.telugupanchangamcalendar.model;

public class Thidhilu {
    String id,name,day,date;

    public Thidhilu(String id, String name, String day, String date) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

