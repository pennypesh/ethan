package com.example.penny.ethan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ApptForm {
    @Id
    @GeneratedValue
    private int id;
    private String date;
    private String time;
    private String location;
    boolean isPastDue;
    private int userId;

    public ApptForm() {
    }


    public ApptForm(int id, String date, String time, String location, int userId, boolean isPastDue) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.location = location;
        this.userId = userId;
        this.isPastDue = isPastDue;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

        public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isPastDue() {
        return isPastDue;
    }

    public void setPastDue(boolean pastDue) {
        isPastDue = pastDue;
    }




}
