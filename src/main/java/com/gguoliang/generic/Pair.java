package com.gguoliang.generic;

/**
 * @Author GGuoLiang
 * @Date 2021/1/2 9:07 下午
 * @Version 1.0
 */
public class Pair<T> {

    private T name;

    private T value;

    public Pair(T name, T value) {
        this.name = name;
        this.value = value;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "name=" + name +
                ", value=" + value +
                '}';
    }
}
