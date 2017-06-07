package com.demo.logindemo.activity.personcenter.impl;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.personcenter.impl.fragment.OrderCenterAllFragment;
import com.demo.logindemo.activity.personcenter.impl.fragment.OrderCenterRefundAfterSalesFragment;
import com.demo.logindemo.activity.personcenter.impl.fragment.OrderCenterWaitEvaluationFragment;
import com.demo.logindemo.activity.personcenter.impl.fragment.OrderCenterWaitPaymentFragment;
import com.demo.logindemo.activity.personcenter.impl.fragment.OrderCenterWaitPickingFragment;
import com.demo.logindemo.activity.personcenter.impl.fragment.OrderCenterWaitReceivingFragment;
import com.demo.logindemo.activity.personcenter.impl.fragment.OrderCenterWaitShipmentsFragment;
import com.demo.logindemo.activity.personcenter.view.IOrderCenterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderCenterActivity extends BaseActivity implements IOrderCenterView {

    @BindView(R.id.iv_activity_order_center_return)
    ImageView ivActivityOrderCenterReturn;
    @BindView(R.id.iv_activity_order_center_close)
    ImageView ivActivityOrderCenterClose;

    @BindView(R.id.tv_activity_order_center_all)
    TextView tvActivityOrderCenterAll;
    @BindView(R.id.v_activity_order_center_all)
    View vActivityOrderCenterAll;
    @BindView(R.id.ll_activity_order_center_all)
    LinearLayout llActivityOrderCenterAll;

    @BindView(R.id.tv_activity_order_center_wait_payment)
    TextView tvActivityOrderCenterWaitPayment;
    @BindView(R.id.v_activity_order_center_wait_payment)
    View vActivityOrderCenterWaitPayment;
    @BindView(R.id.ll_activity_order_center_wait_payment)
    LinearLayout llActivityOrderCenterWaitPayment;

    @BindView(R.id.tv_activity_order_center_wait_shipments)
    TextView tvActivityOrderCenterWaitShipments;
    @BindView(R.id.v_activity_order_center_wait_shipments)
    View vActivityOrderCenterWaitShipments;
    @BindView(R.id.ll_activity_order_center_wait_shipments)
    LinearLayout llActivityOrderCenterWaitShipments;

    @BindView(R.id.tv_activity_order_center_wait_receiving)
    TextView tvActivityOrderCenterWaitReceiving;
    @BindView(R.id.v_activity_order_center_wait_receiving)
    View vActivityOrderCenterWaitReceiving;
    @BindView(R.id.ll_activity_order_center_wait_receiving)
    LinearLayout llActivityOrderCenterWaitReceiving;

    @BindView(R.id.tv_activity_order_center_wait_picking)
    TextView tvActivityOrderCenterWaitPicking;
    @BindView(R.id.v_activity_order_center_wait_picking)
    View vActivityOrderCenterWaitPicking;
    @BindView(R.id.ll_activity_order_center_wait_picking)
    LinearLayout llActivityOrderCenterWaitPicking;

    @BindView(R.id.tv_activity_order_center_wait_evaluation)
    TextView tvActivityOrderCenterWaitEvaluation;
    @BindView(R.id.v_activity_order_center_wait_evaluation)
    View vActivityOrderCenterWaitEvaluation;
    @BindView(R.id.ll_activity_order_center_wait_evaluation)
    LinearLayout llActivityOrderCenterWaitEvaluation;

    @BindView(R.id.tv_activity_order_center_refund_after_sales)
    TextView tvActivityOrderCenterRefundAfterSales;
    @BindView(R.id.v_activity_order_center_refund_after_sales)
    View vActivityOrderCenterRefundAfterSales;
    @BindView(R.id.ll_activity_order_center_refund_after_sales)
    LinearLayout llActivityOrderCenterRefundAfterSales;

    @BindView(R.id.ll_activity_order_center_parent)
    LinearLayout llActivityOrderCenterParent;

    private OrderCenterAllFragment orderCenterAllFragment;
    private OrderCenterWaitPaymentFragment orderCenterWaitPaymentFragment;
    private OrderCenterWaitShipmentsFragment orderCenterWaitShipmentsFragment;
    private OrderCenterWaitReceivingFragment orderCenterWaitReceivingFragment;
    private OrderCenterWaitPickingFragment orderCenterWaitPickingFragment;
    private OrderCenterWaitEvaluationFragment orderCenterWaitEvaluationFragment;
    private OrderCenterRefundAfterSalesFragment orderCenterRefundAfterSalesFragment;

    private Intent intent;

    private int setFragment = 500;

    private static final int ALL = 1;
    private static final int WAIT_PAYMENT = 2;
    private static final int WAIT_SHIPMENTS = 3;
    private static final int WAIT_RECEIVING = 4;
    private static final int WAIT_PICKING = 5;
    private static final int WAIT_EVALUATION = 6;
    private static final int REFUND_AFTER_SALES = 7;

    /**
     * 用于对Fragment的管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    private int fragmentRequestSign;

    public static final String TAG = "OrderCenterActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_center);
        ButterKnife.bind(this);
        //添加一个FragmentTransaction的实例
        fragmentManager = getFragmentManager();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();

        questionList();

    }

    @OnClick({R.id.iv_activity_order_center_return,
            R.id.iv_activity_order_center_close,
            R.id.tv_activity_order_center_all,
            R.id.tv_activity_order_center_wait_payment,
            R.id.tv_activity_order_center_wait_shipments,
            R.id.tv_activity_order_center_wait_receiving,
            R.id.tv_activity_order_center_wait_picking,
            R.id.tv_activity_order_center_wait_evaluation,
            R.id.tv_activity_order_center_refund_after_sales})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_order_center_return:
                intent = new Intent(OrderCenterActivity.this,PersonActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_activity_order_center_close:
                break;

            case R.id.tv_activity_order_center_all:
                setTabSelection(1);
                break;
            case R.id.tv_activity_order_center_wait_payment:
                setTabSelection(2);
                break;
            case R.id.tv_activity_order_center_wait_shipments:
                setTabSelection(3);
                break;
            case R.id.tv_activity_order_center_wait_receiving:
                setTabSelection(4);
                break;
            case R.id.tv_activity_order_center_wait_picking:
                setTabSelection(5);
                break;
            case R.id.tv_activity_order_center_wait_evaluation:
                setTabSelection(6);
                break;
            case R.id.tv_activity_order_center_refund_after_sales:
                setTabSelection(7);
                break;
        }
    }


    /**
     * 根据传入的index参数来设置选中的Fragment。
     *
     * @param index 每个图片对应的下标。0表示已解决，1表示未解决，2表示我要提问，3表示我的问题。
     */
    private void setTabSelection(int index) {
//        Log.e(TAG, "setTabSelection: " );
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        //添加一个FragmentTransaction的实例
        fragmentManager = getFragmentManager();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);

        switch (index) {
            case ALL:
                // 当点击了已解决图片时，改变控件的图片
                tvActivityOrderCenterAll.setTextColor(0xffff0000);
                vActivityOrderCenterAll.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------0");
                if (orderCenterAllFragment == null) {
                    // 如果resolvedFragment为空，则创建一个并添加到界面上
                    orderCenterAllFragment = new OrderCenterAllFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterAllFragment);
                } else {
                    // 如果resolvedFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterAllFragment);
                }
                fragmentRequestSign = 100;
                break;
            case WAIT_PAYMENT:

                // 当点击了未解决图片时，改变控件的图片
                tvActivityOrderCenterWaitPayment.setTextColor(0xffff0000);
                vActivityOrderCenterWaitPayment.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------1");
                if (orderCenterWaitPaymentFragment == null) {
                    // 如果unsolvedFragment为空，则创建一个并添加到界面上
                    orderCenterWaitPaymentFragment = new OrderCenterWaitPaymentFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterWaitPaymentFragment);
                } else {
                    // 如果unsolvedFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterWaitPaymentFragment);
                }
                fragmentRequestSign = 200;
                break;
            case WAIT_SHIPMENTS:
                // 当点击了我要提问时，改变控件的图片
                tvActivityOrderCenterWaitShipments.setTextColor(0xffff0000);
                vActivityOrderCenterWaitShipments.setBackgroundColor(0xffff0000);
                if (orderCenterWaitShipmentsFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    orderCenterWaitShipmentsFragment = new OrderCenterWaitShipmentsFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterWaitShipmentsFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterWaitShipmentsFragment);
                }
                fragmentRequestSign = 300;
                break;
            case WAIT_RECEIVING:
                // 当点击了我要提问时，改变控件的图片
                tvActivityOrderCenterWaitReceiving.setTextColor(0xffff0000);
                vActivityOrderCenterWaitReceiving.setBackgroundColor(0xffff0000);
                if (orderCenterWaitReceivingFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    orderCenterWaitReceivingFragment = new OrderCenterWaitReceivingFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterWaitReceivingFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterWaitReceivingFragment);
                }
                fragmentRequestSign = 400;
                break;
            case WAIT_PICKING:
                // 当点击了我要提问时，改变控件的图片
                tvActivityOrderCenterWaitPicking.setTextColor(0xffff0000);
                vActivityOrderCenterWaitPicking.setBackgroundColor(0xffff0000);
                if (orderCenterWaitPickingFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    orderCenterWaitPickingFragment = new OrderCenterWaitPickingFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterWaitPickingFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterWaitPickingFragment);
                }
                fragmentRequestSign = 500;
                break;
            case WAIT_EVALUATION:
                // 当点击了我要提问时，改变控件的图片
                tvActivityOrderCenterWaitEvaluation.setTextColor(0xffff0000);
                vActivityOrderCenterWaitEvaluation.setBackgroundColor(0xffff0000);
                if (orderCenterWaitEvaluationFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    orderCenterWaitEvaluationFragment = new OrderCenterWaitEvaluationFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterWaitEvaluationFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterWaitEvaluationFragment);
                }
                fragmentRequestSign = 600;
                break;
            case REFUND_AFTER_SALES:
                // 当点击了我要提问时，改变控件的图片
                tvActivityOrderCenterRefundAfterSales.setTextColor(0xffff0000);
                vActivityOrderCenterRefundAfterSales.setBackgroundColor(0xffff0000);
                if (orderCenterRefundAfterSalesFragment == null) {
                    // 如果iQuizFragment为空，则创建一个并添加到界面上
                    orderCenterRefundAfterSalesFragment = new OrderCenterRefundAfterSalesFragment();
                    transaction.add(R.id.ll_activity_order_center_parent, orderCenterRefundAfterSalesFragment);
                } else {
                    // 如果iQuizFragment不为空，则直接将它显示出来
                    transaction.show(orderCenterRefundAfterSalesFragment);
                }
                fragmentRequestSign = 700;
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。（字体颜色和view背景颜色）
     */
    private void clearSelection() {
        tvActivityOrderCenterAll.setTextColor(0xff000000);
        vActivityOrderCenterAll.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterWaitPayment.setTextColor(0xff000000);
        vActivityOrderCenterWaitPayment.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterWaitShipments.setTextColor(0xff000000);
        vActivityOrderCenterWaitShipments.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterWaitReceiving.setTextColor(0xff000000);
        vActivityOrderCenterWaitReceiving.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterWaitPicking.setTextColor(0xff000000);
        vActivityOrderCenterWaitPicking.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterWaitEvaluation.setTextColor(0xff000000);
        vActivityOrderCenterWaitEvaluation.setBackgroundColor(0xdddddddd);

        tvActivityOrderCenterRefundAfterSales.setTextColor(0xff000000);
        vActivityOrderCenterRefundAfterSales.setBackgroundColor(0xdddddddd);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
//        Log.e(TAG, "hideFragments: " );
        if (orderCenterAllFragment != null) {
            transaction.hide(orderCenterAllFragment);
        }
        if (orderCenterWaitPaymentFragment != null) {
            transaction.hide(orderCenterWaitPaymentFragment);
        }
        if (orderCenterWaitShipmentsFragment != null) {
            transaction.hide(orderCenterWaitShipmentsFragment);
        }
        if (orderCenterWaitReceivingFragment != null) {
            transaction.hide(orderCenterWaitReceivingFragment);
        }
        if (orderCenterWaitPickingFragment != null) {
            transaction.hide(orderCenterWaitPickingFragment);
        }
        if (orderCenterWaitEvaluationFragment != null) {
            transaction.hide(orderCenterWaitEvaluationFragment);
        }
        if (orderCenterRefundAfterSalesFragment != null) {
            transaction.hide(orderCenterRefundAfterSalesFragment);
        }
    }

    /**
     * 初始化展示和点击筛选之后的fragment展示
     */
    private void questionList(){
        Intent intent = this.getIntent();
        fragmentRequestSign = intent.getIntExtra("fragmentRequestSign",0);
        Log.e(TAG, "questionList: --------"+ fragmentRequestSign);
        switch (fragmentRequestSign){
            case 200:
                //展示OrderCenterWaitPaymentFragment
                Log.e(TAG, "questionList: "+"002" );
                setTabSelection(WAIT_PAYMENT);
                break;
            case 300:
                //展示OrderCenterWaitShipmentsFragment
                Log.e(TAG, "questionList: "+"003" );
                setTabSelection(WAIT_SHIPMENTS);
                break;
            case 400:
                //展示我的已解决问题Fragment
                Log.e(TAG, "questionList: "+"004" );
                setTabSelection(WAIT_RECEIVING);
                break;
            case 600:
                //展示我的未解决Fragment
                Log.e(TAG, "questionList: "+"006" );
                setTabSelection(WAIT_EVALUATION);
                break;
            case 700:
                //展示我的未解决Fragment
                Log.e(TAG, "questionList: "+"007" );
                setTabSelection(REFUND_AFTER_SALES);
                break;
            default:
                //展示ResolvedFragment
                Log.e(TAG, "questionList: "+"001" );
                setTabSelection(ALL);
                break;
        }
    }
}
