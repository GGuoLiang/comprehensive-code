package com.gguoliang.nx.loadOder;

/**
 * @Author GGuoLiang
 * @Date 2020/12/15 11:23 下午
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {

        Class<SonFile> sonFileClass = SonFile.class;

        try {
            SonFile sonFile = sonFileClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
