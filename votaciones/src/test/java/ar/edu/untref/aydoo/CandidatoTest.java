package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CandidatoTest {

    @Test
    public void recibirVotoDeberiaRetornaUnVoto(){

        Candidato candidatoPorLaPaz = new Candidato("Cosme", "Fulanito", 12345678);

        candidatoPorLaPaz.recibirVoto();

        Assert.assertEquals(1, candidatoPorLaPaz.obtenerCantidadDeVotos());
    }


    @Ignore@Test
    public void recibir2VotosDeberiaRetorna3Votos(){

        Candidato candidatoPorLaPaz = new Candidato("Cosme", "Fulanito", 12345678);

        candidatoPorLaPaz.recibirVoto();
        candidatoPorLaPaz.recibirVoto();

        Assert.assertEquals(2, candidatoPorLaPaz.obtenerCantidadDeVotos());
    }
}
