package com.demo.logindemo.activity.personcenter.impl;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.AddressEditAdapter;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.personcenter.view.IAddressEditView;
import com.demo.logindemo.customerview.AddressEditPopupWindow;
import com.demo.logindemo.entity.ShippingAddress;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddressEditActivity extends BaseActivity
        implements IAddressEditView,
        AdapterView.OnItemClickListener,
        View.OnClickListener{
    public static final String TAG = "AddressEditActivity";

    @BindView(R.id.iv_activity_address_edit_return)
    ImageView ivActivityAddressEditReturn;
    @BindView(R.id.lv_activity_address_edit_list)
    ListView lvActivityAddressEditList;
    @BindView(R.id.btn_activity_address_edit_add)
    Button btnActivityAddressEditAdd;
    @BindView(R.id.btn_activity_address_edit_obtain)
    Button btnActivityAddressEditObtain;

    private LinkedList<ShippingAddress> shippingAddressList;


    AddressEditPopupWindow addressEditPopupWindow;
    private AlertDialog dialog;
    private Button btn_affirm;
    private Button btn_cancle;
    private AddressEditAdapter addressEditAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_address_edit);


        shippingAddressList = new LinkedList<ShippingAddress>();

        for (int i = 0; i < 20; i++) {
            ShippingAddress shippingAddress = new ShippingAddress();
            shippingAddress.setUsername("张三--" + i);
            shippingAddress.setPhoneNumber("11111111--" + i);
            shippingAddress.setAddress("地址--" + i);
            shippingAddress.setIsDefault(true);

            shippingAddressList.add(shippingAddress);
        }

        addressEditAdapter = new AddressEditAdapter(this, shippingAddressList);

        lvActivityAddressEditList.setAdapter(addressEditAdapter);

    }

    @OnClick({R.id.iv_activity_address_edit_return,
            R.id.btn_activity_address_edit_add,
            R.id.btn_activity_address_edit_obtain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_activity_address_edit_return:
                Toast.makeText(
                        AddressEditActivity.this,
                        "点击返回按钮",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_activity_address_edit_add:

                //实例化SelectPicPopupWindow
                addressEditPopupWindow = new AddressEditPopupWindow(AddressEditActivity.this, itemsOnClick);
                //显示窗口
                addressEditPopupWindow.showAtLocation(AddressEditActivity.this.findViewById(R.id.ll_activity_address_edit_parent),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

                Toast.makeText(
                        AddressEditActivity.this,
                        "点击添加按钮",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_activity_address_edit_obtain:
                Toast.makeText(
                        AddressEditActivity.this,
                        "点击一键获取按钮",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }


    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {

        public void onClick(View v) {
            addressEditPopupWindow.dismiss();
            switch (v.getId()) {
                case R.id.btn_address_edit_popup_window_delete:
                    Log.e(TAG, "onClick: " + "删除收货地址");
                    break;
                case R.id.btn_address_edit_popup_window_save:
                    Log.e(TAG, "onClick: " + "保存收货地址");

                    break;
                default:
                    break;
            }


        }

    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_item_activity_address_edit_delete_cancel:
                dialog.dismiss();
                break;
            case R.id.item_item_activity_address_edit_delete_affirm:

//                Log.e(TAG, "onClick:---- "+"listview的内部的删除按钮被点击了！，位置是-->" + (Integer) v.getTag()
//                        + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()) );
//                ShippingAddress shippingAddressFirst = shippingAddressList.get((Integer) v.getTag());
//
//                shippingAddressList.remove((Integer) v.getTag());
//
//                shippingAddressList.addFirst(shippingAddressFirst);
//                // TODO: 2017/6/5 0005  点击删除条目，更新适配器
//                //更新数据源
//                addressEditAdapter.notifyDataSetChanged();
                dialog.dismiss();
                break;



            case R.id.item_activity_address_edit_is_default:
                Toast.makeText(
                        AddressEditActivity.this,
                        "listview的内部的是否默认按钮被点击了！，位置是-->" + (Integer) v.getTag()
                                + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()),
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_activity_address_edit_edit:
                //实例化SelectPicPopupWindow
                addressEditPopupWindow = new AddressEditPopupWindow(AddressEditActivity.this, itemsOnClick);
                //显示窗口
                addressEditPopupWindow.showAtLocation(AddressEditActivity.this.findViewById(R.id.ll_activity_address_edit_parent),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                //设置layout在PopupWindow中显示的位置
                Toast.makeText(
                        AddressEditActivity.this,
                        "listview的内部的编辑按钮被点击了！，位置是-->" + (Integer) v.getTag()
                                + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()),
                        Toast.LENGTH_SHORT).show();

                break;
            case R.id.item_activity_address_edit_delete:


                ShippingAddress shippingAddress = shippingAddressList.get((Integer) v.getTag());

                shippingAddressList.remove((Integer) v.getTag());

                shippingAddressList.addFirst(shippingAddress);
                // TODO: 2017/6/5 0005  点击删除条目，更新适配器
                //更新数据源
                addressEditAdapter.notifyDataSetChanged();



                AlertDialog.Builder builder = new AlertDialog.Builder(AddressEditActivity.this);
//                builder.setIcon(R.drawable.ic_launcher);//添加ICON
//                builder.setTitle("退出");                //添加标题
//                builder.setMessage("你确定要离开吗？");     //添加MSG

                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.item_item_activity_address_edit_delete, null);

                btn_cancle = (Button) view.findViewById(R.id.item_item_activity_address_edit_delete_cancel);
                btn_affirm = (Button) view.findViewById(R.id.item_item_activity_address_edit_delete_affirm);
                btn_affirm.setOnClickListener(this);
                btn_cancle.setOnClickListener(this);

                builder.setView(view);//添加自定义View
                builder.create();
                dialog = builder.show();

                Toast.makeText(
                        AddressEditActivity.this,
                        "listview的内部的删除按钮被点击了！，位置是-->" + (Integer) v.getTag()
                                + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()),
                        Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onClick: "+"listview的内部的删除按钮被点击了！，位置是-->" + (Integer) v.getTag()
                        + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()) );
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "点击的条目位置是-->" + position, Toast.LENGTH_SHORT)
                .show();
    }
}
