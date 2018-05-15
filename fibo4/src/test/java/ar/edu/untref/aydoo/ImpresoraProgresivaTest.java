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
}
