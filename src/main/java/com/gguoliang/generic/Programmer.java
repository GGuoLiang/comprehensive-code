package com.gguoliang.generic;

/**
 * @Author GGuoLiang
 * @Date 2021/1/2 9:15 下午
 * @Version 1.0
 */
public class Programmer<T extends Person> {

    public <T extends Person> Pair<T> youngAndOld(T[] a) { if(a == null || a.length == 0) {
        return null;
    }
        T min = a[0];
        T max = a[1];
        for(int i = 0; i < a.length; i++) {
            if(min.getAge().compareTo(a[i].getAge()) > 0) { min = a[i];
            }
            if(max.getAge().compareTo(a[i].getAge()) < 0) {
                max = a[i]; }
        }
        return new Pair<>(min, max);
    }


}
