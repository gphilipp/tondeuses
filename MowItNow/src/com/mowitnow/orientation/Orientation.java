package com.mowitnow.orientation;

import com.mowitnow.environment.Mower;

/**
 * Mower orientation
 */
public interface Orientation {

    /**
     * Orient mower to left
     * @param mower the mower
     */
    void orientToLeft(Mower mower);

    /**
     * Orient mower to right
     * @param mower the mower
     */
    void orientToRight(Mower mower);

    /**
     * Move mower forward
     * @param mower the mower
     */
    void forward(Mower mower);

    /**
     * Get cardinal direction of mower
     * @return cardinal direction
     */
    CardinalDirection getCardinalDirection();

}
