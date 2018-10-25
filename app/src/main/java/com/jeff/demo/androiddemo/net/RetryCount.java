package com.jeff.demo.androiddemo.net;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建时间：2018/10/08 18:23 <br>
 * 作者：JeffLee <br>
 * 描述：用于标记该网络请求接口是否允许重试,如果被标记,则默认重试一次
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface RetryCount {
  int count() default 1;
}
