package com.vibame.telugupanchangamcalendar.model;

public class YearlyHoroscope {
    String id,graha_dhashakalamu_title,graha_dhashakalamu_description;

    public YearlyHoroscope(String id, String graha_dhashakalamu_title, String graha_dhashakalamu_description) {
        this.id = id;
        this.graha_dhashakalamu_title = graha_dhashakalamu_title;
        this.graha_dhashakalamu_description = graha_dhashakalamu_description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGraha_dhashakalamu_title() {
        return graha_dhashakalamu_title;
    }

    public void setGraha_dhashakalamu_title(String graha_dhashakalamu_title) {
        this.graha_dhashakalamu_title = graha_dhashakalamu_title;
    }

    public String getGraha_dhashakalamu_description() {
        return graha_dhashakalamu_description;
    }

    public void setGraha_dhashakalamu_description(String graha_dhashakalamu_description) {
        this.graha_dhashakalamu_description = graha_dhashakalamu_description;
    }
}

