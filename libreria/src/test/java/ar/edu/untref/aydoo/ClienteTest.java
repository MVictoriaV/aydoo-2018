package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

    private Cliente cliente;

    @Before
    public void crearCliente() {
        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        cliente = new Cliente(datosPersonales);
    }

    @Test
    public void asignarSuscripcionDeUnProducto() {

        Producto revistaInfantil = new Producto(25d, "Pinion", "I1");

        Boolean result = this.cliente.asignarSuscripcion(revistaInfantil);

        Assert.assertTrue(result);
    }
}
