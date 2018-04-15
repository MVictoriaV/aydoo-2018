package ar.edu.untref.aydoo;

public class VerticalFibonacci extends FibonacciDecorator {

    public VerticalFibonacci(SuperFibonacci aSuperFibonacci) {
        super(aSuperFibonacci);
    }

    @Override
    public String getDescription() {
        return "VERTICAL";
    }

    @Override
    public String print() {
        StringBuffer out = new StringBuffer();
        for (Integer eachNumber : super.getSuccession()) {
            out.append("\n").append(eachNumber);
        }
        return out.toString();
    }
}