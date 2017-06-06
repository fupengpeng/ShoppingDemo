package com.demo.logindemo.presenter.personcenter.factory;

import com.demo.logindemo.activity.personcenter.view.ILoginView;
import com.demo.logindemo.activity.personcenter.view.IPersonView;
import com.demo.logindemo.presenter.personcenter.impl.LoginActivityPresenter;
import com.demo.logindemo.presenter.personcenter.impl.PersonPresenter;
import com.demo.logindemo.presenter.personcenter.interf.ILoginActivityPresenter;
import com.demo.logindemo.presenter.personcenter.interf.IPersonPresenter;

/**
 * 登录界面主导器工厂
 */
public class PersonPresenterFactory {

    /**
     * 创建登录界面主导器
     *
     * @param personView 登录界面
     * @return 登录界面主导器实例
     */
    public static IPersonPresenter newInstance(IPersonView personView) {
        return new PersonPresenter(personView);
    }
}
