package com.gguoliang.jvmLecture.classLoader;

public class MyTest1 {
    /**
     * 对于静态的字段 只有直接定义了该字段的类的才会被初始化
     * 当调用的一个子类时，其父类已全部被初始化
     *
     * -XX:+TraceClassLoading 用于追踪类的加载并将加载信息打印出来
     *
     * @param args
     */
    public static void main(String[] args) {

        // 使用Parent1 的变量  由于没有直接使用的Childen的变量  该方法的对Childen没有不产生主动使用 所以不会初始化Childen
        System.out.println(Childen.string1);

        System.out.println(Childen.string1);
    }

    static  class  Parent1{
        public   static  String  string1 = " my parent ....";

        static {
            System.out.println(" my parent ....  构造器");
        }

    }

    static class Childen extends Parent1{
        private  static  String  string2 = " my Childen ....";

        static {
            System.out.println(" my Childen ....  构造器");
        }
    }
}



