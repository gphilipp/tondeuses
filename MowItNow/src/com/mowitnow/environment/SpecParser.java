package com.mowitnow.environment;


import com.mowitnow.orders.InvalidOrderException;
import com.mowitnow.orders.Orders;
import com.mowitnow.orientation.Orientation;
import com.mowitnow.orientation.OrientationFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Specification parser - Specification provides by user
 */
class SpecParser {

    /**
     * Area to mow
     */
    private Area area;

    /**
     * Map that contains mowers with their respective orders
     */
    private Map<Mower, Orders> mowerWithOrders;

    /**
     * Initializes map with a LinkedHashMap (for keeping insertions order of mowers)
     */
    SpecParser() {
        this.mowerWithOrders = new LinkedHashMap<Mower, Orders>();
    }

    /**
     * Parse specification file (contains size of area, mowers positions and mowers orders)
     *
     * @param specPathFile path file specification used by gardener
     * @throws FileNotFoundException when specification file is not found
     */
    void parse(String specPathFile) throws FileNotFoundException {
        Scanner scanner = null;
        BufferedReader specReader;
        int currentLine = 0;
        try {
            specReader = new BufferedReader(new FileReader(specPathFile));
            scanner = new Scanner(specReader);
            if (scanner.hasNextLine()) {
                // Get area
                area = readAreaSize(scanner.nextLine(), ++currentLine);
            }
            Mower mower = null;
            Orders orders = null;
            while (scanner.hasNextLine()) {
                if (scanner.hasNextLine()) {
                    // Get mower
                    mower = readMower(scanner.nextLine(), ++currentLine);
                }
                if (scanner.hasNextLine()) {
                    // Get orders
                    orders = readOrders(scanner.nextLine(), ++currentLine);
                }
                this.mowerWithOrders.put(mower, orders);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Get area
     *
     * @return the area
     */
    Area getArea() {
        return area;
    }

    /**
     * Get map containing mowers with their orders
     *
     * @return map  : mower/orders
     */
    Map<Mower, Orders> getMowerWithOrders() {
        return mowerWithOrders;
    }

    /**
     * Read the size of area
     *
     * @param areaLine line corresponding to the initialization of area in specification file
     * @return the area
     */
    private Area readAreaSize(String areaLine, int currentLine) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(areaLine);
            if (scanner.hasNextInt()) {
                int width = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    int length = scanner.nextInt();
                    return new Area(width, length);
                }
            }
            throw new InvalidAreaException("This area's size is not valid : " + areaLine);
        }
        catch(InvalidAreaException e){
            throw new InvalidAreaException(e.getMessage(),currentLine);
        }finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Read mower
     *
     * @param mowPositionLine line corresponding to mower positions in specification file
     * @return mower
     */
    private Mower readMower(String mowPositionLine, int currentLine) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(mowPositionLine);
            if (scanner.hasNextInt()) {
                int posX = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    int posY = scanner.nextInt();
                    if (scanner.hasNext()) {
                        String cardinalDirection = scanner.next();
                        Position position = new Position(posX, posY);
                        Orientation orientation = OrientationFactory.createOrientation(cardinalDirection);
                        return new Mower(position, orientation, area);
                    }
                }
            }
            throw new InvalidPositionException("this mower's position is not valid : " + mowPositionLine);
        }
        catch(InvalidPositionException e){
            throw new InvalidPositionException(e.getMessage(),currentLine);
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Read orders
     *
     * @param ordersLine line corresponding to mower orders in specification file
     * @return orders for a mower
     */
    private Orders readOrders(String ordersLine, int currentLine) {
        try{
        return new Orders(ordersLine);
        }catch(InvalidOrderException e){
            throw new InvalidOrderException(e.getMessage(),currentLine);
        }
    }
}
