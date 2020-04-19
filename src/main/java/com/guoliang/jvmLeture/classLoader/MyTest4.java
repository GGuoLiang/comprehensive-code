package com.guoliang.jvmLeture.classLoader;

/**
 *创建引用类型的数组的 类的初始化
 *
 * 对于引用类型的数组 其类型是有JVM 运行期间产生的类似于的 [Lcom.guoliang.classLoader.ClassTest4类型
 * 其为动态生成类型 该类型的父类为Object
 *
 * 对于数组来说，JavaDoc构成数组的元素成为component，实际上就是将数组降低一个维度后的类型
 * 一位数据：[Lcom.guoliang.classLoader.ClassTest4
 * 二维数据：[[Lcom.guoliang.classLoader.ClassTest4;
 *
 *
 * 助记符：
 * newarray: 创建基本类型的数据
 * anewarray：创建引用类型的数组
 *
 */
public class MyTest4 {
    public static void main(String[] args) {
        ClassTest4[] classTest4s = new ClassTest4[1];
        System.out.println("当前引用类型数组的class："+classTest4s.getClass()+"当前引用类型数组的父class："+classTest4s.getClass().getSuperclass());
        ClassTest4[][] classTest4s1 = new ClassTest4[1][1];
        System.out.println("当前引用类型数组的class："+classTest4s1.getClass()+"当前引用类型数组的父class："+classTest4s1.getClass().getSuperclass());

        //基本类型的数组
        byte[] bytes = new byte[1];
        System.out.println("bytes 类型："+bytes.getClass());
        int[] ints = new int[1];
        System.out.println("ints 类型："+ints.getClass());
        short[] shorts = new short[1];
        System.out.println("shorts 类型："+shorts.getClass());
        boolean[] booleans = new boolean[1];
        System.out.println("booleans 类型："+booleans.getClass());
        char[] chars = new char[1];
        System.out.println("chars 类型："+chars.getClass());
        double[] doubles = new double[1];
        System.out.println("doubles 类型："+doubles.getClass());
        float[] floats = new float[1];
        System.out.println("floats 类型："+floats.getClass());
        long[] longs = new long[1];
        System.out.println("longs 类型："+longs.getClass());


    }


}


class ClassTest4{

    static {
        System.out.println("ClassTest4 ...");

    }
}