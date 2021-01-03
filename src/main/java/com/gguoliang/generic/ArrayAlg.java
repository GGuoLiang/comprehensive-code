package com.gguoliang.generic;

import com.gguoliang.nx.loadOder.Test;

/**
 * @Author GGuoLiang
 * @Date 2021/1/2 9:11 下午
 * @Version 1.0
 */
public class ArrayAlg {

    public static <T> T getMiddle(T... a){
        return a[a.length / 2];
    }


    public static <U> U getMiddle1(U... a){
        return a[a.length / 2];
    }

    public static void main(String[] args) {
        String middle =ArrayAlg.<String>getMiddle("a","b","c");
        System.out.println(middle);
    }

}
