package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class ShipInGrid {

    private Ship aShip;
    private List<ShipPosition> shipPositions = new ArrayList<>();


    public ShipInGrid(Position initialPosition, Integer lengthShip, boolean isVertical) {
        this.aShip = new Ship(lengthShip);
        for (int i = 0; i < this.aShip.getLength(); i++) {
            ShipPosition shipPosition;
            if (isVertical) {
                shipPosition = new ShipPosition(new Position(initialPosition.getHorizontalPosition(), initialPosition.getVerticalPosition() + i));

            } else {
                shipPosition = new ShipPosition(new Position(initialPosition.getHorizontalPosition() + i, initialPosition.getVerticalPosition()));
            }
            shipPositions.add(shipPosition);
        }
    }

    public List<ShipPosition> getShipPositions() {
        return this.shipPositions;
    }

    public ResultShot getState () {
        long result = this.shipPositions.stream().filter(x -> x.hasShot()).count();
        if (result == this.aShip.getLength()) {
            return ResultShot.SUNKEN;
        }
        return ResultShot.TOUCHED;
    }
}