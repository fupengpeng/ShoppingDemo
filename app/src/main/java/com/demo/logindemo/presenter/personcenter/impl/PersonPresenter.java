package com.demo.logindemo.presenter.personcenter.impl;


import android.util.Log;

import com.demo.logindemo.activity.IBaseView;
import com.demo.logindemo.activity.personcenter.impl.LoginActivity;
import com.demo.logindemo.activity.personcenter.view.IRegisterView;
import com.demo.logindemo.common.Consts;
import com.demo.logindemo.common.ObjectCallBack;
import com.demo.logindemo.model.personcenter.interf.IRegisterModel;
import com.demo.logindemo.presenter.BaseActivityPresenter;
import com.demo.logindemo.presenter.personcenter.interf.IPersonPresenter;
import com.demo.logindemo.presenter.personcenter.interf.IRegisterPresenter;
import com.demo.logindemo.util.InfoUtils;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 注册界面主导器
 */

public class PersonPresenter extends BaseActivityPresenter implements IPersonPresenter {
    public static final String TAG = "RegisterPresenter";

    public PersonPresenter(IBaseView baseView) {
        super(baseView);
    }

    @Override
    public void getVerificationCode(String mobilePhoneNumber) {

    }

    @Override
    public void register(String tel, String password) {

    }
}
