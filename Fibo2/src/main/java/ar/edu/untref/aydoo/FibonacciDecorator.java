package ar.edu.untref.aydoo;

public class FibonacciDecorator implements SuperFibonacci {

    protected SuperFibonacci superFibonacci;

    public FibonacciDecorator(SuperFibonacci aSuperFibonacci){
        this.superFibonacci = aSuperFibonacci;
    }

    @Override
    public String getDescription() {
        return this.superFibonacci.getDescription();
    }
}