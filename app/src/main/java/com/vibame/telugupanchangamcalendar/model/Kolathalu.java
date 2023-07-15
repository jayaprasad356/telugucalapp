package com.vibame.telugupanchangamcalendar.model;

public class Kolathalu {


    private String id;
    private String kolathalu_id;

    private String sub_title;
    private String sub_description;
    private String subtitle2;
    private String title;


    public Kolathalu(String id,String kolathalu_id,String title, String sub_title, String sub_description, String subtitle2) {
        this.id = id;
        this.kolathalu_id = kolathalu_id;
        this.title = title;
        this.sub_title = sub_title;
        this.sub_description = sub_description;
        this.subtitle2 = subtitle2;
    }

    public String getId() {
        return id;
    }

    public String getKolathalu_id() {
        return kolathalu_id;
    }



    public String getTitle() {
        return title;
    }

    public String getSub_title() {
        return sub_title;
    }


    public String getSub_description() {
        return sub_description;
    }


    public String getSubtitle2() {
        return subtitle2;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setKolathalu_id(String kolathalu_id) {
        this.kolathalu_id = kolathalu_id;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }


    public void setSub_description(String sub_description) {
        this.sub_description = sub_description;
    }


    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }




}
