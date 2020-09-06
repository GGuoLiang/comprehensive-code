package com.gguoliang.java8.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @Author GGuoLiang
 * @Date 2020/9/6 5:19 下午
 * @Version 1.0
 */
public class LocateDateTest {

    @Test
    public void test(){
        LocalDate of = LocalDate.of(2018, 7, 13);
        System.out.println(of);
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalTime.of(23, 12, 30));
        System.out.println(LocalDateTime.now());
        System.out.println(Instant.now());
    }

    @Test
    public void test2(){
        LocalDate of = LocalDate.of(2018, 7, 13);
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        Month month = now.getMonth();
        int dayOfMonth = now.getDayOfMonth();
        LocalDate localDate = now.withYear(2012);
        LocalDate localDate1 = now.withMonth(12);
        LocalDate localDate2 = now.withDayOfMonth(23);
        LocalDate with = now.with(ChronoField.DAY_OF_MONTH, 23);

        // 加
        LocalDate localDate3 = now.plusYears(2);
        // 减
        LocalDate localDate4 = now.minusYears(2);
        now.plus(10, ChronoUnit.YEARS);
        now.minus(10,ChronoUnit.YEARS);
        System.out.println(localDate4);
    }

    @Test
    public void test3(){
        LocalTime of = LocalTime.of(12, 30, 50);
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        System.out.println(Duration.between(of, now));
    }

    @Test
    public void test4(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime of = LocalDateTime.of(2012, 7, 23, 12, 50, 23);
    }


    @Test
    public void test5(){
        Instant now = Instant.now();
        // 3秒之后再加上10亿纳秒 -> 4秒
        Instant instant = Instant.ofEpochSecond(3, 1_000_000_000);
        Instant instant1 = Instant.ofEpochSecond(4);
        System.out.println(instant.getEpochSecond());
        System.out.println(instant1.getEpochSecond());
    }

    @Test
    public void test6(){
        LocalDate now = LocalDate.now();
        LocalDate with = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        LocalDate with1 = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(with1);
    }

    @Test
    public void test7(){
        LocalDate now = LocalDate.now();
        String format = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(format);
        LocalDate parse = LocalDate.parse("20201025", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        System.out.println(LocalDate.now().format(dateTimeFormatter));
        // 地区
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd/MM/YYYY", Locale.CHINESE);
        System.out.println(LocalDate.now().format(dateTimeFormatter1));

        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder()
                .appendLiteral("该月")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral("的")
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral("号");
        DateTimeFormatter dateTimeFormatter2 = dateTimeFormatterBuilder.toFormatter();
        System.out.println(LocalDate.now().format(dateTimeFormatter2));
    }

    @Test
    public void test8(){
        LocalDate now = LocalDate.now();
        //创建一个时区
        ZoneOffset of = ZoneOffset.of("Asia/Shanghai");
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        ZonedDateTime zonedDateTime = now.atStartOfDay(ZoneId.of("Asia/Shanghai"));

        //localDateTime 和 instant像话转换
        LocalDateTime localDateTime = LocalDateTime.of(2012,1,1,1,1,10);
        ZoneOffset zoneOffset = ZoneOffset.of("Asia/Shanghai");
        Instant instant = localDateTime.toInstant(zoneOffset);
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, of);
    }
}
