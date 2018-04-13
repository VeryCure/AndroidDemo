package com.jeff.demo.androiddemo.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jeff.demo.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ttxs on 2018/4/13.
 */

public class RxAndroidActivity extends AppCompatActivity
{
    @BindView(R.id.rx_android_tv)
    TextView mRxAndroidTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxandroid_layout);
        ButterKnife.bind(this);
    }
}
