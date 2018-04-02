package ar.edu.untref.aydoo;

public class Glass {

    private int amountOfSugar;
    private boolean coffee = Boolean.FALSE;
    private boolean tea = Boolean.FALSE;

    public int getAmountOfSugar() {
        return amountOfSugar;
    }

    public void setAmountOfSugar(int amountOfSugar) {
        this.amountOfSugar = amountOfSugar;
    }

    public boolean hasCoffee() {
        return this.coffee;
    }

    public boolean hasSugar() { return (this.amountOfSugar > 0); }

    public boolean hasTea() {
        return this.tea;
    }

    public void setCoffee(boolean coffee) {
        this.coffee = coffee;
    }

    public void setTea(boolean tea) {
        this.tea = tea;
    }
}
