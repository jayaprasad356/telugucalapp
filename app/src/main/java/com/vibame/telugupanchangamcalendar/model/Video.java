package com.vibame.telugupanchangamcalendar.model;

public class Video {
    String id,title,link;

    public Video(String id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

