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
}
