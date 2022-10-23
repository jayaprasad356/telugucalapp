package com.vibame.telugupanchangamcalendar.model;

public class SakunaluData {
    private String description;
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SakunaluData(String title, String description) {
        this.description = description;
        this.title = title;
    }
}
