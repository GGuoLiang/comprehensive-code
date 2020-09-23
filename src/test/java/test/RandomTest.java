package test;

import java.util.Random;

/**
 * @Author GGuoLiang
 * @Date 2020/9/21 2:25 下午
 * @Version 1.0
 */
public class RandomTest {
    public static void main(String[] args) {

        Random rand = new Random();
        int n = rand.nextInt(99900000);
        System.out.println(n);

        System.out.println((int)((Math.random()*9+1)*1000));
    }
}
