package com.backend.utils;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * Util class for TimerService .
 * @author Uma Muthukrishnan
 * @version 1.0
 */
public class TimeUtil {

    public static final String TIME_PATTERN = "HH:mm:ss";

    /**
     * Method to get required date formatter
     *
     * @return dateFormatter object with the pattern 'HH:mm:ss'
     */
    public static DateTimeFormatter getDateTimeFormatter() {
        return new DateTimeFormatterBuilder()
                .appendPattern(TIME_PATTERN)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .toFormatter();
    }

    /**
     * Method to get total number of digits in a given string
     *
     * @param checkString accepts a string with combination of numbers
     * @return number of digits in a string as integer datatype
     */
    public static int getNoOfDigitCount(CharSequence checkString) {
        return (int) checkString.chars().distinct().count();

    }
}
