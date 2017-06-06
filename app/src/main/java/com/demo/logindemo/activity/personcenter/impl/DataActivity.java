package com.demo.logindemo.activity.personcenter.impl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.personcenter.view.IDataView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DataActivity extends BaseActivity implements IDataView {

    @BindView(R.id.et_activity_data_username)
    EditText etActivityDataUsername;
    @BindView(R.id.tv_activity_data_province_city)
    TextView tvActivityDataProvinceCity;
    @BindView(R.id.et_activity_data_we_chat)
    EditText etActivityDataWeChat;
    @BindView(R.id.btn_activity_data_confirm)
    Button btnActivityDataConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tv_activity_data_province_city, R.id.btn_activity_data_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_activity_data_province_city:
                // TODO: 2017/6/6 省市选择待加入第三方框架
                break;
            case R.id.btn_activity_data_confirm:
                // TODO: 2017/6/6 确认修改 待实现
                break;
        }
    }
}
