package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CandidatoTest {

    @Test
    public void recibirVotoDeberiaRetornaUnVoto(){

        Candidato candidatoPorLaPaz = new Candidato("Cosme", "Fulanito", 12345678);
        int unVoto = 1;

        candidatoPorLaPaz.recibirVoto(unVoto);

        Assert.assertEquals(1, candidatoPorLaPaz.obtenerCantidadDeVotos());
    }
}
