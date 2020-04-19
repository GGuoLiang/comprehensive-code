package com.gguoliang.juc.thread;

/**
 * 使用两个线程打印 1-100。线程1, 线程2 交替打印
 */
class CommunicationTest{
    public static void main(String[] args) {
        Communication communication = new Communication();
        new Thread(communication).start();
        new Thread(communication).start();
    }
}


public class Communication implements Runnable {

    int i = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                } else {
                    break;
                }
                try {
                   this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



class Number implements Runnable{
    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {

        while(true){

            synchronized (obj) {

                obj.notify();

                if(number <= 100){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }

        }

    }
}
