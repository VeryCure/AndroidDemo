package com.jeff.demo.androiddemo.net;

import com.jeff.demo.androiddemo.utils.BaseUtil;
import java.io.IOException;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 创建时间：2018/10/08 18:51 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class HttpCallAdapter<T> implements HttpCall {

  private static int CODE_204 = 204;
  private static int CODE_205 = 205;
  private static int CODE_400 = 400;
  private static int CODE_401 = 401;
  private static int CODE_500 = 500;
  private static int CODE_600 = 600;

  private Call<T> mDelegate;
  private HttpCallAdapterFactory.MainThreadExecutor mMainThreadExecutor;
  private final int mMaxRetryCount;
  private int mCurrentRetryCount = 0;
  private HttpCallAdapterFactory.Callback mCallback;

  public HttpCallAdapter(Call<T> delegate,
      HttpCallAdapterFactory.MainThreadExecutor mainThreadExecutor, int maxRetryCount,
      HttpCallAdapterFactory.Callback callback) {
    this.mDelegate = delegate;
    this.mMainThreadExecutor = mainThreadExecutor;
    this.mMaxRetryCount = maxRetryCount;
    this.mCallback = callback;
  }

  @Override
  public Response execute() throws IOException {
    return mDelegate.execute();
  }

  @Override
  public void enqueue(final HttpCallBack callBack) {
    BaseUtil.checkNotNull(callBack,"callback == null");
    mDelegate.enqueue(new Callback<T>() {
      @Override
      public void onResponse(final Call<T> call, final Response<T> response) {
        mMainThreadExecutor.execute(new Runnable() {
          @Override
          public void run() {
            if (mCallback != null) mCallback.onResponse(response);
            int code = response.code();
            if (response.isSuccessful()){
              if (code == CODE_204 || code == CODE_205 || response.body() == null){
                callBack.noContent(response,HttpCallAdapter.this);
              }else {
                callBack.success(response.body(),HttpCallAdapter.this);
              }
            }else if (code == CODE_401){
              callBack.unauthenticated(response,HttpCallAdapter.this);
            }else if (code >= CODE_400 && code < CODE_500){
              callBack.clientError(response,HttpCallAdapter.this);
            }else if (code >= CODE_500 && code < CODE_600){
              callBack.serverError(response,HttpCallAdapter.this);
            }else {
              callBack.unexpectedError(new RuntimeException("Unexpected reponse" + response),HttpCallAdapter.this);
            }
          }
        });
      }

      @Override
      public void onFailure(Call<T> call, final Throwable t) {
        if (mCurrentRetryCount++ < mMaxRetryCount){
          call.clone().enqueue(this);
        }else {
          mMainThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
              if (t instanceof IOException){
                callBack.networkError((IOException) t,HttpCallAdapter.this);
              }else {
                callBack.unexpectedError(t,HttpCallAdapter.this);
              }
            }
          });
        }
      }
    });
  }

  @Override
  public void cancel() {
    mDelegate.cancel();
  }

  @Override
  public boolean isExecuted() {
    return mDelegate.isExecuted();
  }

  @Override
  public boolean isCanceled() {
    return mDelegate.isCanceled();
  }

  @Override
  public HttpCall<T> clone() {
    return new HttpCallAdapter<>(mDelegate.clone(),mMainThreadExecutor,mMaxRetryCount,mCallback);
  }

  @Override
  public Request request() {
    return mDelegate.request();
  }
}
