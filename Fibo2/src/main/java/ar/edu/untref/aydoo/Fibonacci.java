package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Fibonacci implements SuperFibonacci {

    private List<Integer> succession;

    public Fibonacci(Integer limitSuccession) {
        succession = this.calculateSuccession(limitSuccession);

    }

    @Override
    public List<Integer> getSuccession() {
        return succession;
    }

    private List<Integer> calculateSuccession(int limitSuccession) {
        return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(limitSuccession)
                .map(n -> n[0])
                .collect(toList());
    }

    public List<Integer> invertSuccession () {
        List<Integer> listInverted = new ArrayList<>();
        for (int i = (succession.size()-1); i >= 0; i--) {
            listInverted.add(succession.get(i));
        }
        return listInverted;
    }

    public String getDescription() {
        return "HORIZONTAL";
    }

    @Override
    public String print() {
        StringBuffer out = new StringBuffer();
        for (Integer eachNumber : succession) {
            out.append(" ").append(eachNumber);
        }
        return out.toString();
    }
}
