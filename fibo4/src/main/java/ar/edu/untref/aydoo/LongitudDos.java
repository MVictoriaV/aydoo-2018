package ar.edu.untref.aydoo;

public class LongitudDos {

    public void fiboLongDos(String args[]){
        if(args[0].toString().equals("-o=vd") && args.length == 2){
            imprimirVerticalAscendente(args);
            return;
        }
        else if(args[0].toString().equals("-o=vi") && args.length == 2){
            imprimirVerticalDescendente(args);
            return;
        }
        else if(args[0].toString().equals("-o=hi") && args.length == 2){
            imprimirHorizontalDescendente(args);
            return;
        }
        else if(args.length == 1){
            imprimirHorizontalAscendente(args);
            return;
        }
        System.out.println("Opciones no validas.");

    }

    public static void imprimirHorizontalAscendente(String args[]){
        try{
            int numero1 = 0;
            int numero2 = 1;
            int temporal;
            int limite = Integer.parseInt(args[args.length -1]);

            System.out.print("fibo<"+ args[0] + ">: " + numero1 + " ");
            System.out.print(numero2 + " ");


            for(int i = 1; i <= limite-2; i++){
                temporal = numero1;
                numero1 = numero2;
                numero2 = temporal + numero1;
                System.out.print(numero2 + " ");
            }
        }catch(Exception e){
            System.out.println("Opciones no validas.");
        }

    }

    public static void imprimirHorizontalDescendente(String args[]){
        int parametroNumerico = Integer.parseInt(args[args.length -1]);
        int arregloFibo[] = new int[parametroNumerico -2];

        int numero1 = 0;
        int numero2 = 1;
        int temporal;
        int limite = parametroNumerico;

        for(int i = 1; i <= limite-2; i++){
            temporal = numero1;
            numero1 = numero2;
            numero2 = temporal + numero1;
            arregloFibo[i-1] = numero2;
        }
        System.out.print("fibo<"+parametroNumerico + ">: ");
        for(int i = arregloFibo.length; i > 0; i--){
            System.out.print(arregloFibo[i -1] + " ");
        }

        System.out.print(1 + " ");
        System.out.print(0 + " ");

    }

    public static void imprimirVerticalAscendente(String args[]){
        int numero1 = 0;
        int numero2 = 1;
        int temporal;
        int limite = Integer.parseInt(args[1]);

        System.out.println("fibo<"+ args[1]+ ">:");
        System.out.println(numero1 + " ");
        System.out.println(numero2 + " ");


        for(int i = 1; i <= limite-2; i++){
            temporal = numero1;
            numero1 = numero2;
            numero2 = temporal + numero1;
            System.out.println(numero2 + " ");
        }


    }

    public static void imprimirVerticalDescendente(String args[]){
        int parametroNumerico = Integer.parseInt(args[args.length -1]);
        int arregloFibo[] = new int[parametroNumerico -2];

        int numero1 = 0;
        int numero2 = 1;
        int temporal;
        int limite = parametroNumerico;

        for(int i = 1; i <= limite-2; i++){
            temporal = numero1;
            numero1 = numero2;
            numero2 = temporal + numero1;
            arregloFibo[i-1] = numero2;
        }
        System.out.println("fibo<"+parametroNumerico + ">:");
        for(int i = arregloFibo.length; i > 0; i--){
            System.out.println(arregloFibo[i -1]);
        }

        System.out.println(1 + " ");
        System.out.println(0 + " ");

    }
}
