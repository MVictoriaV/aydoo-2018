package ar.edu.untref.aydoo;

public class GananciaNegativaExcepcion extends Exception{
    public GananciaNegativaExcepcion(){
        super("El monto de la ganancia no puede ser negativa");
    }
}
