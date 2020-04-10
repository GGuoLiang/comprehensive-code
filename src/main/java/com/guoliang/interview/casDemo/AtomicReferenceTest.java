package com.guoliang.interview.casDemo;

import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author GGuoLiang
 * @Date 2020/4/9 10:58 上午
 * @Version 1.0
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        Person zhangsan = new Person("zhangsan", 18);
        Person lisi = new Person("lisi", 20);
        AtomicReference<Person> personAtomicReference = new AtomicReference<>();
        personAtomicReference.set(zhangsan);
        System.out.println(personAtomicReference.compareAndSet(zhangsan, lisi)+" 修改第一次的后的值"+personAtomicReference.get());
        System.out.println(personAtomicReference.compareAndSet(lisi, zhangsan)+" 修改第二次的后的值"+personAtomicReference.get());
        System.out.println(personAtomicReference.compareAndSet(zhangsan, lisi)+" 修改第三次的后的值"+personAtomicReference.get());

    }

}


@Data
class Person{
    private String name;
    private Integer age;

    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
    }
}