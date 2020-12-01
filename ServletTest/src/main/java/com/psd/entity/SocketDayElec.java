package com.psd.entity;

public class SocketDayElec {
    private String socket_id;
    private int month;
    private int day;
    private int year;
    private String elec;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getElec() {
        return elec;
    }

    public void setElec(String elec) {
        this.elec = elec;
    }

    public SocketDayElec(String socket_id, int month, int day, int year, String elec) {
        this.socket_id = socket_id;
        this.month = month;
        this.day = day;
        this.year = year;
        this.elec = elec;
    }

    public SocketDayElec() {
    }

    public SocketDayElec(String socket_id, int month, String elec) {
        this.socket_id = socket_id;
        this.month = month;
        this.elec = elec;
    }

    public String getSocket_id() {
        return socket_id;
    }

    public void setSocket_id(String socket_id) {
        this.socket_id = socket_id;
    }
}
