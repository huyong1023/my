package org.huyong.my.time;

import java.time.*;

/**
 * @Author: huyong03
 * @Date: 2022/8/11 14:54
 * @Description:
 */
public class TimeUnit {
    public static void main(String args[]) {
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println("-----");
        System.out.println(Year.now());
        System.out.println(YearMonth.now());
        System.out.println(MonthDay.now());


        System.out.println(LocalTime.of(22, 0, 20, 12));
        System.out.println(LocalDate.of(2021, 1, 20));
        System.out.println("----");
        System.out.println(LocalDateTime.of(2021, 1, 20, 22, 11, 3));
        // 也可以LocalDateTime.of(LocalDateTime,LocalTime)
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        System.out.println("---");
        System.out.println(Year.of(1658));
        System.out.println(YearMonth.of(2121, 5));
        System.out.println(MonthDay.of(1, 21));

    }
}
