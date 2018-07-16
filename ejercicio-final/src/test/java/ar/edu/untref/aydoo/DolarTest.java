package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class DolarTest {

    @Test
    public void seCalculaGananciaConCotizacionInicial20YFinal28DebeRetornar400() throws CampoIncorrectoExcepcion {

        Double monto = 1000d;
        Double cotizacionInicial = 20d;
        Double cotizacionFinal = 28d;
        Inversion inversionDolar = new Dolar(monto, cotizacionInicial, cotizacionFinal);

        Double gananciaReal = inversionDolar.calcularGanancia();
        Double gananciaEsperada = 400d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.01);
    }

    @Test(expected = CampoIncorrectoExcepcion.class)
    public void lanzaExcepcionCuandoIngresaMontoConValor0() throws CampoIncorrectoExcepcion{

        Double monto = 0d;
        Double cotizacionInicial = 20d;
        Double cotizacionFinal = 28d;
        new Dolar(monto, cotizacionInicial, cotizacionFinal);
    }

    @Test(expected = CampoIncorrectoExcepcion.class)
    public void lanzaExcepcionCuandoIngresaCotizacionInicialConValor0() throws CampoIncorrectoExcepcion{

        Double monto = 100d;
        Double cotizacionInicial = 0d;
        Double cotizacionFinal = 28d;
        new Dolar(monto, cotizacionInicial, cotizacionFinal);
    }

    @Test(expected = CampoIncorrectoExcepcion.class)
    public void lanzaExcepcionCuandoIngresaCotizacionFinalConValorMenos1() throws CampoIncorrectoExcepcion{

        Double monto = 100d;
        Double cotizacionInicial = 20d;
        Double cotizacionFinal = -1d;
        new Dolar(monto, cotizacionInicial, cotizacionFinal);
    }
}
