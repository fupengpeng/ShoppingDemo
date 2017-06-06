package com.demo.logindemo.activity.other.impl;

import android.os.Bundle;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.other.view.IMainView;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity implements IMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);
    }
}
