package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConsejoElectoralTest {

    @Test
    public void calcularCandidatosMasVotadoEnLaProvinciaDeBsAs() {

        List<Partido> partidos = new ArrayList<>();
        partidos.add(crearPartidoX("X", Provincia.BUENOS_AIRES));
        partidos.add(crearPartidoY("Y", Provincia.BUENOS_AIRES));
        ConsejoElectoral consejo = new ConsejoElectoral();

        HashMap<Provincia, Candidato> ganadores = consejo.calcularCandidatoMasVotado(partidos);

        Candidato esperado = partidos.get(1).obtenerCandidatoMasVotado(Provincia.BUENOS_AIRES);
        Candidato actual = ganadores.get(Provincia.BUENOS_AIRES);

        Assert.assertEquals(esperado, actual);
    }

    private Partido crearPartidoX(String nombrePartido, Provincia provincia) {
        DatosPersonales dp = new DatosPersonales("Cosme", "Fulanito", 12345678);
        Candidato candidatoCosme = new Candidato(dp);
        Partido partidoX = new Partido(nombrePartido);
        partidoX.cargarCandidatoAlListado(candidatoCosme, provincia);
        partidoX.recibirVoto(candidatoCosme);
        partidoX.recibirVoto(candidatoCosme);
        return partidoX;
    }

    private Partido crearPartidoY(String nombrePartido, Provincia provincia) {
        DatosPersonales dp = new DatosPersonales("Cuesta", "Fulanito", 12345679);
        Candidato candidatoCosme = new Candidato(dp);
        Partido partidoX = new Partido(nombrePartido);
        partidoX.cargarCandidatoAlListado(candidatoCosme, provincia);
        partidoX.recibirVoto(candidatoCosme);
        partidoX.recibirVoto(candidatoCosme);
        partidoX.recibirVoto(candidatoCosme);
        partidoX.recibirVoto(candidatoCosme);
        return partidoX;
    }
}
