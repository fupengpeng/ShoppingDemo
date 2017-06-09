package com.demo.logindemo.activity.personcenter.impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.personcenter.view.IShoppingCartView;


/**
 * 我的购物车界面
 */
public class ShoppingCartActivity extends BaseActivity implements IShoppingCartView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
    }
}
