package com.mowitnow.orders;

/**
 * Runtime exception in case of an invalid order
 */
@SuppressWarnings("serial")
public class InvalidOrderException extends RuntimeException {

    public InvalidOrderException(String message) {
        super(message + "\n Orders must be a sequence of char. Either D(droite),G(gauche) or A(avancer) => " +
                "for instance : GAGAADA");
    }

    /**
     * When exception thrown while parsing specification file
     * @param message message
     * @param currentLine  current line in file
     */
    public InvalidOrderException(String message, int currentLine) {
         super(" At line : " + currentLine + " => " + message);
    }
}
