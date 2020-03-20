package com.backend.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Util class for TimerService .
 *
 * @author Uma Muthukrishnan
 * @version 1.0
 */
public class TimeUtil {

    public static final String TIME_PATTERN = "HH:mm:ss";

    /**
     * Method to get LocalTime format from a given string
     *
     * @param inputTime inputTime as String
     * @return LocalTime as datatype
     */
    public static LocalTime getLocalTimeFromString(String inputTime) {
        return LocalTime.parse(inputTime.strip(), DateTimeFormatter.ofPattern(TIME_PATTERN));
    }

    /**
     * Method to get String format from a given LocalTime
     *
     * @param localTime inputTime as LocalTime
     * @return String as datatype
     */
    public static String getStringFromLocalTime(LocalTime localTime) {
        return localTime.format(DateTimeFormatter.ofPattern(TIME_PATTERN));
    }
}
