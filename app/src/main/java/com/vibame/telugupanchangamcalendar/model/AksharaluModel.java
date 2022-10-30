package com.vibame.telugupanchangamcalendar.model;

public class AksharaluModel {
    private String title;
    private String description;

    public AksharaluModel(String heading, String topic) {
        title = heading;
        description = topic;
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
}
