package com.mowitnow.environment;

/**
 * Runtime exception in case of an invalid position
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException {

    public InvalidPositionException(String message) {
        super(message + "\n The right syntax for mower position is : X Y {N,S,E,W} => for instance : 1 2 N " +
        		"and be contained in area");
    }

    /**
     * When exception thrown while parsing specification file
     * @param message message
     * @param currentLine  current line in file
     */
    InvalidPositionException(String message, int currentLine) {
        super(" At line : " + currentLine + " => " + message);
    }

}
