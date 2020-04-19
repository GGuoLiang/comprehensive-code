package com.gguoliang.interview.casDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author GGuoLiang
 * @Date 2020/4/9 10:35 上午
 * @Version 1.0
 *
 * Atomic 使用的unSafe类
 * unsafe.getAndAddInt(this, valueOffset, 1); this 该对象 valueOffset 在内存中地址 i 增加的值
 *
 * unsafe 底层原理实现 var5 主内存中的值 compareAndSwapInt 预期值的值和主内存的值 相等 修改为 var5 + var4
 * 不相等 重新取值 在比较
 *    public final int getAndAddInt(Object var1, long var2, int var4) {
 *         int var5;
 *         do {
 *
 *             var5 = this.getIntVolatile(var1, var2);
 *         } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
 *
 *         return var5;
 *     }
 *
 *     cas原理 ：compareAndSwap
 *     缺点：一个变量修改、循环消耗性能、ABA问题
 *
 */
public class CasTest1 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    atomicInteger.getAndIncrement();
                }
            }).start();


        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(atomicInteger.get());
    }
}
