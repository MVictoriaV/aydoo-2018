package ar.edu.untref.aydoo;

public class DrinkVendingMachine {

    public void doCoffeeWithMilkWithNSugar(Glass aGlass, int amountOfSugar) {
        MakerOfCoffee makerOfCoffee = new MakerOfCoffee();
        makerOfCoffee.loadCoffee(aGlass);
        makerOfCoffee.loadMilk(aGlass);
        aGlass.setAmountOfSugar(amountOfSugar);
    }

    public void doTeaWithMilkWithNSugar(Glass aGlass, int amountOfSugar) {
        aGlass.setAmountOfSugar(amountOfSugar);
        aGlass.setTea(Boolean.TRUE);
    }
}
