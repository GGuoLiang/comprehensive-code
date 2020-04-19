package com.guoliang.jvmLecture.classLoader;


/**
 * 接口的初始化和类的初始化不同
 *
 * jvm规则要求：
 * 1：当一个子接口继承一个父接口时，使用子接口的常量（接口的属性都是被public static final修饰的）不会初始化父接口
 * 2：当一个子类实现一个父接口是，使用子类的也同样不会初始化父接口
 *
 *
 *
 */
public class MyTest5 {

    public static void main(String[] args) {
        // 单独初始化父接口
        //System.out.println(MyChildInterFace.t);

        //单独初始化子接口
        //System.out.println(MyChildInterFace.t1);

        //单独初始化子类
        System.out.println(MyChildClass.t);

    }
}

interface MyParent5 {
     Thread t = new Thread(){
         {
             System.out.println("MyParent5........ ");
         }
     };

}


interface MyChildInterFace extends MyParent5{
    Thread t1 = new Thread(){
        {
            System.out.println("MyChildInterFace........ ");
        }
    };

}

class MyChildClass implements  MyParent5{

    public static final String s = "MyChildClass";
}