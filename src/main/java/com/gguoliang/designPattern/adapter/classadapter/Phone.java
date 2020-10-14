package com.gguoliang.designPattern.adapter.classadapter;

import lombok.Data;

/**
 * @Author GGuoLiang
 * @Date 2020/10/14 3:50 下午
 * @Version 1.0
 */
@Data
public class Phone {

    private String name;


    public void charging(){
        VoltageAdapter voltageAdapter = new VoltageAdapter();
        voltageAdapter.outPut15();
    }


}
