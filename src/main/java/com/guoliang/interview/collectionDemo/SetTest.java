package com.guoliang.interview.collectionDemo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author GGuoLiang
 * @Date 2020/4/9 4:42 下午
 * @Version 1.0
 *
 * HashSet 和 HashMap
 * HashSet 底层是key为值 value不考虑的HashMap
 *
 * set集合不安全问题 ConcurrentModificationException
 *
 * 解决办法：Collections.synchronizedSet 、CopyOnWriteArraySet、
 *
 *
 */
public class SetTest {

    public static void main(String[] args) {
        Set<String> stringSet ;
       // stringSet = new HashSet<>();
        //stringSet = Collections.synchronizedSet(new HashSet<>());
        stringSet = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 20; i++) {
            new Thread(() ->{
                stringSet.add( UUID.randomUUID().toString().substring(0,5));
                System.out.println(stringSet);
            }).start();
        }
    }
}
