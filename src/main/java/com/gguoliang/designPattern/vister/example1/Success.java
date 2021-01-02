package com.gguoliang.designPattern.vister.example1;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 9:18 上午
 * @Version 1.0
 */
public class Success implements Action {
    @Override
    public void getManResult() {
        System.out.println("  man success ....");
    }

    @Override
    public void getWomanResult() {
        System.out.println("  woman success ....");
    }
}
