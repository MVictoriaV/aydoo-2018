package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.PrintWriter;

public class opcionF {

    public void imprimirEnFichero(int[] arreglo, int suma, String fichero, String opcionO) {

        opcionO OpcionO = new opcionO();
        try {
            if(suma != 0){
                OpcionO.imprimirSumaEnFichero(fichero, suma, opcionO, arreglo);
            }
            else{
                OpcionO.imprimirArregloEnFichero(fichero,opcionO,arreglo);
            }

        }
        catch (Exception e){
            System.out.println("Opciones no validas.");
        }
    }


}
