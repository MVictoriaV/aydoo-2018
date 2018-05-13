package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class opcionO {

    public void imprimirSumaEnFichero(String fichero, int suma, String opcionO, int[] arreglo) {



        FileWriter ficheroAEscribir = null;
        PrintWriter pw = null;
        String nombreFichero = fichero.substring(3);
        try {
            ficheroAEscribir = new FileWriter(nombreFichero);
            pw = new PrintWriter(ficheroAEscribir);

            if(opcionO == null || (opcionO.equals("-o=hi") || opcionO.equals("-o=hd"))){
                pw.println("fibo<"+arreglo.length+">s: " + suma);
                System.out.println("fibo<"+arreglo.length+"> guardado en "+nombreFichero);
            }

            else if(opcionO.equals("-o=vi") || opcionO.equals("-o=vd")){
                pw.println("fibo<"+arreglo.length+">s: ");
                pw.println(suma);
                System.out.println("fibo<"+arreglo.length+"> guardado en "+nombreFichero);
            }

            else{
                System.out.println("Opciones no validas.");
            }

            ficheroAEscribir.close();
        }
        catch (IOException e) {
            System.out.println("Opciones no validas.");
        }
    }

    public void imprimirArregloEnFichero(String fichero, String opcionO, int[] arreglo){
        FileWriter ficheroAEscribir = null;
        PrintWriter pw = null;
        String nombreFichero = fichero.substring(3);
        try {
            ficheroAEscribir = new FileWriter(nombreFichero);
            pw = new PrintWriter(ficheroAEscribir);

            if(opcionO == null || opcionO.equals("-o=hd")){
                pw.print("fibo<" + arreglo.length + ">: ");
                for(int i = 0; i < arreglo.length; i++){
                    pw.print(arreglo[i] + " ");
                }
                System.out.println("fibo<"+arreglo.length+"> guardado en "+nombreFichero);

            }
            else if(opcionO.equals("-o=vd")){
                pw.println("fibo<"+arreglo.length+">: ");
                for(int i = 0; i < arreglo.length; i++){
                    pw.println(arreglo[i]);
                }
                System.out.println("fibo<"+arreglo.length+"> guardado en "+nombreFichero);
            }
            else if(opcionO.equals("-o=vi")){
                pw.println("fibo<"+arreglo.length+">: ");
                for(int i = arreglo.length-1; i >= 0; i--){
                    pw.println(arreglo[i]);
                }
                System.out.println("fibo<"+arreglo.length+"> guardado en "+nombreFichero);
            }
            else if(opcionO.equals("-o=hi")){
                pw.print("fibo<" + arreglo.length + ">: ");
                for(int i = arreglo.length-1; i >= 0; i--){
                    pw.print(arreglo[i] + " ");
                }
                System.out.println("fibo<"+arreglo.length+"> guardado en "+nombreFichero);
            }
            else{
                System.out.println("Opciones no validas.");
            }

        }
        catch (IOException e){
            System.out.println("Opciones no validas.");
        }
        finally {
            try {
                ficheroAEscribir.close();
            }
            catch (Exception e2){
                System.out.println("Opciones no validas.");
            }

        }

    }

    public void imprimirSumaEnConsola(int suma, String opcionO, int [] arreglo){
        if(opcionO == null || opcionO.equals("-o=hi") || opcionO.equals("-o=hd")){
            System.out.println("fibo<"+arreglo.length+">s: " + suma);
        }
        else if(opcionO.equals("-o=vi") || opcionO.equals("-o=vd")){
            System.out.println("fibo<"+arreglo.length+">s: ");
            System.out.println(suma);
        }
        else{
            System.out.println("Opciones no validas.");
        }
    }

    public void imprimirArregloEnConsola(String opcionO, int [] arreglo){
        if(opcionO == null || opcionO.equals("-o=hd")){
            System.out.print("fibo<" + arreglo.length + ">: ");
            for(int i = 0; i < arreglo.length; i++){
                System.out.print(arreglo[i] + " ");
            }

        }
        else if(opcionO.equals("-o=vd")){
            System.out.println("fibo<"+arreglo.length+">: ");
            for(int i = 0; i < arreglo.length; i++){
                System.out.println(arreglo[i]);
            }

        }
        else if(opcionO.equals("-o=vi")){
            System.out.println("fibo<"+arreglo.length+">: ");
            for(int i = arreglo.length-1; i >= 0; i--){
                System.out.println(arreglo[i]);
            }
        }
        else if(opcionO.equals("-o=hi")){
            System.out.print("fibo<" + arreglo.length + ">: ");
            for(int i = arreglo.length-1; i >= 0; i--){
                System.out.print(arreglo[i] + " ");
            }
        }
        else{
            System.out.println("Opciones no validas.");
        }
    }

}
