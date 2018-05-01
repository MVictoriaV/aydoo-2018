package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PartidoTest {

    @Test
    public void cargarCandidatoAlListadoDeberiaTenerUnCandidato(){

        Partido partidoX = new Partido();
        Candidato cosme = new Candidato("Cosme", "Fulanito", 12345678);

        partidoX.cargarCandidatoAlListado(cosme);

        Assert.assertTrue(partidoX.tieneCandidatos());
    }
}
