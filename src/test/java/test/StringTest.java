package test;

import org.junit.Test;

import java.sql.SQLOutput;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @Author GGuoLiang
 * @Date 2020/5/15 10:35 上午
 * @Version 1.0
 */
public class StringTest {

    @Test
    public void test(){
        String  test = " test ";
        test.trim();
        System.out.println(test);


        String str = "D_F_D";
        System.out.println(str.split("_")[2]);
/*
        String str = "11223344";
        System.out.println(str.indexOf("00"));
        System.out.println( (int) (Math.random() * (9999 - 1000 + 1)) + 1000);

        String cont ="占位符数据{0},第二个占位符";

        System.out.println( MessageFormat.format(cont,"1111"));*/
    }
}
