package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Fibonacci {

    private List<Integer> succession;

    public Fibonacci(Integer limitSuccession, Boolean isInverted) {
        succession = this.calculateSuccession(limitSuccession);
        if(isInverted) {
            succession = this.invertSuccession();
        }
    }

    public List<Integer> getSuccession() {
        return succession;
    }

    private List<Integer> calculateSuccession(int limitSuccession) {
        return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(limitSuccession)
                .map(n -> n[0])
                .collect(toList());
    }

    private List<Integer> invertSuccession () {
        List<Integer> listInverted = new ArrayList<>();
        for (int i = (succession.size()-1); i >= 0; i--) {
            listInverted.add(succession.get(i));
        }
        return listInverted;
    }

    public Integer sumSuccession(){
        Integer sum = 0;
        for (Integer eachNumber : succession) {
            sum += eachNumber;
        }
        return sum;
    }
}
