package com.demo.logindemo.entity.response;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 注册响应
 */

public class RegisterResponse extends BaseResponse {
    /**
     * 响应数据
     */
    private String data;

    public RegisterResponse() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
