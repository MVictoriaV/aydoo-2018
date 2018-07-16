package ar.edu.untref.aydoo;

public class Dolar implements Inversion {

    private Double monto;
    private Double cotizacionInicial;
    private Double cotizacionFinal;

    public Dolar(Double monto, Double cotizacionInicial, Double cotizacionFinal) {
        this.monto = monto;
        this.cotizacionInicial = cotizacionInicial;
        this.cotizacionFinal = cotizacionFinal;
    }

    @Override
    public Double calcularGanancia() {
        return ((monto / cotizacionInicial) * cotizacionFinal) - monto;
    }
}
