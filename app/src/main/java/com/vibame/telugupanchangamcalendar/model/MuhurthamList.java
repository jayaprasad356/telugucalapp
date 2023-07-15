package com.vibame.telugupanchangamcalendar.model;

public class MuhurthamList {
    String id,subha_muhurtham_id,date_month,description;


    public MuhurthamList(String id, String subha_muhurtham_id, String date_month, String description) {
        this.id = id;
        this.subha_muhurtham_id = subha_muhurtham_id;
        this.date_month = date_month;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubha_muhurtham_id() {
        return subha_muhurtham_id;
    }

    public void setSubha_muhurtham_id(String subha_muhurtham_id) {
        this.subha_muhurtham_id = subha_muhurtham_id;
    }

    public String getDate_month() {
        return date_month;
    }

    public void setDate_month(String date_month) {
        this.date_month = date_month;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

