package com.vibame.telugupanchangamcalendar.model;

public class VideosView {
    String id,video;

    public VideosView(String id, String video) {
        this.id = id;
        this.video = video;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}

