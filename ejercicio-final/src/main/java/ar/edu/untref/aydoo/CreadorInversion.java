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

    public Inversion crear() throws CampoIncorrectoExcepcion, ValorInversionIncorrectoExcepcion, CantidadArgumentosInvalidaExcepcion, InversionInexistenExcepcion {
        Inversion inversion;
        switch (tipoInversion){
            case "pft":
                inversion = crearPlazoFijoTradicional();
                break;
            case "pfp":
                inversion = crearPlazoFijoPrecancelable();
                break;
            case "dol":
                inversion = crearDolar();
                break;
            default:
                throw new InversionInexistenExcepcion("Sin inversion, inversion nula. Debe tener al menos una inversion");
        }
        return inversion;
    }

    private PlazoFijoTradicional crearPlazoFijoTradicional() throws CampoIncorrectoExcepcion, ValorInversionIncorrectoExcepcion {
        try {
            Integer.valueOf(datosInversion[0]);
            Integer.valueOf(datosInversion[1]);
            Double.valueOf(datosInversion[2]);
        } catch (NumberFormatException excepcion) {
            throw new ValorInversionIncorrectoExcepcion("Valores incorrectos para la inversion plazo fijo tradicional");
        }
        return new PlazoFijoTradicional(Double.valueOf(datosInversion[2]), Integer.valueOf(datosInversion[1]), Integer.valueOf(datosInversion[0]));
    }

    private PlazoFijoPrecancelable crearPlazoFijoPrecancelable() throws CampoIncorrectoExcepcion, ValorInversionIncorrectoExcepcion, CantidadArgumentosInvalidaExcepcion {
        try {
            Integer.valueOf(datosInversion[0]);
            Integer.valueOf(datosInversion[1]);
            Integer.valueOf(datosInversion[2]);
            if(datosInversion.length == 3) {
                throw new CantidadArgumentosInvalidaExcepcion();
            }
            Double.valueOf(datosInversion[3]);
        } catch (NumberFormatException excepcion) {
            throw new ValorInversionIncorrectoExcepcion("Valores incorrectos para la inversion plazo fijo precancelable");
        }
        return new PlazoFijoPrecancelable(Double.valueOf(datosInversion[3]), Integer.valueOf(datosInversion[2]), Integer.valueOf(datosInversion[0]), Integer.valueOf(datosInversion[1]));
    }

    private Dolar crearDolar() throws CampoIncorrectoExcepcion, ValorInversionIncorrectoExcepcion {
        try {
            Double.valueOf(datosInversion[0]);
            Double.valueOf(datosInversion[1]);
            Double.valueOf(datosInversion[2]);
        } catch (NumberFormatException excepcion) {
            throw new ValorInversionIncorrectoExcepcion("Valores incorrectos para la inversion dolar");
        }
        return new Dolar(Double.valueOf(datosInversion[0]), Double.valueOf(datosInversion[1]), Double.valueOf(datosInversion[2]));
    }
}