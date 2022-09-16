package com.vibame.telugupanchangamcalendar;

public class MuhurthamList {
    private final String starName;
    private final String startTime;
    private final String endTime;

    public MuhurthamList(String starName, String startTime, String endTime) {
        this.starName = starName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStarName() {
        return starName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
