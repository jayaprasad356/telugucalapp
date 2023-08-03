package com.vibame.telugupanchangamcalendar.model;

public class Notification {

    String id;

    public Notification(String id, String discription, String date, String time) {
        this.id = id;
        this.discription = discription;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    String discription;
    String date;
    String time;


}
