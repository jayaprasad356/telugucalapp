package com.vibame.telugupanchangamcalendar.model;

public class KulaVurthala {
    private String OccupationName;
    private String OccupationReference;

    public KulaVurthala(String occupationName, String occupationReference) {
        OccupationName = occupationName;
        OccupationReference = occupationReference;
    }

    public String getOccupationName() {
        return OccupationName;
    }

    public void setOccupationName(String occupationName) {
        OccupationName = occupationName;
    }

    public String getOccupationReference() {
        return OccupationReference;
    }

    public void setOccupationReference(String occupationReference) {
        OccupationReference = occupationReference;
    }
}
