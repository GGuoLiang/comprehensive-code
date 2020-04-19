package com.gguoliang.juc.thread;

import lombok.Data;

import java.util.concurrent.*;

public class CallableThreadTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Race bunny = new Race("兔",300);
        Race tortoise = new Race("龟",1000);
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> result1 = es.submit(bunny);
        Future<Integer> result2 = es.submit(tortoise);

        Thread.sleep(2000);
        bunny.setFlag(false);
        tortoise.setFlag(false);

        int bunnySteps = result1.get();
        int tortoiseSteps = result2.get();
        System.out.println("兔子跑了"+bunnySteps+"步");
        System.out.println("乌龟跑了"+tortoiseSteps+"步");

        es.shutdownNow();
    }
}


@Data
class Race implements Callable<Integer> {
    private String name;
    private int step;
    private int time = 0 ;
    private boolean flag = true;

    @Override
    public Integer call() throws Exception {
        while(flag){
            Thread.sleep(time);
            step++;
        }
        return step;
    }

    public Race() {
    }

    public Race(String name, int time) {
        this.name = name;
        this.time = time;
    }
}
