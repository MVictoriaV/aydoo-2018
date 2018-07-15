package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PlazoFijoTradicionalTest {

    @Test
    public void seCalculaUnaGananciaConUnInteresDel10PorcDebeRetornar50000() {

        Double monto = 500000d;
        Integer interes = 10;
        Integer plazoAcordado = 365;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);

        Double gananciaReal = pft.calcularGanancia();
        Double gananciaEsperada = 50000d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
    }
}
