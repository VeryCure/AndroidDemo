package com.jeff.demo.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jeff.demo.androiddemo.material.AppBarLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener
{
    @BindView(R.id.main_recycler)
    RecyclerView mMainRecycler;

    private String[] names = new String[]{"AppBarLayout"};
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
        }
    }
}
