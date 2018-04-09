package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class NavalBattleTest {

    @Test
    public void putEmbarkationInGrid () {

        Grid aGrid = new Grid();
        Ship aBoat = new Ship(1);
        Position position = new Position(1, 1);

        aGrid.putEmbarkation(aBoat, position, false);

        Assert.assertTrue(aGrid.hasAnEmbarkation(position));
    }

    @Test
    public void doesNotHaveEmbarkationInPosition () {

        Grid aGrid = new Grid();
        Position position = new Position(1, 1);

        Assert.assertFalse(aGrid.hasAnEmbarkation(position));
    }

    @Test
    public void putAVerticalCruiseInGrid () {

        Grid aGrid = new Grid();
        Ship aCruise = new Ship(2);
        Position position = new Position(0, 0);

        aGrid.putEmbarkation(aCruise, position, true);

        Assert.assertTrue(aGrid.hasAnEmbarkation(position));
        Assert.assertTrue(aGrid.hasAnEmbarkation(new Position(0, 1)));
    }

    @Test
    public void shootToABoatShouldReturnSunken () {

        Grid aGrid = new Grid();
        Ship aBoat = new Ship(1);
        Position position0_0 = new Position(0, 0);
        aGrid.putEmbarkation(aBoat, position0_0, false);
        Position position1_1 = new Position(0, 1);
        aGrid.putEmbarkation(new Ship(1), position1_1, false);

        String result = aBoat.shoot(position1_1);

        Assert.assertEquals("sunken", result);
    }
}
