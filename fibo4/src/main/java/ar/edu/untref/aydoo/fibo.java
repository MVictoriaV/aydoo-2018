package ar.edu.untref.aydoo;

public class fibo {
    public static void main(String[] args) {
        try {
            int limite = Integer.parseInt(args[args.length - 1]);

            arregloDeNumeros claseArreglo = new arregloDeNumeros();
            int[] arreglo = claseArreglo.obtenerArregloDeNumerosDeFibonacci(limite);

            if(args.length == 1){
                System.out.print("fibo<" + args.length + ">: ");
                System.out.print("0 1 ");
                for (int i = 2; i < arreglo.length; i++ ){
                    System.out.print(arreglo[i] + " ");
                }
                return;
            }

            String opcionO = null;
            String opcionF = null;
            String opcionM = null;
            String opcionNumerosPares = null;


            for (int i = 0; i < args.length - 1; i++) {
                String subString = args[i].substring(0, 2);

                if (subString.equals("-m")) {
                    opcionM = args[i].toString();
                }
                if (subString.equals("-f")) {
                    opcionF = args[i].toString();
                }
                if (subString.equals("-o")) {
                    opcionO = args[i].toString();
                }
                if (subString.equals("-n")) {
                    opcionNumerosPares = args[i].toString();
                }
            }
            int sumaDeFibonaccis = 0;
            if (opcionM != null) {
                if (opcionM.equals("-m=s")) {
                    sumaDeFibonaccis = sumar((opcionNumerosPares != null), arreglo);
                } else if (opcionM.equals("-m=l")) {

                } else {
                    System.out.println("Opciones no validas.");
                    return;
                }
            }
            int limiteSerie = arreglo.length;
            if (opcionNumerosPares != null) {
                arreglo = crearSeriePar(arreglo);
            }

            if (opcionF != null) {
                if (opcionF.substring(0, 3).equals("-f=")) {
                    opcionF opcionFile = new opcionF();
                    opcionFile.imprimirEnFichero(arreglo, sumaDeFibonaccis, opcionF, opcionO);
                    return;
                }
            } else {
                opcionNoF impresionEnConsola = new opcionNoF();
                impresionEnConsola.imprimirEnConsola(sumaDeFibonaccis, opcionO, arreglo, limiteSerie);
                return;
            }

        } catch (Exception e) {
            System.out.println("Opciones no validas.");
        }

    }

    private static int[] crearSeriePar(int[] serieReal) {

        int[] serieAuxiliar = new int[contarNumerosPares(serieReal)];
        int posicion = 0;
        for (int i = 0; i < serieReal.length; i++) {
            if (serieReal[i] != 0 && esNumeroPar(serieReal[i])){
                serieAuxiliar[posicion] = serieReal[i];
                posicion++;
            }
        }
        return serieAuxiliar;
    }

    private static int contarNumerosPares(int[] serieReal) {
        int cantidadDeNrosPares = 0;
        for (int i = 0; i < serieReal.length; i++) {
            if (serieReal[i] != 0 && esNumeroPar(serieReal[i])){
                cantidadDeNrosPares++;
            }
        }
        return cantidadDeNrosPares;
    }

    private static int sumar(boolean esSumaDeNrosPares, int[] serie) {
        Integer resultado = 0;
        if (esSumaDeNrosPares) {
            resultado = sumaSoloNumerosPares(serie);
        } else {
            resultado = sumaTodosLosNumeros(serie);
        }
        return resultado;
    }

    private static Integer sumaTodosLosNumeros(int[] serie) {
        Integer resultado = 0;
        for (int i = 0; i < serie.length; i++) {
            resultado += serie[i];
        }
        return resultado;
    }

    private static Integer sumaSoloNumerosPares(int[] serie) {
        Integer resultado = 0;
        for (int i = 0; i < serie.length; i++) {
            if(esNumeroPar(serie[i])) {
                resultado += serie[i];
            }
        }
        return resultado;
    }

    private static boolean esNumeroPar(Integer numero){
     return (numero%2==0);
    }
}
