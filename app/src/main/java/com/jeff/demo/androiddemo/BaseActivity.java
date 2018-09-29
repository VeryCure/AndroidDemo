package com.jeff.demo.androiddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.fatangare.logcatviewer.utils.LogcatViewer;

/**
 * 创建时间：2018/07/26 14:52 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public abstract class BaseActivity extends AppCompatActivity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    ButterKnife.bind(this);
    initData();
    LogcatViewer.showLogcatLoggerView(this);
  }

  protected abstract void initData();

  protected abstract int getLayoutId();

  @Override
  protected void onDestroy() {
    super.onDestroy();
    LogcatViewer.closeLogcatLoggerView(this);
  }
}
