package ar.edu.untref.aydoo;

public class Producto {

    private Double precio;
    private String descripcion;
    private String codigo;

    public Producto(Double precio, String descripcion, String codigo) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigo = codigo;

    }

    public Double getPrecioDeVenta() {
        return precio;
    }
}
