package test;

import org.junit.Test;

import java.sql.Timestamp;

/**
 * @Author GGuoLiang
 * @Date 2020/7/27 3:26 下午
 * @Version 1.0
 */
public class TimeTest {

    @Test
    public void Test(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }
}
