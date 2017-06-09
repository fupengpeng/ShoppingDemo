package com.demo.logindemo.activity.personcenter.impl.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.demo.logindemo.R;
import com.demo.logindemo.entity.response.OrderCenterOrderList;
import com.demo.logindemo.entity.response.OrderCenterOrderObject;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 订单管理
 * 待付款
 */
public class OrderCenterWaitPaymentFragment extends Fragment {
    public static final String TAG = "OrderCenterWaitPaymentFragment";
    /**
     * 订单列表
     */
    @BindView(R.id.ptrlv_fragment_order_center_wait_payment)
    PullToRefreshListView ptrlvFragmentOrderCenterWaitPayment;
    /**
     * 暂无订单时的展示
     */
    @BindView(R.id.ll_fragment_order_center_wait_payment)
    LinearLayout llFragmentOrderCenterWaitPayment;
    Unbinder unbinder;
    private View orderCenterWaitPaymentFragmentView;
    /**
     * 数据源对象
     */
    private OrderCenterOrderList orderCenterOrderList;

    /**
     * 数据源
     */
    List<Map<String, Object>> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        orderCenterWaitPaymentFragmentView = inflater.inflate(R.layout.fragment_order_center_wait_payment, container, false);
        unbinder = ButterKnife.bind(this, orderCenterWaitPaymentFragmentView);
        parseData();
        list = getData();



        return orderCenterWaitPaymentFragmentView;
    }

    /**
     * 给数据对象添加数据
     */
    private void parseData() {
        orderCenterOrderList = new OrderCenterOrderList();
        List<OrderCenterOrderObject> orderCenterOrderObjects = new ArrayList<OrderCenterOrderObject>();
        for (int i = 0; i < 5; i++) {
            OrderCenterOrderObject orderCenterOrderObject = new OrderCenterOrderObject();
            orderCenterOrderObject.setOrderCenterOrderListOrderNumber("订单号：---" + i + "---");
            orderCenterOrderObject.setOrderCenterOrderListCommodityPic(R.drawable.nvshengtouxiang);
            orderCenterOrderObject.setOrderCenterOrderListCommodityName("商品名称：---" + i + "---");
            orderCenterOrderObject.setOrderCenterOrderListCommodityQuantity("商品数量：---" + i + "---");
            orderCenterOrderObject.setOrderCenterOrderListCommodityAggregatePrice("商品价格：---" + i + "---");
            orderCenterOrderObjects.add(orderCenterOrderObject);
        }
        orderCenterOrderList.setOrderCenterOrderObjectList(orderCenterOrderObjects);
        Log.e(TAG, "parseData: " + orderCenterOrderList.getOrderCenterOrderObjectList().get(2).getOrderCenterOrderListCommodityName().toString().trim());

    }

    /**
     * 从数据对象获取数据
     * @return
     */
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < orderCenterOrderList.getOrderCenterOrderObjectList().size(); i++) {
            map = new HashMap<String, Object>();
            map.put("orderCenterOrderListOrderNumber", orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListOrderNumber());
            map.put("orderCenterOrderListCommodityPic", orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityPic());
            map.put("orderCenterOrderListCommodityName", orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityName());
            map.put("orderCenterOrderListCommodityQuantity", orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityQuantity());
            map.put("orderCenterOrderListCommodityAggregatePrice", orderCenterOrderList.getOrderCenterOrderObjectList().get(i).getOrderCenterOrderListCommodityAggregatePrice());
            list.add(map);
        }
        return list;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
