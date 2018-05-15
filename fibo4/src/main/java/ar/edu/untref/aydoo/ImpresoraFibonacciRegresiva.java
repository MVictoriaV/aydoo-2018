package ar.edu.untref.aydoo;

public class ImpresoraFibonacciRegresiva implements ImpresoraFibonacci {

    @Override
    public StringBuffer imprimirSerie(int[] serie) {
        StringBuffer impresionDeLaSerie = new StringBuffer();
        for (int i = (serie.length-1); i >= 0; i--) {
            for (int j = (serie.length-1); j >= i; j--) {
                impresionDeLaSerie.append(serie[j] + " ");
            }
            impresionDeLaSerie.append("\n");
        }
        return impresionDeLaSerie;
    }
}
