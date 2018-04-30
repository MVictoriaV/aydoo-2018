package ar.edu.untref.aydoo;

import java.util.List;

public class SumattionFibonacciPrinter  implements FibonacciPrinter {

    @Override
    public void print(List<Integer> succession) {
        StringBuffer out = new StringBuffer("fibo<").append(succession.size()).append(">s: ");
        Integer sum = 0;
        for (Integer eachNumber : succession) {
            sum += eachNumber;
        }
        out.append(" ").append(sum);
        System.out.println(out.toString());
    }
}
