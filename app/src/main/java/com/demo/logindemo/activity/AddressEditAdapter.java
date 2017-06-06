package com.demo.logindemo.activity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.demo.logindemo.R;
import com.demo.logindemo.entity.ShippingAddress;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fupengpeng on 2017/6/5 0005.
 */

public class AddressEditAdapter extends BaseAdapter {
    private Context context;
    private List<ShippingAddress> shippingAddressList;

    public AddressEditAdapter(Context context, List<ShippingAddress> shippingAddressList) {
        this.context = context;
        this.shippingAddressList = shippingAddressList;
    }


    @Override
    public int getCount() {
        return shippingAddressList.size() == 0 ? 0 : shippingAddressList.size();
    }

    @Override
    public Object getItem(int position) {
        return shippingAddressList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // 最省内存的写法 因为不用重复的findViewById
        ViewHolder viewHolder = null;
        if (viewHolder == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_place_of_receipt_manage, null);
            viewHolder = new ViewHolder(convertView);
            viewHolder.itemActivityAddressEditUsername = (TextView) convertView.findViewById(R.id.item_activity_address_edit_username);
            viewHolder.itemActivityAddressEditPhoneNumber = (TextView) convertView.findViewById(R.id.item_activity_address_edit_phone_number);
            viewHolder.itemActivityAddressEditShippingAddress = (TextView) convertView.findViewById(R.id.item_activity_address_edit_shipping_address);
            viewHolder.itemActivityAddressEditIsDefault = (CheckBox) convertView.findViewById(R.id.item_activity_address_edit_is_default);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.itemActivityAddressEditUsername.setText(shippingAddressList.get(position).getUsername());
        viewHolder.itemActivityAddressEditPhoneNumber.setText(shippingAddressList.get(position).getPhoneNumber());
        viewHolder.itemActivityAddressEditShippingAddress.setText(shippingAddressList.get(position).getShippingAddress());
        viewHolder.itemActivityAddressEditUsername.setText(shippingAddressList.get(position).getUsername());
        viewHolder.itemActivityAddressEditIsDefault.setChecked(shippingAddressList.get(position).isIsDefault());

        // 设置位置，获取点击的条目按钮
        viewHolder.itemActivityAddressEditEdit.setTag(position);
        viewHolder.itemActivityAddressEditDelete.setTag(position);
        viewHolder.itemActivityAddressEditIsDefault.setTag(position);

        viewHolder.itemActivityAddressEditEdit.setOnClickListener((View.OnClickListener) context);
        viewHolder.itemActivityAddressEditDelete.setOnClickListener((View.OnClickListener) context);
        viewHolder.itemActivityAddressEditIsDefault.setOnClickListener((View.OnClickListener) context);
        return convertView;
    }

    public static final String TAG =  "AddressEditAdapter";

    static class ViewHolder {
        @BindView(R.id.item_activity_address_edit_username)
        TextView itemActivityAddressEditUsername;
        @BindView(R.id.item_activity_address_edit_phone_number)
        TextView itemActivityAddressEditPhoneNumber;
        @BindView(R.id.item_activity_address_edit_shipping_address)
        TextView itemActivityAddressEditShippingAddress;
        @BindView(R.id.item_activity_address_edit_is_default)
        CheckBox itemActivityAddressEditIsDefault;
        @BindView(R.id.item_activity_address_edit_edit)
        TextView itemActivityAddressEditEdit;
        @BindView(R.id.item_activity_address_edit_delete)
        TextView itemActivityAddressEditDelete;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
