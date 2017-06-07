package com.demo.logindemo.activity.personcenter.impl.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.personcenter.impl.DiscountCouponActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 优惠券
 * 未使用fragment
 */
public class DiscountCouponUnusedFragment extends Fragment {

    /**
     * 上下文
     */
    protected Context mContext = null;
    /**
     * 依附的MainActivity
     */
    protected Activity mainActivity = null;
    @BindView(R.id.fragment_discount_coupon_unused)
    ListView fragmentDiscountCouponUnused;
    Unbinder unbinder;
    private View DiscountCouponFragmentView;

    /**
     * 获取Fragment依赖的MainActivity
     *
     * @return
     */
    public Activity getDiscountCouponActivity() {
        mainActivity = (DiscountCouponActivity) getActivity();
        mContext = mainActivity;
        return mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        DiscountCouponFragmentView = inflater.inflate(R.layout.fragment_discount_coupon_unused, container, false);
        unbinder = ButterKnife.bind(this, DiscountCouponFragmentView);
        getDiscountCouponActivity();
        return DiscountCouponFragmentView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
