package com.jeff.demo.androiddemo.bean;

import java.io.Closeable;
import java.io.InputStream;
import java.util.List;

/**
 * 创建时间：2018/07/27 15:29 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class TypeVariableBean<K extends InputStream & Closeable,V> {
  //K的上边界是inputStream
  K Key;
  //没有指定的话，V的上边界属于Object
  V value;
  //不属于 TypeVariable
  V[] values;
  String str;
  List<V> kList;
}
