package com.vibame.telugupanchangamcalendar.model;

public class RashuluModel {
    private String RashiNmae;
    private String RashiTime;

    public RashuluModel(String rashiNmae, String rashiTime) {
        RashiNmae = rashiNmae;
        RashiTime = rashiTime;
    }

    public String getRashiNmae() {
        return RashiNmae;
    }

    public void setRashiNmae(String rashiNmae) {
        RashiNmae = rashiNmae;
    }

    public String getRashiTime() {
        return RashiTime;
    }

    public void setRashiTime(String rashiTime) {
        RashiTime = rashiTime;
    }
}
