package com.vibame.telugupanchangamcalendar.model;

public class Kolathalu {
    private String subdescription1;

    public String getSubtitle1() {
        return subtitle1;
    }

    public void setSubtitle1(String subtitle1) {
        this.subtitle1 = subtitle1;
    }

    public String getSubdescription2() {
        return subdescription2;
    }

    public void setSubdescription2(String subdescription2) {
        this.subdescription2 = subdescription2;
    }

    public String getSubtitle2() {
        return subtitle2;
    }

    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }

    private String subtitle1;
    private String subdescription2;
    private String subtitle2;
    private String title;

    public String getSubdescription1() {
        return subdescription1;
    }

    public void setSubdescription1(String subdescription1) {
        this.subdescription1 = subdescription1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Kolathalu(String title, String description) {
        this.subdescription1 = description;
        this.title = title;
    }
}
