package com.vibame.telugupanchangamcalendar.model;

public class KukutaSasthramMenu2Data {
    private String description, star_des, winning_des, losing_des;
    private String title, star, winning, lossing;

    public KukutaSasthramMenu2Data(String description, String star_des, String winning_des, String losing_des, String title, String star, String winning, String losing) {
        this.description = description;
        this.star_des = star_des;
        this.winning_des = winning_des;
        this.losing_des = losing_des;
        this.title = title;
        this.star = star;
        this.winning = winning;
        this.lossing = losing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStar_des() {
        return star_des;
    }

    public void setStar_des(String star_des) {
        this.star_des = star_des;
    }

    public String getWinning_des() {
        return winning_des;
    }

    public void setWinning_des(String winning_des) {
        this.winning_des = winning_des;
    }

    public String getLosing_des() {
        return losing_des;
    }

    public void setLosing_des(String losing_des) {
        this.losing_des = losing_des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
