package test;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * @Author GGuoLiang
 * @Date 2020/7/27 3:26 下午
 * @Version 1.0
 */
public class TimeTest {

    @Test
    public void Test(){
       /* String str = "2020-01-02";
        LocalDateTime parse = LocalDateTime.of(LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd")),LocalTime.of(0,0,0));
        System.out.println(parse.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        *//*System.out.println(parse);
        parse = parse.plusMinutes(60);
        System.out.println(parse);

        String str1 = "10:50";
        LocalTime localTime = LocalTime.parse(str1,DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println(localTime);
        localTime = localTime.plusMinutes(60);
        System.out.println(localTime);


        String *//*
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse("2020-01-02");
            LocalDateTime localDateTime = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
            System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));


        } catch (ParseException e) {
            e.printStackTrace();
        }*/


    }

    @Test
    public void time() {
        long t1 = System.currentTimeMillis();
        long t2 = Calendar.getInstance().getTimeInMillis();
        long t3 = new Date().getTime();
        long per = t3 - t1;
        if (per > 10000) {
            System.out.println(per);
        } else {
            String five = String.format("%06d", per);
            System.out.println(five);
        }

        DecimalFormat df=new DecimalFormat("0000000000000");
        Long t11=86400000L;
        System.out.println(df.format(t1));
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(df.format(t1))), ZoneId.systemDefault()));

    }
}
