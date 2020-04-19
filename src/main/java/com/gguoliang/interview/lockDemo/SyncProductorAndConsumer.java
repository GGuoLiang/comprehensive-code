package com.gguoliang.interview.lockDemo;

/**
 * @Author GGuoLiang
 * @Date 2020/4/14 10:43 上午
 * @Version 1.0
 * synchronized 版本的生产者、消费者模型 wait notify
 *
 * 线程 操作 资源类(Food)
 * 判断  干活  通知
 * 防止虚假唤醒机制
 *
 */
public class SyncProductorAndConsumer {

    public static void main(String[] args) {
        Food food = new Food();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                food.productor();
            }
        },"productor1").start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                food.productor();
            }
        },"productor2").start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                food.consumer();
            }
        },"consumer1").start();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                food.consumer();
            }
        },"consumer2").start();


    }
}


class Food{

    private  int number = 0;

    /**
     * 生产方法
     */
    public synchronized void productor(){
        while (number !=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"生产后数量"+number);
        this.notifyAll();
    }

    /**
     * 消费方法
     */
    public synchronized void consumer(){

        while (number == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"消费后数量"+number);
        this.notifyAll();
    }

}