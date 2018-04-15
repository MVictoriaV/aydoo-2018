package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Fibonacci {

    public static List<Integer> getSuccession(int limitSuccession) {
        return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(limitSuccession)
                .map(n -> n[0])
                .collect(toList());
    }

    public List<Integer> invertSuccession () {
        List<Integer> listInverted = new ArrayList<>();
        listInverted.add(1);
        listInverted.add(1);
        listInverted.add(0);
        return listInverted;
    }
}
