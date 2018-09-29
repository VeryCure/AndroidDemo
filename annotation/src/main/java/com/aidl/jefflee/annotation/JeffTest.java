package com.aidl.jefflee.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建时间：2018/07/26 21:58 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface JeffTest {
}
