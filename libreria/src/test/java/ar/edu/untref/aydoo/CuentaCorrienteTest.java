package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CuentaCorrienteTest {

    @Test
    public void agregarCompraDeberiaEstarEnLaCuentaCorriente(){

        Compra nuevaCompra = new Compra();
        nuevaCompra.setProducto(new ArticuloDeLibreria(30.0, "Lapiz", "A1"));
        CuentaCorriente ctaCte = new CuentaCorriente();

        ctaCte.agregarCompra(nuevaCompra);

        Assert.assertNotNull(ctaCte.getCompras());
    }
}
