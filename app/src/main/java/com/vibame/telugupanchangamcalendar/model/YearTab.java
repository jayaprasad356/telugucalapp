package com.vibame.telugupanchangamcalendar.model;

public class YearTab {
    String id,yearly_horoscope_id,sub_title,sub_description;

    public YearTab(String id, String yearly_horoscope_id, String sub_title, String sub_description) {
        this.id = id;
        this.yearly_horoscope_id = yearly_horoscope_id;
        this.sub_title = sub_title;
        this.sub_description = sub_description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYearly_horoscope_id() {
        return yearly_horoscope_id;
    }

    public void setYearly_horoscope_id(String yearly_horoscope_id) {
        this.yearly_horoscope_id = yearly_horoscope_id;
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

