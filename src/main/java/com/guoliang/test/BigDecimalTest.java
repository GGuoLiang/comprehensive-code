package com.guoliang.test;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.*;

/**
 * @Author GGuoLiang
 * @Date 2020/4/10 4:50 下午
 * @Version 1.0
 */
public class BigDecimalTest {
    public static void main(String[] args) {
       /* BigDecimal aa = new BigDecimal("11");
        System.out.println(aa);
        BigDecimal bb = new BigDecimal("12");
        System.out.println(bb.intValue());
        System.out.println(aa.subtract(bb).subtract(bb).subtract(bb));
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        System.out.println(aa.divide(bb, 4, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println(percent.format(aa.divide(bb, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i+"",aa.subtract(new BigDecimal(i)));
        }
        System.out.println(map);*/
      // BigDecimal bigDecimal = new BigDecimal("");
      //  System.out.println(bigDecimal);

       /* List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("aa","aa");
        list.add(map);
        List<Map<String,Object>> list1 = list;
        for (Map<String, Object> objectMap : list1) {
            objectMap.put("cc","cc");
            list1.add(objectMap);
        }
        System.out.println(list1);
        System.out.println(list);*/
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        BigDecimal a = new  BigDecimal("1");
        BigDecimal b = new  BigDecimal("0");
        System.out.println(percent.format(b.divide(a,4,BigDecimal.ROUND_HALF_UP).doubleValue()));

    }
}
