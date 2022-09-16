package com.vibame.telugupanchangamcalendar;

public class FestivalMonths {
    private String monthNames,festivalsList,adPlustxt;
    private Boolean expandable;

    public Boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(Boolean expandable) {
        this.expandable = expandable;


    }

    public FestivalMonths(String monthNames, String festivalsList, String adPlustxt) {
        this.monthNames = monthNames;
        this.festivalsList = festivalsList;
        this.adPlustxt = adPlustxt;
        this.expandable = false;
    }

    public String getMonthNames() {
        return monthNames;
    }

    public void setMonthNames(String monthNames) {
        this.monthNames = monthNames;
    }

    public String getFestivalsList() {
        return festivalsList;
    }

    public void setFestivalsList(String festivalsList) {
        this.festivalsList = festivalsList;
    }

    @Override
    public String toString() {
        return "FestivalMonths{" +
                "monthNames='" + monthNames + '\'' +
                ", festivalsList='" + festivalsList + '\'' +
                ", adPlustxt='" + adPlustxt + '\'' +
                '}';
    }

    public String getAdPlustxt() {
        return adPlustxt;
    }

    public void setAdPlustxt(String adPlustxt) {
        this.adPlustxt = adPlustxt;
    }
}
