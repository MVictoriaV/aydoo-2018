package ar.edu.untref.aydoo;

public class PlazoFijoPrecancelable extends PlazoFijoTradicional {

    private Integer plazoReal;

    public PlazoFijoPrecancelable(Double monto, Integer interes, Integer plazoAcordado, Integer plazoReal) throws CampoIncorrectoExcepcion {
        super(monto, interes, plazoAcordado);
        this.plazoReal = plazoReal;
    }

    @Override
    public Double calcularGanancia() {
        return 0d;
    }
}
