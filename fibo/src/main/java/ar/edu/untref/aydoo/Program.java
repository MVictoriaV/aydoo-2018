package ar.edu.untref.aydoo;

import java.util.List;

public class Program {

    protected Program() {
    }

    public static void main(String[] args) {
        int limitSuccession = Integer.valueOf(args[0]);
        List<Integer> results = Fibonacci.getSuccession(limitSuccession);
        StringBuffer sb = new StringBuffer("fibo<").append(limitSuccession).append(">: ");
        for (int value: results) {
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString());
    }
}
