package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class NavalBattleTest {

    @Test
    public void putShipInGrid () {

        Position finalPosition = new Position(2, 2);
        Grid aGrid = new Grid(finalPosition);

        Position initialPositionShip = new Position(0, 0);
        ShipInGrid aShipInGrid = new ShipInGrid(initialPositionShip, 1, false);

        aGrid.putShipInGrid(aShipInGrid);

        Assert.assertTrue(aGrid.hasAShip(new Position(0, 0)));
    }

    @Test
    public void doesNotHaveAShipInPositionX0AndY1 () {

        Position finalPosition = new Position(2, 2);
        Grid aGrid = new Grid(finalPosition);

        Assert.assertFalse(aGrid.hasAShip(new Position(0, 1)));
    }

    @Test
    public void putAShipInANotExistingPositionShouldReturnAMsg () {

        Position finalPosition = new Position(2, 2);
        Grid aGrid = new Grid(finalPosition);

        Position initialPositionShip = new Position(3, 0);
        ShipInGrid aShipInGrid = new ShipInGrid(initialPositionShip, 1, false);

        String result = aGrid.putShipInGrid(aShipInGrid);

        Assert.assertEquals("non-existent position", result);
    }
}