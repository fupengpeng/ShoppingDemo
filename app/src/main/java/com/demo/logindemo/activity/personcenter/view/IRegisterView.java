package com.demo.logindemo.activity.personcenter.view;

import com.demo.logindemo.activity.IBaseView;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 *
 */

public interface IRegisterView extends IBaseView {
    /**
     * 设置注册成功
     */
    void setRegisterSuccess();
    /**
     * 验证码获取成功
     */
    void setGetVerificationCodeSuccess();
}
