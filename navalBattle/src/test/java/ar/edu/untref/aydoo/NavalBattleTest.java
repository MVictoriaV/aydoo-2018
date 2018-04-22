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

        Assert.assertEquals(Message.POSITION_NON_EXISTENT, result);
    }

    @Test
    public void shootInAPositionWithoutShipShouldReturnWater () {

        Position finalPosition = new Position(2, 2);
        Grid aGrid = new Grid(finalPosition);

        ResultShot result = aGrid.shoot(new Position(0, 1));

        Assert.assertEquals(ResultShot.WATER, result);
    }

    @Test
    public void shootInAPositionWithShipLength1ShouldReturnSunken () {

        Position finalPosition = new Position(2, 2);
        Grid aGrid = new Grid(finalPosition);

        Position initialPositionShip = new Position(1, 1);
        ShipInGrid aShipInGrid = new ShipInGrid(initialPositionShip, 1, false);

        aGrid.putShipInGrid(aShipInGrid);

        ResultShot result = aGrid.shoot(new Position(1, 1));

        Assert.assertEquals(ResultShot.SUNKEN, result);
    }

    @Test
    public void shootInAPositionWithShipLength2ShouldReturnTouched () {

        Position finalPosition = new Position(2, 2);
        Grid aGrid = new Grid(finalPosition);

        Position initialPositionShip = new Position(0, 0);
        ShipInGrid aShipInGrid = new ShipInGrid(initialPositionShip, 2, true);

        aGrid.putShipInGrid(aShipInGrid);

        ResultShot result = aGrid.shoot(new Position(0, 1));

        Assert.assertEquals(ResultShot.TOUCHED, result);
    }

    @Test
    public void put2ShipsInASamePositionReturnMsgCanNotPut () {

        Position finalPosition = new Position(2, 2);
        Grid aGrid = new Grid(finalPosition);

        Position initialPositionShip = new Position(0, 0);
        ShipInGrid aShipInGrid = new ShipInGrid(initialPositionShip, 1, false);
        ShipInGrid otherShipInGrid = new ShipInGrid(new Position(0, 0), 1, false);

        aGrid.putShipInGrid(aShipInGrid);
        String result = aGrid.putShipInGrid(otherShipInGrid);

        Assert.assertEquals(Message.SHIP_EXISTENT_IN_POSITION, result);
    }
}