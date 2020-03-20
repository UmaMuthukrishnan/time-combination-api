package com.backend.exception;

/**
 * To throw an exception on runtime when there is invalid time in the given time range
 *
 * @author Uma Muthukrishnan
 * @version 1.0
 */
public class InvalidTimeException extends RuntimeException {

    public InvalidTimeException(String message) {
        super(message);
    }
}
