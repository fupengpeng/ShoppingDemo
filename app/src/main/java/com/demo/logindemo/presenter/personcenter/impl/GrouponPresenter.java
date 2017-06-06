package com.demo.logindemo.presenter.personcenter.impl;

import com.demo.logindemo.activity.IBaseView;
import com.demo.logindemo.activity.personcenter.view.IGrouponView;
import com.demo.logindemo.model.personcenter.factory.GrouponModelFactory;
import com.demo.logindemo.model.personcenter.interf.IGrouponModel;
import com.demo.logindemo.presenter.BaseActivityPresenter;
import com.demo.logindemo.presenter.personcenter.interf.IGrouponPresenter;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class GrouponPresenter extends BaseActivityPresenter implements IGrouponPresenter {

    private IGrouponView grouponView;

    private IGrouponModel grouponModel;


    public GrouponPresenter(IGrouponView grouponView) {
        super(grouponView);
        this.grouponView = grouponView;
        this.grouponModel = GrouponModelFactory.newInstance();
    }
}
