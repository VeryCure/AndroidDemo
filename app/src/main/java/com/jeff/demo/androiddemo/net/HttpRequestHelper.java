package com.jeff.demo.androiddemo.net;

import com.jeff.demo.androiddemo.Config;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建时间：2018/09/30 10:55 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class HttpRequestHelper {
  private static OkHttpClient.Builder mHttpClientBuilder = new OkHttpClient.Builder();
  private static final Retrofit.Builder mRetrofitBuilder ;
  private static Retrofit mRetrofit;

  static {
    //设置超时时间
    mHttpClientBuilder.connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS);
    if (Config.mIsDebug){
      HttpRequestHelper.mHttpClientBuilder.addNetworkInterceptor(new HttpLoggingIntercpetor());
    }

    HttpRequestHelper.mHttpClientBuilder.addInterceptor(new HttpHeaderInterceptor());

    mRetrofitBuilder = new Retrofit.Builder().addCallAdapterFactory(HttpCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(mHttpClientBuilder.build());
  }

  //public static <S> S createService(Class<S> serviceClass){
    //if (mRetrofit == null || !mRetrofit.baseUrl().equals())
  //}
}
