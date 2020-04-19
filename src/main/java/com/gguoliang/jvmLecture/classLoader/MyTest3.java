package com.gguoliang.jvmLecture.classLoader;

import java.util.UUID;

/**
 * 编译期和与运行期常量的值初始化区别
 * 当一个常量的值在编译阶段无法确定其值，该常量既不会被放入到调用常量方法的类的常量池中，而是在
 * 主动使用定义该常量的类，即该类会被初始化。
 */
public class MyTest3 {

    public static void main(String[] args) {
        System.out.println(StringTest3.s);
    }
}


class StringTest3{

    public static final String s = UUID.randomUUID().toString();

    static {
        System.out.println(" StringTest3......");
    }

}

