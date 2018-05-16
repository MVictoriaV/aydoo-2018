package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class testFibo3 {

    @Test
    public void imprimirAlgoEnArchivoVD(){

        String[] args = {"-o=vd","-f=salida.txt","-m=s", "5"};
        fibo.main(args);
    }

    @Test
    public void guardarEnArray(){

        arregloDeNumeros claseArreglo = new arregloDeNumeros();
        int[] arreglo = claseArreglo.obtenerArregloDeNumerosDeFibonacci(8);
        int[] arregloEsperado = {0,1,1,2,3,5,8,13};
        System.out.println(Arrays.toString(arreglo));
        System.out.println(Arrays.toString(arregloEsperado));

        Assert.assertTrue(Arrays.equals(arregloEsperado,arreglo));

    }

    @Test
    public void testFuncionSumarNumeros(){

        int[] arregloEsperado = {0,1,1,2,3,5,8,13};
        opcionM M = new opcionM();
        int suma = M.sumarNumeros(arregloEsperado, "-m=s");

        Assert.assertEquals(33, suma);

    }

    @Test
    public void imprimirSuma8VDEnFichero(){
        String[] args = {"-o=vd","-f=salidaVerticalD.txt","-m=s", "8"};
        fibo.main(args);
    }

    @Test
    public void imprimirSuma5VIEnFichero() {
        String[] args = {"-o=vi", "-f=salidaVerticalI.txt", "-m=s", "5"};
        fibo.main(args);
    }

    @Test
    public void imprimirSuma5HIEnFichero() {
        String[] args = {"-o=hi", "-f=salidaHorizontalI.txt", "-m=s", "9"};
        fibo.main(args);
    }

    @Test
    public void imprimirSuma5HDEnFichero() {
        String[] args = {"-o=hd", "-f=salidaHorizontalD.txt", "-m=s", "6"};
        fibo.main(args);
    }

    @Test
    public void imprimirArregloEnFicheroDeManeraVD(){
        String[] args = {"-o=vd", "-f=arregloEnFicheroVD.txt", "-m=l", "6"};
        fibo.main(args);
    }
    @Test
    public void imprimirArregloEnFicheroDeManeraVI(){
        String[] args = {"-o=vi", "-f=arregloEnFicheroVI.txt", "-m=l", "5"};
        fibo.main(args);
    }

    @Test
    public void imprimirSumaEnConsolaVI(){
        String[] args = {"-o=vi", "-m=s", "5"};
        fibo.main(args);
    }
    @Test
    public void imprimirSumaEnConsolaVD(){
        String[] args = {"-o=vd", "-m=s", "5"};
        fibo.main(args);
    }
    @Test
    public void imprimirSumaEnConsolaHI(){
        String[] args = {"-o=hi", "-m=s", "5"};
        fibo.main(args);
    }
    @Test
    public void imprimirSumaEnConsolaHD(){
        String[] args = {"-o=hd", "-m=s", "5"};
        fibo.main(args);
    }

    @Test
    public void imprimirArregloEnConsolaVI(){
        String[] args = {"-o=vi", "-m=l", "5"};
        fibo.main(args);
    }
    @Test
    public void imprimirArregloEnConsolaVD(){
        String[] args = {"-o=vd", "-m=l", "5"};
        fibo.main(args);
    }
    @Test
    public void imprimirArregloEnConsolaHI(){
        String[] args = {"-o=hi", "-m=l", "5"};
        fibo.main(args);
    }
    @Test
    public void imprimirArregloEnConsolaHD(){
        String[] args = {"-o=hd", "-m=l", "5"};
        fibo.main(args);
    }

    @Test
    public void imprimirComoFibo1(){
        String[] args = {"8"};
        fibo.main(args);
    }

    @Test
    public void imprimirSinO(){
        String[] args = {"-m=l", "-f=salida.txt","8"};
        fibo.main(args);
    }
}
