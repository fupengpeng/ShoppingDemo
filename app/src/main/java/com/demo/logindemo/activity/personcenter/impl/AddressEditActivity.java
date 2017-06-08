package com.demo.logindemo.activity.personcenter.impl;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
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
import com.demo.logindemo.customerview.EditAddressEditPopupWindow;
import com.demo.logindemo.entity.ShippingAddress;
import com.demo.logindemo.util.ToastUtils;

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

    /**
     * 返回
     */
    @BindView(R.id.iv_activity_address_edit_return)
    ImageView ivActivityAddressEditReturn;
    /**
     * 地址列表
     */
    @BindView(R.id.lv_activity_address_edit_list)
    ListView lvActivityAddressEditList;
    /**
     * 添加地址
     */
    @BindView(R.id.btn_activity_address_edit_add)
    Button btnActivityAddressEditAdd;
    /**
     * 一键获取微信地址
     */
    @BindView(R.id.btn_activity_address_edit_obtain)
    Button btnActivityAddressEditObtain;

    /**
     * 地址数据列表
     */
    private LinkedList<ShippingAddress> shippingAddressList;


    /**
     * 添加地址的popupwindow
     */
    AddressEditPopupWindow addressEditPopupWindow;

    /**
     * 修改地址的popupwindow
     */
    EditAddressEditPopupWindow editAddressEditPopupWindow;
    /**
     * 删除地址的dialog
     */
    private AlertDialog dialog;
    /**
     * 确认删除
     */
    private Button btn_affirm;
    /**
     * 取消删除
     */
    private Button btn_cancle;
    /**
     * 适配器
     */
    private AddressEditAdapter addressEditAdapter;

    /**
     * 接收popupwindow返回的收货地址数据
     */
    private String username;
    private String phoneNumber;
    private String addressProvinceCity;
    private String addressStreet;
    private String postCode;

    /**
     * 手机号的正则判断
     */
    private String telRegex;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_address_edit);

        /**
         * 模拟地址数据
         */
        getShippingAddressList();

        addressEditAdapter = new AddressEditAdapter(this, shippingAddressList);

        lvActivityAddressEditList.setAdapter(addressEditAdapter);

    }

    /**
     * 模拟地址数据
     */
    private void getShippingAddressList() {
        shippingAddressList = new LinkedList<ShippingAddress>();

        for (int i = 0; i < 20; i++) {
            ShippingAddress shippingAddress = new ShippingAddress();
            shippingAddress.setUsername("张三--" + i);
            shippingAddress.setPhoneNumber("11111111--" + i);
            shippingAddress.setAddress("地址--" + i);
            shippingAddress.setIsDefault(true);

            shippingAddressList.add(shippingAddress);
        }
    }

    @OnClick({R.id.iv_activity_address_edit_return,
            R.id.btn_activity_address_edit_add,
            R.id.btn_activity_address_edit_obtain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /**
             * 地址管理界面的返回按钮
             */
            case R.id.iv_activity_address_edit_return:
                Toast.makeText(
                        AddressEditActivity.this,
                        "点击返回按钮",
                        Toast.LENGTH_SHORT).show();
                intent = new Intent(AddressEditActivity.this,InformationEditActivity.class);
                startActivity(intent);
                break;
            /**
             * 添加新地址
             */
            case R.id.btn_activity_address_edit_add:

                //实例化SelectPicPopupWindow
                addressEditPopupWindow = new AddressEditPopupWindow(AddressEditActivity.this, itemsOnClick);
                addressEditPopupWindow.setFocusable(true);


                //显示窗口
                addressEditPopupWindow.showAtLocation(AddressEditActivity.this.findViewById(R.id.ll_activity_address_edit_parent),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

                Toast.makeText(
                        AddressEditActivity.this,
                        "点击添加按钮",
                        Toast.LENGTH_SHORT).show();
                break;
            /**
             * 一键获取微信地址
             */
            case R.id.btn_activity_address_edit_obtain:
                // TODO: 2017/6/8 0008 一键获取待实现
                Toast.makeText(
                        AddressEditActivity.this,
                        "点击一键获取按钮",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

//    /**
//     * 设置添加屏幕的背景透明度
//     * @param bgAlpha
//     */
//    public void backgroundAlpha(float bgAlpha)
//    {
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.alpha = bgAlpha; //0.0-1.0
//        getWindow().setAttributes(lp);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//    }


    /**
     * popupwindow实现监听类
     */
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {

        public void onClick(View v) {

            switch (v.getId()) {
                /**
                 * 添加新地址的保存
                 */
                case R.id.btn_address_edit_popup_window_save:
                    username = addressEditPopupWindow.getUsername();
                    phoneNumber = addressEditPopupWindow.getPhoneNumber();
                    addressProvinceCity = addressEditPopupWindow.getAddressProvinceCity();
                    addressStreet = addressEditPopupWindow.getAddressStreet();
                    postCode = addressEditPopupWindow.getPostCode();
                    telRegex = "[1][34578]\\d{9}";
                    if (TextUtils.isEmpty(username)&&
                            TextUtils.isEmpty(phoneNumber)&&
                            TextUtils.isEmpty(addressProvinceCity)&&
                            TextUtils.isEmpty(addressStreet)) {
                        ToastUtils.showLong(AddressEditActivity.this, "请填写空白输入框");
                    } else if (!phoneNumber.matches(telRegex)) {
                        ToastUtils.showLong(AddressEditActivity.this, "查无此号码，请重新输入手机号码");
                    } else if (!(postCode.length() == 6) || postCode.length() == 0){
                        ToastUtils.showLong(AddressEditActivity.this,"请输入正确的邮政编码");
                    }else {
                        // TODO: 2017/6/8 0008 添加新地址
                        Log.e(TAG, "onClick: "+"收货人姓名："+username+"    手机号码："+phoneNumber+"    区域信息："+
                                addressProvinceCity+"    详细地址："+addressStreet+"    邮政编码："+postCode );
                        ToastUtils.showLong(AddressEditActivity.this,"onClick: "+"收货人姓名："+username+"    手机号码："+phoneNumber+"    区域信息："+
                                addressProvinceCity+"    详细地址："+addressStreet+"    邮政编码："+postCode);

                        //更新数据源
                        addressEditAdapter.notifyDataSetChanged();
                    }

                    addressEditPopupWindow.dismiss();
                    break;

                /**
                 * 添加新地址的关闭popupwindow按钮
                 */
                case R.id.tv_address_edit_popup_window_close:
                    addressEditPopupWindow.dismiss();
                    break;

                /**
                 * 编辑地址的关闭popupwindow按钮
                 */
                case R.id.tv_address_edit_popup_window_edit_close:
                    editAddressEditPopupWindow.dismiss();
                    break;
                /**
                 * 编辑地址的保存按钮
                 */
                case R.id.btn_address_edit_popup_window_edit_save:
                    username = editAddressEditPopupWindow.getUsername();
                    phoneNumber = editAddressEditPopupWindow.getPhoneNumber();
                    addressProvinceCity = editAddressEditPopupWindow.getAddressProvinceCity();
                    addressStreet = editAddressEditPopupWindow.getAddressStreet();
                    postCode = editAddressEditPopupWindow.getPostCode();
                    telRegex = "[1][34578]\\d{9}";
                    if (TextUtils.isEmpty(username)&&
                            TextUtils.isEmpty(phoneNumber)&&
                            TextUtils.isEmpty(addressProvinceCity)&&
                            TextUtils.isEmpty(addressStreet)) {
                        ToastUtils.showLong(AddressEditActivity.this, "请填写空白输入框");
                    } else if (!phoneNumber.matches(telRegex)) {
                        ToastUtils.showLong(AddressEditActivity.this, "查无此号码，请重新输入手机号码");
                    } else if (!(postCode.length() == 6) || postCode.length() == 0){
                        ToastUtils.showLong(AddressEditActivity.this,"请输入正确的邮政编码");
                    }else {
                        // TODO: 2017/6/8 0008 编辑地址
                        Log.e(TAG, "onClick: "+"收货人姓名："+username+"    手机号码："+phoneNumber+"    区域信息："+
                                addressProvinceCity+"    详细地址："+addressStreet+"    邮政编码："+postCode );
                        ToastUtils.showLong(AddressEditActivity.this,"onClick: "+"收货人姓名："+username+"    手机号码："+phoneNumber+"    区域信息："+
                                addressProvinceCity+"    详细地址："+addressStreet+"    邮政编码："+postCode);

                        //更新数据源
                        addressEditAdapter.notifyDataSetChanged();
                    }

                    editAddressEditPopupWindow.dismiss();
                    break;
                /**
                 * 编辑地址的删除按钮
                 */
                case R.id.btn_address_edit_popup_window_edit_delete:
                    shippingAddressList.remove((Integer) v.getTag());
                    editAddressEditPopupWindow.dismiss();
                    break;
                default:
                    break;
            }


        }

    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /**
             * 删除dialog的取消按钮
             */
            case R.id.item_item_activity_address_edit_delete_cancel:
                dialog.dismiss();
                break;
            /**
             * 删除dialog的确定删除按钮
             */
            case R.id.item_item_activity_address_edit_delete_affirm:
                shippingAddressList.remove((Integer) v.getTag());
                addressEditAdapter.notifyDataSetChanged();
                dialog.dismiss();
                break;
            /**
             * 子条目设置默认地址的点击事件
             */
            case R.id.item_activity_address_edit_is_default:
                // TODO: 2017/6/8 0008   设置默认地址，待实现
                Toast.makeText(
                        AddressEditActivity.this,
                        "listview的内部的是否默认按钮被点击了！，位置是-->" + (Integer) v.getTag()
                                + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()),
                        Toast.LENGTH_SHORT).show();
                ShippingAddress shippingAddressFirst = shippingAddressList.get((Integer) v.getTag());
                shippingAddressList.remove((Integer) v.getTag());
                shippingAddressList.addFirst(shippingAddressFirst);
                //更新数据源
                addressEditAdapter.notifyDataSetChanged();
                break;

            /**
             * 子条目编辑按钮的点击事件
             */
            case R.id.item_activity_address_edit_edit:

                //实例化SelectPicPopupWindow
                editAddressEditPopupWindow = new EditAddressEditPopupWindow(AddressEditActivity.this, itemsOnClick);
                //显示窗口
                editAddressEditPopupWindow.showAtLocation(AddressEditActivity.this.findViewById(R.id.ll_activity_address_edit_parent),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                //设置layout在PopupWindow中显示的位置
                Toast.makeText(
                        AddressEditActivity.this,
                        "listview的内部的编辑按钮被点击了！，位置是-->" + (Integer) v.getTag()
                                + ",内容是-->" + shippingAddressList.get((Integer) v.getTag()),
                        Toast.LENGTH_SHORT).show();

                break;
            /**
             * 子条目删除按钮的点击事件
             */
            case R.id.item_activity_address_edit_delete:


                AlertDialog.Builder builder = new AlertDialog.Builder(AddressEditActivity.this);
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
