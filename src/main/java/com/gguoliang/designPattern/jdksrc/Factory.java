package com.gguoliang.designPattern.jdksrc;

import java.util.Calendar;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 3:00 下午
 * @Version 1.0
 */
public class Factory {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));
    }
}
