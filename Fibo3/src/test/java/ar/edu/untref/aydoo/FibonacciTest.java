package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class FibonacciTest {

    @Test
    public void getSuccessionShouldReturn5Values() {

        Integer limitSuccession = 5;
        Boolean isInverted = false;
        Fibonacci fibonacci = new Fibonacci(limitSuccession, isInverted);
        Integer[] expectedsValues = new Integer[]{0, 1, 1, 2, 3};

        List<Integer> results = fibonacci.getSuccession();

        Assert.assertArrayEquals(expectedsValues, results.toArray());
    }

    @Test
    public void getSuccessionShouldReturn8Values() {

        Integer limitSuccession = 8;
        Boolean isInverted = false;
        Fibonacci fibonacci = new Fibonacci(limitSuccession, isInverted);
        Integer[] expectedsValues = new Integer[]{0, 1, 1, 2, 3, 5, 8, 13};

        List<Integer> results = fibonacci.getSuccession();

        Assert.assertArrayEquals(expectedsValues, results.toArray());
    }

    @Test
    public void successionIsNotNull() {

        Integer limitSuccession = 5;
        Boolean isInverted = false;
        Fibonacci fibonacci = new Fibonacci(limitSuccession, isInverted);
        List<Integer> results = fibonacci.getSuccession();

        Assert.assertNotNull(results);
    }

    @Test
    public void getSuccessionWithLimit3ShouldReturn3ValuesInverted() {

        Boolean isInverted = true;
        Fibonacci fibonacci = new Fibonacci(3, isInverted);
        Integer[] expectedsValues = new Integer[]{1, 1, 0};

        List<Integer> results = fibonacci.getSuccession();

        Assert.assertArrayEquals(expectedsValues, results.toArray());
    }

    @Test
    public void getSuccessionWithLimit4ShouldReturn4ValuesInverted() {

        Boolean isInverted = true;
        Fibonacci fibonacci = new Fibonacci(4, isInverted);
        Integer[] expectedsValues = new Integer[]{2, 1, 1, 0};

        List<Integer> results = fibonacci.getSuccession();

        Assert.assertArrayEquals(expectedsValues, results.toArray());
    }
}