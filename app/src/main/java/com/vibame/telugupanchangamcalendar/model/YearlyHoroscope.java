package com.vibame.telugupanchangamcalendar.model;

public class YearlyHoroscope {
    String id,sub_title,sub_description;

    public YearlyHoroscope(String id, String sub_title, String sub_description) {
        this.id = id;
        this.sub_title = sub_title;
        this.sub_description = sub_description;
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

