package com.gguoliang.idea;

import com.gguoliang.entity.Person;

/**
 * @Author GGuoLiang
 * @Date 2020/12/4 3:17 下午
 * @Version 1.0
 */
public class DropTest {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->mothod1(finalI)).start();
        }



    }

    public static void mothod1(int i){
        Person person = new Person();
        person.setId(i);
        person.setName(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName()+"  "+i);
    }
}
