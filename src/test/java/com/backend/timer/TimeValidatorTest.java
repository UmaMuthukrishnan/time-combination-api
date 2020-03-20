package com.backend.timer;

import com.backend.exception.InvalidTimeException;
import org.junit.Test;

import java.time.format.DateTimeParseException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test class for TimeValidator
 * @author Uma Muthukrishnan
 * @version 1.0
 */
public class TimeValidatorTest {

    /**
     * Test to check if the given time is valid when valid times are given
     */
    @Test
    public void testForValidInputTime_When_Valid_Times_AreGiven() {
        var startTime = "00:00:00";
        var endTime = "01:00:00";
        assertTrue(TimeValidator.validInputTimes(startTime, endTime));
    }

    /**
     * Test to check if the given time is valid when startTime is greater than endTime is given
     *
     * @throws InvalidTimeException when startTime > endTime
     */
    @Test
    public void testForValidInputTime_When_startTime_GreaterThan_endTime_isGiven() {
        var startTime = "01:00:00";
        var endTime = "00:00:00";
        assertThatThrownBy(() -> TimeValidator.validInputTimes(startTime, endTime))
                .isInstanceOf(InvalidTimeException.class)
                .hasMessageContaining("StartTime should not be greater than EndTime");
    }

    /**
     * Test to check if the given times are valid when startTime and endTime same
     */
    @Test
    public void testForValidInputTime_When_startTime_And_endTime_AreEqual() {
        var startTime = "00:00:00";
        var endTime = "00:00:00";
        assertTrue(TimeValidator.validInputTimes(startTime, endTime));
    }

    /**
     * Test to check if the given times are valid when startTime is null
     */
    @Test
    public void testForValidInputTime_When_inputTime_isNull() {
        var endTime = "00:00:00";
        assertFalse(TimeValidator.validInputTimes(null, endTime));
    }

    /**
     * Test to check if the given times are valid when startTime is blank
     */
    @Test
    public void testForValidInputTime_When_inputTime_isBlank() {
        var endTime = "00:00:00";
        assertFalse(TimeValidator.validInputTimes(" ", endTime));
    }

    /**
     * Test to check if the given time is valid when inputTime is with invalid character
     *
     * @throws InvalidTimeException when inputTime format is invalid
     */
    @Test
    public void testForValidInputTime_When_inputTime_With_inValidCharacter() {
        var endTime = "00:00:00";
        assertThatThrownBy(() -> TimeValidator.validInputTimes("-", endTime))
                .isInstanceOf(InvalidTimeException.class)
                .hasMessageContaining("Invalid time format in '-'. \n" +
                        " Please enter time within range of 00:00:00 -23:59:59");
    }

    /**
     * Test to check if the given time is valid when inputTime is with invalid delimiter
     *
     * @throws InvalidTimeException when inputTime format is invalid
     */
    @Test
    public void testForValidInputTime_When_inputTime_With_inValidDelimiter() {
        var startTime = "00-00-00";
        var endTime = "01-00-00";
        assertThatThrownBy(() -> TimeValidator.validInputTimes(startTime, endTime))
                .isInstanceOf(InvalidTimeException.class)
                .hasMessageContaining("Invalid time format in '00-00-00'. \n" +
                        " Please enter time within range of 00:00:00 -23:59:59");
    }

    /**
     * Test to check if the given time is valid when inputTime is with invalid seconds
     *
     * @throws InvalidTimeException when inputTime format is invalid
     */

    @Test
    public void testForValidInputTime_When_Valid_Times_With_InvalidSeconds_AreGiven() {
        var startTime = "00:00:60";
        var endTime = "01:00:00";
        assertThatThrownBy(() -> TimeValidator.validInputTimes(startTime, endTime))
                .isInstanceOf(InvalidTimeException.class)
                .hasMessageContaining("Invalid time format in '00:00:60'. \n" +
                        " Please enter time within range of 00:00:00 -23:59:59");
    }

    /**
     * Test to check if the given time is valid when inputTime is with invalid minutes
     *
     * @throws InvalidTimeException when inputTime format is invalid
     */
    @Test
    public void testForValidInputTime_When_Valid_Times_With_InvalidMinutes_AreGiven() {
        var startTime = "00:71:00";
        var endTime = "01:00:00";
        assertThatThrownBy(() -> TimeValidator.validInputTimes(startTime, endTime))
                .isInstanceOf(InvalidTimeException.class)
                .hasMessageContaining("Invalid time format in '00:71:00'. \n" +
                        " Please enter time within range of 00:00:00 -23:59:59");
    }

    /**
     * Test to check if the given time is valid when inputTime is with invalid hour
     *
     * @throws DateTimeParseException when inputTime is with invalid hour
     */
    @Test
    public void testForValidInputTime_When_Valid_Times_With_InvalidHour_isGiven() {
        var startTime = "00:00:00";
        var endTime = "24:00:00";
        assertThatThrownBy(() -> TimeValidator.validInputTimes(startTime, endTime))
                .isInstanceOf(DateTimeParseException.class)
                .hasMessageContaining("Invalid value for HourOfDay (valid values 0 - 23): 24");
    }

    /**
     * Test to check if the given time is valid when inputTime is without seconds
     *
     * @throws InvalidTimeException when inputTime format is invalid
     */
    @Test
    public void testForValidInputTime_When_Valid_Times_Without_Seconds_AreGiven() {
        var startTime = "00:00";
        var endTime = "01:00:00";
        assertThatThrownBy(() -> TimeValidator.validInputTimes(startTime, endTime))
                .isInstanceOf(InvalidTimeException.class)
                .hasMessageContaining("Invalid time format in '00:00'. \n" +
                        " Please enter time within range of 00:00:00 -23:59:59");
    }

    /**
     * Test to check if the given time is valid when inputTime is with invalid format
     *
     * @throws InvalidTimeException when inputTime format is invalid
     */
    @Test
    public void testForValidInputTime_When_Time_With_Invalid_Format_isGiven() {
        var startTime = "00/00/00";
        var endTime = "01:00:00";
        assertThatThrownBy(() -> TimeValidator.validInputTimes(startTime, endTime))
                .isInstanceOf(InvalidTimeException.class)
                .hasMessageContaining("Invalid time format in '00/00/00'");
    }

    /**
     * Test to check if the given time is valid when inputTime is with Alphanumeric
     *
     * @throws InvalidTimeException when inputTime format is invalid
     */
    @Test
    public void testForValidInputTime_When_Time_With_AlphaNumeric_isGiven() {
        var startTime = "00:00:00";
        var endTime = "01:01 AM";
        assertThatThrownBy(() -> TimeValidator.validInputTimes(startTime, endTime))
                .isInstanceOf(InvalidTimeException.class)
                .hasMessageContaining("Invalid time format in '01:01 AM'. \n" +
                        " Please enter time within range of 00:00:00 -23:59:59 ");
    }


}
