package com.demo.logindemo.activity.personcenter.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demo.logindemo.R;
import com.demo.logindemo.activity.BaseActivity;
import com.demo.logindemo.activity.personcenter.view.IInformationEditView;
import com.demo.logindemo.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 资料编辑界面
 */
public class InformationEditActivity extends BaseActivity implements IInformationEditView, View.OnClickListener {


    @BindView(R.id.ll_activity_information_edit_data)
    LinearLayout llActivityInformationEditData;
    @BindView(R.id.ll_activity_information_edit_address)
    LinearLayout llActivityInformationEditAddress;
    @BindView(R.id.ll_activity_information_edit_pic)
    LinearLayout llActivityInformationEditPic;
    @BindView(R.id.ll_activity_information_edit_password)
    LinearLayout llActivityInformationEditPassword;


    ImageView ivItemActivityInformationEditChangePasswordClose;
    EditText etItemActivityInformationEditChangePasswordOld;
    EditText etItemActivityInformationEditChangePasswordNew;
    EditText etItemActivityInformationEditChangePasswordConfirm;
    Button btnItemActivityInformationEditChangePasswordConfirm;

    private String oldPassword, newPassword, confirmPassword;

    private AlertDialog dialog;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_edit);
        ButterKnife.bind(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_item_activity_information_edit_change_password_close:
                dialog.dismiss();
                break;
            case R.id.btn_item_activity_information_edit_change_password_confirm:
                if ((etItemActivityInformationEditChangePasswordNew.getText().toString().trim())
                        .equals(etItemActivityInformationEditChangePasswordConfirm.getText().toString().trim())
                        && etItemActivityInformationEditChangePasswordOld.getText().toString().trim() != null) {
                    // 密码
                    String password = etItemActivityInformationEditChangePasswordNew.getText().toString().trim();
                    // 验证原密码


                    // 确认提交
                    // TODO: 2017/6/6 验证原密码是否正确，正确，修改密码，错误，提示原密码输入错误

                } else {
                    ToastUtils.showLong(InformationEditActivity.this, "两次输入不同，请重新输入");
                    etItemActivityInformationEditChangePasswordNew.setText("");
                    etItemActivityInformationEditChangePasswordConfirm.setText("");
                    etItemActivityInformationEditChangePasswordOld.setText("");
                }
                break;
        }
    }

    @OnClick({R.id.ll_activity_information_edit_data,
            R.id.ll_activity_information_edit_address,
            R.id.ll_activity_information_edit_pic,
            R.id.ll_activity_information_edit_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_activity_information_edit_data:
                intent = new Intent(InformationEditActivity.this, DataActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_information_edit_address:
                intent = new Intent(InformationEditActivity.this, AddressEditActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_information_edit_pic:
                break;
            case R.id.ll_activity_information_edit_password:
                AlertDialog.Builder builder = new AlertDialog.Builder(InformationEditActivity.this);
//                builder.setIcon(R.drawable.ic_launcher);//添加ICON
//                builder.setTitle("退出");                //添加标题
//                builder.setMessage("你确定要离开吗？");     //添加MSG

                LayoutInflater inflater = getLayoutInflater();
                View viewDialog = inflater.inflate(R.layout.item_activity_information_edit_change_password, null);

                ivItemActivityInformationEditChangePasswordClose = (ImageView) viewDialog.findViewById(R.id.iv_item_activity_information_edit_change_password_close);
                btnItemActivityInformationEditChangePasswordConfirm = (Button) viewDialog.findViewById(R.id.btn_item_activity_information_edit_change_password_confirm);
                etItemActivityInformationEditChangePasswordOld = (EditText) viewDialog.findViewById(R.id.et_item_activity_information_edit_change_password_old);
                etItemActivityInformationEditChangePasswordNew = (EditText) viewDialog.findViewById(R.id.et_item_activity_information_edit_change_password_new);
                etItemActivityInformationEditChangePasswordConfirm = (EditText) viewDialog.findViewById(R.id.et_item_activity_information_edit_change_password_confirm);

                ivItemActivityInformationEditChangePasswordClose.setOnClickListener(this);
                btnItemActivityInformationEditChangePasswordConfirm.setOnClickListener(this);
                etItemActivityInformationEditChangePasswordOld.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        oldPassword = etItemActivityInformationEditChangePasswordOld.getText().toString().trim();
                    }
                });
                etItemActivityInformationEditChangePasswordNew.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        newPassword = etItemActivityInformationEditChangePasswordNew.getText().toString().trim();
                    }
                });
                etItemActivityInformationEditChangePasswordConfirm.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        confirmPassword = etItemActivityInformationEditChangePasswordConfirm.getText().toString().trim();
                    }
                });

                builder.setView(viewDialog);//添加自定义View
                builder.create();
                dialog = builder.show();
                break;
        }
    }
}
