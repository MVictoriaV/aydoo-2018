package ar.edu.untref.aydoo;

import java.util.List;

public class Program {

    protected Program() {
    }

    public static void main(String[] args) {
        int limitSuccession = Integer.valueOf(args[0]);
        Fibonacci fibonacci = new Fibonacci(limitSuccession);
        List<Integer> results = fibonacci.getSuccession();

        StringBuffer sb = new StringBuffer("fibo<").append(limitSuccession).append(">: ");
        for (int value: results) {
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString());
    }
}
