package com.backend.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.DateTimeException;
import java.time.LocalTime;

/**
 * Test class for TimeUtil
 * @author Uma Muthukrishnan
 * @version 1.0
 */
public class TimeUtilTest {

    private static final String TIME_DELIMITER = ":";

    /**
     * Test to get formatted string when only valid Hours and Minutes are given
     */
    @Test
    public void testForFormattedString_When_HourAndMinutesAreGiven() {
        var stringToBeFormatted = LocalTime.of(2, 30);
        var formattedString = TimeUtil.getDateTimeFormatter().format(stringToBeFormatted);
        var formattedTimeArray = formattedString.split(TIME_DELIMITER);
        assertEquals("02:30:00", formattedString);
        assertThat(formattedTimeArray.length, is(3));
    }

    /**
     * Test to get formatted string when valid Hours,Minutes and Seconds are given
     */
    @Test
    public void testForFormattedString_When_Hour_MinutesAndSecondsAreGiven() {
        var stringToBeFormatted = LocalTime.of(2, 14, 0);
        var formattedString = TimeUtil.getDateTimeFormatter().format(stringToBeFormatted);
        var formattedTimeArray = formattedString.split(TIME_DELIMITER);
        assertEquals("02:14:00", formattedString);
        assertThat(formattedTimeArray.length, is(3));
    }

    /**
     * Test to get formatted string when invalid Hours is given
     *
     * @throws DateTimeException when the hour is not in the range between 00 -23
     */
    @Test(expected = DateTimeException.class)
    public void testForFormattedString_When_Invalid_Hour_IsGiven() {
        var stringToBeFormatted = LocalTime.of(27, 14, 0);
        var formattedString = TimeUtil.getDateTimeFormatter().format(stringToBeFormatted);
        assertNull(formattedString);

    }

    /**
     * Test to get formatted string when invalid Minutes are given
     *
     * @throws DateTimeException when the minutes are not in the range between 00 -59
     */
    @Test(expected = DateTimeException.class)
    public void testForFormattedString_When_Invalid_Minutes_AreGiven() {
        var stringToBeFormatted = LocalTime.of(2, 61, 0);
        var formattedString = TimeUtil.getDateTimeFormatter().format(stringToBeFormatted);
        assertNull(formattedString);

    }

    /**
     * Test to get formatted string when invalid seconds are given
     *
     * @throws DateTimeException when the seconds are not in the range between 00 -59
     */
    @Test(expected = DateTimeException.class)
    public void testForFormattedString_When_Invalid_Seconds_AreGiven() {
        var stringToBeFormatted = LocalTime.of(2, 31, 74);
        var formattedString = TimeUtil.getDateTimeFormatter().format(stringToBeFormatted);
        assertNull(formattedString);

    }

    /**
     * Test to get no of digits in a given string
     */
    @Test
    public void testToGetNoOfDigitCount() {
        var numericString = "1234110789";
        assertThat(TimeUtil.getNoOfDigitCount(numericString), is(8));
    }

}
