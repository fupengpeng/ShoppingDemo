package com.demo.logindemo.activity.personcenter.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class InformationEditActivity extends BaseActivity implements IInformationEditView,View.OnClickListener{


    private ImageView imageView;
    private EditText editTextyuanmima,editTextxinmima,editTextzaicishurumima;
    private Button btn_affirm;

    private String yuanmima,xinmima,querenmima;

    private AlertDialog dialog;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_edit);

        LinearLayout linearLayoutData = (LinearLayout) findViewById(R.id.ll_activity_information_edit_data);
        linearLayoutData.setOnClickListener(this);
        LinearLayout linearLayoutAddress = (LinearLayout) findViewById(R.id.ll_activity_information_edit_address);
        linearLayoutAddress.setOnClickListener(this);

        LinearLayout linearLayoutChangePassword = (LinearLayout) findViewById(R.id.ll_activity_information_edit_password);
        linearLayoutChangePassword.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_activity_information_edit_data:
                intent = new Intent(InformationEditActivity.this,DataActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_activity_information_edit_address:
                intent = new Intent(InformationEditActivity.this,AddressEditActivity.class);
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
                View view = inflater.inflate(R.layout.item_activity_information_edit_change_password, null);

                imageView = (ImageView) view.findViewById(R.id.iv_item_activity_information_edit_change_password_close);
                btn_affirm = (Button) view.findViewById(R.id.btn_item_activity_information_edit_change_password_confirm);
                editTextyuanmima = (EditText) view.findViewById(R.id.et_item_activity_information_edit_change_password_old);
                editTextxinmima = (EditText) view.findViewById(R.id.et_item_activity_information_edit_change_password_new);
                editTextzaicishurumima = (EditText) view.findViewById(R.id.et_item_activity_information_edit_change_password_confirm);

                imageView.setOnClickListener(this);
                btn_affirm.setOnClickListener(this);
                editTextyuanmima.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        yuanmima = editTextyuanmima.getText().toString().trim();
                    }
                });
                editTextxinmima.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        xinmima = editTextxinmima.getText().toString().trim();
                    }
                });
                editTextzaicishurumima.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        querenmima = editTextzaicishurumima.getText().toString().trim();
                    }
                });

                builder.setView(view);//添加自定义View
                builder.create();
                dialog = builder.show();
                break;
            case R.id.iv_item_activity_information_edit_change_password_close:
                dialog.dismiss();
                break;
            case R.id.btn_item_activity_information_edit_change_password_confirm:
                if ((editTextxinmima.getText().toString().trim())
                        .equals(editTextzaicishurumima.getText().toString().trim())
                        &&editTextyuanmima.getText().toString().trim()!=null) {
                    // 密码
                    String password = editTextxinmima.getText().toString().trim();
                    // 验证原密码


                    // 确认提交
                    // TODO: 2017/6/6 验证原密码是否正确，正确，修改密码，错误，提示原密码输入错误

                } else {
                    ToastUtils.showLong(InformationEditActivity.this, "两次输入不同，请重新输入");
                    editTextxinmima.setText("");
                    editTextzaicishurumima.setText("");
                    editTextyuanmima.setText("");
                }
                break;
        }
    }
}
