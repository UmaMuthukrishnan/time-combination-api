package com.backend.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 * Test class for TimeUtil
 *
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
        var formattedString = TimeUtil.getStringFromLocalTime(stringToBeFormatted);
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
        var formattedString = TimeUtil.getStringFromLocalTime(stringToBeFormatted);
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
        var formattedString = TimeUtil.getStringFromLocalTime(stringToBeFormatted);
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
        var formattedString = TimeUtil.getStringFromLocalTime(stringToBeFormatted);
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
        var formattedString = TimeUtil.getStringFromLocalTime(stringToBeFormatted);
        assertNull(formattedString);

    }

    /**
     * Test to get formatted LocalTime when valid inputTime is given
     */
    @Test
    public void testForLocalTime_When_String_isGiven() {
        var stringTime = "02:30:00";
        var localTimeFromString = TimeUtil.getLocalTimeFromString(stringTime);
        assertEquals(LocalTime.of(2, 30), localTimeFromString);
    }

    /**
     * Test to get formatted LocalTime when invalid seconds in inputTime are given
     *
     * @throws DateTimeParseException when seconds in inputTime  are not in the range between 00 -59
     */
    @Test
    public void testForLocalTime_When_Invalid_Seconds_In_String_isGiven() {
        var stringTime = "02:30:60";
        assertThatThrownBy(() -> TimeUtil.getLocalTimeFromString(stringTime))
                .isInstanceOf(DateTimeParseException.class)
                .hasMessageContaining("Invalid value for SecondOfMinute (valid values 0 - 59): 60");
    }

    /**
     * Test to get formatted LocalTime when invalid minutes in inputTime are given
     *
     * @throws DateTimeParseException when minutes in inputTime  are not in the range between 00 -59
     */
    @Test
    public void testForLocalTime_When_Invalid_Minutes_In_String_isGiven() {
        var stringTime = "02:60:59";
        assertThatThrownBy(() -> TimeUtil.getLocalTimeFromString(stringTime))
                .isInstanceOf(DateTimeParseException.class)
                .hasMessageContaining("Invalid value for MinuteOfHour (valid values 0 - 59): 60");
    }

    /**
     * Test to get formatted LocalTime when invalid hour in inputTime is given
     *
     * @throws DateTimeParseException when hour in inputTime  is not in the range between 00 -23
     */
    @Test
    public void testForLocalTime_When_Invalid_Hours_In_String_isGiven() {
        var stringTime = "24:59:59";
        assertThatThrownBy(() -> TimeUtil.getLocalTimeFromString(stringTime))
                .isInstanceOf(DateTimeParseException.class)
                .hasMessageContaining("Invalid value for HourOfDay (valid values 0 - 23): 24");
    }

}
