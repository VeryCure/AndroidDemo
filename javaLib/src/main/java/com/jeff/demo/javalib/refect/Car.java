package com.jeff.demo.javalib.refect;

import java.awt.Color;

/**
 * Created by ttxs on 2018/1/17.
 */

public class Car
{
    private String mBand;
    private Color mColor;

    public enum Color
    {
        RED,
        WHITE,
        BLACK,
        BLUE,
        YELLOR
    }

    public Car()
    {
        super();
        // TODO Auto-generated constructor stub
    }


    public Car(String mBand)
    {
        this.mBand = mBand;
    }


    public void drive()
    {
        System.out.println("di di di,开车了！");
    }

    @Override
    public String toString()
    {
        return "Car [mBand=" + mBand + ", mColor=" + mColor + "]";
    }

}
