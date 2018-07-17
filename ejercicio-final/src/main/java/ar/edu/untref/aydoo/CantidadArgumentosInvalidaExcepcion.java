package ar.edu.untref.aydoo;

public class CantidadArgumentosInvalidaExcepcion extends Exception {

    private static final String mensaje = "Cantidad de argumentos invalida";

    public CantidadArgumentosInvalidaExcepcion(){
        super(mensaje);
    }
}
