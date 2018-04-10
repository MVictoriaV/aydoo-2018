package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Grid {

    private Position finalPosition;
    private List<ShipInGrid> shipsInGrid = new ArrayList<>();
    private final static String MSG_NON_EXISTENT = "non-existent position";

    public Grid (Position finalPosition) {
        this.finalPosition = finalPosition;
    }

    public String putShipInGrid(ShipInGrid aShipInGrid) {
        String message = MSG_NON_EXISTENT;
        if (aShipInGrid.getShipPositions().get(0).getPosition().getHorizontalPosition() <= this.finalPosition.getHorizontalPosition()
                || aShipInGrid.getShipPositions().get(0).getPosition().getHorizontalPosition() <= this.finalPosition.getHorizontalPosition()) {
            shipsInGrid.add(aShipInGrid);
            message = "INSERT OK";
        }
        return message;
    }

    public boolean hasAShip(Position position) {

        for (ShipInGrid itemShipInGrid : this.shipsInGrid) {
            for (ShipPosition itemShipPosition : itemShipInGrid.getShipPositions()) {
                if (itemShipPosition.getPosition().getHorizontalPosition() == position.getHorizontalPosition() &&
                        itemShipPosition.getPosition().getVerticalPosition() == position.getVerticalPosition()) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public ResultShot shoot(Position position) {

        for (ShipInGrid each : this.shipsInGrid) {
            Optional<ShipPosition> anOptional = each.getShipPositions().stream().filter(aPosition ->
                    ( aPosition.getPosition().getHorizontalPosition().equals(position.getHorizontalPosition())) &&
                            aPosition.getPosition().getVerticalPosition().equals(position.getVerticalPosition())).findFirst();
            if (anOptional.isPresent()) {
                anOptional.get().setHasShot(Boolean.TRUE);
                return ResultShot.SUNKEN;
            }

        }
        return ResultShot.WATER;
    }
}