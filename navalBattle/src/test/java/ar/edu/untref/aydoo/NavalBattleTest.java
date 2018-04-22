package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class NavalBattleTest {

    @Test
    public void putShipInGrid () {

        Grid aGrid = this.createAGridWithFinalPosition(2, 2);
        ShipInGrid aShipInGrid = this.createAShipInGrid(0, 0, 1);

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

        Grid aGrid = this.createAGridWithFinalPosition(2, 2);
        ShipInGrid aShipInGrid = this.createAShipInGrid(3, 0, 1);

        String result = aGrid.putShipInGrid(aShipInGrid);

        Assert.assertEquals(Message.POSITION_NON_EXISTENT, result);
    }

    @Test
    public void shootInAPositionWithoutShipShouldReturnWater () {

        Grid aGrid = this.createAGridWithFinalPosition(2,2);

        ResultShot result = aGrid.shoot(new Position(0, 1));

        Assert.assertEquals(ResultShot.WATER, result);
    }

    @Test
    public void shootInAPositionWithShipLength1ShouldReturnSunken () {

        Grid aGrid = this.createAGridWithFinalPosition(2, 2);
        ShipInGrid aShipInGrid = this.createAShipInGrid(1, 1, 1);
        aGrid.putShipInGrid(aShipInGrid);

        ResultShot result = aGrid.shoot(new Position(1, 1));

        Assert.assertEquals(ResultShot.SUNKEN, result);
    }

    @Test
    public void shootInAPositionWithShipLength2ShouldReturnTouched () {

        Grid aGrid = this.createAGridWithFinalPosition(2, 2);
        Position initialPositionShip = new Position(0, 0);
        ShipInGrid aShipInGrid = new ShipInGrid(initialPositionShip, 2, true);

        aGrid.putShipInGrid(aShipInGrid);

        ResultShot result = aGrid.shoot(new Position(0, 1));

        Assert.assertEquals(ResultShot.TOUCHED, result);
    }

    @Test
    public void put2ShipsInASamePositionReturnMsgCanNotPut () {

        Grid aGrid = this.createAGridWithFinalPosition(2, 2);
        ShipInGrid aShipInGrid = this.createAShipInGrid(0, 0, 1);
        ShipInGrid otherShipInGrid = this.createAShipInGrid(0,0, 1);

        aGrid.putShipInGrid(aShipInGrid);
        String result = aGrid.putShipInGrid(otherShipInGrid);

        Assert.assertEquals(Message.SHIP_EXISTENT_IN_POSITION, result);
    }

    private Grid createAGridWithFinalPosition(final Integer horizontalPosition, final Integer verticalPosition) {
        Position finalPosition = new Position(horizontalPosition, verticalPosition);
        return new Grid(finalPosition);
    }

    private ShipInGrid createAShipInGrid(final Integer horizontalPosition, final Integer verticalPosition, final Integer length) {
        Position finalPosition = new Position(horizontalPosition, verticalPosition);
        return new ShipInGrid(finalPosition, length, Boolean.FALSE);
    }
}