package com.jeff.demo.androiddemo.net;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 创建时间：2018/10/08 16:33 <br>
 * 作者：JeffLee <br>
 * 描述：拦截请求，添加通用的header信息
 */
public class HttpHeaderInterceptor implements Interceptor {
  @Override
  public Response intercept(Chain chain) throws IOException {
    Request.Builder builder =
        chain.request().newBuilder().addHeader("User-Agent", "Jeff_Retrofit_Header_Interceptor");
    return chain.proceed(builder.build());
  }
}
