package com.jeff.demo.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jeff.demo.androiddemo.chart.DataChartActivity;
import com.jeff.demo.androiddemo.material.AppBarLayoutActivity;
import com.jeff.demo.androiddemo.material.BehaviorActivity;
import com.jeff.demo.androiddemo.material.CollapsingToolBarActivity;
import com.jeff.demo.androiddemo.shadow.ViewShadowActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener
{
    @BindView(R.id.main_recycler)
    RecyclerView mMainRecycler;

    private String[] names = new String[]{"AppBarLayout","CollapsingToolBar",
            "Behavior","ViewShadow","DataChart","RxAndroid"};
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
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
        switch (position){
            case 0:
                //AppBarLayout;
                startActivity(new Intent(this,AppBarLayoutActivity.class));
                break;
            case 1:
                startActivity(new Intent(this,CollapsingToolBarActivity.class));
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
        }
    }
}
