package com.vibame.telugupanchangamcalendar.model;

public class NakTab {
    String id,nakshatralu_id,title,description,sub_title,sub_description;

    public NakTab(String id, String nakshatralu_id, String title, String description, String sub_title, String sub_description) {
        this.id = id;
        this.nakshatralu_id = nakshatralu_id;
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

    public String getNakshatralu_id() {
        return nakshatralu_id;
    }

    public void setNakshatralu_id(String nakshatralu_id) {
        this.nakshatralu_id = nakshatralu_id;
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

