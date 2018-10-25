package com.jeff.demo.androiddemo.net;

import com.jeff.demo.androiddemo.utils.LogUtils;
import java.io.IOException;
import java.util.logging.Logger;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 创建时间：2018/09/30 15:17 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class HttpLoggingIntercpetor implements Interceptor {
  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    long t1 = System.nanoTime();
    LogUtils.e(String.format("Sending request %s on %s%n%s",request.url(),chain.connection(),request.headers()));
    Response response = chain.proceed(request);
    long t2 = System.nanoTime();
    LogUtils.e(String.format("Received response for %s in %.1fms%n%s",response.request().url(),(t2-t1)/1e6d,response.headers()));
    return response;
  }
}
