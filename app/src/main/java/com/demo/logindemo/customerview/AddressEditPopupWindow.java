package com.demo.logindemo.customerview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.demo.logindemo.R;
import com.lljjcoder.citypickerview.widget.CityPicker;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by fupengpeng on 2017/6/3 0003.
 */

public class AddressEditPopupWindow extends PopupWindow {
    public static final String TAG = "AddressEditPopupWindow";
    TextView tvAddressEditPopupWindowClose;
    EditText etAddressEditPopupWindowUsername;
    EditText etAddressEditPopupWindowPhoneNumber;
    TextView tvAddressEditPopupWindowAddressProvinceCity;
    EditText etAddressEditPopupWindowAddressStreet;
    EditText etAddressEditPopupWindowPostcode;
    Button btnAddressEditPopupWindowSave;
    Button btnAddressEditPopupWindowDelete;
    private View mMenuView;
    private String username;
    private String phoneNumber;
    private String addressProvinceCity;
    private String addressStreet;
    private String postCode;


    public AddressEditPopupWindow(final Activity context, View.OnClickListener onClickListener) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.edit_place_of_receipt, null);

        btnAddressEditPopupWindowDelete = (Button) mMenuView.findViewById(R.id.btn_address_edit_popup_window_delete);
        btnAddressEditPopupWindowSave = (Button) mMenuView.findViewById(R.id.btn_address_edit_popup_window_save);
        tvAddressEditPopupWindowClose = (TextView) mMenuView.findViewById(R.id.tv_address_edit_popup_window_close);

        etAddressEditPopupWindowUsername = (EditText) mMenuView.findViewById(R.id.et_address_edit_popup_window_username);
        etAddressEditPopupWindowPhoneNumber = (EditText) mMenuView.findViewById(R.id.et_address_edit_popup_window_phone_number);
        tvAddressEditPopupWindowAddressProvinceCity = (TextView) mMenuView.findViewById(R.id.tv_address_edit_popup_window_address_province_city);
        etAddressEditPopupWindowAddressStreet = (EditText) mMenuView.findViewById(R.id.et_address_edit_popup_window_address_street);
        etAddressEditPopupWindowPostcode = (EditText) mMenuView.findViewById(R.id.et_address_edit_popup_window_postcode);


        tvAddressEditPopupWindowAddressProvinceCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAddress(context);
            }
        });

        etAddressEditPopupWindowUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                username = etAddressEditPopupWindowUsername.getText().toString();
            }
        });
        etAddressEditPopupWindowPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                phoneNumber = etAddressEditPopupWindowPhoneNumber.getText().toString();
            }
        });
        etAddressEditPopupWindowAddressStreet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                addressStreet = etAddressEditPopupWindowAddressStreet.getText().toString();
            }
        });
        etAddressEditPopupWindowPostcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                postCode = etAddressEditPopupWindowPostcode.getText().toString();
            }
        });

        //取消按钮
        tvAddressEditPopupWindowClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //销毁弹出框
                dismiss();
            }
        });
        //设置按钮监听
        btnAddressEditPopupWindowDelete.setOnClickListener(onClickListener);
        btnAddressEditPopupWindowSave.setOnClickListener(onClickListener);
        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
//        this.setAnimationStyle(R.style.AnimBottom);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xffeeeeee);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = mMenuView.findViewById(R.id.ll_address_edit_popup_window).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });

    }


    //Texview的点击事件
//    public void chooseArea(View view) {
//        //判断输入法的隐藏状态
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        if (imm.isActive()) {
//            imm.hideSoftInputFromWindow(view.getWindowToken(),
//                    InputMethodManager.HIDE_NOT_ALWAYS);
//            selectAddress();//调用CityPicker选取区域
//        }
//    }
    private void selectAddress(Context context) {
        CityPicker cityPicker = new CityPicker.Builder(context)
                .textSize(14)
                .title("地址选择")
                .titleBackgroundColor("#ffffff")
//                .titleTextColor("#696969")
                .confirTextColor("#696969")
                .cancelTextColor("#696969")
                .province("山东省")
                .city("济宁市")
                .district("任城区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();
        cityPicker.show();
        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                //为TextView赋值
                tvAddressEditPopupWindowAddressProvinceCity.setText(province.trim() + "-" + city.trim() + "-" + district.trim());
            }
        });
    }

}
