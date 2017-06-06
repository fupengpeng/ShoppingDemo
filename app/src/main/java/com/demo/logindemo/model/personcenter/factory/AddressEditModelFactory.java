package com.demo.logindemo.model.personcenter.factory;

import com.demo.logindemo.model.personcenter.impl.AddressEditModel;
import com.demo.logindemo.model.personcenter.impl.DataModel;
import com.demo.logindemo.model.personcenter.interf.IAddressEditModel;
import com.demo.logindemo.model.personcenter.interf.IDataModel;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class AddressEditModelFactory {
    public static IAddressEditModel newInstance() {
        return new AddressEditModel();
    }
}
