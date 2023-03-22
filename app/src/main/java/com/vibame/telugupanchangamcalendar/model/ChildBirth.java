package com.vibame.telugupanchangamcalendar.model;

public class ChildBirth {
    String id,sub_title,sub_description,date_month;

    public ChildBirth(String id, String sub_title, String sub_description, String date_month) {
        this.id = id;
        this.sub_title = sub_title;
        this.sub_description = sub_description;
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

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getSub_description() {
        return sub_description;
    }

    public void setSub_description(String sub_description) {
        this.sub_description = sub_description;
    }
}

