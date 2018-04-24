package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {

    @Test
    public void obtenerPrecioDeVentaDeUnProductoRetornaValor10() {

        Producto lapiz = new Producto();

        Double precio = lapiz.getPrecioDeVenta();

        Assert.assertEquals(new Double(10), precio);
    }
}
