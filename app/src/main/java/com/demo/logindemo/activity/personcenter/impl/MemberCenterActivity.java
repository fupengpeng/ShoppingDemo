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
import com.demo.logindemo.activity.personcenter.impl.fragment.MemberCenterGradeListFragment;
import com.demo.logindemo.activity.personcenter.impl.fragment.MemberCenterStrategyFragment;
import com.demo.logindemo.activity.personcenter.view.IMemgerCenterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 会员中心界面
 */
public class MemberCenterActivity extends BaseActivity implements IMemgerCenterView {

    @BindView(R.id.iv_activity_member_center_query)
    ImageView ivActivityMemberCenterQuery;

    @BindView(R.id.tv_activity_member_center_grade_list)
    TextView tvActivityMemberCenterGradeList;
    @BindView(R.id.v_activity_member_center_grade_list)
    View vActivityMemberCenterGradeList;
    @BindView(R.id.ll_activity_member_center_grade_list)
    LinearLayout llActivityMemberCenterGradeList;

    @BindView(R.id.tv_activity_member_center_strategy)
    TextView tvActivityMemberCenterStrategy;
    @BindView(R.id.v_activity_member_center_strategy)
    View vActivityMemberCenterStrategy;
    @BindView(R.id.ll_activity_member_center_strategy)
    LinearLayout llActivityMemberCenterStrategy;

    @BindView(R.id.ll_activity_member_center_parent)
    LinearLayout llActivityMemberCenterParent;

    private Intent intent;

    private int setFragment = 500;

    private static final int GRADE_LIST = 1;
    private static final int STRATEGY = 2;

    /**
     * 用于展示已解决的Fragment
     */
    private MemberCenterGradeListFragment memberCenterGradeListFragment;

    /**
     * 用于展示未解决的Fragment
     */
    private MemberCenterStrategyFragment memberCenterStrategyFragment;

    /**
     * 用于对Fragment的管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    private int fragmentRequestSign;

    public static final String TAG = "MemberCenterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_center);
        ButterKnife.bind(this);

        //添加一个FragmentTransaction的实例
        fragmentManager = getFragmentManager();
        // 开启一个Fragment事务
        transaction = fragmentManager.beginTransaction();

        setTabSelection(1);

    }

    @OnClick({R.id.iv_activity_member_center_query,
            R.id.ll_activity_member_center_grade_list,
            R.id.ll_activity_member_center_strategy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_member_center_query:
                break;
            case R.id.ll_activity_member_center_grade_list:
                setTabSelection(1);
                break;
            case R.id.ll_activity_member_center_strategy:
                setTabSelection(2);
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
            case GRADE_LIST:
                // 当点击了已解决图片时，改变控件的图片
                tvActivityMemberCenterGradeList.setTextColor(0xffff0000);
                vActivityMemberCenterGradeList.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------0");
                if (memberCenterGradeListFragment == null) {
                    // 如果resolvedFragment为空，则创建一个并添加到界面上
                    memberCenterGradeListFragment = new MemberCenterGradeListFragment();
                    transaction.add(R.id.ll_activity_member_center_parent, memberCenterGradeListFragment);
                } else {
                    // 如果resolvedFragment不为空，则直接将它显示出来
                    transaction.show(memberCenterGradeListFragment);
                }
                fragmentRequestSign = 100;
                break;
            case STRATEGY:

                // 当点击了未解决图片时，改变控件的图片
                tvActivityMemberCenterStrategy.setTextColor(0xffff0000);
                vActivityMemberCenterStrategy.setBackgroundColor(0xffff0000);
                Log.e(TAG, "setTabSelection--------------setTabSelection: " + "-----------1");
                if (memberCenterStrategyFragment == null) {
                    // 如果unsolvedFragment为空，则创建一个并添加到界面上
                    memberCenterStrategyFragment = new MemberCenterStrategyFragment();
                    transaction.add(R.id.ll_activity_member_center_parent, memberCenterStrategyFragment);
                } else {
                    // 如果unsolvedFragment不为空，则直接将它显示出来
                    transaction.show(memberCenterStrategyFragment);
                }
                fragmentRequestSign = 200;
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。（字体颜色和view背景颜色）
     */
    private void clearSelection() {
        tvActivityMemberCenterGradeList.setTextColor(0xff000000);
        vActivityMemberCenterGradeList.setBackgroundColor(0xdddddddd);
        tvActivityMemberCenterStrategy.setTextColor(0xff000000);
        vActivityMemberCenterStrategy.setBackgroundColor(0xdddddddd);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
//        Log.e(TAG, "hideFragments: " );
        if (memberCenterGradeListFragment != null) {
            transaction.hide(memberCenterGradeListFragment);
        }
        if (memberCenterStrategyFragment != null) {
            transaction.hide(memberCenterStrategyFragment);
        }
    }

}
