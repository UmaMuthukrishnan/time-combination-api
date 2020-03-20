package com.backend.timer;

import com.backend.utils.TimeUtil;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Service class for getting the appearance of two digits in a given time range .
 * @author Uma Muthukrishnan
 * @version 1.0
 */
public final class TimerService {
    public static final Integer MINIMUM_DIGITS = 2;
    public static final String TIME_DELIMITER = ":";
    public static final String EMPTY_STRING = "";

    /**
     * Method which calculates the amount of times where only 2 digits appear
     * in every possible combination in a specific time range
     *
     * It also checks for the startTime/endTime which do holds only two digits
     *
     * @param startTime startTime in HH:MM:SS  format where HH is for hours (24 format), MM is for minutes and SS is for seconds
     * @param endTime   endTime in HH:MM:SS  format where HH is for hours (24 format), MM is for minutes and SS is for second
     * @return count as integer datatype
     */
    public int count(String startTime, String endTime) {
        AtomicInteger counter = new AtomicInteger();
        if (TimeValidator.validInputTimes(startTime, endTime)) {
            var timeRangeList = Stream.iterate(LocalTime.parse(startTime.strip()),
                    startTimeValue -> LocalTime.parse(endTime.strip()).compareTo(startTimeValue) >= 0,
                    (startTimeValue) -> startTimeValue.plusSeconds(1)).collect(Collectors.toList());

            if (timeRangeList.size() > 0) {
                DateTimeFormatter formatter = TimeUtil.getDateTimeFormatter();
                timeRangeList.forEach(timeRange -> {
                    var formattedStartTime = formatter.format(timeRange);
                    var startTimeArray = formattedStartTime.split(TIME_DELIMITER);
                    var startTimeString = String.join(EMPTY_STRING, startTimeArray).strip();
                    var digitCount = TimeUtil.getNoOfDigitCount(startTimeString);
                    if (digitCount == MINIMUM_DIGITS) {
                        counter.getAndIncrement();
                    }
                });
            }
        }
        return counter.get();
    }
}
