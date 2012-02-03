package com.mowitnow.environment;


/**
 * Position on an area
 */
public class Position {

    /**
     * Position in width
     */
    private int x;

    /**
     * Position in length
     */
    private int y;

    /**
     * Construct a position
     * @param x Position in width
     * @param y Position in length
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Increase coordinate x
     * @return position
     */
    public Position addX() {
        return new Position(x + 1, y);
    }

    /**
     * Increase coordinate y
     * @return position
     */
    public Position addY() {
        return new Position(x, y + 1);
    }

    /**
     * Increase coordinate x
     * @return position
     */
    public Position removeX() {
        return new Position(x - 1, y);
    }

    /**
     * Increase coordinate y
     * @return position
     */
    public Position removeY() {
        return new Position(x, y - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
