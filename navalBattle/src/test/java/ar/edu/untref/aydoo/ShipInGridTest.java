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

    private ShipInGrid createAShipInGrid(Integer horizontalPosition, Integer verticalPosition, Integer lengthShip){
        Position initialPosition = new Position(horizontalPosition, verticalPosition);
        return new ShipInGrid(initialPosition, lengthShip, Boolean.TRUE);
    }
}