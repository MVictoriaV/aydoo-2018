package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class ClienteTest {

    private Cliente cliente;

    @Before
    public void crearCliente() {
        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        cliente = new Cliente(datosPersonales);
    }

    @Test
    public void asignarSuscripcionDeUnProducto() {

        Producto revistaInfantil = new Periodico(25d, "Pinion", "I1");

        Boolean result = this.cliente.asignarSuscripcion(revistaInfantil);

        Assert.assertTrue(result);
    }

    @Test
    public void contieneSuscripcionRetornaFalse() {

        Producto revistaInfantil = new Periodico(25d, "Pinion", "I1");

        Boolean result = this.cliente.contieneSuscripcion(revistaInfantil);

        Assert.assertFalse(result);
    }

    @Test
    public void contieneSuscripcionRetornaTrue() {

        Producto revistaInfantil = new Periodico(25d, "Pinion", "I1");
        this.cliente.asignarSuscripcion(revistaInfantil);

        Boolean result = this.cliente.contieneSuscripcion(revistaInfantil);

        Assert.assertTrue(result);
    }

    @Test
    public void obtenerMontoComprasRealizadasMes4DeberiaRetornar100SinSuscripcion() {

        Compra nuevaCompra = new Compra(new Date());
        nuevaCompra.setProducto(new Periodico(100.0, "Revista", "A1"));
        CuentaCorriente ctaCte = new CuentaCorriente();
        ctaCte.agregarCompra(nuevaCompra);
        this.cliente.setCtaCte(ctaCte);

        Double monto = this.cliente.obtenerMontoComprasRealizadas(4, 2018);

        Assert.assertEquals(new Double(100), monto);
    }

    @Test
    public void obtenerDeMontoCompraConSuscripcionDeberiaRetonarMontoMenos20x100to() {

        Compra nuevaCompra = new Compra(new Date());
        Producto revistaGente = new Periodico(100.0, "Revista", "A1");
        nuevaCompra.setProducto(revistaGente);
        CuentaCorriente ctaCte = new CuentaCorriente();
        ctaCte.agregarCompra(nuevaCompra);
        this.cliente.asignarSuscripcion(revistaGente);
        this.cliente.setCtaCte(ctaCte);

        Double monto = this.cliente.obtenerMontoComprasRealizadas(4, 2018);

        Assert.assertEquals(new Double(83.33), monto, 0.02);
    }
}
