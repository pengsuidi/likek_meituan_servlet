package com.psd.entity;

public class ShopInfoBuy {
    private String user_id;
    private String food_img;
    private String shop_img;
    private String food_name;
    private String food_txt;
    private String food_price;
    private String food_type;
    private String shop_id;
    private String shop_name;
    private byte[] food_image;
    private byte[] shop_image;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public ShopInfoBuy(String user_id, String food_img, String shop_img, String food_name, String food_txt, String food_price, String food_type, String shop_id, String shop_name, byte[] food_image, byte[] shop_image) {
        this.user_id = user_id;
        this.food_img = food_img;
        this.shop_img = shop_img;
        this.food_name = food_name;
        this.food_txt = food_txt;
        this.food_price = food_price;
        this.food_type = food_type;
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.food_image = food_image;
        this.shop_image = shop_image;
    }

    public byte[] getFood_image() {
        return food_image;
    }

    public void setFood_image(byte[] food_image) {
        this.food_image = food_image;
    }

    public byte[] getShop_image() {
        return shop_image;
    }

    public void setShop_image(byte[] shop_image) {
        this.shop_image = shop_image;
    }

    public String getFood_img() {
        return food_img;
    }

    public void setFood_img(String food_img) {
        this.food_img = food_img;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_txt() {
        return food_txt;
    }

    public void setFood_txt(String food_txt) {
        this.food_txt = food_txt;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_img() {
        return shop_img;
    }

    public void setShop_img(String shop_img) {
        this.shop_img = shop_img;
    }



    public ShopInfoBuy() {
    }



    public ShopInfoBuy(byte[] image, String food_img, String food_name, String food_txt, String food_price, String food_type, String shop_id, String shop_name, String shop_img) {

        this.food_img = food_img;
        this.food_name = food_name;
        this.food_txt = food_txt;
        this.food_price = food_price;
        this.food_type = food_type;
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.shop_img = shop_img;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "uimage"+image+
//                "uid=" + uid +
//                ", uname='" + uname + '\'' +
//                ", unickname='" + unickname + '\'' +
//                ", usex='" + usex + '\'' +
//                ", upassword='" + upassword + '\'' +
//                ", ubirthday=" + ubirthday +
//                ", uphone='" + uphone + '\'' +
//                ", uemail='" + uemail + '\'' +
//                ", ucity='" + ucity + '\'' +
//                ", uqqnum='" + uqqnum + '\'' +
//                ", ustate=" + ustate +
//        ", createtime=" + createtime +
//                ", headimg='" + headimg + '\'' +
//                '}';
//    }
}
