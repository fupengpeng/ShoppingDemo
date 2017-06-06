package com.demo.logindemo.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.personcenter.view.IPersonView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonActivity extends BaseActivity implements IPersonView {
    public static final String TAG = "PersonActivity";


    /**
     * 用户头像
     */
    @BindView(R.id.iv_activity_person_pic)
    ImageView ivActivityPersonPic;
    /**
     * 未登录时的登录注册
     */
    @BindView(R.id.tv_activity_person_login_register)
    TextView tvActivityPersonLoginRegister;
    /**
     * 登录后的用户名
     */
    @BindView(R.id.tv_activity_person_information_username)
    TextView tvActivityPersonInformationUsername;
    /**
     *用户手机号
     */
    @BindView(R.id.tv_activity_person_information_phone_number)
    TextView tvActivityPersonInformationPhoneNumber;
    /**
     *收货地址
     */
    @BindView(R.id.ll_activity_person_information_address)
    LinearLayout llActivityPersonInformationAddress;
    /**
     *
     */
    @BindView(R.id.ll_activity_person_information_person)
    LinearLayout llActivityPersonInformationPerson;
    /**
     *会员级别
     */
    @BindView(R.id.btn_activity_person_member)
    Button btnActivityPersonMember;
    /**
     *会员成长值
     */
    @BindView(R.id.tv_activity_person_growth_value)
    TextView tvActivityPersonGrowthValue;
    /**
     *积分图片
     */
    @BindView(R.id.iv_activity_person_integral)
    ImageView ivActivityPersonIntegral;
    /**
     *积分数量
     */
    @BindView(R.id.tv_activity_person_integral)
    TextView tvActivityPersonIntegral;
    /**
     *积分条目点击事件
     */
    @BindView(R.id.ll_activity_person_integral)
    LinearLayout llActivityPersonIntegral;
    /**
     *用户余额
     */
    @BindView(R.id.tv_activity_person_balance)
    TextView tvActivityPersonBalance;
    /**
     *余额条目
     */
    @BindView(R.id.ll_activity_person_balance)
    LinearLayout llActivityPersonBalance;
    /**
     *提现
     */
    @BindView(R.id.btn_activity_person_kiting)
    Button btnActivityPersonKiting;
    /**
     *全部订单
     */
    @BindView(R.id.tv_activity_person_order_all)
    TextView tvActivityPersonOrderAll;
    /**
     *普通订单条目
     */
    @BindView(R.id.ll_activity_person_order_all)
    LinearLayout llActivityPersonOrderAll;
    /**
     *待付款
     */
    @BindView(R.id.ll_activity_person_wait_payment)
    LinearLayout llActivityPersonWaitPayment;
    /**
     *待发货
     */
    @BindView(R.id.ll_activity_person_wait_shipments)
    LinearLayout llActivityPersonWaitShipments;
    /**
     *待收货
     */
    @BindView(R.id.ll_activity_person_wait_receiving)
    LinearLayout llActivityPersonWaitReceiving;
    /**
     *提货
     */
    @BindView(R.id.ll_activity_person_wait_picking)
    LinearLayout llActivityPersonWaitPicking;
    /**
     *售后
     */
    @BindView(R.id.ll_activity_person_refund_after_sales)
    LinearLayout llActivityPersonRefundAfterSales;
    /**
     *购物车
     */
    @BindView(R.id.ll_activity_person_shopping_cart)
    LinearLayout llActivityPersonShoppingCart;
    /**
     *优惠券
     */
    @BindView(R.id.ll_activity_person_discount_coupon)
    LinearLayout llActivityPersonDiscountCoupon;
    /**
     *砍价
     */
    @BindView(R.id.ll_activity_person_bargain)
    LinearLayout llActivityPersonBargain;
    /**
     *团购
     */
    @BindView(R.id.ll_activity_person_groupon)
    LinearLayout llActivityPersonGroupon;
    /**
     *中奖记录
     */
    @BindView(R.id.ll_activity_person_winning)
    LinearLayout llActivityPersonWinning;
    /**
     *积分商城
     */
    @BindView(R.id.ll_activity_person_integral_shopping)
    LinearLayout llActivityPersonIntegralShopping;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.iv_activity_person_pic,
            R.id.tv_activity_person_login_register,
            R.id.tv_activity_person_information_username,
            R.id.tv_activity_person_information_phone_number,
            R.id.ll_activity_person_information_address,
            R.id.ll_activity_person_information_person,
            R.id.btn_activity_person_member,
            R.id.tv_activity_person_growth_value,
            R.id.iv_activity_person_integral,
            R.id.tv_activity_person_integral,
            R.id.ll_activity_person_integral,
            R.id.tv_activity_person_balance,
            R.id.ll_activity_person_balance,
            R.id.btn_activity_person_kiting,
            R.id.tv_activity_person_order_all,
            R.id.ll_activity_person_order_all,
            R.id.ll_activity_person_wait_payment,
            R.id.ll_activity_person_wait_shipments,
            R.id.ll_activity_person_wait_receiving,
            R.id.ll_activity_person_wait_picking,
            R.id.ll_activity_person_refund_after_sales,
            R.id.ll_activity_person_shopping_cart,
            R.id.ll_activity_person_discount_coupon,
            R.id.ll_activity_person_bargain,
            R.id.ll_activity_person_groupon,
            R.id.ll_activity_person_winning,
            R.id.ll_activity_person_integral_shopping})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_person_pic:
                Log.e(TAG, "onViewClicked: "+"跳转至用户资料修改界面" );
                intent = new Intent(PersonActivity.this,InformationEditActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_activity_person_login_register:
                Log.e(TAG, "onViewClicked: "+"跳转至登录界面" );
                break;
            case R.id.tv_activity_person_information_username:
                Log.e(TAG, "onViewClicked: "+"跳转至用户资料修改界面" );
                intent = new Intent(PersonActivity.this,InformationEditActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_activity_person_information_phone_number:
                Log.e(TAG, "onViewClicked: "+"跳转至手机号修改界面" );
                intent = new Intent(PersonActivity.this,PhoneNumberBindActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_information_address:
                Log.e(TAG, "onViewClicked: "+"跳转至收货地址管理界面" );
                intent = new Intent(PersonActivity.this,AddressEditActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_information_person:
                Log.e(TAG, "onViewClicked: "+"跳转至？？？？" );
                break;
            case R.id.btn_activity_person_member:
                Log.e(TAG, "onViewClicked: "+"跳转至会员中心" );
                intent = new Intent(PersonActivity.this,MemberCenterActivity.class);
                startActivity(intent);
                break;


            case R.id.tv_activity_person_growth_value:
                Log.e(TAG, "onViewClicked: "+"跳转至" );
                break;
            case R.id.iv_activity_person_integral:
                Log.e(TAG, "onViewClicked: "+"跳转至" );
                break;
            case R.id.tv_activity_person_integral:
                Log.e(TAG, "onViewClicked: "+"跳转至" );
                break;


            case R.id.ll_activity_person_integral:
                Log.e(TAG, "onViewClicked: "+"跳转至积分首页" );
                intent = new Intent(PersonActivity.this,IntegralPersonActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_activity_person_balance:
                Log.e(TAG, "onViewClicked: "+"跳转至" );
                break;
            case R.id.ll_activity_person_balance:
                Log.e(TAG, "onViewClicked: "+"跳转至 余额界面" );

                break;
            case R.id.btn_activity_person_kiting:
                Log.e(TAG, "onViewClicked: "+"跳转至 提现余额" );
                intent = new Intent(PersonActivity.this,WithdrawDepositActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_activity_person_order_all:
                Log.e(TAG, "onViewClicked: "+"跳转至 全部订单" );
                intent = new Intent(PersonActivity.this,OrderCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_order_all:
                Log.e(TAG, "onViewClicked: "+"跳转至 全部订单" );
                intent = new Intent(PersonActivity.this,OrderCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_wait_payment:
                Log.e(TAG, "onViewClicked: "+"跳转至 待付款" );
                intent = new Intent(PersonActivity.this,OrderCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_wait_shipments:
                Log.e(TAG, "onViewClicked: "+"跳转至 待发货" );
                intent = new Intent(PersonActivity.this,OrderCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_wait_receiving:
                Log.e(TAG, "onViewClicked: "+"跳转至 待收货" );
                intent = new Intent(PersonActivity.this,OrderCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_wait_picking:
                Log.e(TAG, "onViewClicked: "+"跳转至 提货" );
                intent = new Intent(PersonActivity.this,OrderCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_refund_after_sales:
                Log.e(TAG, "onViewClicked: "+"跳转至 退货售后" );
                intent = new Intent(PersonActivity.this,OrderCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_shopping_cart:
                Log.e(TAG, "onViewClicked: "+"跳转至 购物车" );
                intent = new Intent(PersonActivity.this,ShoppingCartActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_discount_coupon:
                Log.e(TAG, "onViewClicked: "+"跳转至 优惠券" );
                intent = new Intent(PersonActivity.this,DiscountCouponActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_bargain:
                Log.e(TAG, "onViewClicked: "+"跳转至 砍价" );
                intent = new Intent(PersonActivity.this,BargainActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_groupon:
                Log.e(TAG, "onViewClicked: "+"跳转至 团购订单" );
                intent = new Intent(PersonActivity.this,GrouponActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_winning:
                Log.e(TAG, "onViewClicked: "+"跳转至 中奖纪录" );
                intent = new Intent(PersonActivity.this,WinningActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_person_integral_shopping:
                Log.e(TAG, "onViewClicked: "+"跳转至 积分商城" );
                intent = new Intent(PersonActivity.this,IntegralActivity.class);
                startActivity(intent);
                break;
        }
    }
}
