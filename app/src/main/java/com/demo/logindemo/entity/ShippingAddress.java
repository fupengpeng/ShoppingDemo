package com.demo.logindemo.entity;

import java.io.Serializable;

/**
 * Created by fupengpeng on 2017/6/5 0005.
 * 收货地址
 */

public class ShippingAddress implements Serializable{
    private String username;
    private String phoneNumber;
    private String shippingAddress;
    private boolean isDefault;

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", iDefault=" + isDefault +
                '}';
    }

    public ShippingAddress() {
    }

    public ShippingAddress(String username, String phoneNumber, String shippingAddress, boolean isDefault) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.shippingAddress = shippingAddress;
        this.isDefault = isDefault;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
