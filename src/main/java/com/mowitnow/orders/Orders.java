package com.mowitnow.orders;

import java.util.*;

/**
 * Collection of mower orders
 */
public class Orders implements Iterable<Order> {

    /**
     * Orders list
     */
    private List<Order> orders;

    /**
     * Use by scanner of orders
     */
    private static final String EMPTY_STRING = "";

    /**
     * Initialize orders list
     */
    public Orders() {
        this(new ArrayList<Order>());
    }

    /**
     * Set orders from a list of orders
     *
     * @param orders list of orders
     */
    private Orders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Set orders from a list of orders
     * @param ordersSequence Sequence of orders
     */
    public Orders(String ordersSequence) {
        this.orders = createOrders(ordersSequence);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }

    /**
     * Create orders by ordersSequence
     * @param ordersSequence String representing sequence of orders  example : AAGAAGA
     * @return List of orders
     */
    private List<Order> createOrders(String ordersSequence) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(ordersSequence).useDelimiter(EMPTY_STRING);
            List<Order> orders = new LinkedList<Order>();
            while (scanner.hasNext()) {
                Order order = OrderFactory.createOrder(scanner.next());
                orders.add(order);
            }
            return orders;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
