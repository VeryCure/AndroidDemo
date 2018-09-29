package com.jeff.demo.androiddemo.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 创建时间：2018/07/27 15:03 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class ParameterizedTypeBean {
  //小面的field的Type属于ParameterizedType
  Map<String,Person> map;
  Set<String> set;
  Class<?> clz;
  Holder<String> holder;
  List<String> list;
  //Map<String,String> map这个ParameteriedTypede 的getOwnerType()为null，
  // 而 Map.Entry<String, String> entry 的 getOwnerType() 为 Map 所属于的 Type。
  Map.Entry<String,String> entry;
  // 下面的 field 的 Type 不属于ParameterizedType
  String str;
  Integer i;
  Set set2;
  List aList;

  static class Holder<V>{

  }
}
