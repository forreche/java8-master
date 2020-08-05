package com.fangxiaobin.java8.chapter14;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-06 04:25
 * <p>
 * description
 **/
public class DateTest {

    public static void main(String[] args) throws InterruptedException {
/*        testLocalDate();
        testLocalTime();
        combineLocalDateAndTime();
         testInstant();
         testDuration();
        testPeriod();
        testDateFormat();
         */


        testDateParse();


    }

    private static void testLocalDate() {
        LocalDate localDate = LocalDate.of(2020, 11, 07);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfYear());

    }


    private static void testLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getNano());
        System.out.println(localTime.getSecond());
    }

    private static void combineLocalDateAndTime() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime.toString());

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

    }

    private static void testInstant() throws InterruptedException {

        Instant instant = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();
        //Duration 时间段
        Duration duration = Duration.between(instant, end);
        System.out.println(duration.toMillis());

    }

    private static void testDuration() {
        LocalTime start = LocalTime.now();
        LocalTime localTime = start.minusHours(1);

        Duration duration = Duration.between(start, localTime);
        System.out.println(duration.toHours());
    }

    private static void testPeriod() {
        Period between = Period.between(LocalDate.of(110, 10, 20), LocalDate.of(2020, 01, 01));
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
        System.out.println(between.getYears());
    }


    private static void testDateFormat() {
        LocalDate localDate = LocalDate.now();
        String format1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(format1);

        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = localDate.format(ofPattern);
        System.out.println(format);
    }

    private static void testDateParse() {
        String date = "20200806";
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);

        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = "2020-08-06";

        LocalDate localDate1 = LocalDate.parse(date1, ofPattern);
        System.out.println(localDate);
        System.out.println(localDate1);

    }

}
