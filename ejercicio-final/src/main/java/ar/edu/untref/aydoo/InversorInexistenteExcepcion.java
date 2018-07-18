package ar.edu.untref.aydoo;

public class InversorInexistenteExcepcion extends Exception {

    private static final String mensaje = "Inversor inexistente";

    public InversorInexistenteExcepcion(){
        super(mensaje);
    }
}
