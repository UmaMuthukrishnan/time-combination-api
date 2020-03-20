package com.backend;

import com.backend.timer.TimeValidatorTest;
import com.backend.timer.TimerServiceTest;
import com.backend.utils.TimeUtilTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Common class to run all the test cases in TimeUtilTest.class,TimeValidatorTest.class and TimerServiceTest.class
 *
 * @author Uma Muthukrishnan
 * @version 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TimeUtilTest.class, TimeValidatorTest.class, TimerServiceTest.class})
public class TestForAllClasses {
}
