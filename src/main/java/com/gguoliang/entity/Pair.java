package com.gguoliang.entity;

/**
 * @Author GGuoLiang
 * @Date 2021/1/2 8:57 下午
 * @Version 1.0
 */
public class Pair<K,V> {

    private K key;
    private V value;

    public Pair(K key, V value) { this.key = key;
        this.value = value; }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; } public K getKey() { return key; }
    public V getValue() { return value; }
}
