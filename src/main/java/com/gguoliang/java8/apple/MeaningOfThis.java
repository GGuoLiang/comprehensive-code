package com.gguoliang.java8.apple;

/**
 * @Author GGuoLiang
 * @Date 2020/9/1 10:44 上午
 * @Version 1.0
 */
public class MeaningOfThis {

    private static final int value = 5;

    public void doIt(){
        int value = 6;
        new Thread(new Runnable() {
            public final int value= 7;
            @Override
            public void run() {
                System.out.println(this.value);
            }
        }).start();

    }

    public static void main(String[] args) {
        MeaningOfThis meaningOfThis = new MeaningOfThis();
        meaningOfThis.doIt();
    }
}
