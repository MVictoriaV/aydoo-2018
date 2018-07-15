package ar.edu.untref.aydoo;

public class PlazoFijoTradicional implements Inversion {

    private Double monto;
    private Integer interes;
    private Integer plazoAcordado;

    public PlazoFijoTradicional(Double monto, Integer interes, Integer plazoAcordado) throws CampoIncorrectoExcepcion {
        validarCamposDePlazoFijo(monto, interes, plazoAcordado);
        this.monto = monto;
        this.interes = interes;
        this.plazoAcordado = plazoAcordado;
    }

    @Override
    public Double calcularGanancia() {
        Double plazoCalculado = (Math.floor((plazoAcordado / 365d) * 10000) / 10000);
        return (plazoCalculado * (interes / 100d) * monto);
    }

    private void validarCamposDePlazoFijo(Double monto, Integer interes, Integer plazoAcordado) throws CampoIncorrectoExcepcion {
        if (monto == null || monto <= 0d) {
            throw new CampoIncorrectoExcepcion("El monto debe ser mayor que 0");
        }
        if (interes == null || interes <= 0 || interes > 100) {
            throw new CampoIncorrectoExcepcion("El interes debe tener un valor comprendido entre 1 y 100");
        }
        if (plazoAcordado == null || plazoAcordado <= 0 || plazoAcordado > 365) {
            throw new CampoIncorrectoExcepcion("El plazo acordado debe tener un valor comprendido entre 1 y 365");
        }
    }
}
