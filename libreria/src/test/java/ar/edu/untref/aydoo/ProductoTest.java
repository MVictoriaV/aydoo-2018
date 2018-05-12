package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {

    private static Double IVA = 1.21;

    @Test
    public void obtenerPrecioDeVentaDeUnProductoRetornaValor10() {

        Producto revista = new Periodico(10d, "RevistaGente", "A1");

        Double precio = revista.getPrecioDeVenta();

        Assert.assertEquals(new Double(10), precio);
    }

    @Test
    public void obtenerPrecioDeVentaDeUnProductoRetornaValor9Con99() {

        Producto diarioArg = new Periodico(9.99, "Diario ARG","A2");

        Double precio = diarioArg.getPrecioDeVenta();

        Assert.assertEquals(new Double(9.99), precio);
    }

    @Test
    public void obtenerPrecioDeVentaDeUnArticuloRetornaValor20MasIVA() {

        Producto lapizColorNegro = new ArticuloDeLibreria(20d, "Lapiz color negro","A2");

        Double precio = lapizColorNegro.getPrecioDeVenta();
        Double precioMasIVA = 20d*IVA;

         Assert.assertEquals(precioMasIVA, precio);
    }
}
