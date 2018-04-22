package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShipInGrid {

    private Ship aShip;
    private ResultShot state;
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
        return this.state;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof ShipInGrid)) {
            return Boolean.FALSE;
        }

        ShipInGrid newShip = (ShipInGrid) o;

        Optional<ShipPosition> anOptional = newShip.shipPositions.stream().filter(aPosition ->
                ( aPosition.getPosition().getHorizontalPosition().equals(this.getShipPositions().get(0).getPosition().getHorizontalPosition())) &&
                        aPosition.getPosition().getVerticalPosition().equals(this.getShipPositions().get(0).getPosition().getVerticalPosition())).findFirst();
        return anOptional.isPresent();
    }

    public boolean isThereAShipInSamePosition (ShipInGrid aShipInGrid) {
        return true;
    }

    public void shootInPosition(Position position) {
        Optional<ShipPosition> anOptional = this.shipPositions.stream().filter(aPosition ->
                (position.isEquals(aPosition.getPosition()))).findFirst();
        if (anOptional.isPresent()) {
            anOptional.get().receiveAShot();
        }
        this.actionState();
    }

    private void actionState () {
        long result = this.shipPositions.stream().filter(x -> x.hasShot()).count();
        this.state = (result == this.aShip.getLength() ? ResultShot.SUNKEN : ResultShot.TOUCHED);
    }
}