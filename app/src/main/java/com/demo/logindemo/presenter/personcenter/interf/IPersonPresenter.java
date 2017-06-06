package com.demo.logindemo.presenter.personcenter.interf;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 个人中心主导器接口
 */

public interface IPersonPresenter {

    /**
     *资料编辑
     */
    public void getInformationEdit();
    /**
     *绑定手机号
     */
    public void getPhoneNumberBind();
    /**
     *收货地址管理
     */
    public void getAddressEdit();
    /**
     *会员中心
     */
    public void getMemberCenter();
    /**
     *积分中心
     */
    public void getIntegralPerson();
    /**
     *提现
     */
    public void getWithdrawDeposit();
    /**
     *订单中心
     */
    public void getOrderCenter();
    /**
     *我的购物车
     */
    public void getShoppingCart();
    /**
     *我的优惠券
     */
    public void getDiscountCoupon();
    /**
     *我的砍价
     */
    public void getBargain();
    /**
     *拼团订单
     */
    public void getGroupon();
    /**
     *中奖纪录
     */
    public void getWinning();
    /**
     *积分商城
     */
    public void getIntegral();

}
