package com.jeff.demo.androiddemo.net;

import java.io.IOException;
import retrofit2.Response;

/**
 * 创建时间：2018/10/08 18:12 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public interface HttpCallBack<T> {
  /** Called for [200, 300) responses. But not include 204 or 205 */
  void success(T entity, HttpCall<T> httpCall);

  /** Called for 204 and 205 */
  void noContent(Response<T> response, HttpCall<T> httpCall);

  /** Called for 401 responses. */
  void unauthenticated(Response<T> response, HttpCall<T> httpCall);

  /** Called for [400, 500) responses, except 401. */
  void clientError(Response<T> response, HttpCall<T> httpCall);

  /** Called for [500, 600) response. */
  void serverError(Response<T> response, HttpCall<T> httpCall);

  /** Called for network errors while making the call. */
  void networkError(IOException e, HttpCall<T> httpCall);

  /** Called for unexpected errors while making the call. */
  void unexpectedError(Throwable t, HttpCall<T> httpCall);
}
