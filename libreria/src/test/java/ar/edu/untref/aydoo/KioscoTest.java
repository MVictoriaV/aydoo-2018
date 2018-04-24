package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KioscoTest {

    private List<Cliente> listadoDeClientes;
    private Kiosco kiosquito;

    @Before
    public void crearEntidadesIniciadoras(){
        listadoDeClientes = new ArrayList<>();
        kiosquito = new Kiosco(crearListadoDeProductos(), listadoDeClientes);
    }

    @Test
    public void seCreaKioscoCon3Productos(){

        List<Producto> productos = this.crearListadoDeProductos();

        Kiosco kiosquito = new Kiosco(productos, new ArrayList<>());

        Assert.assertTrue(kiosquito.hayProductos());
    }

    @Test
    public void seRegistraUnCliente(){

        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        Cliente pepe = new Cliente(datosPersonales);
        Kiosco kiosquito = new Kiosco(this.crearListadoDeProductos(), new ArrayList<>());

        Boolean result = kiosquito.agregarCliente(pepe);

        Assert.assertTrue(result);
    }

    @Test
    public void seCreaKioscoCon2Clientes(){

        List<Cliente> clientes = new ArrayList<>();
        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        clientes.add(new Cliente(datosPersonales));
        datosPersonales = new DatosPersonales("Cosme", "Perez", "Calle 123", 12345679);
        clientes.add(new Cliente(datosPersonales));

        Kiosco kiosquito = new Kiosco(this.crearListadoDeProductos(), clientes);

        Assert.assertTrue(kiosquito.hayClientes());
    }

    @Test
    public void seCreaKioscoConMismosClientesDeberiaRetornarFalse(){

        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        Cliente pepe = new Cliente(datosPersonales);
        Kiosco kiosquito = new Kiosco(this.crearListadoDeProductos(), new ArrayList<>());

        kiosquito.agregarCliente(pepe);
        Boolean result = kiosquito.agregarCliente(pepe);

        Assert.assertFalse(result);
    }

    @Test
    public void montoACobrarAUnClienteEnElMes3() {

        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        Cliente pepe = new Cliente(datosPersonales);

        Double montoMesMarzo = kiosquito.montoACobrar(3);

        Assert.assertEquals(new Double(100), montoMesMarzo);
    }

    private List<Producto> crearListadoDeProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new ArticuloDeLibreria(10.0, "Lapiz", "A1"));
        productos.add(new ArticuloDeLibreria(26.0, "Cuaderno", "A1"));
        productos.add(new Periodico(55.0, "Revista", "R1"));
        return productos;
    }
}
