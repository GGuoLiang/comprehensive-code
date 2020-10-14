package com.gguoliang.designPattern.adapter.objectadapter;

import lombok.Data;

/**
 * @Author GGuoLiang
 * @Date 2020/10/14 3:55 下午
 * @Version 1.0
 */
@Data
public class VoltageAdapter implements Voltage15 {

    private Voltage220 voltage220;

    @Override
    public void outPut15() {
        int i = voltage220.outPut220();
        i = i - 205;
        System.out.println(i+"V开始充电");
    }
}
