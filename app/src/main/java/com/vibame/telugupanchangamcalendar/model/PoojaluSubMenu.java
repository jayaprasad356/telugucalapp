package com.vibame.telugupanchangamcalendar.model;

public class PoojaluSubMenu {
    String id,poojalu_id,name,image;

    public PoojaluSubMenu(String id, String poojalu_id, String name, String image) {
        this.id = id;
        this.poojalu_id = poojalu_id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoojalu_id() {
        return poojalu_id;
    }

    public void setPoojalu_id(String poojalu_id) {
        this.poojalu_id = poojalu_id;
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

