package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkVendingMachineTest {

    private DrinkVendingMachine drinkVendingMachine;
    private Glass aGlass;

    @Before
    public void glassAndMachineAreInstantiated() {
        this.drinkVendingMachine = new DrinkVendingMachine();
        this.aGlass = new Glass();
    }

    @Test
    public void shouldMakeCoffeeWithMilkWith10Sugar() {
        int amountOfSugar = 10;

        this.drinkVendingMachine.doCoffeeWithMilkWithNSugar(aGlass, amountOfSugar);

        Assert.assertEquals(amountOfSugar, this.aGlass.getAmountOfSugar());
        Assert.assertTrue(this.aGlass.hasCoffee());
        Assert.assertTrue(this.aGlass.hasSugar());
        Assert.assertFalse(this.aGlass.hasTea());
    }

    @Test
    public void shouldMakeTeaWithMilkWith0Sugar() {

        int amountOfSugar = 0;

        this.drinkVendingMachine.doTeaWithMilkWithNSugar(this.aGlass, amountOfSugar);

        Assert.assertEquals(amountOfSugar, aGlass.getAmountOfSugar());
        Assert.assertFalse(this.aGlass.hasCoffee());
        Assert.assertFalse(this.aGlass.hasSugar());
        Assert.assertTrue(this.aGlass.hasTea());
    }

    @Test
    public void shouldMakeTeaWithMilkWith3Sugar() {

        int amountOfSugar = 3;

        this.drinkVendingMachine.doTeaWithMilkWithNSugar(this.aGlass, amountOfSugar);

        Assert.assertEquals(amountOfSugar, this.aGlass.getAmountOfSugar());
        Assert.assertFalse(this.aGlass.hasCoffee());
        Assert.assertTrue(this.aGlass.hasSugar());
        Assert.assertTrue(this.aGlass.hasTea());
    }
}
