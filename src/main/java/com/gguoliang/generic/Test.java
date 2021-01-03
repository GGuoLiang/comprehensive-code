package com.gguoliang.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GGuoLiang
 * @Date 2021/1/2 10:15 下午
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        MyNode myNode = new MyNode(5);
        Node node = myNode;
        node.setData("aaa");
        Integer data = myNode.getData();
    }

    public static <E> void append(List<E> list) {
        //E elem = new E(); // compile-time error list.add(elem);
    }

    //作为解决办法，可以通过反射来创建
    public static <E> void append(List<E> list, Class<E> cls) throws Exception {
        E elem = cls.newInstance(); // OK
        list.add(elem);
    }

   /* public static <E> void rtti(List<E> list) { //编译期会提示异常
        if (list instanceof ArrayList<Integer>) {
// ...
        }
    }*/

    //解决方法可以通过无界通配符来进行参数化
    public static void rtti(List<?> list) { //编译不会报错
        if (list instanceof ArrayList<?>) { // ...
        }
    }
}
