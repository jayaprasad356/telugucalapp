package com.vibame.telugupanchangamcalendar.model;

public class MonthlyModel {


    private String id;
    private String month;
    private String year;
    private String text1;
    private String pournami;
    private String amavasya;
    private String akadhashi;
    private String pradhosha;
    private String shasti;
    private String chavithi;
    private String masa_shiva_Rathri;
    private String sankatahara_chathurdhi;
    private String festivals;
    private String holiday;


    public MonthlyModel(String id, String month, String year, String text1, String pournami, String amavasya, String akadhashi, String pradhosha, String shasti, String chavithi, String masa_shiva_Rathri, String sankatahara_chathurdhi, String festivals, String holiday) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.text1 = text1;
        this.pournami = pournami;
        this.amavasya = amavasya;
        this.akadhashi = akadhashi;
        this.pradhosha = pradhosha;
        this.shasti = shasti;
        this.chavithi = chavithi;
        this.masa_shiva_Rathri = masa_shiva_Rathri;
        this.sankatahara_chathurdhi = sankatahara_chathurdhi;
        this.festivals = festivals;
        this.holiday = holiday;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getPournami() {
        return pournami;
    }

    public void setPournami(String pournami) {
        this.pournami = pournami;
    }

    public String getAmavasya() {
        return amavasya;
    }

    public void setAmavasya(String amavasya) {
        this.amavasya = amavasya;
    }

    public String getAkadhashi() {
        return akadhashi;
    }

    public void setAkadhashi(String akadhashi) {
        this.akadhashi = akadhashi;
    }

    public String getPradhosha() {
        return pradhosha;
    }

    public void setPradhosha(String pradhosha) {
        this.pradhosha = pradhosha;
    }

    public String getShasti() {
        return shasti;
    }

    public void setShasti(String shasti) {
        this.shasti = shasti;
    }

    public String getChavithi() {
        return chavithi;
    }

    public void setChavithi(String chavithi) {
        this.chavithi = chavithi;
    }

    public String getMasa_shiva_Rathri() {
        return masa_shiva_Rathri;
    }

    public void setMasa_shiva_Rathri(String masa_shiva_Rathri) {
        this.masa_shiva_Rathri = masa_shiva_Rathri;
    }

    public String getSankatahara_chathurdhi() {
        return sankatahara_chathurdhi;
    }

    public void setSankatahara_chathurdhi(String sankatahara_chathurdhi) {
        this.sankatahara_chathurdhi = sankatahara_chathurdhi;
    }

    public String getFestivals() {
        return festivals;
    }

    public void setFestivals(String festivals) {
        this.festivals = festivals;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

}
