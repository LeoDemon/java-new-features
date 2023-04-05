package tech.demonlee.swexpr.modern;

import lombok.extern.log4j.Log4j2;

import java.util.Calendar;

/**
 * @author Demon.Lee
 * @date 2023-04-06 00:19
 */
@Log4j2
public class DaysInMonth {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.FEBRUARY, 22);
        int daysInMonth = calculateDaysInMonth(calendar);
        log.info("daysInMonth: {}", daysInMonth);
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

        int daysInMonth = switch (month) {
            case Calendar.JANUARY,
                    Calendar.MARCH,
                    Calendar.MAY,
                    Calendar.JULY,
                    Calendar.AUGUST,
                    Calendar.OCTOBER,
                    Calendar.DECEMBER -> 31;
            case Calendar.APRIL,
                    Calendar.JUNE,
                    Calendar.SEPTEMBER,
                    Calendar.NOVEMBER -> 30;
            case Calendar.FEBRUARY -> {
                if ((0 == year % 400) || ((0 == year % 4) && 0 != year % 100)) {
                    yield 29;
                }
                yield 28;
            }
            default -> throw new RuntimeException("invalid month...");
        };

        log.info("month {} has {} days", month + 1, daysInMonth);

        return daysInMonth;
    }
}
