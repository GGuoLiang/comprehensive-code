package com.gguoliang.nx.loadOder;

/**
 * @Author GGuoLiang
 * @Date 2020/12/15 11:21 下午
 * @Version 1.0
 */
public class SonFile extends FatherFile {

    private static int  b = 2;

    static {
        a = 3;
        System.out.println(b);
    }

    static {
        System.out.println(a);
    }
}
