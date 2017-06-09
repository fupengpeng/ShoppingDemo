package com.demo.logindemo.model.personcenter.factory;

import com.demo.logindemo.model.personcenter.impl.OrderCenterAllFragmentModel;
import com.demo.logindemo.model.personcenter.interf.IOrderCenterAllFragmentModel;

/**
 * Created by fupengpeng on 2017/6/9 0009.
 * 订单管理
 *     全部订单model工厂
 */

public class OrderCenterAllFragmentModelFactory {
    public static IOrderCenterAllFragmentModel newInstance(){
        return new OrderCenterAllFragmentModel();
    }
}
