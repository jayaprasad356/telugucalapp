package com.vibame.telugupanchangamcalendar.model;

public class Abdhikam {
    String id,description,date_month;



       public Abdhikam(String id, String description, String date_month) {
            this.id = id;
            this.description = description;
            this.date_month = date_month;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


        public String getDescription() {
            return description;
        }


        public void setDescription(String description) {
            this.description = description;
        }


        public String getDate_month() {
            return date_month;
        }


        public void setDate_month(String date_month) {
            this.date_month = date_month;
        }

}

