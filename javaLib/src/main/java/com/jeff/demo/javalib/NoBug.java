package com.jeff.demo.javalib;

import com.jeff.demo.javalib.annotation.TestBug;

/**
 * Created by ttxs on 2018/1/16.
 */

public class NoBug
{
    @TestBug
    public void suanShu(){
        System.out.println("1234567890");
    }
    @TestBug
    public void jiafa(){
        System.out.println("1+1="+1+1);
    }
    @TestBug
    public void jiefa(){
        System.out.println("1-1="+(1-1));
    }
    @TestBug
    public void chengfa(){
        System.out.println("3 x 5="+ 3*5);
    }

    @TestBug
    public void chufa(){
        System.out.println("6 / 0="+ 6 /0);
    }

    public void ziwojieshao(){
        System.out.println("我写的程序没有 bug!");
    }
}
