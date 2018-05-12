package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

    private static final Double IVA = 1.21;

    public ArticuloDeLibreria(Double precio, String descripcion, String codigo) {
        this.precio = precio * IVA;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
}
