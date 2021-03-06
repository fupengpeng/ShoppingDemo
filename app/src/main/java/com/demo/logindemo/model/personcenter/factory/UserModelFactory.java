package com.demo.logindemo.model.personcenter.factory;


import com.demo.logindemo.model.personcenter.impl.UserModel;
import com.demo.logindemo.model.personcenter.interf.IUserModel;

/**
 * 用户信息业务工厂
 */
public class UserModelFactory {

    /**
     * 创建用户信息业务
     *
     * @return 用户信息业务
     */
    public static IUserModel newInstance() {
        return new UserModel();
    }
}
