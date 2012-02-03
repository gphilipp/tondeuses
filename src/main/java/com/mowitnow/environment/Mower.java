package com.mowitnow.environment;

import com.mowitnow.orders.Order;
import com.mowitnow.orders.Orders;
import com.mowitnow.orientation.Orientation;

/**
 * Mower used by gardener
 */
public class Mower {

    /**
     * Current mower position
     */
    private Position currentPosition;

    /**
     * Mower orientation set dynamically
     */
    private Orientation orientation;

    /**
     * Area where mowers are installed
     */
    private Area area;

    /**
     * Orders assigned by gardener to this mower
     */
    private Orders orders;

    /**
     * Constructs mower
     * @param initialPosition set the initialPosition
     * @param initialOrientation  set the initialOrientation
     * @param area the area
     */
    public Mower(Position initialPosition, Orientation initialOrientation, Area area) {
        if (initialPosition == null) {
            throw new IllegalArgumentException("Current position must not be null");
        }
        if (initialOrientation == null) {
            throw new IllegalArgumentException("Orientation must not be null");
        }
        if (area == null) {
            throw new IllegalArgumentException("Area must not be null");
        }
        if(!area.isValid(initialPosition)){
        	throw new InvalidPositionException("Mower position is out of area.");
        }
        this.currentPosition = initialPosition;
        this.orientation = initialOrientation;
        this.area = area;
        this.orders = new Orders();
    }

    /**
     * Get mower orientation
     * @return currentOrientation
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Set mower orientation
     * @param orientation new orientation
     */
    public void setOrientation(Orientation orientation) {
        if (orientation == null) {
            throw new IllegalArgumentException("Orientation must not be null");
        }
        this.orientation = orientation;
    }

    /**
     * Get current position
     * @return mower current position
     */
    public Position getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Set orders
     * @param orders mower orders
     */
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    /**
     * Returns true if the mower has moved forward on the area
     * @param position next Position
     * @return true if mower has moved
     */
    public boolean moveTo(Position position) {
        if (canMoveMow(position)) {
            currentPosition = position;
            return true;
        }
        return false;
    }

    /**
     * Start to execute mower orders
     */
    public void start() {
        for (Order order : orders) {
            order.execute(this);
        }
        // print new position
        System.out.println(getCurrentPosition().toString() + " " + getOrientation().getCardinalDirection().name());
    }

    /**
     * Get area
     * @return area
     */
    public Area getArea() {
        return area;
    }

    /**
     * Check whether  mower can move to next position
     * @param position potential next position
     * @return true if mower can effectively move
     */
    private boolean canMoveMow(Position position) {
        if (position != null) {
            return area.isValid(position);
        }
        return false;
    }
}
