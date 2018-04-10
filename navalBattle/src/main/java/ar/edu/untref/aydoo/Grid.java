package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private Position finalPosition;
    private List<ShipInGrid> shipsInGrid = new ArrayList<>();

    public Grid (Position finalPosition) {
        this.finalPosition = finalPosition;
    }

    public void putShipInGrid(ShipInGrid aShipInGrid) {
        shipsInGrid.add(aShipInGrid);
    }

    public boolean hasAShip(Position position) {
        return Boolean.TRUE;
    }
}