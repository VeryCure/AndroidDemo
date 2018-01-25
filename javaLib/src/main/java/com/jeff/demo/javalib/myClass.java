package com.jeff.demo.javalib;

import com.jeff.demo.javalib.annotation.TestBug;
import com.jeff.demo.javalib.dependence.Bike;
import com.jeff.demo.javalib.dependence.Person;
import com.jeff.demo.javalib.proxy.Cinema;
import com.jeff.demo.javalib.proxy.CityCinema;
import com.jeff.demo.javalib.proxy.Movie;
import com.jeff.demo.javalib.proxy.RealMovie;
import com.jeff.demo.javalib.refect.Car;
import com.jeff.demo.javalib.refect.Outer;
import com.jeff.demo.javalib.refect.Son;
import com.jeff.demo.javalib.refect.TestModifier;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;


public class myClass
{
    public static void main(String[] args)
    {
        System.out.println("hellow world!");
//        testAnnotation();
//        staticProxy();
//        dynamicProxy();
//        className();
//        modifier();
        /*Class sonClazz = Son.class;
        Field[] declaredFields = sonClazz.getDeclaredFields();
        Field[] fields = sonClazz.getFields();*/
        Person person = new Person(new Bike());
        person.shumen();
    }

    private static void modifier()
    {
        Class modifierClass = TestModifier.class;
        System.out.println("modifireName:"+modifierClass.getModifiers()+" : " +
                ""+ Modifier.toString(modifierClass.getModifiers()));
    }

    private static void className()
    {
        Car car = new Car();
        Class carClazz = car.getClass();
        System.out.println("name:"+carClazz.getName()+":"+carClazz
                .getSimpleName()+":"+carClazz.getCanonicalName());
        Class innerClazz = Outer.Inner.class;
        System.out.println("innerSimpleName:"+innerClazz.getSimpleName()+" " +
                "innerName:"+innerClazz.getName());
        Class carClazz2 = Car.class;
        Class<Integer> integerClazz = int.class;
        try
        {
            Class clz = Class.forName("com.jeff.demo.javalib.refect.Car");
        } catch (ClassNotFoundException e)
        {
            System.out.println(e.getCause().getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 动态代理
     */
    private static void dynamicProxy()
    {
        RealMovie realMovie = new RealMovie();
        InvocationHandler cityCinema = new CityCinema(realMovie);
        Movie dynamicProxy = (Movie) Proxy.newProxyInstance(RealMovie.class
                        .getClassLoader(), RealMovie.class.getInterfaces(), cityCinema);
        dynamicProxy.play();
    }

    /**
     * 静态代理
     */
    private static void staticProxy()
    {
        RealMovie realMovie = new RealMovie();
        Cinema cinema = new Cinema(realMovie);
        cinema.play();
    }

    /**
     * 注解
     */
    private static void testAnnotation()
    {
        NoBug noBug = new NoBug();
        Class clazz = noBug.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        StringBuilder builder = new StringBuilder();
        //异常次数
        int errorNum = 0;
        for (Method method : methods)
        {
            if (method.isAnnotationPresent(TestBug.class))
            {
                try
                {
                    method.setAccessible(true);
                    method.invoke(noBug, null);
                } catch (Exception e)
                {
                    errorNum++;
                    builder.append(method.getName());
                    builder.append(" ");
                    builder.append("has error");
                    builder.append("\n\r caused by");
                    //记录测试过程中发生异常的名称
                    builder.append(e.getCause().getClass().getSimpleName());
                    builder.append("\n\r");
                    builder.append(e.getCause().getMessage());
                    builder.append("\n\r");
                }
            }
        }

        builder.append(clazz.getSimpleName());
        builder.append(" has ");
        builder.append(errorNum);
        builder.append(" error.");

        System.out.print(builder.toString());
    }
}
