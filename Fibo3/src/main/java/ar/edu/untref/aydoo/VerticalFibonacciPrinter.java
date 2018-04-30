package ar.edu.untref.aydoo;

import java.util.List;

public class VerticalFibonacciPrinter implements FibonacciPrinter {

    @Override
    public void print(List<Integer> succession) {
        StringBuffer out = new StringBuffer("fibo<").append(succession.size()).append(">: ");
        for (Integer eachNumber : succession) {
            out.append("\n");
            out.append(eachNumber);
        }
        System.out.println(out.toString());
    }
}
