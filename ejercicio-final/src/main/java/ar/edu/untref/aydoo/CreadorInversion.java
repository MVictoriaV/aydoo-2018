package ar.edu.untref.aydoo;

public class CreadorInversion {

    private String tipoInversion;
    private String[] datosInversion;

    public CreadorInversion(String[] argumentos) throws CantidadArgumentosInvalidaExcepcion {

        if (argumentos == null || argumentos.length < 4 || argumentos.length > 5) {
            throw new CantidadArgumentosInvalidaExcepcion();
        }
        tipoInversion = argumentos[0];
        datosInversion = new String[argumentos.length-1];
        for (int i = 1; i < argumentos.length; i++) {
            int j = i-1;
            datosInversion[j] = argumentos[i];
        }
    }

    public Inversion crear() throws CampoIncorrectoExcepcion, ValorInversionIncorrectoExcepcion {
        Inversion inversion = null;
        if (tipoInversion.matches("pft")) {
            inversion = crearPlazoFijoTradicional();
        }
        return inversion;
    }

    private PlazoFijoTradicional crearPlazoFijoTradicional() throws CampoIncorrectoExcepcion, ValorInversionIncorrectoExcepcion {
        try {
            Integer.valueOf(datosInversion[0]);
            Integer.valueOf(datosInversion[1]);
            Double.valueOf(datosInversion[2]);
        } catch (NumberFormatException exepcion) {
            throw new ValorInversionIncorrectoExcepcion("Valores incorrectos para la inversion plazo fijo tradicional");
        }
        return new PlazoFijoTradicional(Double.valueOf(datosInversion[2]), Integer.valueOf(datosInversion[1]), Integer.valueOf(datosInversion[0]));
    }
}