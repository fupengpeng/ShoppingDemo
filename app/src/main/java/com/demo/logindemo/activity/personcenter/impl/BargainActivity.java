package com.demo.logindemo.activity.personcenter.impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.personcenter.view.IBargainView;

public class BargainActivity extends BaseActivity implements IBargainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bargain);
    }
}