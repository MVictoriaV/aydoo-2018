package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartidoTest {

    private Candidato candidatoCosme;

    @Before
    public void crearCandidato() {
        DatosPersonales dp = new DatosPersonales("Cosme", "Fulanito", 12345678);
        candidatoCosme = new Candidato(dp);
    }

    @Test
    public void cargarCandidatoAlListadoDeberiaTenerUnCandidato(){

        Partido partidoX = new Partido("XYZ");

        partidoX.cargarCandidatoAlListado(candidatoCosme, Provincia.BUENOS_AIRES);

        Assert.assertTrue(partidoX.contieneCandidato(candidatoCosme, Provincia.BUENOS_AIRES));
    }

    @Test
    public void cargar2CandidatosAlListado(){

        Partido partidoX = new Partido("XYZ");
        Candidato pepe = crearOtroCandidato();

        partidoX.cargarCandidatoAlListado(pepe, Provincia.BUENOS_AIRES);
        partidoX.cargarCandidatoAlListado(candidatoCosme, Provincia.BUENOS_AIRES);

        Assert.assertTrue(partidoX.contieneCandidato(pepe, Provincia.BUENOS_AIRES));
    }

    private Candidato crearOtroCandidato(){
        DatosPersonales dp = new DatosPersonales("Pepe", "Fulanito", 12345679);
        return new Candidato(dp);
    }
}
