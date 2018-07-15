package ar.edu.untref.aydoo;

public class PlazoFijoTradicional implements Inversion {

    private Double monto;
    private Integer interes;
    private Integer plazoAcordado;

    public PlazoFijoTradicional(Double monto, Integer interes, Integer plazoAcordado) throws CampoIncorrectoExcepcion {
        validarCamposDeEntrada(monto, interes, plazoAcordado);
        this.monto = monto;
        this.interes = interes;
        this.plazoAcordado = plazoAcordado;
    }

    @Override
    public Double calcularGanancia() {
        Double ganancia = (plazoAcordado / 365) * (interes / 100d) * monto;
        return ganancia;
    }

    private void validarCamposDeEntrada(Double monto, Integer interes, Integer plazoAcordado) throws CampoIncorrectoExcepcion {
        if (monto == null || monto <= 0d) {
            throw new CampoIncorrectoExcepcion("El monto debe ser mayor que 0.");
        }
    }
}
