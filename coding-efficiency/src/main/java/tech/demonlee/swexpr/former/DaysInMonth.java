package tech.demonlee.swexpr.former;

import lombok.extern.log4j.Log4j2;

import java.util.Calendar;

/**
 * @author Demon.Lee
 * @date 2023-04-05 15:52
 * @desc not recommend this old style
 */
@Log4j2
public class DaysInMonth {

    public static void main(String[] args) {
        int daysInMonth = calculateDaysInMonthForNow();
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
        int daysInMonth;

        switch (month) {
            case Calendar.JANUARY:
            case Calendar.MARCH:
            case Calendar.MAY:
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.OCTOBER:
            case Calendar.DECEMBER:
                daysInMonth = 31;
                break;
            case Calendar.APRIL:
            case Calendar.JUNE:
            case Calendar.SEPTEMBER:
            case Calendar.NOVEMBER:
                daysInMonth = 30;
                break;
            case Calendar.FEBRUARY:
                daysInMonth = 28;
                if ((0 == year % 400) || ((0 == year % 4) && 0 != year % 100)) {
                    daysInMonth = 29;
                }
                break;
            default:
                throw new RuntimeException("invalid month...");
        }

        return daysInMonth;
    }
}
