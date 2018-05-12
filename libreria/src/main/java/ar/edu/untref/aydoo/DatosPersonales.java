package ar.edu.untref.aydoo;

public class DatosPersonales {

    private String nombre;
    private String apellido;
    private String direccion;
    private Integer numeroDNI;

    public DatosPersonales(String nombre, String apellido, String direccion, Integer numeroDNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.numeroDNI = numeroDNI;
    }
}
