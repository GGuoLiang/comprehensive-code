package com.gguoliang.java8.apple;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GGuoLiang
 * @Date 2020/9/1 9:49 上午
 * @Version 1.0
 */

@Data
public class Apple {
    private String color;
    private Double weight;



    public List<Apple> filterGreenApples(List<Apple> apples){
        List<Apple>  appleList = new ArrayList<>();
        for (Apple apple : apples) {
            if("green".equals(apple.getColor())){
                appleList.add(apple);
            }
        }
        return appleList;
    }

    public List<Apple> filterColorApples(List<Apple> apples,String color){
        List<Apple>  appleList = new ArrayList<>();
        for (Apple apple : apples) {
            if(color.equals(apple.getColor())){
                appleList.add(apple);
            }
        }
        return appleList;
    }


    public List<Apple> filterApples(List<Apple> apples,String color,double weight,boolean flag){
        List<Apple>  appleList = new ArrayList<>();
        for (Apple apple : apples) {
            if(color.equals(apple.getColor())){
                if(flag){
                    if(weight > 150){
                        appleList.add(apple);
                    }
                }else {
                    if(weight <= 150){
                        appleList.add(apple);
                    }
                }
            }
        }
        return appleList;
    }

    public List<Apple> filterApples(List<Apple> apples, ApplePredicate applePredicate){
        List<Apple>  appleList = new ArrayList<>();
        for (Apple apple : apples) {
            if(applePredicate.test(apple)){
                appleList.add(apple);
            }
        }
        return appleList;
    }

    public void test(){
        List<Apple> apples = new ArrayList<>();
        List<Apple> redApples = filterApples(apples, apple -> "red".equals(apple.color));

    }
}
