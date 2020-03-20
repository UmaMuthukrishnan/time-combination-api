package com.backend.timer;

import com.backend.exception.InvalidTimeException;
import com.backend.utils.TimeUtil;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Validator for Input Times provided by the user.
 * @author Uma Muthukrishnan
 * @version 1.0
 */
public class TimeValidator {


    /**
     * Method to validate whether the given string is in valid format or not
     *
     * @param inputTime input time provided by the user
     * @return true if valid else false
     */
    private static boolean validateInputTime(String inputTime) {
        if (inputTime == null || inputTime.isBlank()) {
            return false;
        } else {
            DateTimeFormatter formatter = TimeUtil.getDateTimeFormatter();
            try {
                formatter.parse(inputTime);
            } catch (Exception e) {
                throw new InvalidTimeException("Invalid time format in '" + inputTime + "'. \n " +
                        "Please enter time within range of 00:00:00 -23:59:59 ");
            }
            return true;
        }
    }

    /**
     * Method to validate both startTime and endTime provided by the user
     *
     * @param startTime start time provided by the user
     * @param endTime   end time provided by the user
     * @return true if valid else false
     */
    public static boolean validInputTimes(String startTime, String endTime) {
        boolean valid = false;
        if (validateInputTime(startTime) && validateInputTime(endTime)) {
            LocalTime localStartTime = LocalTime.parse(startTime);
            LocalTime localEndTime = LocalTime.parse(endTime);
            if (localStartTime.isBefore(localEndTime)) {
                valid = true;//If startTime is before the endTime
            } else if (localStartTime.equals(localEndTime)) {
                valid = true;//If two times are equal
            } else if (localEndTime.compareTo(localStartTime) > 0) {
                valid = true;//If endTime is greater than startTime
            } else if (localStartTime.compareTo(localEndTime) > 0) {
                throw new InvalidTimeException("StartTime should not be greater than EndTime");
            } else {
                valid = false;
            }

        }
        return valid;
    }
}
