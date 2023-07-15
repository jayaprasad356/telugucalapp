package com.vibame.telugupanchangamcalendar.model;

public class Ramayanam {
    String id,title,image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ramayanam(String title) {
        this.title = title;
    }

public Ramayanam(String id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public Ramayanam(String id, String title) {
        this.id = id;
        this.title = title;
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
}
