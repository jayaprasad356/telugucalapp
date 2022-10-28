package com.vibame.telugupanchangamcalendar.model;

public class AksharaluModel {
    private String Heading;
    private String Topic;

    public AksharaluModel(String heading, String topic) {
        Heading = heading;
        Topic = topic;
    }

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }
}
