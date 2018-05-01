package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PartidoTest {

    @Test
    public void cargarCandidatoAlListadoDeberiaTenerUnCandidato(){

        Partido partidoX = new Partido("XYZ");
        Candidato cosme = new Candidato("Cosme", "Fulanito", 12345678);

        partidoX.cargarCandidatoAlListado(cosme, Provincia.BUENOS_AIRES);

        Assert.assertTrue(partidoX.contieneCandidato(cosme, Provincia.BUENOS_AIRES));
    }

    @Test
    public void cargar2CandidatosAlListado(){

        Partido partidoX = new Partido("XYZ");
        Candidato cosme = new Candidato("Cosme", "Fulanito", 12345678);
        Candidato pepe = new Candidato("Pepe", "Fulanito", 12345679);

        partidoX.cargarCandidatoAlListado(cosme, Provincia.BUENOS_AIRES);
        partidoX.cargarCandidatoAlListado(pepe, Provincia.BUENOS_AIRES);

        Assert.assertTrue(partidoX.contieneCandidato(cosme, Provincia.BUENOS_AIRES));
    }
}
