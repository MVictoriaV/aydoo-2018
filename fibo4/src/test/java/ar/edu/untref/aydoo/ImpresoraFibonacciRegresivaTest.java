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
}
