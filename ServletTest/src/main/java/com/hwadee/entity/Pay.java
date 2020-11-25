package com.hwadee.entity;

public class Pay {
    private String ppassword;
/*    private String user_id;*/

    public  Pay() {
    }

    public Pay(String ppassword) {
        this.ppassword = ppassword;
    }

/*    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }*/

    public String getppassword() {
        return ppassword;
    }
    public void setppassword(String ppassword) {
        this.ppassword = ppassword == null ? null : ppassword.trim();
    }

    @Override
    public String toString() {
        return "buyer{" +
                "ppassword='" + ppassword +
/*                ", user_id='" + user_id + '\'' +*/
                '}';
    }
}
