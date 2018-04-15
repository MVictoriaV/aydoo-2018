package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FibonacciTest {

    @Test
    public void getSuccessionShouldReturn5Values() {
        List<Integer> results = Fibonacci.getSuccession(5);

        int[] actualsValues = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            actualsValues[i] = results.get(i);
        }
        int[] expectedsValues = new int[]{0, 1, 1, 2, 3};
        Assert.assertArrayEquals(expectedsValues, actualsValues);
    }

    @Test
    public void getSuccessionShouldReturn8Values() {
        List<Integer> results = Fibonacci.getSuccession(8);

        int[] actualsValues = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            actualsValues[i] = results.get(i);
        }
        int[] expectedsValues = new int[]{0, 1, 1, 2, 3, 5, 8, 13};
        Assert.assertArrayEquals(expectedsValues, actualsValues);
    }

    @Test
    public void successionIsNotNull() {
        List<Integer> results = Fibonacci.getSuccession(3);
        Assert.assertNotNull(results);
    }
}
