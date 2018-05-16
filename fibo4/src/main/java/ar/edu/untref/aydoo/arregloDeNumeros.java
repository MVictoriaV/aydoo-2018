package ar.edu.untref.aydoo;

public class arregloDeNumeros {

    public int[] obtenerArregloDeNumerosDeFibonacci(int limite){
        int numero1 = 0;
        int numero2 = 1;
        int temporal;
        int[] arreglo = new int[limite];
        arreglo[0] = 0;
        arreglo[1] = 1;

        for(int i = 2; i < limite; i++){
            temporal = numero1;
            numero1 = numero2;
            numero2 = temporal + numero1;
            arreglo[i] = numero2;
        }
        return arreglo;
    }
}
