package com.demo.logindemo.activity.personcenter.impl;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.personcenter.view.IDataView;
import com.demo.logindemo.util.ToastUtils;
import com.lljjcoder.citypickerview.widget.CityPicker;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 资料完善界面
 */
public class DataActivity extends BaseActivity implements IDataView {
    public static final String TAG = "DataActivity";

    /**
     * 姓名
     */
    @BindView(R.id.et_activity_data_username)
    EditText etActivityDataUsername;
    /**
     * 所在地
     */
    @BindView(R.id.tv_activity_data_province_city)
    TextView tvActivityDataProvinceCity;
    /**
     * 微信号
     */
    @BindView(R.id.et_activity_data_we_chat)
    EditText etActivityDataWeChat;
    /**
     * 确定
     */
    @BindView(R.id.btn_activity_data_confirm)
    Button btnActivityDataConfirm;
    /**
     * 男
     */
    @BindView(R.id.rbtn_activity_data_male)
    RadioButton rbtnActivityDataMale;
    /**
     * 女
     */
    @BindView(R.id.rbtn_activity_data_female)
    RadioButton rbtnActivityDataFemale;
    /**
     * 性别
     */
    @BindView(R.id.rg_activity_data_sex)
    RadioGroup rgActivityDataSex;
    /**
     * 生日
     */
    @BindView(R.id.tv_activity_data_birthday)
    TextView tvActivityDataBirthday;
    /**
     * 返回资料修改界面
     */
    @BindView(R.id.iv_activity_data_return)
    ImageView ivActivityDataReturn;
    private String sex;
    private String provinceCity;
    private String username;
    private String birthday;
    private String weChat;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ButterKnife.bind(this);

        etActivityDataUsername.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                username = etActivityDataUsername.getText().toString().trim();
//                        Log.e(TAG, "afterTextChanged: "+username );
            }
        });
//                String sex = String.valueOf(rbtnActivityDataMale.isChecked());
        if (rbtnActivityDataMale.isChecked()) {
            sex = "男";
        } else {
            sex = "女";
        }
        provinceCity = tvActivityDataProvinceCity.getText().toString().trim();

        etActivityDataWeChat.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                weChat = etActivityDataWeChat.getText().toString().trim();
            }
        });

    }

    // 记录当前的时间
    private int year;
    private int month;
    private int day;
    private DatePickerDialog datePickerDialog;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick({R.id.tv_activity_data_province_city,
            R.id.btn_activity_data_confirm,
            R.id.tv_activity_data_birthday,
            R.id.iv_activity_data_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_activity_data_province_city:
                selectAddress(this);
                break;
            case R.id.btn_activity_data_confirm:
                // TODO: 2017/6/6 确认修改 待实现

                ToastUtils.showLong(this, "姓名：" + username + "   性别：" + sex + "    所在地：" + provinceCity + "    生日：" + birthday + "    微信号：" + weChat);

                intent = new Intent(DataActivity.this, InformationEditActivity.class);
                startActivity(intent);
                break;
            case  R.id.tv_activity_data_birthday:


                // TODO: 2017/6/12 0012  ????????????????????????????????

                datePickerDialog.show();

                // 或许当前的年月日，小时，分钟
                Calendar ca = Calendar.getInstance();
                year = ca.get(Calendar.YEAR);
                month = ca.get(Calendar.MONTH);
                day = ca.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(this);

                // 设置文本的内容：
                tvActivityDataBirthday.setText(new StringBuilder().append(year).append("年")
                        .append(month + 1).append("月")// 得到的月份+1，因为从0开始
                        .append(day).append("日"));



                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        year = year;
                        month = month;
                        day = dayOfMonth;

                        String str1 = new String(new StringBuilder().append(year)
                                .append("年").append(month + 1).append("月")// 得到的月份+1，因为从0开始
                                .append(day).append("日"));
                        // 设置文本的内容：
                        tvActivityDataBirthday.setText(str1);
                    }
                });

                break;
            case R.id.iv_activity_data_return:
                intent = new Intent(DataActivity.this, InformationEditActivity.class);
                startActivity(intent);
                break;

        }
    }

    private void selectAddress(Context context) {
        CityPicker cityPicker = new CityPicker.Builder(context)
                .textSize(14)
                .title("地址选择")
                .titleBackgroundColor("#ffffff")
                .confirTextColor("#696969")
                .cancelTextColor("#696969")
                .province("山东省")
                .city("济宁市")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(true)
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
                //邮编
                String code = citySelected[3];
                //为TextView赋值
                tvActivityDataProvinceCity.setText(province.trim() + "  " + city.trim());
            }
        });
    }


}
