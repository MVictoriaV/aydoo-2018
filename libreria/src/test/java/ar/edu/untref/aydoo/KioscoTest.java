package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Ignore@Test
    public void montoACobrarAUnClienteEnElMes3() {

        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        Cliente pepe = new Cliente(datosPersonales);

        Double montoMesMarzo = kiosquito.montoACobrar(3, pepe);

        Assert.assertEquals(new Double(100), montoMesMarzo);
    }

    @Test
    public void montoACobrarAUnClienteEnElMes3RetornarValor30Pesos() {

        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        Cliente pepe = new Cliente(datosPersonales);

        CuentaCorriente ctaCte = new CuentaCorriente();

        Compra compra = new Compra(obtenerFechaFormateada("01/03/2018"));
        compra.setProducto(new Periodico(30.0, "Revista", "A1"));
        ctaCte.agregarCompra(compra);

        pepe.setCtaCte(ctaCte);

        kiosquito.agregarCliente(pepe);

        Double montoMesMarzo = kiosquito.montoACobrar(3, pepe);

        Assert.assertEquals(new Double(28.57), montoMesMarzo, 0.02);
    }

    @Test
    public void montoACobrarAUnClienteEnElMes3Retonar100Menos5x100toDescuento() {

        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        Cliente pepe = new Cliente(datosPersonales);

        CuentaCorriente ctaCte = new CuentaCorriente();

        Compra compra = new Compra(obtenerFechaFormateada("01/03/2018"));
        compra.setProducto(new Periodico(30.0, "Revista", "A1"));
        ctaCte.agregarCompra(compra);

        pepe.setCtaCte(ctaCte);

        kiosquito.agregarCliente(pepe);

        Double montoMesMarzo = kiosquito.montoACobrar(3, pepe);

        Assert.assertEquals(new Double(28.57), montoMesMarzo, 0.02);
    }

    @Test
    public void montoACobrarAUnClienteEnElMes3TieneUnaSuscripcionSoloTiene20x100toDescuento() {

        DatosPersonales datosPersonales = new DatosPersonales("Pepe", "Perez", "Calle 123", 12345678);
        Cliente pepe = new Cliente(datosPersonales);

        CuentaCorriente ctaCte = new CuentaCorriente();

        Compra compra = new Compra(obtenerFechaFormateada("01/03/2018"));
        Producto diarioARG = new Periodico(30.0, "Diario ARG.", "A1");
        compra.setProducto(diarioARG);
        ctaCte.agregarCompra(compra);

        pepe.setCtaCte(ctaCte);
        pepe.asignarSuscripcion(diarioARG);

        kiosquito.agregarCliente(pepe);

        Double montoMesMarzo = kiosquito.montoACobrar(3, pepe);

        Assert.assertEquals(new Double(25), montoMesMarzo, 0.1);
    }

    private Date obtenerFechaFormateada(String unaFecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = sdf.parse(unaFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }

    private List<Producto> crearListadoDeProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new ArticuloDeLibreria(10.0, "Lapiz", "A1"));
        productos.add(new ArticuloDeLibreria(26.0, "Cuaderno", "A1"));
        productos.add(new Periodico(55.0, "Revista", "R1"));
        return productos;
    }
}
