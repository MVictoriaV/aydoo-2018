package ar.edu.untref.aydoo;

public class VerticalFibonacci extends FibonacciDecorator {

    public VerticalFibonacci(SuperFibonacci aSuperFibonacci) {
        super(aSuperFibonacci);
    }

    @Override
    public String getDescription() {
        return "VERTICAL";
    }
}
