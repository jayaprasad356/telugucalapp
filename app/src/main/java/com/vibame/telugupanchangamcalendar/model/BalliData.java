package com.vibame.telugupanchangamcalendar.model;

public class BalliData {
    private String id, title, description, subtitle1, subtitle2, subdescription1a, subdescription2a, subdescription1b, subdescription2b;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getSubtitle1() {
        return subtitle1;
    }

    public void setSubtitle1(String subtitle1) {
        this.subtitle1 = subtitle1;
    }

    public String getSubtitle2() {
        return subtitle2;
    }

    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }

    public String getSubdescription1a() {
        return subdescription1a;
    }

    public void setSubdescription1a(String subdescription1a) {
        this.subdescription1a = subdescription1a;
    }

    public String getSubdescription2a() {
        return subdescription2a;
    }

    public void setSubdescription2a(String subdescription2a) {
        this.subdescription2a = subdescription2a;
    }

    public String getSubdescription1b() {
        return subdescription1b;
    }

    public void setSubdescription1b(String subdescription1b) {
        this.subdescription1b = subdescription1b;
    }

    public String getSubdescription2b() {
        return subdescription2b;
    }

    public void setSubdescription2b(String subdescription2b) {
        this.subdescription2b = subdescription2b;
    }

    public BalliData(String title, String description, String subTitle1, String subTitle2, String subDesc1a, String subDesc2a, String subDesc1b, String subDesc2b) {
        this.title = title;
        this.description = description;
        this.subtitle1 = subTitle1;
        this.subtitle2 = subTitle2;
        this.subdescription1a = subDesc1a;
        this.subdescription2a = subDesc2a;
        this.subdescription1b = subDesc1b;
        this.subdescription2b = subDesc2b;
    }
}
