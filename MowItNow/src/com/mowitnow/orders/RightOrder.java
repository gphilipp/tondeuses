package com.mowitnow.orders;

import com.mowitnow.environment.Mower;

/**
 * Order expecting mower to orient itself to right
 */
class RightOrder implements Order {

    /** {@inheritDoc} */
    @Override
    public void execute(Mower mower) {
        mower.getOrientation().orientToRight(mower);
    }
}
