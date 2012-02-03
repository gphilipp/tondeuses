package com.mowitnow.environment;

import com.mowitnow.orders.Orders;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Gardener that aims to install
 */
public class Gardener {

    /**
     * Map of Mowers with their respective orders
     */
    private Map<Mower, Orders> mowerWithOrders;

    /**
     * Area where mowers are installed
     */
    private Area area;

    /**
     * Gardener parses his specification to mow the area
     * @param specFilePath specification file path
     * @throws FileNotFoundException when file isn't found
     */
    public Gardener(String specFilePath) throws FileNotFoundException {
        SpecParser specParser = new SpecParser();
        specParser.parse(specFilePath);
        // get the area
        this.area = specParser.getArea();
        // get mowers associated to their orders
        this.mowerWithOrders = specParser.getMowerWithOrders();
    }

    /**
     * Alternative constructor for creating environment without file => Tests for instance
     * @param area the area
     * @param mowerWithOrders mowers associated with their respective orders
     */
    public Gardener(Area area, Map<Mower,Orders> mowerWithOrders){
        // get the area
        this.area = area;
        // get mowers associated to their orders
        this.mowerWithOrders = mowerWithOrders;
    }

    /**
     * Process to mow area
     */
    public void mow() {
        installMowers();
        startMowers();
    }

    public Map<Mower, Orders> getMowerWithOrders() {
        return mowerWithOrders;
    }

    /**
     * Install mowers
     */
    private void installMowers() {
        for (Map.Entry<Mower, Orders> entry : mowerWithOrders.entrySet()) {
            //Assign orders to mower
            entry.getKey().setOrders(entry.getValue());
            //install mowers to area
            area.getMowers().add(entry.getKey());
        }
    }

    /**
     * Starts mowers
     */
    private void startMowers() {
        for (Mower mower : area.getMowers()) {
            mower.start();
        }
    }


}
