package com.jeff.demo.androiddemo.utils;

import android.util.Log;

/**
 * Created by ttxs on 2017/1/23.
 */

public class LogUtils
{
    private static boolean isDebug = true;
    private static char logFilter = 'v';
    private static final String TAG = "jeff";

    /**
     * Verbose日志
     *
     * @param msg 消息
     */
    public static void v(String msg)
    {
        if (isDebug){
            log(TAG, msg, null, 'v');
        }
    }

    /**
     * Verbose日志
     *
     * @param tag 标签
     * @param msg 消息
     */
    public static void v(String tag, String msg)
    {
        if (isDebug){
            log(tag, msg, null, 'v');
        }
    }

    /**
     * Verbose日志
     *
     * @param tag 标签
     * @param msg 消息
     * @param tr  异常
     */
    public static void v(String tag, String msg, Throwable tr)
    {
        if (isDebug){
            log(tag, msg, tr, 'v');
        }
    }

    /**
     * Debug日志
     *
     * @param msg 消息
     */
    public static void d(String msg)
    {
        if (isDebug){
            log(TAG, msg, null, 'd');
        }
    }

    /**
     * Debug日志
     *
     * @param tag 标签
     * @param msg 消息
     */
    public static void d(String tag, String msg)
    {
        if (isDebug){
            log(tag, msg, null, 'd');
        }
    }

    /**
     * Debug日志
     *
     * @param tag 标签
     * @param msg 消息
     * @param tr  异常
     */
    public static void d(String tag, String msg, Throwable tr)
    {
        if (isDebug){
            log(tag, msg, tr, 'd');
        }
    }

    /**
     * Info日志
     *
     * @param msg 消息
     */
    public static void i(String msg)
    {
        if (isDebug){
            log(TAG, msg, null, 'i');
        }
    }

    /**
     * Info日志
     *
     * @param tag 标签
     * @param msg 消息
     */
    public static void i(String tag, String msg)
    {
        if (isDebug){
            log(tag, msg, null, 'i');
        }
    }

    /**
     * Info日志
     *
     * @param tag 标签
     * @param msg 消息
     * @param tr  异常
     */
    public static void i(String tag, String msg, Throwable tr)
    {
        if (isDebug){
            log(tag, msg, tr, 'i');
        }
    }

    /**
     * Warn日志
     *
     * @param msg 消息
     */
    public static void w(String msg)
    {
        if (isDebug){
            log(TAG, msg, null, 'w');
        }
    }

    /**
     * Warn日志
     *
     * @param tag 标签
     * @param msg 消息
     */
    public static void w(String tag, String msg)
    {
        if (isDebug){
            log(tag, msg, null, 'w');
        }
    }

    /**
     * Warn日志
     *
     * @param tag 标签
     * @param msg 消息
     * @param tr  异常
     */
    public static void w(String tag, String msg, Throwable tr)
    {
        if (isDebug){
            log(tag, msg, tr, 'w');
        }
    }

    /**
     * Error日志
     *
     * @param msg 消息
     */
    public static void e(String msg)
    {
        if (isDebug){
            log(TAG, msg, null, 'e');
        }
    }

    /**
     * Error日志
     *
     * @param tag 标签
     * @param msg 消息
     */
    public static void e(String tag, String msg)
    {
        if (isDebug){
            log(tag, msg, null, 'e');
        }
    }

    /**
     * Error日志
     *
     * @param tag 标签
     * @param msg 消息
     * @param tr  异常
     */
    public static void e(String tag, String msg, Throwable tr)
    {
        if (isDebug){
            log(tag, msg, tr, 'e');
        }
    }


    /**
     * 根据tag, msg和等级，输出日志
     *
     * @param tag  标签
     * @param msg  消息
     * @param tr   异常
     * @param type 日志类型
     */
    private static void log(String tag, String msg, Throwable tr, char type)
    {
        if (isDebug)
        {
            switch (type)
            {
                case 'v':
                    if (logFilter == 'v')
                        Log.v(generateTag(tag), msg, tr);
                    break;
                case 'd':
                    if (logFilter == 'v' || logFilter == 'd')
                        Log.d(generateTag(tag), msg, tr);
                    break;
                case 'i':
                    if (logFilter == 'v' || logFilter == 'd' ||
                            logFilter == 'i')
                        Log.i(generateTag(tag), msg, tr);
                    break;
                case 'w':
                    if (logFilter == 'v' || logFilter == 'd' ||
                            logFilter == 'i' || logFilter == 'w')
                        Log.w(generateTag(tag), msg, tr);
                    break;
                case 'e':
                    Log.e(generateTag(tag), msg, tr);
                    break;
            }
        }
    }

    /**
     * 产生tag
     *
     * @return tag
     */
    private static String generateTag(String tag)
    {
        // 获取当前线程的堆栈数组
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        // 前两个是vm和Thread的方法
        // 第三个是当前generateTag()方法
        // 第四个是LogUtils调用generateTag()方法的log()方法
        // 第五个是LogUtils调用log()方法的v()/d()/i()/w()/e()方法
        // 所以取第六个，调用LogUtils的类的信息
        StackTraceElement caller = stacks[5];
        String format = tag + " %s[%s, %d]";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName
                .lastIndexOf(".") + 1);
        return String.format(format, callerClazzName, caller.getMethodName(),
                caller.getLineNumber());
    }
}
