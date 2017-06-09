package com.demo.logindemo.presenter.personcenter.factory;

import com.demo.logindemo.activity.personcenter.view.IPhoneNumberBindView;
import com.demo.logindemo.presenter.personcenter.impl.PhoneNumberBindPresenter;
import com.demo.logindemo.presenter.personcenter.interf.IPhoneNumberBindPresenter;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 */

public class PhoneNumberBindPresenterFactory {
    public static IPhoneNumberBindPresenter newInstance(IPhoneNumberBindView phoneNumberBindView){
        return new PhoneNumberBindPresenter(phoneNumberBindView);
    }
}
