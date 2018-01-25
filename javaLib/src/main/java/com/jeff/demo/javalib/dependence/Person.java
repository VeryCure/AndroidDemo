package com.jeff.demo.javalib.dependence;

/**
 * Created by ttxs on 2018/1/18.
 */

public class Person
{
    private Driveable driveable;
    public Person(Driveable driveable)
    {
        this.driveable = driveable;
    }

    public void shumen(){
        driveable.drive();
    }
}
