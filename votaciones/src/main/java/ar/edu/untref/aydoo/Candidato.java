package ar.edu.untref.aydoo;

public class Candidato {

    private DatosPersonales datosPersonales;
    private Integer cantidadDeVotos;

    public Candidato(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
        this.cantidadDeVotos = 0;
    }

    public void recibirVoto() {
        this.cantidadDeVotos += 1;
    }

    public Integer obtenerCantidadDeVotos() {
        return this.cantidadDeVotos;
    }
}
