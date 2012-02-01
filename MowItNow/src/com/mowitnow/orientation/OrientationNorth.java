package com.mowitnow.orientation;

import com.mowitnow.environment.Mower;
import com.mowitnow.environment.Position;

/**
 * Move mower when initially oriented to north
 */
class OrientationNorth implements Orientation {

    @Override
    public void orientToLeft(Mower mower){
       mower.setOrientation(new OrientationWest());
    }

    @Override
    public void orientToRight(Mower mower){
      mower.setOrientation(new OrientationEast());
    }

    @Override
    public void forward(Mower mower) {
        Position currentPosition = mower.getCurrentPosition();
        Position nextPosition = currentPosition.addY();
        if(!mower.moveTo(nextPosition)){
            System.out.println("Cannot move from " + currentPosition.toString());
        }
    }

    @Override
    public CardinalDirection getCardinalDirection(){
        return CardinalDirection.N;
    }

}
