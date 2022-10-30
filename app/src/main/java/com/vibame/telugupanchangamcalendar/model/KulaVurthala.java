package com.vibame.telugupanchangamcalendar.model;

public class KulaVurthala {
    private String title;
    private String description;

    public KulaVurthala(String occupationName, String occupationReference) {
        title = occupationName;
        description = occupationReference;
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
