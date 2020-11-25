package com.hwadee.entity;

import java.util.Date;

public class payment {
    private String food_name;

    private String food_price;

    private String food_image;

    private String total_price;

    private String User_id;

    private String shop_id;

    private String shop_name;

    private String food_id;

    private Date otime;

    private String oid;

    public payment() {
        this.oid = oid;
        this.food_name = food_name;
        this.food_price = food_price;
        this.shop_id = shop_id;
        this.shop_name = shop_name;

    }

    public String getOid() {
        return oid;
    }
    public void setOid(String uid) {
        this.oid = uid;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String user_id) {
        this.User_id = user_id;
    }

    public String getShop_id() {return shop_id;}
    public void setShop_id(String shop_id) {this.shop_id = shop_id;}

    public String getFood_name() {
        if (this.food_name.indexOf("/") != -1) {
            return this.food_name.substring(0, this.food_name.indexOf("/"));
        }
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name == null ? null : food_name.trim();
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name == null ? null : shop_name.trim();
    }

    public String getFood_price() { return food_price; }

    public void setFood_price(String food_price) {
        this.food_price = food_price == null ? null : food_price.trim();
    }

    public String getTotal_price(){ return total_price; }

    public void setTotal_price(String total_price) {
        this.total_price = total_price == null ? null : total_price.trim();
    }

    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image == null ? null : food_image.trim();
    }

    public Date getOtime(){return otime;}
    public void setOtime(Date otime) {this.otime = otime;}

    @Override
    public String toString() {
        return "payment{" +
                "oid=" + oid+
                ", food_id=" + food_id +'\''+
                ", food_name='" + food_name + '\'' +
                ", shop_name='" + shop_name + '\'' +
                ", shop_id='" + shop_id + '\'' +
                ", food_price='" + food_price + '\'' +
                ", otime='" + otime + '\''+
                '}';
    }
}
