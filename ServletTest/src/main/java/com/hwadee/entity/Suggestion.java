package com.hwadee.entity;

public class Suggestion {

    private Integer id;
    private String content;

    public Suggestion(){
    }
    public Suggestion(String s){
        this.content=s;
    }
    public Suggestion(String s,Integer i){
        this.id=i;
        this.content=s;
    }

    public void setId(Integer i){
        this.id=i;
    }

    public Integer getId(){return id;}

    public void setContent(String s){
        this.content=s;
    }
    public String getSuggestion(){
        return this.content;
    }
    @Override
    public String toString(){
        return "ID->"+id+'\''+",Content:"+content;
    }

}
