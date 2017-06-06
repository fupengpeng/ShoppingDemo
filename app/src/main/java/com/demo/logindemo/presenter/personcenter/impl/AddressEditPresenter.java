package com.demo.logindemo.presenter.personcenter.impl;

import com.demo.logindemo.activity.IBaseView;
import com.demo.logindemo.activity.personcenter.view.IAddressEditView;
import com.demo.logindemo.model.personcenter.factory.AddressEditModelFactory;
import com.demo.logindemo.model.personcenter.interf.IAddressEditModel;
import com.demo.logindemo.presenter.BaseActivityPresenter;
import com.demo.logindemo.presenter.personcenter.interf.IAddressEditPresenter;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class AddressEditPresenter extends BaseActivityPresenter implements IAddressEditPresenter {

    private IAddressEditView addressEditView;

    private IAddressEditModel addressEditModel;


    public AddressEditPresenter(IAddressEditView addressEditView) {
        super(addressEditView);
        this.addressEditView = addressEditView;
        this.addressEditModel = AddressEditModelFactory.newInstance();


    }

    @Override
    public void setDefault() {

    }

    @Override
    public void getEditSave() {

    }

    @Override
    public void getAddNewSave() {

    }

    @Override
    public void getDelete() {

    }

    @Override
    public void getObtain() {

    }
}
