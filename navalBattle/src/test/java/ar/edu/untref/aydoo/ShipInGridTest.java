package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ShipInGridTest {

    @Test
    public void shootInPositionToShipOf1LengthShouldBeReturnSUNKEN() {

        ShipInGrid shipInGrid = this.createAShipInGrid(1, 2, 1);

        shipInGrid.shootInPosition(new Position(1, 2));

        Assert.assertEquals(ResultShot.SUNKEN, shipInGrid.getState());
    }

    @Test
    public void shootInPositionToShipOf2LengthShouldBeReturnTOUCHED() {

        ShipInGrid shipInGrid = this.createAShipInGrid(1, 2, 2);

        shipInGrid.shootInPosition(new Position(1, 2));

        Assert.assertEquals(ResultShot.TOUCHED, shipInGrid.getState());
    }

    @Test
    public void shootX2ToShipOf2LengthShouldBeReturnSUNKEN() {

        ShipInGrid shipInGrid = this.createAShipInGrid(1, 2, 2);

        shipInGrid.shootInPosition(new Position(1, 2));
        shipInGrid.shootInPosition(new Position(1, 3));

        Assert.assertEquals(ResultShot.SUNKEN, shipInGrid.getState());
    }

    @Test
    public void compareIf2ShipsInGridAreInTheSamePositions() {

        ShipInGrid shipInGrid = this.createAShipInGrid(1, 2, 2);
        ShipInGrid otherShipInGrid = this.createAShipInGrid(1, 2, 2);

        Boolean result = shipInGrid.isThereAShipInSamePosition(otherShipInGrid);

        Assert.assertTrue(result);
    }

    @Test
    public void thereAre2ShipsInGridButDifferentPositions() {

        ShipInGrid shipInGrid = this.createAShipInGrid(1, 2, 1);
        ShipInGrid otherShipInGrid = this.createAShipInGrid(5, 1, 1);

        Boolean result = shipInGrid.isThereAShipInSamePosition(otherShipInGrid);

        Assert.assertFalse(result);
    }

    private ShipInGrid createAShipInGrid(Integer horizontalPosition, Integer verticalPosition, Integer lengthShip){
        Position initialPosition = new Position(horizontalPosition, verticalPosition);
        return new ShipInGrid(initialPosition, lengthShip, Boolean.TRUE);
    }
}