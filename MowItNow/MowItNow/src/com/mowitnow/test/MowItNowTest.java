package com.mowitnow.test;

import com.mowitnow.environment.Area;
import com.mowitnow.environment.Gardener;
import com.mowitnow.environment.Mower;
import com.mowitnow.environment.Position;
import com.mowitnow.orders.Orders;
import com.mowitnow.orientation.CardinalDirection;
import com.mowitnow.orientation.Orientation;
import com.mowitnow.orientation.OrientationFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Test two mowers starting by the gardener  (without specification file but directly call
 * to explicit constructor of Gardener)
 */
public class MowItNowTest {

    /**
     * The gardener
     */
    private Gardener gardener;

    @Before
    public void initialize() {
        //Create Area
        Area area = new Area(5,5);
        // Orientation for the first mower
        Orientation orientation = OrientationFactory.createOrientation("N");
        //Create the first mower
        Mower mower1 = new Mower(new Position(1,2),orientation,area);
        //Create his orders
        Orders ordersForMower1 = new Orders("GAGAGAGAA");
        // Orientation for the second mower
        orientation = OrientationFactory.createOrientation("E");
        //Create the second mower
        Mower mower2 = new Mower(new Position(3,3),orientation,area);
        //Create orders for the second mower
        Orders ordersForMower2 = new Orders("AADAADADDA");
        //Regroup mowers with their respective order into LinkedHashMap (for keeping order insertions)
        Map<Mower,Orders> mowersWithOrders = new LinkedHashMap<Mower, Orders>();
        mowersWithOrders.put(mower1,ordersForMower1);
        mowersWithOrders.put(mower2,ordersForMower2);
        //Initializes the gardener
        gardener = new Gardener(area, mowersWithOrders);
    }


    @Test
    public void mow(){
        //Start to mow
        gardener.mow();
        Assert.assertTrue(gardener.getMowerWithOrders() instanceof LinkedHashMap);
        LinkedHashMap<Mower,Orders> mowersWithOrders = (LinkedHashMap<Mower,Orders>)gardener.getMowerWithOrders();
        Iterator<Map.Entry<Mower,Orders>> iterator = mowersWithOrders.entrySet().iterator();
        // Get mower 1
        Mower mower1 = iterator.next().getKey();
        Assert.assertEquals(mower1.getCurrentPosition(), new Position(1, 3));
        Assert.assertEquals(mower1.getOrientation().getCardinalDirection(), CardinalDirection.N);
        //Get mower 2
        Mower mower2 = (iterator.next().getKey());
        Assert.assertEquals(mower2.getCurrentPosition(), new Position(5, 1));
        Assert.assertEquals(mower2.getOrientation().getCardinalDirection(), CardinalDirection.E);
    }


}
