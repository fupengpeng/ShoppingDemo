package com.demo.logindemo.model.personcenter.factory;

import com.demo.logindemo.model.personcenter.impl.RegisterModel;
import com.demo.logindemo.model.personcenter.interf.IRegisterModel;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 注册信息业务工厂
 */

public class RegisterModelFactory {

    /**
     * 创建注册信息业务
     *
     * @return 注册信息业务
     */
    public static IRegisterModel newInstance() {
        return new RegisterModel();
    }
}
