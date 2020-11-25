package com.hwadee.entity;

public class SocketMonthElec {
    private String socket_id;
    private int year;
    private int month;
    private String elec;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getElec() {
        return elec;
    }

    public void setElec(String elec) {
        this.elec = elec;
    }

    public SocketMonthElec(String socket_id, int year, int month, String elec) {
        this.socket_id = socket_id;
        this.year = year;
        this.month = month;
        this.elec = elec;
    }

    public SocketMonthElec() {
    }

    public SocketMonthElec(String socket_id, int month, String elec) {
        this.socket_id = socket_id;
        this.year = month;
        this.elec = elec;
    }

    public String getSocket_id() {
        return socket_id;
    }

    public void setSocket_id(String socket_id) {
        this.socket_id = socket_id;
    }
}
