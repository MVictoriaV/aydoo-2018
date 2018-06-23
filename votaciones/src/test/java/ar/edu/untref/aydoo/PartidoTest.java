package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartidoTest {

    private Partido partidoDeBsAs;
    private Candidato candidatoCosme;

    @Before
    public void crearCandidato() {
        DatosPersonales dp = new DatosPersonales("Cosme", "Fulanito", 12345678);
        candidatoCosme = new Candidato(dp);
        partidoDeBsAs = new Partido("Partido de Buenos Aires");
    }

    @Test
    public void cargarCandidatoAlListadoDeberiaTenerUnCandidato(){

        partidoDeBsAs.cargarCandidatoAlListado(candidatoCosme, Provincia.BUENOS_AIRES);

        Assert.assertTrue(partidoDeBsAs.contieneCandidato(candidatoCosme, Provincia.BUENOS_AIRES));
    }

    @Test
    public void cargar2CandidatosAlListado(){

        Candidato pepe = crearOtroCandidato();

        partidoDeBsAs.cargarCandidatoAlListado(pepe, Provincia.BUENOS_AIRES);
        partidoDeBsAs.cargarCandidatoAlListado(candidatoCosme, Provincia.BUENOS_AIRES);

        Assert.assertTrue(partidoDeBsAs.contieneCandidato(pepe, Provincia.BUENOS_AIRES));
        Assert.assertTrue(partidoDeBsAs.contieneCandidato(candidatoCosme, Provincia.BUENOS_AIRES));
    }

    @Test
    public void recibeVotoUnCandidatoDelListadoSumaUnPuntoElPartido(){

        partidoDeBsAs.cargarCandidatoAlListado(candidatoCosme, Provincia.BUENOS_AIRES);

        partidoDeBsAs.recibirVoto(candidatoCosme);

        Assert.assertEquals(Integer.valueOf(1), partidoDeBsAs.cantidadDeVotos(Provincia.BUENOS_AIRES));
    }

    @Test
    public void recibe3VotoCandidatoDelListadoSuma3PuntosElPartido(){

        partidoDeBsAs.cargarCandidatoAlListado(candidatoCosme, Provincia.BUENOS_AIRES);

        partidoDeBsAs.recibirVoto(candidatoCosme);
        partidoDeBsAs.recibirVoto(candidatoCosme);
        partidoDeBsAs.recibirVoto(candidatoCosme);

        Assert.assertEquals(Integer.valueOf(3), partidoDeBsAs.cantidadDeVotos(Provincia.BUENOS_AIRES));
    }

    @Test
    public void obtenerElCandidatoQueMasVotosTuvo(){

        partidoDeBsAs.cargarCandidatoAlListado(candidatoCosme, Provincia.BUENOS_AIRES);

        partidoDeBsAs.recibirVoto(candidatoCosme);

        Candidato candidatoEstrella = partidoDeBsAs.obtenerCandidatoMasVotado(Provincia.BUENOS_AIRES);

        Assert.assertEquals(candidatoCosme, candidatoEstrella);
    }

    private Candidato crearOtroCandidato(){
        DatosPersonales dp = new DatosPersonales("Pepe", "Fulanito", 12345679);
        return new Candidato(dp);
    }
}
