package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KioscoTest {

    @Test
    public void seCreaKioscoCon3Productos(){

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(10.0, "Lapiz", "A1"));
        productos.add(new Producto(26.0, "Cuaderno", "A1"));
        productos.add(new Producto(55.0, "Revista", "R1"));

        Kiosco kiosquito = new Kiosco(productos);

        Assert.assertTrue(kiosquito.hayProductos());
    }
}
