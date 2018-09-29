package com.jeff.demo.androiddemo.tablayout;

import com.jeff.demo.androiddemo.BaseActivity;
import com.jeff.demo.androiddemo.R;
import com.jeff.demo.androiddemo.utils.LogUtils;

/**
 * 创建时间：2018/08/28 22:08 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class CustomTabLayoutActivity extends BaseActivity{


  @Override
  protected void initData() {
    LogUtils.e(CustomTabLayoutActivity.class.getName());
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_custom_tablayout;
  }

}
