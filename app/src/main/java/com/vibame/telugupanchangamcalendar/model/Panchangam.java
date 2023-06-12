package com.vibame.telugupanchangamcalendar.model;

import java.util.ArrayList;

public class Panchangam {


    String id,date,sunrise,sunset,moonrise,	moonset,text1,text2,text3,text4,text5,text6,festivals,thidhi,nakshatram,yogam,karanam,abhijith_muhurtham,bhrama_muhurtham,amrutha_kalam,rahukalam,yamakandam,dhurmuhurtham,varjyam,gulika,hc1,hc2,hc3,hc4,hc5,hc6,hc7,hc8,hc9,hc10,hc11,hc12;

    public Panchangam(String id, String date, String sunrise, String sunset, String moonrise, String moonset, String text1, String text2, String text3, String text4, String text5, String text6, String festivals, String thidhi, String nakshatram, String yogam, String karanam, String abhijith_muhurtham, String bhrama_muhurtham, String amrutha_kalam, String rahukalam, String yamakandam, String dhurmuhurtham, String varjyam, String gulika, String hc1, String hc2, String hc3, String hc4, String hc5, String hc6, String hc7, String hc8, String hc9, String hc10, String hc11, String hc12) {
        this.id = id;
        this.date = date;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        this.text6 = text6;
        this.festivals = festivals;
        this.thidhi = thidhi;
        this.nakshatram = nakshatram;
        this.yogam = yogam;
        this.karanam = karanam;
        this.abhijith_muhurtham = abhijith_muhurtham;
        this.bhrama_muhurtham = bhrama_muhurtham;
        this.amrutha_kalam = amrutha_kalam;
        this.rahukalam = rahukalam;
        this.yamakandam = yamakandam;
        this.dhurmuhurtham = dhurmuhurtham;
        this.varjyam = varjyam;
        this.gulika = gulika;
        this.hc1 = hc1;
        this.hc2 = hc2;
        this.hc3 = hc3;
        this.hc4 = hc4;
        this.hc5 = hc5;
        this.hc6 = hc6;
        this.hc7 = hc7;
        this.hc8 = hc8;
        this.hc9 = hc9;
        this.hc10 = hc10;
        this.hc11 = hc11;
        this.hc12 = hc12;
    }



    public Panchangam(String string, String string1, String string2, String string3, String string4, String string5) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getText6() {
        return text6;
    }

    public void setText6(String text6) {
        this.text6 = text6;
    }

    public String getFestivals() {
        return festivals;
    }

    public void setFestivals(String festivals) {
        this.festivals = festivals;
    }

    public String getThidhi() {
        return thidhi;
    }

    public void setThidhi(String thidhi) {
        this.thidhi = thidhi;
    }

    public String getNakshatram() {
        return nakshatram;
    }

    public void setNakshatram(String nakshatram) {
        this.nakshatram = nakshatram;
    }

    public String getYogam() {
        return yogam;
    }

    public void setYogam(String yogam) {
        this.yogam = yogam;
    }

    public String getKaranam() {
        return karanam;
    }

    public void setKaranam(String karanam) {
        this.karanam = karanam;
    }

    public String getAbhijith_muhurtham() {
        return abhijith_muhurtham;
    }

    public void setAbhijith_muhurtham(String abhijith_muhurtham) {
        this.abhijith_muhurtham = abhijith_muhurtham;
    }

    public String getBhrama_muhurtham() {
        return bhrama_muhurtham;
    }

    public void setBhrama_muhurtham(String bhrama_muhurtham) {
        this.bhrama_muhurtham = bhrama_muhurtham;
    }

    public String getAmrutha_kalam() {
        return amrutha_kalam;
    }

    public void setAmrutha_kalam(String amrutha_kalam) {
        this.amrutha_kalam = amrutha_kalam;
    }

    public String getRahukalam() {
        return rahukalam;
    }

    public void setRahukalam(String rahukalam) {
        this.rahukalam = rahukalam;
    }

    public String getYamakandam() {
        return yamakandam;
    }

    public void setYamakandam(String yamakandam) {
        this.yamakandam = yamakandam;
    }

    public String getDhurmuhurtham() {
        return dhurmuhurtham;
    }

    public void setDhurmuhurtham(String dhurmuhurtham) {
        this.dhurmuhurtham = dhurmuhurtham;
    }

    public String getVarjyam() {
        return varjyam;
    }

    public void setVarjyam(String varjyam) {
        this.varjyam = varjyam;
    }

    public String getGulika() {
        return gulika;
    }

    public void setGulika(String gulika) {
        this.gulika = gulika;
    }

    public String getHc1() {
        return hc1;
    }

    public void setHc1(String hc1) {
        this.hc1 = hc1;
    }

    public String getHc2() {
        return hc2;
    }

    public void setHc2(String hc2) {
        this.hc2 = hc2;
    }

    public String getHc3() {
        return hc3;
    }

    public void setHc3(String hc3) {
        this.hc3 = hc3;
    }

    public String getHc4() {
        return hc4;
    }

    public void setHc4(String hc4) {
        this.hc4 = hc4;
    }

    public String getHc5() {
        return hc5;
    }

    public void setHc5(String hc5) {
        this.hc5 = hc5;
    }

    public String getHc6() {
        return hc6;
    }

    public void setHc6(String hc6) {
        this.hc6 = hc6;
    }

    public String getHc7() {
        return hc7;
    }

    public void setHc7(String hc7) {
        this.hc7 = hc7;
    }

    public String getHc8() {
        return hc8;
    }

    public void setHc8(String hc8) {
        this.hc8 = hc8;
    }

    public String getHc9() {
        return hc9;
    }

    public void setHc9(String hc9) {
        this.hc9 = hc9;
    }

    public String getHc10() {
        return hc10;
    }

    public void setHc10(String hc10) {
        this.hc10 = hc10;
    }

    public String getHc11() {
        return hc11;
    }

    public void setHc11(String hc11) {
        this.hc11 = hc11;
    }

    public String getHc12() {
        return hc12;
    }

    public void setHc12(String hc12) {
        this.hc12 = hc12;
    }
}

