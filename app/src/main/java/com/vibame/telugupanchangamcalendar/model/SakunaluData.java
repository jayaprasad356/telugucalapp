package com.vibame.telugupanchangamcalendar.model;

public class SakunaluData {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id, description;
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
