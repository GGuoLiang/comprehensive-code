package com.gguoliang.nx.classLoader;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author GGuoLiang
 * @Date 2020/12/16 9:58 下午
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        ClassLoaderFrame classLoaderFrame = new ClassLoaderFrame();
        try {
            classLoaderFrame.runClass("/Users/guoliang/code/Java/codespace/comprehensive-code/target/classes/com/gguoliang/nx/classLoader/ClassLoaderTest.class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
