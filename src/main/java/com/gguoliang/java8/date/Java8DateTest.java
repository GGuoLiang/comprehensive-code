package com.gguoliang.java8.date;


import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * java8  新增的时间api
 */
public class Java8DateTest {


    /**
     * 只会获取年月日
     * LocalDate
     */
    @Test
    public void localDateTest() {
        //获取当前年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //构造指定的年月日
        LocalDate localDate1 = LocalDate.of(2019, 9, 10);
        System.out.println(localDate1);


        int year = localDate.getYear();
        System.out.println(year);
        int year1 = localDate.get(ChronoField.YEAR);
        System.out.println(year1);
        Month month = localDate.getMonth();
        System.out.println(month);
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(month1);
        int day = localDate.getDayOfMonth();
        System.out.println(day);
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
        System.out.println(day1);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);
        System.out.println(dayOfWeek1);

    }


    /**
     * 只会获取几点几分几秒
     * LocalTime
     */
    @Test
    public void localTimeTest() {
        LocalTime localTime = LocalTime.of(13, 51, 10);
        LocalTime localTime1 = LocalTime.now();

        //获取小时
        int hour = localTime.getHour();
        int hour1 = localTime.get(ChronoField.HOUR_OF_DAY);
        //获取分
        int minute = localTime.getMinute();
        int minute1 = localTime.get(ChronoField.MINUTE_OF_HOUR);
        //获取秒
        int second = localTime.getSecond();
        int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE);

    }

    /**
     * 获取年月日时分秒，等于LocalDate+LocalTime
     * LocalDateTime
     */
    @Test
    public void localDateTimeTest() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime3 = localDate.atTime(localTime);
        LocalDateTime localDateTime4 = localTime.atDate(localDate);
        LocalDate localDate2 = localDateTime.toLocalDate();
        LocalTime localTime2 = localDateTime.toLocalTime();

        //获取秒数
        Instant instant = Instant.now();
        long currentSecond = instant.getEpochSecond();
        //获取毫秒数
        long currentMilli = instant.toEpochMilli();
        //个人觉得如果只是为了获取秒数或者毫秒数，使用System.currentTimeMillis()来得更为方便

    }

    @Test
    public void updateDateTimeTest() {
        //增加、减少年数、月数、天数等 以LocalDateTime为例
        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.SEPTEMBER, 10,
                14, 46, 56);

        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime.format(dateTimeFormatter1));
        System.out.println(LocalDateTime.now().format(dateTimeFormatter1));

        //增加一年
        localDateTime = localDateTime.plusYears(1);
        localDateTime = localDateTime.plus(1, ChronoUnit.YEARS);
        //减少一个月
        localDateTime = localDateTime.minusMonths(1);
        localDateTime = localDateTime.minus(1, ChronoUnit.MONTHS);


        //通过with修改某些值
        //修改年为2019
        localDateTime = localDateTime.withYear(2020);
        //修改为2022
        localDateTime = localDateTime.with(ChronoField.YEAR, 2022);
        //还可以修改月、日

        //比如有些时候想知道这个月的最后一天是几号、下个周末是几号，通过提供的时间和日期API可以很快得到答案
        LocalDate localDate = LocalDate.now();
        // LocalDate localDate1 = localDate.with(firstDayOfYear());


        //格式化时间 DateTimeFormatter默认提供了多种格式化方式，如果默认提供的不能满足要求，可以通过DateTimeFormatter的ofPattern方法创建自定义格式化方式
        //和SimpleDateFormat相比，DateTimeFormatter是线程安全的
        localDate = LocalDate.of(2019, 9, 10);
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        //自定义格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s3 = localDate.format(dateTimeFormatter);

        //解析时间
        LocalDate localDate1 = LocalDate.parse("20190910", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate localDate2 = LocalDate.parse("2019-09-10", DateTimeFormatter.ISO_LOCAL_DATE);


    }


}
