package com.backend.timer;

import com.backend.exception.InvalidTimeException;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for TimeService
 *
 * @author Uma Muthukrishnan
 * @version 1.0
 */
public class TimerServiceTest {


    TimerService timerService;

    @Before
    public void setUp() {
        timerService = new TimerService();
    }

    /**
     * Test to get possible count of two digits when valid times are given
     */
    @Test
    public void testForPossibleCount_With_validTimes() {
        var startTime = "16:15:00";
        var endTime = "17:00:00";
        assertThat(timerService.count(startTime, endTime), is(2));
    }

    @Test
    public void testForPossibleCount_With_validTimesRange() {
        var startTime = "00:01:00";
        var endTime = "23:59:59";
        assertThat(timerService.count(startTime, endTime), is(482));
    }

    /**
     * Test to get possible count of two digits when startTime and endTime are same
     * if the combination of 2 digit occurs in inputString ,then it will also be counted
     */
    @Test
    public void testForPossibleCount_With_same_startAndEndTimes() {
        var startTime = "16:16:16";
        var endTime = "16:16:16";
        assertThat(timerService.count(startTime, endTime), is(0));
    }

    /**
     * Test to get possible count of two digits when startTime contains 2 digits
     * if the combination of 2 digit occurs in startTime ,then it will also be counted
     */
    @Test
    public void testForPossibleCount_With_TwoDigits_in_startTime() {
        var startTime = "17:17:17";
        var endTime = "17:17:18";
        assertThat(timerService.count(startTime, endTime), is(1));
    }

    /**
     * Test to get possible count of two digits when endTime contains 2 digits
     * if the combination of 2 digit occurs in endTime ,then it will not be counted
     */
    @Test
    public void testForPossibleCount_With_TwoDigits_in_endTime() {
        var startTime = "17:17:16";
        var endTime = "17:17:17";
        assertThat(timerService.count(startTime, endTime), is(0));
    }

    /**
     * Test to get possible count of two digits when startTime is greater than endTime
     *
     * @throws InvalidTimeException when startTime > endTime
     */
    @Test
    public void testForPossibleCount_With_inValidTimes() {
        var startTime = "17:00:00";
        var endTime = "16:00:00";
        assertThatThrownBy(() -> timerService.count(startTime, endTime))
                .isInstanceOf(InvalidTimeException.class)
                .hasMessageContaining("StartTime should not be greater than EndTime");
    }

    /**
     * Test to get possible count of two digits when endTime is less than startTime
     *
     * @throws InvalidTimeException when startTime > endTime
     */
    @Test
    public void testForPossibleCount_With_inValidEndTime() {
        var startTime = "17:00:00";
        var endTime = "00:00:00";
        assertThatThrownBy(() -> timerService.count(startTime, endTime))
                .isInstanceOf(InvalidTimeException.class)
                .hasMessageContaining("StartTime should not be greater than EndTime");
    }


    /**
     * Test to get no of digits in a given string
     */
    @Test
    public void testToGetNoOfDigitCount() {
        var numericString = "1234110789";
        assertThat((int) numericString.chars().distinct().count(), is(8));
    }


}
