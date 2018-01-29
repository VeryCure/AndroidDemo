package com.jeff.demo.androiddemo.annotation;

/**
 * Created by ttxs on 2018/1/16.
 */

@TestAnnotation(id = 2,msg = "hello world")
public class Test
{
    @SuppressWarnings("deprecation")
    public Test()
    {
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }
    public static void main(String[] args){
        boolean hasAnnotation = Test.class.isAnnotationPresent
                (TestAnnotation.class);
        if (hasAnnotation){
            TestAnnotation annotation = Test.class.getAnnotation
                    (TestAnnotation.class);
            System.out.print("id:"+annotation.id());
            System.out.print("msg:"+annotation.msg());
        }
    }
}
