package ar.edu.untref.aydoo;

public class ImpresoraProgresiva {

    public StringBuffer imprimirSerie(int[] serie) {
        StringBuffer impresionDeLaSerie = new StringBuffer();
        for (int i = 0; i < serie.length; i++) {
            for (int j = 0; j <= i; j++) {
                impresionDeLaSerie.append(serie[j] + " ");
            }
            impresionDeLaSerie.append("\n");
        }
        return impresionDeLaSerie;
    }
}
