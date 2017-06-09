package com.demo.logindemo.entity.response.person;

import java.io.Serializable;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 */

public class PhoneNumberBindEntity implements Serializable {
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
