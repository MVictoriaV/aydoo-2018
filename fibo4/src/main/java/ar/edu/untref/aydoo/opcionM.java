package ar.edu.untref.aydoo;

public class opcionM {
    public static int sumarNumeros(int[] arregloEsperado, String M) {
        int suma = 0;
        if(M.equals("-m=s")){
            for(int i = 0; i < arregloEsperado.length; i++){
                suma += arregloEsperado[i];
            }

            return suma;
        }
        return suma;
    }
}