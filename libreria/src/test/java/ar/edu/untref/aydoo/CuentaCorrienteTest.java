package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CuentaCorrienteTest {

    @Test
    public void agregarCompraDeberiaEstarEnLaCuentaCorriente(){

        Compra nuevaCompra = new Compra();
        nuevaCompra.setProducto();
        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        Cliente cliente = new Cliente(datosPersonales);
        nuevaCompra.setCliente(cliente);
        CuentaCorriente ctaCte = new CuentaCorriente();

        ctaCte.agregarCompra(nuevaCompra);

        Assert.assertNotNull(ctaCte.getCompras());
    }
}
