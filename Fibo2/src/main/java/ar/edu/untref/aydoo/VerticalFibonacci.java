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
        StringBuffer out = new StringBuffer("fibo<").append(super.getSuccession().size()).append(">: ");
        for (Integer eachNumber : super.getSuccession()) {
            out.append("\n\n");
            out.append(eachNumber);
        }
        return out.toString();
    }
}