package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class ShipInGrid {

    private Ship aShip;

    private List<Position> positions = new ArrayList<>();

    public ShipInGrid(Position initialPosition, Integer lengthShip, boolean isVertical) {
        this.aShip = new Ship(lengthShip);
        for (int i = 0; i < this.aShip.getLength(); i++) {
            if (isVertical) {
                positions.add(new Position(initialPosition.getHorizontalPosition(), initialPosition.getVerticalPosition() + i));

            } else {
                positions.add(new Position(initialPosition.getHorizontalPosition() + i, initialPosition.getVerticalPosition()));
            }
        }
    }
}
