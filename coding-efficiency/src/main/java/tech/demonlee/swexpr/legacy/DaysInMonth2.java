package tech.demonlee.swexpr.legacy;

import lombok.extern.log4j.Log4j2;

import java.util.Calendar;

/**
 * @author Demon.Lee
 * @date 2023-04-06 08:10
 * @desc not recommend this mixed style yet
 */
@Log4j2
public class DaysInMonth2 {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.FEBRUARY, 12);
        log.info("daysInMonth: {}", calculateDaysInMonth(calendar));
        calendar.set(2023, Calendar.FEBRUARY, 20);
        log.info("daysInMonth: {}", calculateDaysInMonth(calendar));
    }

    static int calculateDaysInMonthForNow() {
        Calendar today = Calendar.getInstance();
        return calculateDaysInMonth(today);
    }

    static int calculateDaysInMonth(Calendar calendar) {
        if (null == calendar) {
            throw new RuntimeException("invalid calendar...");
        }
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int daysInMonth;
        switch (month) {
            case Calendar.JANUARY,
                    Calendar.MARCH,
                    Calendar.MAY,
                    Calendar.JULY,
                    Calendar.AUGUST,
                    Calendar.OCTOBER,
                    Calendar.DECEMBER -> daysInMonth = 31;
            case Calendar.APRIL,
                    Calendar.JUNE,
                    Calendar.SEPTEMBER,
                    Calendar.NOVEMBER -> daysInMonth = 30;
            case Calendar.FEBRUARY -> {
                if ((0 == year % 400) || ((0 == year % 4) && 0 != year % 100)) {
                    daysInMonth = 29;
                    break; // exit the switch statement
                }
                daysInMonth = 28; // cannot use `yield` key word here
            }
            default -> throw new RuntimeException("invalid month...");
        }

        return daysInMonth;
    }
}
