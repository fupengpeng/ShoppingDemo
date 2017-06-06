package com.demo.logindemo.model.personcenter.factory;

import com.demo.logindemo.model.personcenter.impl.DataModel;
import com.demo.logindemo.model.personcenter.interf.IDataModel;

/**
 * Created by fupengpeng on 2017/6/6 0006.
 */

public class DataModelFactory {
    public static IDataModel newInstance() {
        return new DataModel();
    }
}
