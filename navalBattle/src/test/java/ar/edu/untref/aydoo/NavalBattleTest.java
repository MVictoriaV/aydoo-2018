package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class NavalBattleTest {

    @Test
    public void putEmbarkationInGrid () {

        Grid aGrid = new Grid();
        Ship aShip = new Ship();
        Position position = new Position(1, 1);

        aGrid.putEmbarkation(aShip, position);

        Assert.assertTrue(aGrid.hasAnEmbarkation(position));
    }

    @Test
    public void doesNotHaveEmbarkationInPosition () {

        Grid aGrid = new Grid();
        Position position = new Position(1, 1);

        Assert.assertFalse(aGrid.hasAnEmbarkation(position));
    }
}
