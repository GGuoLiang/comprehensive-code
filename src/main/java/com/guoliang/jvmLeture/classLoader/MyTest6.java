package com.guoliang.jvmLeture.classLoader;

/**
 *
 * 在加载完成之后，连接阶段中的准备 ：为属性赋予默认值
 * 来到初始化阶段： 代码会按照源码的顺序执行
 *
 */
public class MyTest6 {

    public static void main(String[] args) {
        System.out.println(Singloten.getInstance());
    }
}

class Singloten{
    private static Singloten singloten = new Singloten();
    private  static int  a =2 ;
    private static int b =4 ;

    public Singloten(){
        System.out.println("没有被++修改的值 a="+a+" b="+b);
        a++;
        b++;
        System.out.println("被++修改的值 a="+a+" b="+b);
    }

    public static Singloten getInstance(){
        System.out.println(" a="+a+" b="+b);
        return singloten;
    }


}