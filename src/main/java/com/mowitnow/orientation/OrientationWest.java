package com.mowitnow.orientation;

import com.mowitnow.environment.Mower;
import com.mowitnow.environment.Position;

/**
 * Move mower when initially oriented to west
 */
class OrientationWest implements Orientation {

    @Override
    public void orientToLeft(Mower mower) {
        mower.setOrientation(new OrientationSouth());
    }

    @Override
    public void orientToRight(Mower mower) {
        mower.setOrientation(new OrientationNorth());
    }

    @Override
    public void forward(Mower mower) {
        Position currentPosition = mower.getCurrentPosition();
        Position nextPosition = currentPosition.removeX();
        if (!mower.moveTo(nextPosition)) {
            System.out.println("Cannot move from " + currentPosition.toString());
        }
    }

    @Override
    public CardinalDirection getCardinalDirection(){
        return CardinalDirection.W;
    }
}
