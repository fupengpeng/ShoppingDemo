package com.demo.logindemo.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.personcenter.view.IPhoneNumberBindView;
import com.demo.logindemo.customerview.ClearEditText;
import com.demo.logindemo.model.personcenter.impl.PhoneNumberBindModel;
import com.demo.logindemo.presenter.personcenter.factory.PhoneNumberBindPresenterFactory;
import com.demo.logindemo.presenter.personcenter.impl.PhoneNumberBindPresenter;
import com.demo.logindemo.presenter.personcenter.interf.IPhoneNumberBindPresenter;
import com.demo.logindemo.util.ToastUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 绑定手机号界面
 */
public class PhoneNumberBindActivity extends BaseActivity implements IPhoneNumberBindView {
    public static final String TAG = "PhoneNumberBindActivity";
    /**
     * 返回至PersonActivity界面
     */
    @BindView(R.id.iv_activity_phone_number_bind_return)
    ImageView ivActivityPhoneNumberBindReturn;
    /**
     * 手机号
     */
    @BindView(R.id.cet_activity_phone_number_bind_phone_number)
    ClearEditText cetActivityPhoneNumberBindPhoneNumber;
    /**
     * 验证码
     */
    @BindView(R.id.cet_activity_phone_number_bind_verification_code)
    ClearEditText cetActivityPhoneNumberBindVerificationCode;
    /**
     * 获取验证码
     */
    @BindView(R.id.btn_activity_phone_number_bind_verification_code)
    Button btnActivityPhoneNumberBindVerificationCode;
    /**
     * 设置账号密码
     */
    @BindView(R.id.cet_activity_phone_number_bind_affirm_password)
    ClearEditText cetActivityPhoneNumberBindAffirmPassword;
    /**
     * 立即绑定
     */
    @BindView(R.id.btn_activity_phone_number_bind_bind)
    Button btnActivityPhoneNumberBindBind;

    String phoneNumber,verificationCode,password;
    private Intent intent;

    /**
     *
     */
    IPhoneNumberBindPresenter phoneNumberBindPresenter;


    /**
     * 倒计时60秒
     */
    private int recLen = 60;
    /**
     * 计时器
     */
    Timer timer = new Timer();
    /**
     * 倒计时任务
     */
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    btnActivityPhoneNumberBindVerificationCode.setText("重新获取("+recLen+")");
                    btnActivityPhoneNumberBindVerificationCode.setEnabled(false);
                    if (recLen < 0) {
                        timer.cancel();
                        btnActivityPhoneNumberBindVerificationCode.setText("获取验证码");
                        btnActivityPhoneNumberBindVerificationCode.setEnabled(true);
                    }
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_bind);
        ButterKnife.bind(this);

        phoneNumberBindPresenter = PhoneNumberBindPresenterFactory.newInstance(this);

        cetActivityPhoneNumberBindPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                phoneNumber = cetActivityPhoneNumberBindPhoneNumber.getText().toString().trim();
                Log.e(TAG, "onViewClicked: "+"手机号："+phoneNumber+"    验证码："+verificationCode+"    密码："+password );
            }
        });

        cetActivityPhoneNumberBindVerificationCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                verificationCode = cetActivityPhoneNumberBindVerificationCode.getText().toString().trim();
                Log.e(TAG, "onViewClicked: "+"手机号："+phoneNumber+"    验证码："+verificationCode+"    密码："+password );
            }
        });

        cetActivityPhoneNumberBindAffirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                password = cetActivityPhoneNumberBindAffirmPassword.getText().toString().trim();
                Log.e(TAG, "onViewClicked: "+"手机号："+phoneNumber+"    验证码："+verificationCode+"    密码："+password );

            }
        });

    }

    @OnClick({R.id.iv_activity_phone_number_bind_return,
            R.id.btn_activity_phone_number_bind_verification_code,
            R.id.btn_activity_phone_number_bind_bind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_phone_number_bind_return:
                intent = new Intent(PhoneNumberBindActivity.this,PersonActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_activity_phone_number_bind_verification_code:
                String telRegex = "[1][34578]\\d{9}";
                if (TextUtils.isEmpty(cetActivityPhoneNumberBindPhoneNumber.getText().toString().trim())) {
                    ToastUtils.showLong(PhoneNumberBindActivity.this, "请输入手机号码");
                } else if (cetActivityPhoneNumberBindPhoneNumber.getText().toString().trim().matches(telRegex)) {
                    phoneNumber = cetActivityPhoneNumberBindPhoneNumber.getText().toString().trim();
                    // TODO: 2017/6/8 0008  获取验证码待实现
                    phoneNumberBindPresenter.getVerificationCode(phoneNumber);
                    timer.schedule(task, 0, 1000);       // timeTask
                } else {
                    ToastUtils.showLong(PhoneNumberBindActivity.this, "查无此号码，请重新输入手机号码");
                }
                break;
            case R.id.btn_activity_phone_number_bind_bind:
                // TODO: 2017/6/9 0009  绑定待实现

                if (TextUtils.isEmpty(cetActivityPhoneNumberBindPhoneNumber.getText().toString().trim())&&
                        TextUtils.isEmpty(cetActivityPhoneNumberBindVerificationCode.getText().toString().trim())&&
                        TextUtils.isEmpty(cetActivityPhoneNumberBindAffirmPassword.getText().toString().trim())){

                    ToastUtils.showLong(this,"请完整填写输入框内容");

                }else {
                    phoneNumber = cetActivityPhoneNumberBindPhoneNumber.getText().toString().trim();
                    verificationCode = cetActivityPhoneNumberBindVerificationCode.getText().toString().trim();
                    password = cetActivityPhoneNumberBindAffirmPassword.getText().toString().trim();
                    Log.e(TAG, "onViewClicked: "+"手机号："+phoneNumber+"    验证码："+verificationCode+"    密码："+password );

                    phoneNumberBindPresenter.getBind(phoneNumber,verificationCode,password);

                }

                break;
        }
    }
}
