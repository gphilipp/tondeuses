package com.mowitnow.orientation;

import com.mowitnow.environment.InvalidPositionException;

/**
 * Factory creating Orientation
 */
public class OrientationFactory {

    /**
     * Static factory for creating Orientation
     * @param orientation orientation (N,S,E or W)
     * @return an orientation
     */
    public static Orientation createOrientation(String orientation) {
        if(CardinalDirection.N.name().equals(orientation)){
          return new OrientationNorth();
        }
        else if(CardinalDirection.S.name().equals(orientation)){
          return new OrientationSouth();
        }
        else if(CardinalDirection.E.name().equals(orientation)){
          return new OrientationEast();
        }
        else if(CardinalDirection.W.name().equals(orientation)){
          return new OrientationWest();
        }
        else{
            throw new InvalidPositionException("Orientation " + orientation + " is not valid.");
        }
    }
}
