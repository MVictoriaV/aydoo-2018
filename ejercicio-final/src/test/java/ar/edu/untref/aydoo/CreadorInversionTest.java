package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CreadorInversionTest {

    @Test
    public void seCreaUnaInversionDelTipoPFTCuandoRecibepft() throws ValorInversionIncorrectoExcepcion, CampoIncorrectoExcepcion, CantidadArgumentosInvalidaExcepcion {

        String[] argumentos = new String[]{"pft", "365", "10", "5000"};
        CreadorInversion creadorInversion = new CreadorInversion(argumentos);

        Inversion pft = creadorInversion.crear();

        String tipoInversion = pft.getTipoInversion();

        Assert.assertEquals("pft", tipoInversion);
    }
}
