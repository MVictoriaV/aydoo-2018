package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CandidatoTest {

    @Test
    public void recibirVotoDeberiaRetornaUnVoto(){

        Candidato candidatoPorLaPaz = new Candidato("Cosme", "Fulanito", 12345678);

        candidatoPorLaPaz.recibirVoto();

        Assert.assertEquals(Integer.valueOf(1), candidatoPorLaPaz.obtenerCantidadDeVotos());
    }

    @Test
    public void recibir2VotosDeberiaRetorna2Votos(){

        Candidato candidatoPorLaPaz = new Candidato("Cosme", "Fulanito", 12345678);

        candidatoPorLaPaz.recibirVoto();
        candidatoPorLaPaz.recibirVoto();

        Assert.assertEquals(Integer.valueOf(2), candidatoPorLaPaz.obtenerCantidadDeVotos());
    }
}
