package ar.edu.untref.aydoo;

public class PlazoFijoTradicional implements Inversion {

    private Double monto;
    private Integer interes;
    private Integer plazoAcordado;

    public PlazoFijoTradicional(Double monto, Integer interes, Integer plazoAcordado) {
        this.monto = monto;
        this.interes = interes;
        this.plazoAcordado = plazoAcordado;
    }

    @Override
    public Double calcularGanancia() {
        Double ganancia = (plazoAcordado / 365) * (interes / 100d) * monto;
        return ganancia;
    }
}
