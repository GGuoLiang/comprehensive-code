package com.guoliang.designMode.singleton;

/**
 * @Author GGuoLiang
 * @Date 2020/4/2 11:16 下午
 * @Version 1.0
 *
 * 登记式： 饿汉式的变种  线程安全 反射可以安全 序列化不安全
 *
 * 区别：在调用getInstance时 才会加载实例
 * 可以防止反射攻击
 */
public class Singleton3 {

    /**
     * 在一个静态的内部类实名设置一个全局的属性
     */
    private static class SingletonHepler{
        private static Singleton3 singleton3= new Singleton3();
    }

    private Singleton3()  {
        System.out.println(" init Singleton3 。。。。。。");
        //防止反射攻击
        if(SingletonHepler.singleton3 != null){
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static Singleton3 getInstance(){
        return SingletonHepler.singleton3;

    }
}
