package test;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 9:05 下午
 * @Version 1.0
 */
public class StringBufferTest {

    @Test
    public void test(){
     /*   String str = "aabbbcccde";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str,str.length()-5,str.length());
        System.out.println(stringBuffer.toString());*/

      /*  System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMddHHmm")));

        System.out.println(LocalDateTime.now().minusDays(1));*/

      String str = "addbb";
        System.out.println( str.split(",").length);


    }
}
