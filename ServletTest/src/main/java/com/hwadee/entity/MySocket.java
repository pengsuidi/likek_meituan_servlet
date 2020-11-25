package com.hwadee.entity;


public class MySocket {
    private String socket_id;

    private String remark;
    private byte[] image64;
    private String image64_addr;

    public byte[] getImage64() {
        return image64;
    }

    public void setImage64(byte[] image64) {
        this.image64 = image64;
    }

    public String getImage64_addr() {
        return image64_addr;
    }

    public void setImage64_addr(String image64_addr) {
        this.image64_addr = image64_addr;
    }

    public MySocket(String id, String remark, byte[] image64, String image64_addr) {
        this.socket_id = id;
        this.remark = remark;
        this.image64 = image64;
        this.image64_addr = image64_addr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



    public MySocket(String id) {
        this.socket_id = id;
    }




    public MySocket() {
    }

    public String getSocket_id() {
        return socket_id;
    }

    public void setSocket_id(String socket_id) {
        this.socket_id = socket_id;
    }

}
