package com.demo.logindemo.presenter.personcenter.factory;

import com.demo.logindemo.activity.personcenter.view.IGrouponView;
import com.demo.logindemo.presenter.personcenter.impl.GrouponPresenter;
import com.demo.logindemo.presenter.personcenter.interf.IGrouponPresenter;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class GrouponPresenterFactory {
    public static IGrouponPresenter newInstance(IGrouponView grouponView) {
        return new GrouponPresenter(grouponView);
    }
}
