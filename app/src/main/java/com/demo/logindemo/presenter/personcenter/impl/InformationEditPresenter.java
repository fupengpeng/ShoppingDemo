package com.demo.logindemo.presenter.personcenter.impl;

import com.demo.logindemo.activity.personcenter.view.IInformationEditView;
import com.demo.logindemo.model.personcenter.factory.InformationEditModelFactory;
import com.demo.logindemo.model.personcenter.interf.IInformationEditModel;
import com.demo.logindemo.presenter.BaseActivityPresenter;
import com.demo.logindemo.presenter.personcenter.factory.InformationEditPresenterFactory;
import com.demo.logindemo.presenter.personcenter.interf.IInformationEditPresenter;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class InformationEditPresenter extends BaseActivityPresenter implements IInformationEditPresenter {

    /**
     * 登录界面
     */
    private IInformationEditView informationEditView;
    /**
     * 用户信息业务
     */
    private IInformationEditModel informationEditModel;

    public InformationEditPresenter(IInformationEditView informationEditView) {
        super(informationEditView);
        this.informationEditView = informationEditView;
        this.informationEditModel = InformationEditModelFactory.newInstance();
    }

    @Override
    public void getData() {

    }

    @Override
    public void getAddressEdit() {

    }

    @Override
    public void getEditPic() {

    }

    @Override
    public void getEditPassword() {

    }
}
