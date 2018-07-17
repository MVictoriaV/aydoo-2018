package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PlazoFijoPrecancelableTest {

    @Test
    public void seCalculaUnaGananciaConUnInteresDel10PorcDebeRetornar1232() throws CampoIncorrectoExcepcion {

        Double monto = 100000d;
        Integer interes = 10;
        Integer plazoAcordado = 90;
        Integer plazoReal = 45;
        Inversion pfp = new PlazoFijoPrecancelable(monto, interes, plazoAcordado, plazoReal);

        Double gananciaReal = pfp.calcularGanancia();
        Double gananciaEsperada = 1232.9d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
    }

    @Test
    public void seCalculaUnaGananciaConUnInteresDel10PorcDebeRetornar3698() throws CampoIncorrectoExcepcion {

        Double monto = 200000d;
        Integer interes = 15;
        Integer plazoAcordado = 90;
        Integer plazoReal = 30;
        Inversion pfp = new PlazoFijoPrecancelable(monto, interes, plazoAcordado, plazoReal);

        Double gananciaReal = pfp.calcularGanancia();
        Double gananciaEsperada = 3698.6d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
    }

    @Test(expected = CampoIncorrectoExcepcion.class)
    public void lanzaExcepcionCuandoIngresaMontoConValor0() throws CampoIncorrectoExcepcion{

        Double monto = 0d;
        Integer interes = 10;
        Integer plazoAcordado = 365;
        Integer plazoReal = 365;
        new PlazoFijoPrecancelable(monto, interes, plazoAcordado, plazoReal);
    }
}
