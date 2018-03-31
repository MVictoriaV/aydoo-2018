package ar.edu.untref.aydoo;

public class Glass {

    private int amountOfSugar;

    public int getAmountOfSugar() {
        return amountOfSugar;
    }

    public void setAmountOfSugar(int amountOfSugar) {
        this.amountOfSugar = amountOfSugar;
    }

    public boolean hasCoffee() { return true; }

    public boolean hasSugar() { return true; }

    public boolean hasTea() { return false; }
}
