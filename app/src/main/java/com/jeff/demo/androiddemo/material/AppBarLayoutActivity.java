package com.jeff.demo.androiddemo.material;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jeff.demo.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ttxs on 2018/1/9.
 */

public class AppBarLayoutActivity extends AppCompatActivity
{
    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_layout);
        ButterKnife.bind(this);
        setSupportActionBar(mToolBar);
    }
}
