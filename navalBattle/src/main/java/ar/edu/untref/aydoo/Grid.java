package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private Position finalPosition;
    private List<ShipInGrid> shipsInGrid = new ArrayList<>();
    private final static String MSG_NON_EXISTENT = "non-existent position";

    public Grid (Position finalPosition) {
        this.finalPosition = finalPosition;
    }

    public String putShipInGrid(ShipInGrid aShipInGrid) {
        String message = MSG_NON_EXISTENT;
        if (aShipInGrid.getPositions().get(0).getHorizontalPosition() <= this.finalPosition.getHorizontalPosition()
                || aShipInGrid.getPositions().get(0).getHorizontalPosition() <= this.finalPosition.getHorizontalPosition()) {
            shipsInGrid.add(aShipInGrid);
            message = "INSERT OK";
        }
        return message;
    }

    public boolean hasAShip(Position position) {

        for (ShipInGrid itemShipInGrid : this.shipsInGrid) {
            for (Position itemPosition : itemShipInGrid.getPositions()) {
                if (itemPosition.getHorizontalPosition() == position.getHorizontalPosition() &&
                    itemPosition.getVerticalPosition() == position.getVerticalPosition()) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }
}