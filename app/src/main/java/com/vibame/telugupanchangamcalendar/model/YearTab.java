package com.vibame.telugupanchangamcalendar.model;

public class YearTab {
    String id,yearly_horoscope_id,title,description;

    public YearTab(String id, String yearly_horoscope_id, String title, String description) {
        this.id = id;
        this.yearly_horoscope_id = yearly_horoscope_id;
        this.title = title;
        this.description = description;
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

