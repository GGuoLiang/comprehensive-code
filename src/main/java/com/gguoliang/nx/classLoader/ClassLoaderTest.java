package com.gguoliang.nx.classLoader;

import java.io.Serializable;

/**
 * @Author GGuoLiang
 * @Date 2020/12/16 9:57 下午
 * @Version 1.0
 */
public class ClassLoaderTest implements Serializable {

    private String name;

    private String city;

    public ClassLoaderTest(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static void main(String[] args) {
        System.out.println("ClassLoaderTest main .......");
    }

    @Override
    public String toString() {
        return "ClassLoaderTest{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
