package com.demo.logindemo.presenter.personcenter.impl;


import android.util.Log;

import com.demo.logindemo.activity.IBaseView;
import com.demo.logindemo.activity.personcenter.impl.LoginActivity;
import com.demo.logindemo.activity.personcenter.view.IPersonView;
import com.demo.logindemo.activity.personcenter.view.IRegisterView;
import com.demo.logindemo.common.Consts;
import com.demo.logindemo.common.ObjectCallBack;
import com.demo.logindemo.model.personcenter.factory.PersonModelFactory;
import com.demo.logindemo.model.personcenter.interf.IPersonModel;
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

    private IPersonView personView;

    private IPersonModel personModel;

    public PersonPresenter(IPersonView personView) {
        super(personView);
        this.personView = personView;
        this.personModel = PersonModelFactory.newInstance();
    }


    @Override
    public void getInformationEdit() {

    }

    @Override
    public void getPhoneNumberBind() {

    }

    @Override
    public void getAddressEdit() {

    }

    @Override
    public void getMemberCenter() {

    }

    @Override
    public void getIntegralPerson() {

    }

    @Override
    public void getWithdrawDeposit() {

    }

    @Override
    public void getOrderCenter() {

    }

    @Override
    public void getShoppingCart() {

    }

    @Override
    public void getDiscountCoupon() {

    }

    @Override
    public void getBargain() {

    }

    @Override
    public void getGroupon() {

    }

    @Override
    public void getWinning() {

    }

    @Override
    public void getIntegral() {

    }
}
