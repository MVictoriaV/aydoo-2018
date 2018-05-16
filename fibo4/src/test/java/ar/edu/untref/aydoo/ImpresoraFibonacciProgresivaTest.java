package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ImpresoraFibonacciProgresivaTest {

    @Test
    public void imprimeSerieDeFormaProgresivaDebeSerDistintoDeNull(){

        int[] serieFibonacci = new arregloDeNumeros().obtenerArregloDeNumerosDeFibonacci(3);
        ImpresoraFibonacciProgresiva impresora = new ImpresoraFibonacciProgresiva();

        StringBuffer serieReal = impresora.imprimirSerie(serieFibonacci);

        Assert.assertNotNull(serieReal);
    }

    @Test
    public void imprimeSerieDeFormaProgresivaDebeContenerLaLineaConValores011(){

        int[] serieFibonacci = new arregloDeNumeros().obtenerArregloDeNumerosDeFibonacci(3);
        ImpresoraFibonacciProgresiva impresora = new ImpresoraFibonacciProgresiva();
        final String serieEsperada = "0 1 1";

        StringBuffer serieReal = impresora.imprimirSerie(serieFibonacci);

        Assert.assertTrue(serieReal.toString().contains(serieEsperada));
    }
}
