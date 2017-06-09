package com.demo.logindemo.presenter.personcenter.impl;

import com.demo.logindemo.activity.IBaseView;
import com.demo.logindemo.activity.personcenter.impl.PersonActivity;
import com.demo.logindemo.activity.personcenter.view.IPhoneNumberBindView;
import com.demo.logindemo.common.Consts;
import com.demo.logindemo.common.ObjectCallBack;
import com.demo.logindemo.model.personcenter.factory.PhoneNumberBindModelFactory;
import com.demo.logindemo.model.personcenter.interf.IPhoneNumberBindModel;
import com.demo.logindemo.presenter.BaseActivityPresenter;
import com.demo.logindemo.presenter.personcenter.interf.IPhoneNumberBindPresenter;
import com.demo.logindemo.util.ToastUtils;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 */

public class PhoneNumberBindPresenter extends BaseActivityPresenter implements IPhoneNumberBindPresenter {
    private IPhoneNumberBindView phoneNumberBindView;

    private IPhoneNumberBindModel phoneNumberBindModel;


    public PhoneNumberBindPresenter(IPhoneNumberBindView phoneNumberBindView) {
        super(phoneNumberBindView);
        this.phoneNumberBindView = phoneNumberBindView;
        this.phoneNumberBindModel = PhoneNumberBindModelFactory.newInstance();

    }

    @Override
    public void getVerificationCode(String phoneNumber) {
        // 显示等待对话框
        showWaitDialog(Consts.WaitDialogMessage.DATA_LODING);

        phoneNumberBindModel.getVerificationCode(phoneNumber, new ObjectCallBack<String>() {
            @Override
            public void onSuccess(String data) {// 获取验证码成功
                // 关闭等待对话框
                closeWaitDialog();

            }

            @Override
            public void onFail(Exception e) {// 获取验证码失败
                // 关闭等待对话框
                closeWaitDialog();
            }
        });
    }

    @Override
    public void getBind(String phoneNumber, String verificationCode, String password) {
        // 显示等待对话框
        showWaitDialog(Consts.WaitDialogMessage.DATA_LODING);

        phoneNumberBindModel.getBind(phoneNumber, verificationCode, password, new ObjectCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                closeWaitDialog();
                startActivity(PersonActivity.class);
            }

            @Override
            public void onFail(Exception e) {
                closeWaitDialog();
                ToastUtils.showLong(activity,"绑定失败，请重新绑定");
            }
        });
    }
}
