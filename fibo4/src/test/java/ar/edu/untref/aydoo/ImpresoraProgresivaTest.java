package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ImpresoraProgresivaTest {

    @Test
    public void imprimeSerieDeFormaProgresivaDebeSerDistintoDeNull(){

        int[] serieFibonacci = new arregloDeNumeros().obtenerArregloDeNumerosDeFibonacci(3);
        ImpresoraProgresiva impresora = new ImpresoraProgresiva();

        StringBuffer serieReal = impresora.imprimirSerie(serieFibonacci);

        Assert.assertNotNull(serieReal);
    }

    @Test
    public void imprimeSerieDeFormaProgresivaDebeContenerLa1erLineaConValor0(){

        int[] serieFibonacci = new arregloDeNumeros().obtenerArregloDeNumerosDeFibonacci(3);
        ImpresoraProgresiva impresora = new ImpresoraProgresiva();
        final String serieEsperada = "0 1 1";

        StringBuffer serieReal = impresora.imprimirSerie(serieFibonacci);

        Assert.assertTrue(serieReal.toString().contains(serieEsperada));
    }
}
