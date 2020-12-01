package com.psd.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
    private Integer mid;

    private String mname;

    private String maliasname;

    private String leadingactor;

    private String language;

    private String director;

    private String screenwriter;

    private Integer filmlength;

    private String producer;

    private String coverimg;

    private Float mscore;

    private Date realsetime;

    private String mdesc;
    private String fileyear;

    public String getFileyear() {
        if (this.realsetime != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            return sdf.format(this.realsetime);
        }
        return fileyear;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        if (this.mname.indexOf("/") != -1) {
            return this.mname.substring(0, this.mname.indexOf("/"));
        }
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getMaliasname() {
        return maliasname;
    }

    public void setMaliasname(String maliasname) {
        this.maliasname = maliasname == null ? null : maliasname.trim();
    }

    public String getLeadingactor() {
        return leadingactor;
    }

    public void setLeadingactor(String leadingactor) {
        this.leadingactor = leadingactor == null ? null : leadingactor.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter == null ? null : screenwriter.trim();
    }

    public Integer getFilmlength() {
        return filmlength;
    }

    public void setFilmlength(Integer filmlength) {
        this.filmlength = filmlength;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer == null ? null : producer.trim();
    }

    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg == null ? null : coverimg.trim();
    }

    public Float getMscore() {
        return mscore;
    }

    public void setMscore(Float mscore) {
        this.mscore = mscore;
    }

    public String getRealsetime() {
        if (this.realsetime != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(this.realsetime);
        }
        return "";
    }

    public void setRealsetime(Date realsetime) {
        this.realsetime = realsetime;
    }

    public String getMdesc() {
        return mdesc;
    }

    public void setMdesc(String mdesc) {
        this.mdesc = mdesc == null ? null : mdesc.trim();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", maliasname='" + maliasname + '\'' +
                ", leadingactor='" + leadingactor + '\'' +
                ", language='" + language + '\'' +
                ", director='" + director + '\'' +
                ", screenwriter='" + screenwriter + '\'' +
                ", filmlength=" + filmlength +
                ", producer='" + producer + '\'' +
                ", coverimg='" + coverimg + '\'' +
                ", mscore=" + mscore +
                ", realsetime=" + realsetime +
                ", mdesc='" + mdesc + '\'' +
                '}';
    }
}
