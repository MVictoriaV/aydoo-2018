package ar.edu.untref.aydoo;

public class Glass {

    private int amountOfSugar;
    private Drink drink;

    public Glass (Drink drink, int amountOfSugar) {
        this.drink = drink;
        this.amountOfSugar = amountOfSugar;
    }

    public int getAmountOfSugar() {
        return amountOfSugar;
    }

    public void setAmountOfSugar(int amountOfSugar) {
        this.amountOfSugar = amountOfSugar;
    }

    public boolean hasCoffee() {
        return (this.drink instanceof Coffee);
    }

    public boolean hasSugar() { return (this.amountOfSugar > 0); }

    public boolean hasTea() {
        return (this.drink instanceof Tea);
    }
}
