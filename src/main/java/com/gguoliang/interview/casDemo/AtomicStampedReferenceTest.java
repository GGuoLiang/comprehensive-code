package com.gguoliang.interview.casDemo;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author GGuoLiang
 * @Date 2020/4/9 11:04 上午
 * @Version 1.0
 *
 * ABA 解决办法
 *  增加一个版本号 Stamp
 */
public class AtomicStampedReferenceTest {

    public static void main(String[] args) {
        Person zhangsan = new Person("zhangsan", 18);
        Person lisi = new Person("lisi", 20);
        AtomicStampedReference<Person> atomicStampedReference = new AtomicStampedReference<>(zhangsan,1);
        System.out.println(atomicStampedReference.compareAndSet(zhangsan, lisi, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1)+" 修改后的值"+atomicStampedReference.getStamp()+" "+atomicStampedReference.getReference());
        System.out.println(atomicStampedReference.compareAndSet(lisi, zhangsan, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1)+" 修改后的值"+atomicStampedReference.getStamp()+" "+atomicStampedReference.getReference());
        System.out.println(atomicStampedReference.compareAndSet(zhangsan, lisi, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1)+" 修改后的值"+atomicStampedReference.getStamp()+" "+atomicStampedReference.getReference());

    }

}
