package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FibonacciTest {

    @Test
    public void getSuccessionShouldReturn5Values() {
        Integer limitSuccession = 5;
        Fibonacci fibonacci = new Fibonacci(limitSuccession);
        List<Integer> results = fibonacci.getSuccession();

        int[] actualsValues = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            actualsValues[i] = results.get(i);
        }
        int[] expectedsValues = new int[]{0, 1, 1, 2, 3};
        Assert.assertArrayEquals(expectedsValues, actualsValues);
    }

    @Test
    public void getSuccessionShouldReturn8Values() {
        Integer limitSuccession = 8;
        Fibonacci fibonacci = new Fibonacci(limitSuccession);
        List<Integer> results = fibonacci.getSuccession();

        int[] actualsValues = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            actualsValues[i] = results.get(i);
        }
        int[] expectedsValues = new int[]{0, 1, 1, 2, 3, 5, 8, 13};
        Assert.assertArrayEquals(expectedsValues, actualsValues);
    }

    @Test
    public void successionIsNotNull() {
        Integer limitSuccession = 5;
        Fibonacci fibonacci = new Fibonacci(limitSuccession);
        List<Integer> results = fibonacci.getSuccession();

        Assert.assertNotNull(results);
    }

    @Test
    public void getSuccessionWithLimit3ShouldReturn3ValuesInverted() {
        Fibonacci fibonacci = new Fibonacci(3);
        List<Integer> results = fibonacci.invertSuccession();

        int[] actualsValues = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            actualsValues[i] = results.get(i);
        }
        int[] expectedsValues = new int[]{1, 1, 0};
        Assert.assertArrayEquals(expectedsValues, actualsValues);
    }

    @Test
    public void getSuccessionWithLimit4ShouldReturn4ValuesInverted() {
        Fibonacci fibonacci = new Fibonacci(4);
        List<Integer> results = fibonacci.invertSuccession();

        int[] actualsValues = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            actualsValues[i] = results.get(i);
        }
        int[] expectedsValues = new int[]{2, 1, 1, 0};
        Assert.assertArrayEquals(expectedsValues, actualsValues);
    }

    @Test
    public void printSuccessionWithLimit4InShapeVerticalShouldReturnVertical() {
        Fibonacci fibonacci = new Fibonacci(4);
        SuperFibonacci verticalFibonacci = new VerticalFibonacci(fibonacci);
        String result = verticalFibonacci.getDescription();

        Assert.assertEquals("VERTICAL", result);
    }

    @Test
    public void printSuccessionWithLimit4InShapeHorizontalShouldReturnHorizontal() {
        Fibonacci fibonacci = new Fibonacci(4);

        String result = fibonacci.getDescription();

        Assert.assertEquals("HORIZONTAL", result);
    }

    @Test
    public void printSuccessionHorizontal() {
        Fibonacci fibonacci = new Fibonacci(4);

        String result = fibonacci.print();

        Assert.assertEquals("print horizontal", result);
    }

    @Test
    public void printSuccessionVertical() {
        Fibonacci fibonacci = new Fibonacci(4);
        SuperFibonacci verticalFibonacci = new VerticalFibonacci(fibonacci);
        String result = verticalFibonacci.print();

        Assert.assertEquals("print vertical", result);
    }
}
