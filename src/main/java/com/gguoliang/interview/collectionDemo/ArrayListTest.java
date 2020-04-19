package com.gguoliang.interview.collectionDemo;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author GGuoLiang
 * @Date 2020/4/9 4:32 下午
 * @Version 1.0
 *
 * ArrayList 线程不安全
 * 出现ConcurrentModificationException 异常
 *
 * 解决办法：Vector、Collections.synchronizedList、CopyOnWriteArrayList
 *
 * CopyOnWriteArrayList 写时复制 在写的加锁代码块处理
 *  Object[] newElements = Arrays.copyOf(elements, len); 创建新的数据
 *                 newElements[index] = element; 新数组添加值
 *                 setArray(newElements)；底层设置成为新数组
 *
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> arrayList ;
       // arrayList = new ArrayList<>();
       // arrayList = new Vector<>();
       // arrayList = Collections.synchronizedList(new ArrayList<>());
        arrayList = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                arrayList.add( UUID.randomUUID().toString().substring(0,5));
                System.out.println(arrayList);
            }).start();
        }

    }


}
