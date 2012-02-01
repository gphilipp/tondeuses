package com.mowitnow.orders;

import com.mowitnow.environment.Mower;

/**
 * Order expecting mower to move forward
 */
class ForwardOrder implements Order {

    @Override
    /** {@inheritDoc} */
    public void execute(Mower mower) {
        mower.getOrientation().forward(mower);
    }


}
