package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PlazoFijoTradicionalTest {

    @Test
    public void seCalculaUnaGananciaConUnInteresDel10PorcDebeRetornar50000() throws CampoIncorrectoExcepcion {

        Double monto = 500000d;
        Integer interes = 10;
        Integer plazoAcordado = 365;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);

        Double gananciaReal = pft.calcularGanancia();
        Double gananciaEsperada = 50000d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.01);
    }

    @Test(expected = CampoIncorrectoExcepcion.class)
    public void lanzaExcepcionCuandoIngresaMontoConValor0() throws CampoIncorrectoExcepcion{

        Double monto = 0d;
        Integer interes = 10;
        Integer plazoAcordado = 365;
        new PlazoFijoTradicional(monto, interes, plazoAcordado);
    }

    @Test(expected = CampoIncorrectoExcepcion.class)
    public void lanzaExcepcionCuandoIngresaInteresConValorMenos1() throws CampoIncorrectoExcepcion{

        Double monto = 10000d;
        Integer interes = -1;
        Integer plazoAcordado = 365;
        new PlazoFijoTradicional(monto, interes, plazoAcordado);
    }

    @Test(expected = CampoIncorrectoExcepcion.class)
    public void lanzaExcepcionCuandoIngresaInteresConValor101() throws CampoIncorrectoExcepcion{

        Double monto = 10000d;
        Integer interes = 101;
        Integer plazoAcordado = 365;
        new PlazoFijoTradicional(monto, interes, plazoAcordado);
    }

    @Test(expected = CampoIncorrectoExcepcion.class)
    public void lanzaExcepcionCuandoIngresaPlazoAcordadoConValor366() throws CampoIncorrectoExcepcion{

        Double monto = 10000d;
        Integer interes = 10;
        Integer plazoAcordado = 366;
        new PlazoFijoTradicional(monto, interes, plazoAcordado);
    }

    @Test(expected = CampoIncorrectoExcepcion.class)
    public void lanzaExcepcionCuandoIngresaPlazoAcordadoConValor0() throws CampoIncorrectoExcepcion{

        Double monto = 10000d;
        Integer interes = 10;
        Integer plazoAcordado = 0;
        new PlazoFijoTradicional(monto, interes, plazoAcordado);
    }

    @Test
    public void seCalculaLaGananciaDe100000ConUnInteresDel10PorcDebeRetornar10000() throws CampoIncorrectoExcepcion {

        Double monto = 100000d;
        Integer interes = 10;
        Integer plazoAcordado = 365;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);

        Double gananciaReal = pft.calcularGanancia();
        Double gananciaEsperada = 10000d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.01);
    }

    @Test
    public void seCalculaLaGananciaDe100000ConPlazo90DiasDebeRetornar2466() throws CampoIncorrectoExcepcion {

        Double monto = 100000d;
        Integer interes = 10;
        Integer plazoAcordado = 90;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);

        Double gananciaReal = pft.calcularGanancia();
        Double gananciaEsperada = 2466d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 1);
    }

    @Test
    public void seCalculaLaGananciaDe200000ConUnInteresDe15PorcDiasDebeRetornar7397() throws CampoIncorrectoExcepcion {

        Double monto = 200000d;
        Integer interes = 15;
        Integer plazoAcordado = 90;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);

        Double gananciaReal = pft.calcularGanancia();
        Double gananciaEsperada = 7397d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
    }

    @Test
    public void seCalculaLaGananciaDe250000ConUnInteresDe40PorcDiasDebeRetornar24658() throws CampoIncorrectoExcepcion {

        Double monto = 250000d;
        Integer interes = 40;
        Integer plazoAcordado = 90;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);

        Double gananciaReal = pft.calcularGanancia();
        Double gananciaEsperada = 24658d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 1);
    }
}
