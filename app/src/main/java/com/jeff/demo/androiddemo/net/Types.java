package com.jeff.demo.androiddemo.net;

import com.jeff.demo.androiddemo.utils.BaseUtil;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/**
 * 创建时间：2018/10/08 17:33 <br>
 * 作者：JeffLee <br>
 * 描述：
 */
public class Types {
  public static Class<?> getRawType(Type type){
    BaseUtil.checkNotNull(type,"type == null");

    if (type instanceof Class<?>){
      /*type是一般的class，如Foo*/
      return (Class<?>) type;
    }

    if (type instanceof ParameterizedType){
      /* type 是参数化泛型 ，如Foo<A>*/
      ParameterizedType parameterizedType = (ParameterizedType) type;
      Type rawType = parameterizedType.getRawType();
      if (!(rawType instanceof Class)) throw new IllegalArgumentException();
      return (Class<?>) rawType;
    }
    if (type instanceof GenericArrayType){
      /* type 属于泛型数组 ,如Foo<String>[],T[]*/
      Type componentType = ((GenericArrayType) type).getGenericComponentType();
      return Array.newInstance(getRawType(componentType),0).getClass();
    }
    /* type主语泛型变量，如class Foo<T extends Number>，List<? extends T>,T[]中的"T",
    需要注意的是只有"Class","Method","Constructor","Executable"可以定义变量泛型*/
    if (type instanceof TypeVariable){
      return Object.class;
    }

    if (type instanceof WildcardType){
      /*Type属于通配符泛型,如"<?>"或者"<? extend A & B>"中的"?"*/
      return getRawType(((WildcardType)type).getUpperBounds()[0]);
    }
    throw new IllegalArgumentException("Expected a Class, ParameterizedType, or "
        + "GenericArrayType, but <"
        + type
        + "> is of type "
        + type.getClass().getName());
  }
}
