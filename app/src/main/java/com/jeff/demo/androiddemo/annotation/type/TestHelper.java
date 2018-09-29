package com.jeff.demo.androiddemo.annotation.type;

import com.jeff.demo.androiddemo.bean.ParameterizedTypeBean;
import com.jeff.demo.androiddemo.bean.TypeVariableBean;
import com.jeff.demo.androiddemo.utils.LogUtils;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 创建时间：2018/07/27 15:11 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class TestHelper {
  public static void testParameterizedType(){
    Field field = null;
    try {
      Field[] fields = ParameterizedTypeBean.class.getDeclaredFields();
      for (Field f : fields){
        field = f;
        LogUtils.e(f.getName()
            + " getGenericType() instanceof ParameterizedType "
            + (f.getGenericType() instanceof ParameterizedType)+"\n");
      }
      getParameterizedType("map");
      getParameterizedType("entry");
    } catch (SecurityException e){
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
  }

  private static void getParameterizedType(String feildName)throws NoSuchFieldException{
    Field f;
    f = ParameterizedTypeBean.class.getDeclaredField(feildName);
    f.setAccessible(true);
    LogUtils.e(f.getGenericType()+"\n");
    boolean b = f.getGenericType() instanceof ParameterizedType;
    LogUtils.e(b+"\n");
    if (b){
      ParameterizedType pType = (ParameterizedType) f.getGenericType();
      LogUtils.e(pType + "\n");
      for (Type type : pType.getActualTypeArguments()){
        LogUtils.e(type + "\n");
      }
      LogUtils.e(pType.getOwnerType()+"\n");
    }
  }

  public static void testTypeVariable(){
    TypeVariableBean<InputStream, String> variableBean =
        new TypeVariableBean<>();
    try {
      Field fk = TypeVariableBean.class.getDeclaredField("Key");
      Type type = fk.getGenericType();
      LogUtils.e(type + "\n"+fk.getName());
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
  }

  /**
   * 打印构造函数名
   * @param className
   */
  public static void printConstructor(String className){
    try {
      Class<?> clazz = Class.forName(className);
      Constructor<?>[] constructors = clazz.getConstructors();
      LogUtils.e("public Constructor\n");
      printConstructor(constructors);
      Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
      LogUtils.e("private Constructor\n");
      printConstructor(declaredConstructors);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void printConstructor(Constructor... constructors){
    for (Constructor constructor : constructors){
      LogUtils.e(constructor+"\n");
    }
  }

  public static Constructor getConstructor(String className,Class<?>... clzs){
    try {
      Class<?> aClass = Class.forName(className);
      Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(clzs);
      printConstructor(declaredConstructor);
      //如果构造函数不是public需要调用
      declaredConstructor.setAccessible(true);
      return declaredConstructor;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static void printField(String className){
    try {
      Class<?> aClass = Class.forName(className);
      Field[] fields = aClass.getFields();
      LogUtils.e(fields + "\n");
      Field[] declaredFields = aClass.getDeclaredFields();
      LogUtils.e(declaredFields + "\n");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
