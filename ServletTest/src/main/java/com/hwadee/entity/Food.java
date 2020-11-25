package com.hwadee.entity;

public class Food {
    private String food_name;

    private String food_price;

    private String food_image;

    private String User_id;

    private String shop_id;

    private String shop_name;

    private String food_id;


    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

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


    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image == null ? null : food_image.trim();
    }

    @Override
    public String toString() {
        return "Food{" +
                "food_id=" + food_id +
                ", food_name='" + food_name + '\'' +
                ", shop_name='" + shop_name + '\'' +
                ", food_price='" + food_price + '\'' +
                '}';
    }
}
