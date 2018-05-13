package ar.edu.untref.aydoo;

public class opcionNoF {

    public void imprimirEnConsola(int suma, String opcionO, int[] arreglo) {

        opcionO OpcionO = new opcionO();
        try {
            if(suma != 0){
                OpcionO.imprimirSumaEnConsola(suma, opcionO, arreglo);
            }
            else{
                OpcionO.imprimirArregloEnConsola(opcionO,arreglo);
            }

        }
        catch (Exception e){
            System.out.println("Opciones no validas.");
        }
    }
}
