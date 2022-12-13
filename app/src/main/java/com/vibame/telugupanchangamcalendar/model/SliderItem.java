package com.vibame.telugupanchangamcalendar.model;

public class SliderItem {

    private int imageUrl ;
    private String title;

    public SliderItem(int imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
