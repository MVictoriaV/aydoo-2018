package ar.edu.untref.aydoo;

import java.util.Date;

public class Compra {

    private Producto producto;
    private Date fecha;

    public Compra (Date unaFecha) {
        this.fecha = unaFecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto unProducto) {
        producto = unProducto;
    }
}
