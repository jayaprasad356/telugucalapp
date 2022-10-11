package com.vibame.telugupanchangamcalendar.model;

public class Audio {
    String id,title,image,lyrics;

    public Audio(String id, String title, String image, String lyrics) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.lyrics = lyrics;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}

