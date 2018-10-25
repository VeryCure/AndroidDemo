package com.jeff.demo.androiddemo.utils;

import java.math.BigInteger;

/**
 * Created by ttxs on 2018/4/18.
 */

public class DataUtil
{
    // 任意进制数转为十进制数
    public static String toD(String a, int b) {
        long r = 0;
        for (int i = a.length()-1; i >=0; i--){
            r = (long) (r + formatting(a.substring(i, i + 1))
                                * Math.pow(b, a.length() - i - 1));
        }
        return String.valueOf(r);
    }

    // 将十六进制中的字母转为对应的数字
    public static int formatting(String a) {
        int i = 0;
        for (int u = 0; u < 10; u++) {
            if (a.equals(String.valueOf(u))) {
                i = u;
            }
        }
        if (a.equals("A")) {
            i = 10;
        }
        if (a.equals("B")) {
            i = 11;
        }
        if (a.equals("C")) {
            i = 12;
        }
        if (a.equals("D")) {
            i = 13;
        }
        if (a.equals("E")) {
            i = 14;
        }
        if (a.equals("F")) {
            i = 15;
        }
        return i;
    }
}
