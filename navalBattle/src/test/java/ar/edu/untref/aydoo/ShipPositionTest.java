package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ShipPositionTest {

    @Test
    public void createAShipPositionWithoutShot() {

        ShipPosition aShipPosition = this.createAShipPosition(3, 1);

        Boolean result = aShipPosition.hasShot();

        Assert.assertFalse(result);
    }

    @Test
    public void aShipPositionReceiveAShot() {

        ShipPosition aShipPosition = this.createAShipPosition(2, 4);

        aShipPosition.receiveAShot();

        Assert.assertTrue(aShipPosition.hasShot());
    }

    private ShipPosition createAShipPosition(Integer horizontalPosition, Integer verticalPosition){
        Position aPosition = new Position(horizontalPosition, verticalPosition);
        return new ShipPosition(aPosition);
    }
}
