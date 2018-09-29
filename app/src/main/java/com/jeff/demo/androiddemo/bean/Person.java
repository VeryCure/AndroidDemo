package com.jeff.demo.androiddemo.bean;

import com.jeff.demo.androiddemo.utils.LogUtils;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * 创建时间：2018/07/27 15:03 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class Person {
  public String name;
  public int age;
  private String city;
  private String phone;
  private String country;
  private String like;

  public Person(){
    LogUtils.e("无参数构造方法 ");
  }

  private Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Person(String city, String country) {
    this.city = city;
    this.country = country;
  }

  protected Person(String like,String country,String city){
    this.like = like;
    this.country = country;
    this.city = city;
  }

  private String getPhone(String number){
    String phone = "1323"+"-"+ number;
    return phone;
  }

  private void setCountry(String country) {
    this.country=country;
  }

  public void getGenericHelper(HashMap<String, Integer> hashMap) {
  }
  public Class getGenericType() {
    try {
      HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
      Method method = getClass().getDeclaredMethod("getGenericHelper",HashMap.class);
      Type[] genericParameterTypes = method.getGenericParameterTypes();
      if (null == genericParameterTypes || genericParameterTypes.length < 1) {
        return null;
      }

      ParameterizedType parameterizedType=(ParameterizedType)genericParameterTypes[0];
      Type rawType = parameterizedType.getRawType();
      LogUtils.e("----> rawType=" + rawType);
      Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
      if (actualTypeArguments==genericParameterTypes || actualTypeArguments.length<1) {
        return null;
      }

      for (int i = 0; i < actualTypeArguments.length; i++) {
        Type type = actualTypeArguments[i];
        LogUtils.e("----> type=" + type);
      }
    } catch (Exception e) {

    }
    return null;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", city='" + city + '\'' +
        ", phone='" + phone + '\'' +
        ", country='" + country + '\'' +
        ", like='" + like + '\'' +
        '}';
  }
}
