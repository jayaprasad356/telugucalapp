package com.vibame.telugupanchangamcalendar.model;

public class PoojaluTab {
    String id,poojalu_id,subcategory_id,title,description;

    public PoojaluTab(String id, String poojalu_id, String subcategory_id, String title, String description) {
        this.id = id;
        this.poojalu_id = poojalu_id;
        this.subcategory_id = subcategory_id;
        this.title = title;
        this.description = description;
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

    public String getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(String subcategory_id) {
        this.subcategory_id = subcategory_id;
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

