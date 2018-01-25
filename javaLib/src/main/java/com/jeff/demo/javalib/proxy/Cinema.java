package com.jeff.demo.javalib.proxy;

/**
 * Created by ttxs on 2018/1/17.
 */
//静态代理类
public class Cinema implements Movie
{
    private RealMovie realMovie;

    public Cinema(RealMovie realMovie)
    {
        this.realMovie = realMovie;
    }

    @Override
    public void play()
    {
        guanggao(true);
        realMovie.play();
        guanggao(false);
    }

    public void guanggao(boolean isStart){
        if ( isStart ) {
            System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        } else {
            System.out.println("电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
        }
    }
}
