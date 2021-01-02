package com.gguoliang.designPattern.observer;

/**
 * @Author GGuoLiang
 * @Date 2020/12/29 9:19 下午
 * @Version 1.0
 */
public interface Subject {

     void registerObserver();
     void removeObserver();
     void notifyObserver();


}
