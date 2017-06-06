package com.demo.logindemo.presenter.personcenter.factory;

import com.demo.logindemo.activity.personcenter.view.ILoginView;
import com.demo.logindemo.presenter.personcenter.impl.LoginActivityPresenter;
import com.demo.logindemo.presenter.personcenter.interf.ILoginActivityPresenter;

/**
 * 登录界面主导器工厂
 */
public class LoginActivityPresenterFactory {

    /**
     * 创建登录界面主导器
     *
     * @param loginView 登录界面
     * @return 登录界面主导器实例
     */
    public static ILoginActivityPresenter newInstance(ILoginView loginView) {
        return new LoginActivityPresenter(loginView);
    }
}
