package com.jeff.demo.androiddemo.shadow;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jeff.demo.androiddemo.R;

/**
 * Created by ttxs on 2018/1/25.
 */

public class ViewShadowActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_shadow_layout);
    }
}
