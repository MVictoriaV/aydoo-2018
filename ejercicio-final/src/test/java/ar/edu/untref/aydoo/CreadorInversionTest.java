package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CreadorInversionTest {

    @Test
    public void seCreaUnaInversionDelTipoPFTCuandoRecibePft() throws ValorInversionIncorrectoExcepcion, CampoIncorrectoExcepcion, CantidadArgumentosInvalidaExcepcion {

        String[] argumentos = new String[]{"pft", "365", "10", "5000"};
        CreadorInversion creadorInversion = new CreadorInversion(argumentos);

        Inversion pft = creadorInversion.crear();

        String tipoInversion = pft.getTipoInversion();

        Assert.assertEquals("pft", tipoInversion);
    }

    @Test(expected = CantidadArgumentosInvalidaExcepcion.class)
    public void seCreaUnaInversionDelTipoPFTSinEl3erArgDeberiaLanzarExcepcion() throws ValorInversionIncorrectoExcepcion, CampoIncorrectoExcepcion, CantidadArgumentosInvalidaExcepcion {

        String[] argumentos = new String[]{"pft", "365", "10"};
        new CreadorInversion(argumentos);
    }

    @Test
    public void seCreaUnaInversionDelTipoPFTCuandoRecibePfp() throws ValorInversionIncorrectoExcepcion, CampoIncorrectoExcepcion, CantidadArgumentosInvalidaExcepcion {

        String[] argumentos = new String[]{"pfp", "365", "300", "40", "100000"};
        CreadorInversion creadorInversion = new CreadorInversion(argumentos);

        Inversion pft = creadorInversion.crear();

        String tipoInversion = pft.getTipoInversion();

        Assert.assertEquals("pfp", tipoInversion);
    }

    @Test
    public void seCreaUnaInversionDelTipoDolarCuandoRecibeDol() throws ValorInversionIncorrectoExcepcion, CampoIncorrectoExcepcion, CantidadArgumentosInvalidaExcepcion {

        String[] argumentos = new String[]{"dol", "100", "20", "25"};
        CreadorInversion creadorInversion = new CreadorInversion(argumentos);

        Inversion pft = creadorInversion.crear();

        String tipoInversion = pft.getTipoInversion();

        Assert.assertEquals("dol", tipoInversion);
    }

    @Test(expected = CantidadArgumentosInvalidaExcepcion.class)
    public void seCreaUnaInversionDelTipoDolarSinEl2doArgDeberiaLanzarExcepcion() throws ValorInversionIncorrectoExcepcion, CampoIncorrectoExcepcion, CantidadArgumentosInvalidaExcepcion {

        String[] argumentos = new String[]{"dol", "100", "20"};
        new CreadorInversion(argumentos);
    }

    @Test(expected = CantidadArgumentosInvalidaExcepcion.class)
    public void seCreaUnaInversionDelTipoPFPSinUnArgDeberiaLanzarExcepcion() throws ValorInversionIncorrectoExcepcion, CampoIncorrectoExcepcion, CantidadArgumentosInvalidaExcepcion {

        String[] argumentos = new String[]{"pfp", "365", "300", "40"};
        new CreadorInversion(argumentos).crear();

    }
}
