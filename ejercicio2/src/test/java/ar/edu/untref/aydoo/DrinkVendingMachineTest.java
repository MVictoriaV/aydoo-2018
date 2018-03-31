package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class DrinkVendingMachineTest {

    @Test
    public void shouldMakeCoffeeWithMilkWith10Sugar() {
        int amountOfSugar = 10;
        Glass aGlass = new Glass();
        DrinkVendingMachine drinkVendingMachine = new DrinkVendingMachine();

        drinkVendingMachine.doCoffeeWithMilkWithNSugar(aGlass, amountOfSugar);

        Assert.assertEquals(amountOfSugar, aGlass.getAmountOfSugar());
        Assert.assertTrue(aGlass.hasCoffee());
        Assert.assertTrue(aGlass.hasSugar());
        Assert.assertFalse(aGlass.hasTea());
    }
}
