package com.demo.logindemo.activity.personcenter.impl;

import android.os.Bundle;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.personcenter.view.IIntegralView;

/**
 * 积分商城
 */
public class IntegralShoppingMallActivity extends BaseActivity implements IIntegralView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_shopping_mall);
    }
}
