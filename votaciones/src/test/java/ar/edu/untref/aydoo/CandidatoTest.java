package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandidatoTest {

    private Candidato candidato;

    @Before
    public void crearCandidato() {
        DatosPersonales dp = new DatosPersonales("Cosme", "Fulanito", 12345678);
        candidato = new Candidato(dp);
    }

    @Test
    public void recibirVotoDeberiaRetornaUnVoto(){

        Candidato candidatoPorLaPaz = candidato;

        candidatoPorLaPaz.recibirVoto();

        Assert.assertEquals(Integer.valueOf(1), candidatoPorLaPaz.obtenerCantidadDeVotos());
    }

    @Test
    public void recibir2VotosDeberiaRetorna2Votos(){

        Candidato candidatoPorLaPaz = candidato;

        candidatoPorLaPaz.recibirVoto();
        candidatoPorLaPaz.recibirVoto();

        Assert.assertEquals(Integer.valueOf(2), candidatoPorLaPaz.obtenerCantidadDeVotos());
    }
}
