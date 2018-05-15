package ar.edu.untref.aydoo;

public class opcionNoF {

    public void imprimirEnConsola(int suma, String opcionO, int[] arreglo, int limiteSerie) {

        opcionO OpcionO = new opcionO();
        try {
            if(suma != 0){
                OpcionO.imprimirSumaEnConsola(suma, opcionO, arreglo, limiteSerie);
            }
            else{
                OpcionO.imprimirArregloEnConsola(opcionO,arreglo, limiteSerie);
            }

        }
        catch (Exception e){
            System.out.println("Opciones no validas.");
        }
    }
}
