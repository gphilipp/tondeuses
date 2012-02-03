package com.mowitnow.environment;

/**
 * Runtime exception in case of an invalid area
 */
@SuppressWarnings("serial")
class InvalidAreaException extends RuntimeException {

    InvalidAreaException(String message) {
        super(message + "\n The right syntax for size of area is : X(>0) Y(>0) => for instance : 5 5 ");
    }

    /**
     * When exception thrown while parsing specification file
     * @param message message
     * @param currentLine  current line in file
     */
    InvalidAreaException(String message, int currentLine) {
        super(" At line : " + currentLine + " => " + message);
    }
}
