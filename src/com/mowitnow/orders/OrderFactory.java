package com.mowitnow.orders;

/**
 * Factory to create order
 */
class OrderFactory {

    /**
     * Create order from an order name
     * @param orderName name of the order
     * @return an order
     */
    static Order createOrder(String orderName) {

        if (OrderName.A.name().equals(orderName)) {
            return new ForwardOrder();
        } else if (OrderName.D.name().equals(orderName)) {
            return new RightOrder();
        }
        if (OrderName.G.name().equals(orderName)) {
            return new LeftOrder();
        }
        throw new InvalidOrderException("Invalid Order " + orderName + ".");
    }

}
