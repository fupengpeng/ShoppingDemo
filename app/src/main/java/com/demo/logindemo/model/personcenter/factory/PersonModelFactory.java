package com.demo.logindemo.model.personcenter.factory;


import com.demo.logindemo.model.personcenter.impl.PersonModel;
import com.demo.logindemo.model.personcenter.interf.IPersonModel;

/**
 * 用户信息业务工厂
 */
public class PersonModelFactory {

    /**
     * 创建用户信息业务
     *
     * @return 用户信息业务
     */
    public static IPersonModel newInstance() {
        return new PersonModel();
    }
}
