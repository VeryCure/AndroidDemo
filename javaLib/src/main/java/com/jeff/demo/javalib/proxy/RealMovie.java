package com.jeff.demo.javalib.proxy;

/**
 * Created by ttxs on 2018/1/17.
 */

public class RealMovie implements Movie
{
    @Override
    public void play()
    {
        System.out.println("您正在观看电影《速度与激情8》");
    }
}
