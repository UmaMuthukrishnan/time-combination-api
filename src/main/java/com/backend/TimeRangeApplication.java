package com.backend;

import java.util.Scanner;

import com.backend.timer.TimerService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Main Class for TimeRange Application
 * @author Uma Muthukrishnan
 * @version 1.0
 */
public final class TimeRangeApplication {

    private static final Logger LOGGER = Logger.getLogger(TimeRangeApplication.class.getName());

    /**
     * Main Method for entering the Timer service
     *
     * @param args accepts user input for both startTime and endTime
     */
    public static void main(final String[] args) {

        //configuring log4j properties
        BasicConfigurator.configure();
        Scanner reader = new Scanner(System.in);
        LOGGER.info("Enter the Start Time in HH:mm:ss format ");
        String startTime = reader.next();
        reader = new Scanner(System.in);
        LOGGER.info("Enter the End Time in HH:mm:ss format");
        String endTime = reader.next();
        TimerService timerService = new TimerService();
        int count = timerService.count(startTime, endTime);
        LOGGER.info("Possible count of two digits in a given time range is : " + count);


    }


}
