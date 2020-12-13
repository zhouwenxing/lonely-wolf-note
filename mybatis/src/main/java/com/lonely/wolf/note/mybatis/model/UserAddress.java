package com.lonely.wolf.note.mybatis.model;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/6
 * @since jdk1.8
 */
public class UserAddress {
    private int id;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
