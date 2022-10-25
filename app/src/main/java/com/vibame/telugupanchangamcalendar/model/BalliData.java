package com.vibame.telugupanchangamcalendar.model;

public class BalliData {
    private String title, description, subTitle1, subTitle2, subDesc1a, subDesc2a, subDesc1b, subDesc2b;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubTitle1() {
        return subTitle1;
    }

    public void setSubTitle1(String subTitle1) {
        this.subTitle1 = subTitle1;
    }

    public String getSubTitle2() {
        return subTitle2;
    }

    public void setSubTitle2(String subTitle2) {
        this.subTitle2 = subTitle2;
    }

    public String getSubDesc1a() {
        return subDesc1a;
    }

    public void setSubDesc1a(String subDesc1a) {
        this.subDesc1a = subDesc1a;
    }

    public String getSubDesc2a() {
        return subDesc2a;
    }

    public void setSubDesc2a(String subDesc2a) {
        this.subDesc2a = subDesc2a;
    }

    public String getSubDesc1b() {
        return subDesc1b;
    }

    public void setSubDesc1b(String subDesc1b) {
        this.subDesc1b = subDesc1b;
    }

    public String getSubDesc2b() {
        return subDesc2b;
    }

    public void setSubDesc2b(String subDesc2b) {
        this.subDesc2b = subDesc2b;
    }

    public BalliData(String title, String description, String subTitle1, String subTitle2, String subDesc1a, String subDesc2a, String subDesc1b, String subDesc2b) {
        this.title = title;
        this.description = description;
        this.subTitle1 = subTitle1;
        this.subTitle2 = subTitle2;
        this.subDesc1a = subDesc1a;
        this.subDesc2a = subDesc2a;
        this.subDesc1b = subDesc1b;
        this.subDesc2b = subDesc2b;
    }
}
