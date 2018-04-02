package ar.edu.untref.aydoo;

public class DrinkVendingMachine {

    public void doCoffeeWithMilkWithNSugar(Glass aGlass, int amountOfSugar) {
        new MakerOfCoffee().loadCoffee(aGlass);
        aGlass.setAmountOfSugar(amountOfSugar);
    }

    public void doTeaWithMilkWithNSugar(Glass aGlass, int amountOfSugar) {
        aGlass.setAmountOfSugar(amountOfSugar);
        aGlass.setTea(Boolean.TRUE);
    }
}
