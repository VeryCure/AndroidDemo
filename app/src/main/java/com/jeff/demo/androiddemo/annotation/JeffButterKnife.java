package com.jeff.demo.androiddemo.annotation;

import android.app.Activity;

/**
 * 创建时间：2018/07/26 17:05 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class JeffButterKnife {
  private JeffButterKnife(){}
  private static volatile JeffButterKnife instance=null;
  public static JeffButterKnife getInstance(){
    if (instance == null){
      synchronized (JeffButterKnife.class){
        if (instance == null){
          instance = new JeffButterKnife();
        }
      }
    }
    return instance;
  }

  public void regist(Activity activity){

  }
}
