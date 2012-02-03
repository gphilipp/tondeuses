package com.mowitnow.orientation;

import com.mowitnow.environment.Mower;
import com.mowitnow.environment.Position;

/**
 * Move mower when initially oriented to left
 */
class OrientationEast implements Orientation {

    /** {@inheritDoc} */
    @Override
    public void orientToLeft(Mower mower){
       mower.setOrientation(new OrientationNorth());
    }

    /** {@inheritDoc} */
    @Override
    public void orientToRight(Mower mower){
      mower.setOrientation(new OrientationSouth());
    }

    /** {@inheritDoc} */
    @Override
    public void forward(Mower mower) {
        Position currentPosition = mower.getCurrentPosition();
        Position nextPosition = currentPosition.addX();
        if(!mower.moveTo(nextPosition)){
            System.out.println("Cannot move from " + currentPosition.toString());
        }
    }

    /** {@inheritDoc} */
    @Override
    public CardinalDirection getCardinalDirection(){
        return CardinalDirection.E;
    }


}
