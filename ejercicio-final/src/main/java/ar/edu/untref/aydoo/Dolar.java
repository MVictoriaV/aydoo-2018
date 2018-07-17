package ar.edu.untref.aydoo;

public class Dolar implements Inversion {

    private Double monto;
    private Double cotizacionInicial;
    private Double cotizacionFinal;

    public Dolar(Double monto, Double cotizacionInicial, Double cotizacionFinal) throws CampoIncorrectoExcepcion {
        validar(monto, cotizacionInicial, cotizacionFinal);
        this.monto = monto;
        this.cotizacionInicial = cotizacionInicial;
        this.cotizacionFinal = cotizacionFinal;
    }

    @Override
    public Double calcularGanancia() {
        return ((monto / cotizacionInicial) * cotizacionFinal) - monto;
    }

    @Override
    public String getTipoInversion() {
        return "dol";
    }

    private void validar(Double monto, Double cotizacionInicial, Double cotizacionFinal) throws CampoIncorrectoExcepcion {
        if (monto == null || monto <= 0d) {
            throw new CampoIncorrectoExcepcion("El monto debe ser mayor que 0");
        }
        if (cotizacionInicial == null || cotizacionInicial <= 0) {
            throw new CampoIncorrectoExcepcion("La cotizacion inicial debe ser mayor que 0");
        }
        if (cotizacionFinal == null || cotizacionFinal <= 0) {
            throw new CampoIncorrectoExcepcion("La cotizacion final debe ser mayor que 0");
        }
    }
}
