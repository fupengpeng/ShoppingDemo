package com.demo.logindemo.activity.personcenter.impl.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.logindemo.R;

/**
 * 积分向清界面的获得Fragment
 */
public class IntegralParticularsGainFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_integral_particulars_gain, container, false);
    }

}
