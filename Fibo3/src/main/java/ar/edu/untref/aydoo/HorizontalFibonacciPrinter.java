package ar.edu.untref.aydoo;

import java.util.List;

public class HorizontalFibonacciPrinter implements FibonacciPrinter {

    @Override
    public void print(List<Integer> succession) {
        StringBuffer out = new StringBuffer("fibo<").append(succession.size()).append(">: ");
        for (Integer eachNumber : succession) {
            out.append(" ").append(eachNumber);
        }
        System.out.println(out.toString());
    }
}
