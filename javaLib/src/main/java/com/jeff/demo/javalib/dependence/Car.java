package com.jeff.demo.javalib.dependence;

/**
 * Created by ttxs on 2018/1/18.
 */

public class Car implements Driveable
{
    @Override
    public void drive()
    {
        System.out.println("开车出去");
    }
}
