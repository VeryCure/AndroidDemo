package com.jeff.demo.androiddemo.utils;

/**
 * 创建时间：2018/10/08 17:14 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class BaseUtil {
  /**
   * 判null
   * @param object
   * @param message
   * @param <T>
   * @return
   */
  public static <T> T checkNotNull(T object,String message){
    if (object == null) throw new NullPointerException(message);
    return object;
  }
}
