package com.jeff.demo.javalib.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by ttxs on 2018/1/17.
 */

public class CityCinema implements InvocationHandler
{
    private Object area;

    public CityCinema(Object area)
    {
        this.area = area;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws
            Throwable
    {
        System.out.println("目前所属区域是 ："+this.getClass().getSimpleName());
        method.invoke(area,args);
        System.out.println("播放结束");
        return null;
    }
}
