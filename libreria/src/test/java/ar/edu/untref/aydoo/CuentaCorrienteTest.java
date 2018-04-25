package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class CuentaCorrienteTest {

    @Test
    public void agregarCompraDeberiaEstarEnLaCuentaCorriente(){

        Compra nuevaCompra = new Compra(new Date());
        nuevaCompra.setProducto(new ArticuloDeLibreria(30.0, "Lapiz", "A1"));
        CuentaCorriente ctaCte = new CuentaCorriente();

        ctaCte.agregarCompra(nuevaCompra);

        Assert.assertNotNull(ctaCte.getCompras());
    }
}
