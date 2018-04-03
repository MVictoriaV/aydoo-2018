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

    @Test
    public void shouldMakeTeaWithMilkWith0Sugar() {

        int amountOfSugar = 0;
        Glass aGlass = new Glass();
        DrinkVendingMachine drinkVendingMachine = new DrinkVendingMachine();

        drinkVendingMachine.doTeaWithMilkWithNSugar(aGlass, amountOfSugar);

        Assert.assertEquals(amountOfSugar, aGlass.getAmountOfSugar());
        Assert.assertFalse(aGlass.hasCoffee());
        Assert.assertFalse(aGlass.hasSugar());
        Assert.assertTrue(aGlass.hasTea());
    }

    @Test
    public void shouldMakeTeaWithMilkWith3Sugar() {

        int amountOfSugar = 3;
        Glass aGlass = new Glass();
        DrinkVendingMachine drinkVendingMachine = new DrinkVendingMachine();

        drinkVendingMachine.doTeaWithMilkWithNSugar(aGlass, amountOfSugar);

        Assert.assertEquals(amountOfSugar, aGlass.getAmountOfSugar());
        Assert.assertFalse(aGlass.hasCoffee());
        Assert.assertTrue(aGlass.hasSugar());
        Assert.assertTrue(aGlass.hasTea());
    }
}
