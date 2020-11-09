package test;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @Author GGuoLiang
 * @Date 2020/7/27 3:26 下午
 * @Version 1.0
 */
public class TimeTest {

    @Test
    public void Test(){
        String str = "2020-01-02 10:50:30";
        LocalDateTime parse = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        /*System.out.println(parse);
        parse = parse.plusMinutes(60);
        System.out.println(parse);

        String str1 = "10:50";
        LocalTime localTime = LocalTime.parse(str1,DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println(localTime);
        localTime = localTime.plusMinutes(60);
        System.out.println(localTime);


        String */
    }
}
