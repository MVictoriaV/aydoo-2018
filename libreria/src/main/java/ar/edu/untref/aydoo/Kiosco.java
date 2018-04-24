package ar.edu.untref.aydoo;

import java.util.List;

public class Kiosco {

    private List<Producto> productos;

    public Kiosco (List<Producto> listadoDeProductos) {
        this.productos = listadoDeProductos;
    }

    public boolean hayProductos(){
        return (productos.size() > 0);
    }
}
