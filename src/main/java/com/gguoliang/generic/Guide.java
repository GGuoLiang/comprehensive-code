package com.gguoliang.generic;

import java.util.List;

/**
 * @Author GGuoLiang
 * @Date 2021/1/2 9:49 下午
 * @Version 1.0
 */
public class Guide<T> {

    /**
     * T的作用域是整个class,func的T的作用域就是本方法
     * 当上述两个类型参数冲突时，在方法中，方法的T会覆盖类的T，即和普通变量的作用域一样，内 部覆盖外部，外部的同名变量是不可见的
     * @param t
     * @param <T>
     */
    public <T> void func(T t) {
    }

    /**
     * 可以定义不同类型泛型来区分作用域
     * @param s
     * @param <S>
     */
    public <S> void fund(S s) {
    }

    /**
     * <T extends Parson>指定泛型方法的类型参数的上限
     *  @param src
     * @param <T>
     * @return
     */
    public <T extends Person> T funa(List<T> src) {
        return null;
    }

    /**
     * 不能在方法参数中定义上限
     * @param src
     * @param <T>
     */
   /* public <T> T funb(List<T extends Person> src) {
        return null;
    } }*/


    public <T> void copy(List<T> dest,List<? extends T> src) {
        for (T t : src) {
            dest.add(t); }
    }


    /**
     * 使用?还可以强制避免你对src做不必要的修改，增加的安全性
     * @param src
     * @param <Person>
     */
    public <Person> void update(List<? extends Person> src){
        for (Person person : src) {
           // person.

        }

    }


}
