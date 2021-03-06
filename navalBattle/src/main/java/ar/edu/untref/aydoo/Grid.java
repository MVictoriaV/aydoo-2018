package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Grid {

    private Position finalPosition;
    private List<ShipInGrid> shipsInGrid = new ArrayList<>();

    public Grid (Position finalPosition) {
        this.finalPosition = finalPosition;
    }

    public String putShipInGrid(ShipInGrid aShipInGrid) {

        String message = Message.POSITION_NON_EXISTENT;
        if (this.isInTheLimitsOfPosition(aShipInGrid)) {
            Optional result = this.shipsInGrid.stream().filter(a -> a.isThereAShipInSamePosition(aShipInGrid)).findFirst();
            if (result.isPresent()) {
                message = Message.SHIP_EXISTENT_IN_POSITION;
            } else {
                this.shipsInGrid.add(aShipInGrid);
                message = Message.INSERT_OK;
            }
        }
        return message;
    }

    public boolean hasAShip(Position position) {
        return (this.searchAShipInPosition(position) != null);
    }

    public ResultShot shoot(Position position) {

        ShipInGrid aShip = this.searchAShipInPosition(position);

        if (aShip != null) {
            aShip.shootInPosition(position);
            return aShip.getState();
        }
        return ResultShot.WATER;
    }

    private ShipInGrid searchAShipInPosition(Position aPosition) {

        for (ShipInGrid itemShipInGrid : this.shipsInGrid) {
            Boolean result = itemShipInGrid.presentAShipInPosition(aPosition);
            if (result) {
                return itemShipInGrid;
            }
        }
        return null;
    }

    private boolean isInTheLimitsOfPosition (ShipInGrid aShipInGrid) {
        return aShipInGrid.isInTheLimits(this.finalPosition);
    }
}