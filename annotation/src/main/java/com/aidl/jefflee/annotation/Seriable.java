package com.aidl.jefflee.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建时间：2018/07/30 14:53 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
@Documented()
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.FIELD,ElementType.TYPE})
public @interface Seriable {
}
