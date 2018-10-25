package com.jeff.demo.androiddemo.net;

import java.io.IOException;
import okhttp3.Request;
import retrofit2.Response;

/**
 * 创建时间：2018/10/08 18:04 <br>
 * 作者：JeffLee <br>
 * 描述：自定义网络执行类
 */
public interface HttpCall<T> extends Cloneable {
  /**
   * 同步执行网络请求，不要在主线程使用
   * @return
   * @throws IOException
   */
  Response<T> execute() throws IOException;

  /**
   * 异步执行网络请求
   * @param callBack
   */
  void enqueue(HttpCallBack<T> callBack);

  /**
   * 取消网络请求
   */
  void cancel();

  /**
   * 判断网络请求是否已经执行
   * @return
   */
  boolean isExecuted();

  /**
   * 判断网络请求是否被取消
   * @return
   */
  boolean isCanceled();

  /**
   * 需要注意的是retrofit只能执行一次,,如果需要重复执行,可使用这个clone方法,或者重新创建接口实例
   */
  HttpCall<T> clone();

  /**
   * 获取请求参数信息
   * @return
   */
  Request request();
}
