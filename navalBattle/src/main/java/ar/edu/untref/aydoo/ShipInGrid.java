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

    public ResultShot getState () {
        return this.state;
    }

    public boolean isThereAShipInSamePosition (ShipInGrid aShipInGrid) {
        Optional<ShipPosition> anOptional = aShipInGrid.shipPositions.stream().filter(aPosition ->
        (aPosition.samePosition(this.shipPositions.get(0)))).findFirst();
        return anOptional.isPresent();
    }

    public void shootInPosition(Position position) {
        Optional<ShipPosition> anOptional = this.applyFilterInShipsPositions(position);
        if (anOptional.isPresent()) {
            anOptional.get().receiveAShot();
        }
        this.actionState();
    }

    public boolean presentAShipInPosition(Position aPosition) {
        Optional<ShipPosition> anOptional = this.applyFilterInShipsPositions(aPosition);
        return anOptional.isPresent();
    }

    private void actionState () {
        long result = this.shipPositions.stream().filter(x -> x.hasShot()).count();
        this.state = (result == this.aShip.getLength() ? ResultShot.SUNKEN : ResultShot.TOUCHED);
    }

    private Optional<ShipPosition> applyFilterInShipsPositions (Position aPosition) {
        return this.shipPositions.stream().filter(lambdaPosition ->
                (aPosition.isEquals(lambdaPosition.getPosition()))).findFirst();
    }

    public boolean isInTheLimits(final Position finalPosition) {
        Optional<ShipPosition> anOptional = this.shipPositions.stream().filter(lambdaPosition ->
                (finalPosition.isGreaterThan(lambdaPosition.getPosition()))).findFirst();
        return anOptional.isPresent();
    }
}