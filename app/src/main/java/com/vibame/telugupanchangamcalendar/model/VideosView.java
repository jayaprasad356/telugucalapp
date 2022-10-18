package com.vibame.telugupanchangamcalendar.model;

public class VideosView {
    String id,name,video;

    public VideosView(String id, String name, String video) {
        this.id = id;
        this.name = name;
        this.video = video;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}

