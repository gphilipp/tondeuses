package com.mowitnow.orders;

import com.mowitnow.environment.Mower;

public interface Order {

    /**
     * Execute mower order
     * @param mower the mower concerned
     */
    void execute(Mower mower);

}
