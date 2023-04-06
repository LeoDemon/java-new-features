package tech.demonlee.swexpr.legacy;

import lombok.extern.log4j.Log4j2;

import java.util.Calendar;

/**
 * @author Demon.Lee
 * @date 2023-04-06 08:10
 * @desc not recommend this mixed style
 */
@Log4j2
public class DaysInMonth {

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
        return switch (month) {
            case Calendar.JANUARY:
            case Calendar.MARCH:
            case Calendar.MAY:
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.OCTOBER:
            case Calendar.DECEMBER:
                yield 31;
                // break; // cannot use `break` key word here
            case Calendar.APRIL:
            case Calendar.JUNE:
            case Calendar.SEPTEMBER:
            case Calendar.NOVEMBER:
                yield 30;
                // break;
            case Calendar.FEBRUARY:
                if ((0 == year % 400) || ((0 == year % 4) && 0 != year % 100)) {
                    yield 29;
                }
                yield 28;
                // break;
            default:
                throw new RuntimeException("invalid month...");
        };
    }
}
