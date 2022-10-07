package com.vibame.telugupanchangamcalendar.model;

public class GrahaluSubMenu {
    String id,grahalu_id,name,image;

    public GrahaluSubMenu(String id, String grahalu_id, String name, String image) {
        this.id = id;
        this.grahalu_id = grahalu_id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrahalu_id() {
        return grahalu_id;
    }

    public void setGrahalu_id(String grahalu_id) {
        this.grahalu_id = grahalu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

