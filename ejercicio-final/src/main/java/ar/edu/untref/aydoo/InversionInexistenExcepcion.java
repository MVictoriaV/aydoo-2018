package ar.edu.untref.aydoo;

public class InversionInexistenExcepcion extends Exception{
    public InversionInexistenExcepcion(){
        super("Sin inversion, inversion nula. Debe tener al menos una inversion");
    }
}
