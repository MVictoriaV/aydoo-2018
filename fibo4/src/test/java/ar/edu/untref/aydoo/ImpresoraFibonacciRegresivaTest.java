package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ImpresoraFibonacciRegresivaTest {

    @Test
    public void imprimeSerieDeFormaRegresivaDebeSerDistintoDeNull(){

        int[] serieFibonacci = new arregloDeNumeros().obtenerArregloDeNumerosDeFibonacci(3);
        ImpresoraFibonacci impresora = new ImpresoraFibonacciRegresiva();

        StringBuffer serieReal = impresora.imprimirSerie(serieFibonacci);

        Assert.assertNotNull(serieReal);
    }

    @Test
    public void imprimeSerieDeFormaRegresivaDebeContenerLaLineaConValores2110(){

        int[] serieFibonacci = new arregloDeNumeros().obtenerArregloDeNumerosDeFibonacci(4);
        ImpresoraFibonacci impresora = new ImpresoraFibonacciRegresiva();
        final String serieEsperada = "2 1 1 0";

        StringBuffer serieReal = impresora.imprimirSerie(serieFibonacci);

        Assert.assertTrue(serieReal.toString().contains(serieEsperada));
    }
}
