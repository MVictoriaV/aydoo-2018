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
            }

            int sumaDeFibonaccis = 0;
            if (opcionM != null) {
                if (opcionM.equals("-m=s")) {
                    for (int i = 0; i < arreglo.length; i++) {
                        sumaDeFibonaccis += arreglo[i];
                    }
                } else if (opcionM.equals("-m=l")) {

                } else {
                    System.out.println("Opciones no validas.");
                    return;
                }
            }

            if (opcionF != null) {
                if (opcionF.substring(0, 3).equals("-f=")) {
                    opcionF opcionFile = new opcionF();
                    opcionFile.imprimirEnFichero(arreglo, sumaDeFibonaccis, opcionF, opcionO);
                    return;
                }
            } else {
                opcionNoF impresionEnConsola = new opcionNoF();
                impresionEnConsola.imprimirEnConsola(sumaDeFibonaccis, opcionO, arreglo);
                return;
            }

        } catch (Exception e) {
            System.out.println("Opciones no validas.");
        }

    }

}
