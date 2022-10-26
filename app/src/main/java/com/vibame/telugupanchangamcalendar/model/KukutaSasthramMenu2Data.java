package com.vibame.telugupanchangamcalendar.model;

public class KukutaSasthramMenu2Data {
    private String title,description, star, winning, lossing;

    public KukutaSasthramMenu2Data(String title, String description, String star, String winning, String lossing) {
        this.title = title;
        this.description = description;
        this.star = star;
        this.winning = winning;
        this.lossing = lossing;
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

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getWinning() {
        return winning;
    }

    public void setWinning(String winning) {
        this.winning = winning;
    }

    public String getLossing() {
        return lossing;
    }

    public void setLossing(String lossing) {
        this.lossing = lossing;
    }
}
