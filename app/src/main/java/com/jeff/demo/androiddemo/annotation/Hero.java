package com.jeff.demo.androiddemo.annotation;

/**
 * Created by ttxs on 2018/1/16.
 */

public class Hero
{
    public Hero()
    {

    }

    @Deprecated
    public void say(){
        System.out.print("Noting has to say!");
    }

    public void speak(){
        System.out.print("I have a dream!");
    }
}
