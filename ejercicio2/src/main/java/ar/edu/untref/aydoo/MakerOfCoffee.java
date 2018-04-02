package ar.edu.untref.aydoo;

public class MakerOfCoffee {

    //cafetero
    private CoffeeMaker coffeeMaker;
    private MilkMaker milkMaker;


    public MakerOfCoffee () {
        this.coffeeMaker = new CoffeeMaker();
    }

    public Glass loadCoffee(Glass aGlass) {
        aGlass = this.coffeeMaker.putCoffee(aGlass);
        return aGlass;
    }

    public Glass loadMilk(Glass aGlass) {
        this.milkMaker = new MilkMaker();
        return this.milkMaker.putMilk(aGlass);
    }
}
