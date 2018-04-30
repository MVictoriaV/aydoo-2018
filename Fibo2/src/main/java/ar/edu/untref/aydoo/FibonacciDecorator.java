package ar.edu.untref.aydoo;

import java.util.List;

public class FibonacciDecorator implements SuperFibonacci {

    protected SuperFibonacci superFibonacci;

    public FibonacciDecorator(SuperFibonacci aSuperFibonacci){
        this.superFibonacci = aSuperFibonacci;
    }

    @Override
    public String getDescription() {
        return this.superFibonacci.getDescription();
    }

    @Override
    public String print() {
        return this.superFibonacci.print();
    }

    @Override
    public List<Integer> getSuccession() {
        return this.superFibonacci.getSuccession();
    }
}