package ar.edu.untref.aydoo;

public class Candidato {

    private String nombre;
    private String apellido;
    private Integer numeroDNI;
    private Integer cantidadDeVotos;

    public Candidato(String nombre, String apellido, Integer numeroDNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDNI = numeroDNI;
        this.cantidadDeVotos = 0;
    }

    public void recibirVoto(Integer voto) {
        this.cantidadDeVotos += voto;
    }

    public int obtenerCantidadDeVotos() {
        return 1;
    }
}