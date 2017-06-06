package com.demo.logindemo.presenter.personcenter.impl;

import com.demo.logindemo.activity.personcenter.view.IDataView;
import com.demo.logindemo.model.personcenter.factory.DataModelFactory;
import com.demo.logindemo.model.personcenter.interf.IDataModel;
import com.demo.logindemo.presenter.BaseActivityPresenter;
import com.demo.logindemo.presenter.personcenter.interf.IDataPresenter;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class DataPresenter extends BaseActivityPresenter implements IDataPresenter {

    private IDataView dataView;

    private IDataModel dataModel;

    public DataPresenter (IDataView dataView){
        super(dataView);
        this.dataView = dataView;
        this.dataModel = DataModelFactory.newInstance();

    }

    @Override
    public void getConfirm() {

    }
}
