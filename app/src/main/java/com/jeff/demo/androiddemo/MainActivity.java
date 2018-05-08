package com.jeff.demo.androiddemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;

import com.jeff.demo.androiddemo.chart.DataChartActivity;
import com.jeff.demo.androiddemo.material.AppBarLayoutActivity;
import com.jeff.demo.androiddemo.material.BehaviorActivity;
import com.jeff.demo.androiddemo.material.CollapsingToolBarActivity;
import com.jeff.demo.androiddemo.shadow.ViewShadowActivity;
import com.jeff.demo.androiddemo.shield.HomeReceiver;
import com.jeff.demo.androiddemo.utils.BaseUtils;
import com.jeff.demo.androiddemo.utils.LogUtils;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements MainAdapter
        .OnItemClickListener
{
    @BindView(R.id.main_recycler)
    RecyclerView mMainRecycler;

    private String[] names = new String[]{"AppBarLayout", "CollapsingToolBar",
            "Behavior", "ViewShadow", "DataChart", "RxAndroid","tansform"};
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullScreen();
        ButterKnife.bind(this);
//        HomeReceiver homeReceiver = new HomeReceiver();
//        IntentFilter intentFilter = new IntentFilter(Intent
//                .ACTION_CLOSE_SYSTEM_DIALOGS);
//        registerReceiver(homeReceiver, intentFilter);
        initView();
    }

    private void fullScreen()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN | View
                    .SYSTEM_UI_FLAG_HIDE_NAVIGATION | View
                    .SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void initView()
    {
        mMainRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMainAdapter = new MainAdapter(this, names);
        mMainAdapter.setOnItemClickListener(this);
        mMainRecycler.setAdapter(mMainAdapter);
    }

    @Override
    public void itemClick(int position)
    {
        switch (position)
        {
            case 0:
                //AppBarLayout;
                startActivity(new Intent(this, AppBarLayoutActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, CollapsingToolBarActivity
                        .class));
                break;
            case 2:
                startActivity(new Intent(this, BehaviorActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, ViewShadowActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, DataChartActivity.class));
                break;
            case 5:
                break;
            case 6:
                String s = "7D6B9C6D";
                String code = transformCode(s);
                String number = BaseUtils.toD(code,16);
                LogUtils.e(code+"  :  "+number);
                break;
        }
    }
    @NonNull
    private String transformCode(String pSnrM1)
    {
        String code = "";
        for (int i = 0; i < pSnrM1.length()/2; i++)
        {
            code = code + pSnrM1.substring(pSnrM1.length()-2*(i+1),pSnrM1.length
                    ()-2*i);
        }
        code = BaseUtils.toD(code, 16);
        return code;
    }
    @SuppressLint("WrongConstant")
    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19)
        {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            return true;
        } else
        {
            return super.onKeyDown(keyCode, event);
        }
    }
}
