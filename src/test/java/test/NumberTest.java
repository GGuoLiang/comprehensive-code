package test;

import org.junit.Test;

/**
 * @Author GGuoLiang
 * @Date 2020/3/24 6:33 下午
 * @Version 1.0
 */
public class NumberTest {



    @Test
    public void Test(){
        int a = 5%4;
        int b = 5&(4-1);
        System.out.println(a == b);
    }
}
