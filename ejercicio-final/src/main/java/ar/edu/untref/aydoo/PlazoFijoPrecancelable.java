package ar.edu.untref.aydoo;

public class PlazoFijoPrecancelable extends PlazoFijoTradicional {

    private Integer plazoReal;

    public PlazoFijoPrecancelable(Double monto, Integer interes, Integer plazoAcordado, Integer plazoReal) throws CampoIncorrectoExcepcion {
        super(monto, interes, plazoAcordado);
        this.plazoReal = plazoReal;
    }

    @Override
    public Double calcularGanancia() {
        Double valorSegunDifPlazos = (super.getPlazoAcordado() - plazoReal == 0) ? 1d : 0.5d;
        return ((super.getPlazoAcordado() / 365d) * (super.getInteres() / 100d) * super.getMonto() * valorSegunDifPlazos);
    }
}
