package com.gguoliang.jvmLecture.classLoader;

public class MyTest2 {
    /**
     * 常量调用的过程中会直接存入到调用这个常量方法（mian）的所在的类（MyTest2）常量池中
     * 本质上 调用类并没有直接引用定义常量的类（不是主动使用）所以类（StringTest）不会初始化
     *
     * 注：这个指的常量会被直接被放入MyTest2的常量池，本质上于StringTest类没有关系
     * 甚至可以直接删除StringTest的class文件
     *
     *
     * 查看class 命令javap -c 文件
     * 助记符：
     * Ldc：将int float和String类的常量从常量池中推至栈顶
     * ldc2_w: 将double类型的常量推至栈顶
     * iconst_1: 将int类的常量从常量池中推至栈顶（这种类的的还是存在-1-5之间：iconst_m1~iconst_5）
     * bipush：将int-128~127 之间的常量推至栈顶
     * sipush：将一个短整型常量（-32768-32767）
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(StringTest.string);
    }

}

class  StringTest{

    public  static  String string = " StringTest ";
    public  static final int i=32768;
    public  static final double f = 3.0;

    static {
        System.out.println(" StringTest .........");

    }
}
