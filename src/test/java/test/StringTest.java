package test;

import org.junit.Test;

import java.sql.SQLOutput;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author GGuoLiang
 * @Date 2020/5/15 10:35 上午
 * @Version 1.0
 */
public class StringTest {

    @Test
    public void test(){
       /* String  test = " test ";
        test.trim();
        System.out.println(test);


        String str = "D_F_D";
        System.out.println(str.split("_")[2]);*/
/*
        String str = "11223344";
        System.out.println(str.indexOf("00"));
        System.out.println( (int) (Math.random() * (9999 - 1000 + 1)) + 1000);

        String cont ="占位符数据{0},第二个占位符";

        System.out.println( MessageFormat.format(cont,"1111"));*/

        String str = "sss_ddd";
        //int ddd = str.lastIndexOf("d");
       // System.out.println(ddd);
    }


    public static void main(String[] args) {
        /*String abc = null;
        getStr(abc);
        System.out.println(abc);*/

        //DAYLY_FRZ_READ_REC
        //MONTHLY_FRZ_READ_REC
        //MONTHLY_FRZ_DEMAND_REC
        //CURVE_DATA_REC

        StringBuffer stringBuffer = new StringBuffer();
        Stream.iterate(0,n->n+1).limit(10).forEach(n->{
            stringBuffer.append("aaa").append(",");
        });
        System.out.println(stringBuffer.toString());
        System.out.println(stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString());

    }


    public static int getStr(String string){
        string = 12345+"qqq";
        return 0;
    }


    @Test
    public void test1(){

        String str = "aaaddd";
        System.out.println(str.lastIndexOf("vv"));
    }
}
