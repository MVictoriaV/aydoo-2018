package ar.edu.untref.aydoo;

public class Cliente {

    private DatosPersonales datosPersonales;

    public Cliente(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Boolean asignarSuscripcion(Producto revistaInfantil) {
        return true;
    }

    public Boolean contieneSuscripcion(Producto revistaInfantil) {
        return false;
    }
}
