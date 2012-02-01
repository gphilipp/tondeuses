package com.mowitnow.environment;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Rectangular area to mow
 */
public class Area {

    /**
     * Different area's positions
     */
    private Set<Position> positions;

    /**
     * Mowers installed this area
     */
    private Set<Mower> mowers;

    /**
     * Area width
     */
    private int width;

    /**
     * Area length
     */
    private int length;

    /**
     * Constructs area
     * @param width area width
     * @param length area length
     */
    public Area(int width, int length) {
    	if(width < 0 || length < 0){
    		throw new InvalidAreaException("Width and length of area must be both positive.");
    	}
        this.positions = new HashSet<Position>();
        this.mowers = new LinkedHashSet<Mower>();
        this.width = width;
        this.length = length;
        initializeArea();
    }

    /**
     * Check if a position is an area position valid
     * @param position position to valid
     * @return true if position is valid
     */
    public boolean isValid(Position position) {
        return positions.contains(position) && doesNotCollideWith(position);
    }

    /**
     * Get mowers installed on area
     * @return mowers
     */
    public Set<Mower> getMowers() {
        return mowers;
    }

    /**
     * Initializes area
     */
    private void initializeArea() {
        for (int i = 0; i <= width; i++) {
            for (int j = 0; j <= length; j++) {
                Position position = new Position(i, j);
                positions.add(position);
            }
        }
    }

    /**
     * Check if an area position collides with other one
     * @param position current mower position
     * @return true if current mower position does not collide with other one in area
     */
    private boolean doesNotCollideWith(Position position) {
        for (Mower mower : mowers) {
            if (mower.getCurrentPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }
}
