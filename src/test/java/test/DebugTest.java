package test;

import org.junit.Test;

/**
 * @Author GGuoLiang
 * @Date 2020/9/18 9:54 上午
 * @Version 1.0
 */
public class DebugTest {


    public static void main(String[] args) {
        new Thread(()->{
            test1();
        },"11111").start();

        new Thread(()->{
            test1();
        },"22222").start();
    }


    public static void test1(){
        System.out.println(111111);
    }

    @Test
    public void test(){
        int i = 99;
        mothed1(i);
    }


    public void mothed1(int i){
        i++;
        System.out.println(i);
        mothed2(i);
    }

    public void mothed2(int i){
        i++;
        System.out.println(i);
    }
}
