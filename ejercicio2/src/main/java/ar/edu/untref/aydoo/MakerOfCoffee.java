package ar.edu.untref.aydoo;

public class MakerOfCoffee {

    //cafetero
    private CoffeeMaker coffeeMaker;

    public MakerOfCoffee () {
        this.coffeeMaker = new CoffeeMaker();
    }

    public Glass loadCoffee(Glass aGlass) {
        aGlass = this.coffeeMaker.putCoffee(aGlass);
        return aGlass;
    }
}
