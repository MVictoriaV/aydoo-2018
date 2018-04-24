package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {

    @Test
    public void obtenerPrecioDeVentaDeUnProductoRetornaValor10() {

        Producto lapiz = new Producto(10d, "Lapiz", "A1");

        Double precio = lapiz.getPrecioDeVenta();

        Assert.assertEquals(new Double(10), precio);
    }

    @Test
    public void obtenerPrecioDeVentaDeUnProductoRetornaValor9Con99() {

        Producto lapizColorNegro = new Producto(9.99, "Lapiz color negro","A2");

        Double precio = lapizColorNegro.getPrecioDeVenta();

        Assert.assertEquals(new Double(9.99), precio);
    }
}
