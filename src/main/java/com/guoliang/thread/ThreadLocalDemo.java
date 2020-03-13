package com.guoliang.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
    private static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            //executorService.submit(new DateUtil("2019-11-25 09:00:" + i % 60));
            executorService.submit(new DateUtil( i ));

        }
    }

    static class DateUtil implements Runnable {
        private String date;
        private Integer i;

        public DateUtil(String date) {
            this.date = date;
        }

        public DateUtil(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            if (sdf.get() == null) {
                // 为每个线程 添加ThreadLocalMap添加 SimpleDateFormat实例
                sdf.set(new SimpleDateFormat("yyyy-"+i+"-MM-dd HH:mm:ss"));
            } else {
                Date date = null;
                /*try {
                    date = sdf.get().parse(new Date());
                } catch (ParseException e) {
                    e.printStackTrace();
                }*/
                System.out.println(sdf.get().format(new Date()));

            }
        }
    }

}