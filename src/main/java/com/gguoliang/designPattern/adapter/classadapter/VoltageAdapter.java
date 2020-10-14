package com.gguoliang.designPattern.adapter.classadapter;

/**
 * @Author GGuoLiang
 * @Date 2020/10/14 3:46 下午
 * @Version 1.0
 */
public class VoltageAdapter extends Voltage220 implements Voltage15 {
    @Override
    public void outPut15() {
        int i = outPut220();
        i = i - 205;
        System.out.println(i+"V开始充电");
    }
}
