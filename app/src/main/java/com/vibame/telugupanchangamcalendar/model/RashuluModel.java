package com.vibame.telugupanchangamcalendar.model;

public class RashuluModel {
    private String title;
    private String description;

    public RashuluModel(String rashiNmae, String rashiTime) {
        title = rashiNmae;
        description = rashiTime;
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
