package com.gguoliang.interview.collectionDemo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author GGuoLiang
 * @Date 2020/4/9 4:47 下午
 * @Version 1.0
 *
 * map线程不安全问题 ConcurrentModificationException
 *
 * 解决办法：ConcurrentHashMap (1.7 和 1.8 区别)
 *
 *
 *
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String,Object> objectMap ;
        //objectMap = new HashMap<>();
      //  objectMap = new ConcurrentHashMap<>();
        objectMap = Collections.synchronizedMap(new HashMap<>());
        for (int i = 0; i < 20; i++) {
            new Thread(() ->{
                objectMap.put(UUID.randomUUID().toString().substring(0,5),Thread.currentThread().getName());
                System.out.println(objectMap);
            }).start();
        }
    }
}
