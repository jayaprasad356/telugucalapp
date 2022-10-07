package com.vibame.telugupanchangamcalendar.model;

public class GrahaluTab {
    String id,grahalu_id,subcategory_id,title,description,sub_title,sub_description;

    public GrahaluTab(String id, String grahalu_id, String subcategory_id, String title, String description, String sub_title, String sub_description) {
        this.id = id;
        this.grahalu_id = grahalu_id;
        this.subcategory_id = subcategory_id;
        this.title = title;
        this.description = description;
        this.sub_title = sub_title;
        this.sub_description = sub_description;
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

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getSub_description() {
        return sub_description;
    }

    public void setSub_description(String sub_description) {
        this.sub_description = sub_description;
    }
}

