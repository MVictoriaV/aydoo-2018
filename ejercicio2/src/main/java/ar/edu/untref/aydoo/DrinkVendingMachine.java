package ar.edu.untref.aydoo;

public class DrinkVendingMachine {

    public void doCoffeeWithMilkWithNSugar(Glass aGlass, int amountOfSugar) {
        MakerOfCoffee makerOfCoffee = new MakerOfCoffee();
        makerOfCoffee.loadCoffee(aGlass);
        makerOfCoffee.loadMilk(aGlass);
        new SugarMaker().putSugar(aGlass, amountOfSugar);
    }

    public void doTeaWithMilkWithNSugar(Glass aGlass, int amountOfSugar) {
        MakerOfTeaWithMilk makerOfTeaWithMilk = new MakerOfTeaWithMilk();
        makerOfTeaWithMilk.load(aGlass);
        new SugarMaker().putSugar(aGlass, amountOfSugar);
    }
}
